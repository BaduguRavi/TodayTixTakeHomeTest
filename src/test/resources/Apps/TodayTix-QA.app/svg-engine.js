/**
 * Get rect from element, <svg> or <rect>
 */
class TTSVGRect {
    constructor(element) {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        if (element) {
            if (element.nodeName === 'svg') {
                const viewBox = element.getAttribute('viewBox').split(' ');
                this.x = parseFloat(viewBox[0]);
                this.y = parseFloat(viewBox[1]);
                this.width = parseFloat(viewBox[2]);
                this.height = parseFloat(viewBox[3]);
            } else if (element.nodeName === 'rect') {
                this.x = parseFloat(element.getAttribute('x'));
                this.y = parseFloat(element.getAttribute('y'));
                this.width = parseFloat(element.getAttribute('width'));
                this.height = parseFloat(element.getAttribute('height'));
            } else if (element.nodeName === 'path') {
                const rectData = element.getAttribute('tt_rect');
                if (rectData) {
                    const points = rectData.split(',');
                    if (points.length > 3) {
                        this.x = parseFloat(points[0]);
                        this.y = parseFloat(points[1]);
                        this.width = parseFloat(points[2]);
                        this.height = parseFloat(points[3]);
                    }
                }
            }
        }
        return this;
    }

    /**
    * Return center of TTSVGRect
    * @returns {TTSVGPoint}
    */
    getCenter() {
        const x = this.x + (this.width / 2);
        const y = this.y + (this.height / 2);
        return new TTSVGPoint(x, y);
    }
}

class TTSVGPoint {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        return this;
    }
}

class TTColor {
    constructor(hexColor) {
        if (hexColor && hexColor.charAt(0) === '#') {
            this.r = parseInt(hexColor.substring(1, 3), 16);
            this.g = parseInt(hexColor.substring(3, 5), 16);
            this.b = parseInt(hexColor.substring(5, 7), 16);
        } else {
            this.r = 0;
            this.g = 0;
            this.b = 0;
        }
        this.a = 1;
    }
}

/**
* Class to find and highlight seats
*/
class TTSVGEngine {
    /**
     * @param svgRoot - root svg element of the chart
     * @param windowWidth - initial window.innerWidth - to get correct scale
     * @param windowHeight - initial window.innerHeight - to get correct scale
     */
    constructor(svgRoot, windowWidth, windowHeight) {
        this.svgRoot = svgRoot;
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        // internal svg coordinates (Rect)
        this.viewBoxRect = new TTSVGRect(this.svgRoot);
        // scale for svg in window
        this.svgScale = Math.min(
            this.windowWidth / this.viewBoxRect.width, 
            this.windowHeight / this.viewBoxRect.height
        );
        // frame of svg on window
        this.svgRect = new TTSVGRect();
        this.svgRect.width = this.viewBoxRect.width * this.svgScale;
        this.svgRect.height = this.viewBoxRect.height * this.svgScale;
        this.svgRect.x = (this.windowWidth - this.svgRect.width) / 2;
        this.svgRect.y = (this.windowHeight - this.svgRect.height) / 2;
        // get seat width
        this.seatWidth = this.getSeatWidth();
        // get max Scale depend on seat width
        this.maxScale = this.seatWidth ? 
            this.getMaxZoomScaleWithSeatWidth(this.seatWidth) : 
            5;
        // constants
        this.svgNode = 'http://www.w3.org/2000/svg';
        this.redColor = '#BD0D07';
    }

    /**
    * Convert SVG point to Window coordinate system
    * @param point
    * @returns {{x: *, y: *}}
    */
    convertPointSVGToWindow(point) {
        let x = point.x;
        let y = point.y;
        x = (x - this.viewBoxRect.x) / this.viewBoxRect.width;
        y = (y - this.viewBoxRect.y) / this.viewBoxRect.height;
        x = x * this.svgRect.width + this.svgRect.x;
        y = y * this.svgRect.height + this.svgRect.y;
        const result = { x: x, y: y };
        return result;
    }

    /**
    * Remove previous group with old highlighted seats elements
    * Create new groups
    * @returns SVGElement "g"
    */
    reCreateSeatGroup() {
        const pinsGroupId = 'tt_pinsGroupId';
        // remove old group if exist
        const oldHighlightGroup = document.getElementById(pinsGroupId);
        if (oldHighlightGroup) {
            oldHighlightGroup.parentElement.removeChild(oldHighlightGroup);
        }
        const pinsGroup = document.createElementNS(this.svgNode, 'g');
        pinsGroup.setAttribute('id', pinsGroupId);
        this.svgRoot.appendChild(pinsGroup);
        return pinsGroup;
    }

