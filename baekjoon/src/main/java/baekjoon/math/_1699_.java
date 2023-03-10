package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.Problem;

public class _1699_ implements Problem {

  public void solution(String[] args) throws Exception {

    // BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 100,000

    int N = Integer.parseInt(br.readLine());

    int[] memo = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = (int) Math.sqrt(i); j >= 1; j--) {
        if (j * j == i) {
          memo[i] = 1;
        } else {
          memo[i] = memo[i] == 0 ? memo[i - j * j] + 1 : Math.min(memo[i - j * j] + 1, memo[i]);
        }
      }
    }

    br.close();
  }

}
