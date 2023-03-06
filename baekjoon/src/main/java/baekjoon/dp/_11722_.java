package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _11722_ implements Problem {
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 1,000

    int N = Integer.parseInt(br.readLine());

    String[] strNums = br.readLine().split(" ");

    int[] nums = new int[N];
    int[] memo = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(strNums[i]);
    }

    memo[N - 1] = 1;

    for (int i = N - 1; i >= 0; i--) {
      for (int j = i + 1; j < N; j++) {
        if (nums[i] > nums[j]) {
          memo[i] = memo[j] + 1 > memo[i] ? memo[j] + 1 : memo[i];
        }
      }
      memo[i] = memo[i] == 0 ? 1 : memo[i];
    }

    int maxCnt = 0;

    for (int i = 0; i < N; i++) {
      if (memo[i] > maxCnt) {
        maxCnt = memo[i];
      }
    }

    System.out.println(maxCnt);

    br.close();
  }

}
