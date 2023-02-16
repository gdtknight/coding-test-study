package zerobase._230216;

import common.Problem;

public class _04_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 2 <= x.length = y.length <= 100000
    // -100000 <= x[i], y[i] <= 100000
    // 0 <= k <= 1000
    int[] x = new int[] { 1, 2, 5, 6 };
    int[] y = new int[] { 3, 1, 10, -9 };
    int k = 2;

    System.out.println(solution(x, y, k));
  }

  public int solution(int[] x, int[] y, int k) {
    int answer = 0;

    int idxI = 0;
    int idxJ = 1;

    while (idxI != x.length - 2 && idxJ != x.length - 1) {
      if (Math.abs(x[idxI] - x[idxJ]) <= k) {
        int curVal = y[idxI] + y[idxJ] + Math.abs(x[idxI] - x[idxJ]);

        if (answer < curVal) {
          answer = curVal;
        }
      } else {
        idxI += 1;
      }
      if (idxJ == x.length - 1) {
        idxI += 1;
        continue;
      }

      if (idxI + 1 == idxJ) {
        idxJ += 1;
        continue;
      }

      if (y[idxJ] < y[idxI]) {
        idxJ += 1;
      } else {
        idxI += 1;
      }
    }

    return answer;
  }

}
