package baekjoon.backtracking;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _16987_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Initialization
    int N = Integer.parseInt(br.readLine());
    int[][] eggs = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      eggs[i][0] = Integer.parseInt(st.nextToken());
      eggs[i][1] = Integer.parseInt(st.nextToken());
    }

    // Your code

    int cnt = 0;
    for (int idx = 0; idx < N; idx++) {
      int[] curEgg = eggs[idx];

      for (int i = 0; i < N; i++) {
        if (i == idx) {
          continue;
        }

        if (curEgg[0] < 0) {
          break;
        }

        if (curEgg[1] > eggs[i][0] && curEgg[0] > eggs[i][1]) {
          cnt++;
          curEgg[0] -= eggs[idx][1];
          eggs[idx][0] -= curEgg[1];
        }
      }

      if (curEgg[0] < 0) {
        continue;
      }

      for (int i = 0; i < N; i++) {
        if (i == idx) {
          continue;
        }

        if (curEgg[0] < 0) {
          break;
        }

        if (curEgg[1] > eggs[i][0]) {
          cnt++;
          curEgg[0] -= eggs[idx][1];
          eggs[idx][0] -= curEgg[1];
        }
      }

    }

    System.out.println(cnt);

    br.close();
  }

}
