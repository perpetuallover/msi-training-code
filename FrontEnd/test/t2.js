var readBinaryWatch = function(num) {
    var combination = [];
    var result = [];
    var hour = 0;
    var minute = 0;
    var time = "";
    findCombinations([0,0,0,0,0,0,0,0,0,0], num, combination, 0);
    console.log(combination);
    combination.forEach(function(c){
        for(var i = 0; i < 4; i++){
            if(c[i] == 1){
                hour += (8 / Math.pow(2, i));
            }
        }
        for(var j = 4; j < 10; j++){
            if(c[j] == 1){
                minute += (32 / Math.pow(2 , j - 4));
            }
        }
        if(hour <= 11 && minute <= 59){
            time += hour + ":";
            time += (minute < 10) ? "0" + minute : minute;
            result.push(time);
        }
        hour = 0;
        minute = 0;
        time = "";
    })
    return result;
};

function findCombinations(current, num, combination, start){
    if(num === 0){
        combination.push(current);
        return;
    }
    for(var i = 0; i < current.length; i++){
        var modified = current.slice(0);
        if(modified[i] === 0){
            modified[i] = 1;
            findCombinations(modified, num - 1, combination, i + 1);
        }
    }
}

console.log(readBinaryWatch(2));