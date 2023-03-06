package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _2156_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 10,000
    int N = Integer.parseInt(br.readLine());

    int[] wines = new int[N + 1];
    int[] result = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      wines[i] = Integer.parseInt(br.readLine());
    }

    if (N == 1) {
      System.out.println(wines[N]);
      return;
    }

    result[1] = wines[1];
    result[2] = wines[2] + wines[1];

    for (int i = 3; i <= N; i++) {
      result[i] = Math.max(Math.max(result[i - 2], result[i - 3] + wines[i - 1]) + wines[i], result[i - 1]);
    }

    System.out.println(result[N]);

    br.close();
  }

}
