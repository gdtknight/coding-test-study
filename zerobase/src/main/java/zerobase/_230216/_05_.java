package zerobase._230216;

import java.util.Arrays;

import common.Problem;

public class _05_ implements Problem {
  public void solution(String[] args) throws Exception {

    // 0 < N <= 100
    // 0 < stones.length <= 1000
    int N = 6;
    int[][] stones = new int[][] { { 0, 1 }, { 0, 2 }, { 5, 3 }, { 4, 3 } };

    System.out.println(solution(N, stones));
  }

  public int solution(int N, int[][] stones) {
    int answer = 0;

    boolean[][] board = new boolean[N][N];
    int[] row = new int[N];
    int[] col = new int[N];

    for (int i = 0; i < stones.length; i++) {
      board[stones[i][0]][stones[i][1]] = true;
      row[stones[i][0]] += 1;
      col[stones[i][1]] += 1;
    }

    while (true) {

      int maxRowIdx = -1;
      int maxElementsCntOfRow = 0;
      for (int i = 0; i < N; i++) {
        if (row[i] <= 0) {
          continue;
        }

        if (maxElementsCntOfRow < row[i]) {
          maxElementsCntOfRow = row[i];
          maxRowIdx = i;
        }
      }

      int maxColIdx = -1;
      int maxElementsCntOfCol = 0;
      for (int i = 0; i < N; i++) {
        if (col[i] <= 0) {
          continue;
        }

        if (maxElementsCntOfCol < col[i]) {
          maxElementsCntOfCol = col[i];
          maxColIdx = i;
        }
      }

      if (maxRowIdx == -1 && maxColIdx == -1) {
        break;
      }

      answer += 1;

      if (maxElementsCntOfRow > maxElementsCntOfCol) {
        row[maxRowIdx] = 0;
        for (int i = 0; i < N; i++) {
          col[i] -= 1;
        }
      } else {
        col[maxColIdx] = 0;
        for (int i = 0; i < N; i++) {
          row[i] -= 1;
        }
      }
    }

    return answer;
  }

}
