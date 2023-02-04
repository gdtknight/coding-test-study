package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _2579_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] stairs = new int[N + 1];
    int[] points = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    if (N == 1) {
      System.out.println(stairs[N]);
      br.close();
      return;
    }

    // 연속된 3개의 계단을 밟아서는 안된다.
    points[1] = stairs[1];

    if (stairs[1] + stairs[2] > stairs[2]) {
      points[2] = stairs[2] + stairs[1];
    } else {
      points[2] = stairs[2];
    }

    if (N == 2) {
      System.out.println(points[N]);
      br.close();
      return;
    }

    for (int i = 3; i <= N; i++) {
      points[i] = Math.max(points[i - 3] + stairs[i - 1] + stairs[i], points[i - 2] + stairs[i]);
    }

    System.out.println(points[N]);

    br.close();
  }

}
