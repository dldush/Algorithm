function solution(participant, completion) {
    // 1. 참가자 이름을 카운트할 Map 생성
    const map = new Map();

    // 2. 참가자 배열에서 이름 카운트 증가
    for (let name of participant) {
        map.set(name, (map.get(name) || 0) + 1);
    }

    // 3. 완주자 배열에서 해당 이름 카운트 감소
    for (let name of completion) {
        map.set(name, map.get(name) - 1);
    }

    // 4. 카운트가 1인 사람이 완주하지 못한 사람
    for (let [name, count] of map) {
        if (count > 0) {
            return name;
        }
    }
}
