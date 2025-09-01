function solution(n, w, num) {
  const H = Math.ceil(n / w);
  const rowB = Math.floor((num - 1) / w);      // 아래에서부터의 행
  const posInRow = (num - 1) % w;
  const col = (rowB % 2 === 0) ? posInRow : (w - 1 - posInRow);

  let rowsAbove = (H - 1) - rowB;              // 타겟 위의 행 개수
  const topLen = n % w;                         // 0이면 맨 위도 꽉 참

  if (topLen !== 0) {
    const topRowIndex = H - 1;
    let hasTopAtCol = true;
    if (topRowIndex % 2 === 0) {
      // 맨 위가 짝수행(왼→오): 0..topLen-1만 채워짐
      hasTopAtCol = (col < topLen);
    } else {
      // 맨 위가 홀수행(오→왼): w-topLen..w-1만 채워짐
      hasTopAtCol = (col >= w - topLen);
    }
    if (!hasTopAtCol) rowsAbove -= 1;
  }

  return rowsAbove + 1;
}
