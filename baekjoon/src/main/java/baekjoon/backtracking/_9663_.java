package baekjoon.backtracking;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _9663_ implements Problem {
  static int answer = 0;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    int[] colPos = new int[N];

    for (int i = 0; i < N; i++) {
      colPos[0] = i;
      queen(colPos, 1, N);
    }

    System.out.println(answer);

    br.close();
  }

  public void queen(int[] colPos, int curRow, int N) {
    if (curRow == N) {
      answer += 1;
      return;
    }

    outer: for (int col = 0; col < N; col++) {
      for (int row = 0; row < curRow; row++) {
        if (colPos[row] == col || colPos[row] == col + (curRow - row) || colPos[row] == col - (curRow - row)) {
          continue outer;
        }
      }
      colPos[curRow] = col;
      queen(colPos, curRow + 1, N);
    }
  }

}
