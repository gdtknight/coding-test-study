package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _9465_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int cases = Integer.parseInt(br.readLine());

    for (int i = 0; i < cases; i++) {
      // 1 <= N <= 100,000
      int N = Integer.parseInt(br.readLine());

      String[] line1 = br.readLine().split(" ");
      String[] line2 = br.readLine().split(" ");

      int[][] nums = new int[2][N + 1];

      for (int j = 1; j <= N; j++) {
        nums[0][j] = Integer.parseInt(line1[j - 1]);
        nums[1][j] = Integer.parseInt(line2[j - 1]);
      }

      int[][] dp = new int[2][N + 1];

      if (N == 1) {
        System.out.println(Math.max(nums[0][1], nums[1][1]));
        continue;
      }

      dp[0][1] = nums[0][1];
      dp[1][1] = nums[1][1];

      for (int j = 2; j <= N; j++) {
        dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + nums[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + nums[1][j];
      }

      System.out.println(Math.max(dp[0][N], dp[1][N]));
    }

    br.close();
  }

}
