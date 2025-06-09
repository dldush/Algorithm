function solution(n) {
    const numberToStr = n.toString(); 
    const splited = numberToStr.split('');
    const reversed = splited.reverse();
    const toNumberListFromStrList = reversed.map((str)=>Number(str));

    return toNumberListFromStrList
}