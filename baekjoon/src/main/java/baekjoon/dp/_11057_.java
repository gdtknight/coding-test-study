package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.Problem;

public class _11057_ implements Problem {
  static int N;
  static long mod = 10007;

  public void solution(String[] args) throws Exception {

    // BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 100
    // int N = Integer.parseInt(br.readLine());

    int N = 3;
    // int answer = 0;

    long dp[][] = new long[N + 1][10];

    /* 첫번째 자릿수는 경우의 수가 하나 뿐임 */
    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    /* 두번째 자릿수부터 N번째 자릿수까지 탐색 */
    for (int radix = 2; radix <= N; radix++) {
      /* 현재 자릿값을 0부터 9까지 탐색 */
      for (int num = 0; num < 10; num++) {
        // 0인 경우는 앞자리도 0인 경우만 가능
        for (int j = num; j >= 0; j--) {
          dp[radix][num] = (dp[radix][num] + dp[radix - 1][j]) % mod;
        }
      }
    }

    long ans = 0;

    for (int i = 0; i < 10; i++) {
      ans += dp[N][i];
    }

    System.out.println(ans % mod);
    br.close();
  }

}
