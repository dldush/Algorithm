function solution(clothes) {
    
    const map = new Map();
    
    clothes.forEach((c) => {
        map.set(c[1], map.has(c[1]) ? map.get(c[1])+1 : 1)
    })
    let answer = 1;
    
    for(const key of map.keys()) {
        answer *= map.get(key)+1;
        console.log(map.get(key)+1);
    }
    answer--;
    return answer;
}