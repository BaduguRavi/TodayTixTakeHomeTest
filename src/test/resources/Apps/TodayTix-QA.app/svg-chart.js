function setSeatClickHandlers() {
    let clickHandler = (event) => { 
        const section = getSectionNameFromSeatAttribute(event.target.getAttribute('seat'));
        window.location = `tt-chart-click-seat://?section=${section}`;
    };

    let allElements = document
        .getElementById('svg-wrapper')
        .getElementsByTagName("*");

    for (let i = 0; i < allElements.length; i++) {
        const element = allElements[i];
        if (element.hasAttribute('seat')) {
            element.addEventListener("click", clickHandler);
        }
    }
}

/**
 * Returns a map of sections in the seat map to the color of the seats in that
 * section. 
 * 
 * @returns {{string: TTColor}} Map of section names to their colors
 */
function getAllSectionColors() {
    let sectionColors = {};
    let allElements = document
        .getElementById('svg-wrapper')
        .getElementsByTagName('*');

    for (let i = 0; i < allElements.length; i++) {
        const element = allElements[i];
        if (!element.hasAttribute('seat') || !element.hasAttribute('fill')) {
            continue; 
        }
    
        let sectionName = getSectionNameFromSeatAttribute(element.getAttribute('seat'));
        
        if (sectionColors[sectionName] == null) { 
            sectionColors[sectionName] = new TTColor(element.getAttribute('fill'));
        }
    } 

    return sectionColors;
}

function getSectionNameFromSeatAttribute(seatIdentifier) {
    const seatAttributeSplit = seatIdentifier.split(':');
    if (seatAttributeSplit.count < 1) { return null; }
    return seatAttributeSplit[0];
}

/**
 * Get `tixCount` seat elements in the given range.
 *
 * @param {string} startSeatAttribute e.g. "Orchestra:A:107"
 * @param {string?} endSeatAttribute e.g. "Orchestra:A:109"
 * @param {number} tixCount number of seats to highlight (e.g. `3`)
 * @returns {Element[]} list of seat SVG elements
 */
function getAllSeats(startSeatAttribute, endSeatAttribute, tixCount) {
    let matchingElements = [];
    let allElements = document
        .getElementById('svg-wrapper')
        .getElementsByTagName('*');

    for (let i = 0; i < allElements.length; i++) {
        const element = allElements[i];
        let value = element.getAttribute("seat");
        if (value == null) { continue; }

        if ([startSeatAttribute, endSeatAttribute].includes(value)) {
            matchingElements.push(element);
        }
    }

    // If necessary, add any seats between start and end
    if (endSeatAttribute != null && tixCount > 2) {
        let firstSeat = matchingElements[0];
        let secondSeat = matchingElements[1];
        if (firstSeat == secondSeat) {
            matchingElements.pop();
        } else if (firstSeat.parentElement == secondSeat.parentElement) {
            let children = firstSeat.parentElement.childNodes;
            let moreSeats = [];
            let between = false;
            for (let i = 0; i < children.length; i ++) {
                // skip anything that isn't an element
                if (children[i].nodeType!=1) continue;
                let child = children[i];
                if (child == firstSeat || child == secondSeat) {
                    if (between) {
                        break;
                    }
                    between = true;
                } else if (between && child.getAttribute("seat") != null) {
                    moreSeats.push(child);
                }
            }
            for (let i = 0, n = moreSeats.length; i < n; i ++) {
                matchingElements.splice(i + 1, 0, moreSeats[i]);
            }
        }
    }
    return matchingElements;
}

// eslint-disable-next-line no-unused-vars
function highlightSeats(section, row, startSeat, endSeat, tixCount) {
    // create group
    let highlightGroup = svgEngine.reCreateSeatGroup();

    // find seats in SVG
    let sectionPrefix = section + ":" + row + ":";
    let startSeatAttributeValue = sectionPrefix + startSeat;
    let endSeatAttributeValue;
    if (endSeat != "<null>") {
        endSeatAttributeValue = sectionPrefix + endSeat;
    }
    let elements = getAllSeats(startSeatAttributeValue, endSeatAttributeValue, tixCount);

    let pins = [];

    //highlight the seats
    let pointToZoom = new TTSVGPoint(0, 0);

    //update seatWidth
    for (let i = 0; i < elements.length; i++) {
        let element = elements[i];
        // get rect
        let seatRect = new TTSVGRect(element);
        let center = seatRect.getCenter();

        let color = new TTColor(element.getAttribute("fill"));
        // Check whether the background is a red color by check whether the
        // red channel has 30 more than green and blue channel
        let isRed = (color.r - color.g > 30) && (color.r - color.b > 30);
        // Check whether the color is grey, by check the rgb channels have
        // differences less than 10
        let isGrey = Math.abs(color.r - color.g) < 10 && 
            Math.abs(color.r - color.b) < 10 && 
            Math.abs(color.g - color.b) < 10;
        // Check whether this color is darker by checking the average of the
        // three channels are less then a certain value.
        let isDarker = (color.r + color.g + color.b) / 3 < 160;
        let isDarkerGray = isDarker && isGrey;
        let highlightColor = (isRed || isDarkerGray) ? 
            "#FFFFFF" : 
            svgEngine.redColor;
        let pin = svgEngine.createCircle(
            highlightGroup, 
            center.x, 
            center.y, 
            highlightColor , 
            "ttSeat" + i
        );
        let pinOut = svgEngine.createCircle(
            highlightGroup, 
            center.x, 
            center.y, 
            element.getAttribute("fill") , 
            "ttSeat" + i + "out"
        );
        pins.push(pin);
        pins.push(pinOut);

        // get center point of all seats
        pointToZoom.x += center.x;
        pointToZoom.y += center.y;
    }

    //add animation
    let radius = svgEngine.getAvarageSeatWidth(elements)/2;
    let prevPin = null;
    let animation = null;
    for (let i = 0; i < pins.length; i += 2) {
        let pin = pins[i];
        let pinOut = pins[i+1];
        let anim = svgEngine.createCircleAnimate(
            highlightGroup, 
            pin, 
            prevPin, 
            false, 
            elements.length, 
            radius
        );
        svgEngine.createCircleAnimate(
            highlightGroup, 
            pinOut, 
            pin, 
            true, 
            elements.length, 
            radius
        );
        if (i == 0) {
            animation = anim;
        }
        prevPin = pin;

    }
    if (animation) {
        animation.beginElement();
    }


    // find x, y and scale to zoom to seat function
    let result = null;
    if(elements.length > 0) {
        pointToZoom.x = pointToZoom.x / elements.length;
        pointToZoom.y = pointToZoom.y / elements.length;
        pointToZoom = svgEngine.convertPointSVGToWindow(pointToZoom);
        let scale =  svgEngine.maxScale;
        result = { "x": pointToZoom.x, "y": pointToZoom.y, "scale": scale };

    }
    return result;
}

function updateViewPortScale(scale, maxScale) {
    document
        .getElementsByName('viewport')[0]
        .setAttribute(
            'content',
            `width=device-width, initial-scale=${scale}, maximum-scale=${maxScale}`
        );
}

var svgEngine;

function recreateSVGEngine() {
    let svgRoot = document.getElementsByTagName("svg")[0];
    svgEngine = new TTSVGEngine(svgRoot, window.innerWidth, window.innerHeight);
    //update max initial scale and max scale
    updateViewPortScale(1.0, svgEngine.maxScale);
}

window.onload = function() {
    recreateSVGEngine()
    setSeatClickHandlers();
};

window.addEventListener('resize', () => {
    recreateSVGEngine()
});

