class Queue {
    constructor() {
        this.items = [];
    }
    enqueue(item) {
        this.items.push(item);
    }
    dequeue() {
        return this.items.shift();
    }
    
    isEmpty() {
        return this.items.length === 0;
    }
}

function bfs(start, n, computers, visited) {
    const q = new Queue();
    q.enqueue(start);
    while(!q.isEmpty()) {
        const cur = q.dequeue();
        for(let next = 0; next < n; next++) {
            if(computers[cur][next] === 1 && !visited[next]) {
                visited[next] = true;
                q.enqueue(next);
            }
        }
    }
}

function solution(n, computers) {
    const visited = Array(n).fill(false);
    let answer = 0;
    for(let i = 0; i < n; i++) {
        if(!visited[i]) {
            bfs(i, n, computers, visited);
            answer++;
        }
    }
    
    
    
    return answer;
}