    /**
    * Find first seat and return width of this seat
    * @returns {null|number}
    */
    getSeatWidth() {
        const allElements = document.getElementsByTagName('*');
        for (let i = 0, n = allElements.length; i < n; i++) {
            const value = allElements[i].getAttribute('seat');
            if (value != null) {
                const rect = new TTSVGRect(allElements[i]);
                if (rect.width > 0) {
                    return rect.width;
                }
            }
        }
        return null;
    }

    /**
    * Find avarage seat width
    * @returns {null|number}
    */
    getAvarageSeatWidth(seats) {
        let width = 0;
        let count = 0;
        for (let i = 0; i < seats.length; i++) {
            const seatWidth = new TTSVGRect(seats[i]).width;
            if (seatWidth > 0) {
                count++;
                width += seatWidth;
            }
        }
        width /= count;
        if (width == 0) {
            width = this.seatWidth;
        }
        return width;
    }

    /**
    * Cuclulate Maximum Zoom Scale depend on seat width
    * Maximum zoom scale will be always bigger then 1.5
    * Maximum zoom scale should show 25 seats in screen width
    * @param width - seat width
    * @returns {number}
    */
    getMaxZoomScaleWithSeatWidth(width) {
        const windowSeatWidth = width * this.svgScale;
        // Max zoom should contain at least 25 seats in screenWidth
        let scale = this.windowWidth / windowSeatWidth / 25;
        scale = Math.max(scale, 1.5);
        return scale;
    }

    /**
    * Create pin in group at x and y with id
    * @param groupPins
    * @param x
    * @param y
    * @param id
    * @returns {Element}
    */
    createCircle(groupPins, x, y, color, id) {
        const circle = document.createElementNS(this.svgNode, 'circle');
        circle.setAttribute('cx', x);
        circle.setAttribute('cy', y);
        circle.setAttribute('r', 0);
        circle.setAttribute('fill', color);
        circle.id = id;
        groupPins.appendChild(circle);
        return circle;
    }

    setValuesAndKeyTimes(animation, values, keys) {
        if (values.length != keys.length) {
            throw "setValuesAndKeyTimes - values and keys should have the same length";
        }
        let valuesResult = '', keysResult = '';
        for (let i = 0; i < values.length; i++) {
            const symbol = (i == 0) ? '' : '; ';
            valuesResult += symbol + values[i];
            keysResult += symbol + keys[i];
        }
        animation.setAttribute('values', valuesResult);
        animation.setAttribute('keyTimes', keysResult);
    }

    /**
    * Create animation for pip
    * @param groupPins - where to put animation
    * @param pin - what to animate
    * @param afterPin - start animation after 0.1s afterPin will begin animation
    * @param toY - destination Y
    * @returns {Amimate}
    */
    createCircleAnimate(groupPins, pin, afterPin, isOut, count, radius) {
        const pinId = pin.getAttribute('id');
        const duration = 0.5;
        const durationBetweenSeats = 0.1;
        const fullDuration = 0.5 * 2 + durationBetweenSeats * count;
        const animation = document.createElementNS(this.svgNode, 'animate');
        animation.setAttributeNS(
            'http://www.w3.org/1999/xlink',
            'href',
            '#' + pinId
        );
        animation.setAttribute('attributeName', 'r');
        animation.setAttribute('from', 0);
        animation.setAttribute('to', radius);
        animation.setAttribute('dur', `${fullDuration}s`);
        animation.setAttribute('fill', 'freeze');
        animation.setAttribute('repeatCount', 'indefinite');
        let values, keys;
        const firstKey = duration / fullDuration;
        if (isOut) {
            keys = [0, firstKey, firstKey, 1];
            values = [0, radius, 0, 0];
        }
        else {
            keys = [0, firstKey, 2 * firstKey, 2 * firstKey, 1];
            values = [0, radius, radius, 0, 0];
        }
        svgEngine.setValuesAndKeyTimes(animation, values, keys);
        animation.id = `${pinId}-anim`;
        if (afterPin) {
            const prevAnimation = `${afterPin.getAttribute("id")}-anim`;
            // begin="circ-anim.begin + 1s"
            const nextStart = isOut ? duration : durationBetweenSeats;
            animation.setAttribute(
                'begin', 
                `${prevAnimation}.begin + ${nextStart}s`
            );
        }
        else {
            animation.setAttribute('begin', 'indefinite');
        }
        groupPins.appendChild(animation);
        return animation;
    }
}
