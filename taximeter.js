const OVERNIGHT_FARE = 3.9;
const SUNDAY_FARE = 3;
const NORMAL_FARE = 2;
const SUNDAY_CODE = 0;

const calculateTrip = function (date, distance) {
    if (isOvernight(date)) {
        return calculateTotal (distance, OVERNIGHT_FARE);  
    }
    if (isSunday(date)) {
        return calculateTotal (distance, SUNDAY_FARE);
    } else {
        return calculateTotal (distance, NORMAL_FARE);
        }    
    };

    const isOvernight = function (date) {
        return date.getHours() > 22 || date.getHours() <6;
        
};

    const isSunday = function (date) {
        return date.getDay () === SUNDAY_CODE;
    }

const calculateTotal = function (distance, fare){
    return distance * fare;
}

const date = new Date ("2018-09-23T23:00:00");
const testOvernight = isOvernight (date);
console.log (testOvernight);
const total = calculateTrip (date, 10);
console.log (total === 39);