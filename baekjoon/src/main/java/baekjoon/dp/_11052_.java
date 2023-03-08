package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _11052_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] nums = br.readLine().split(" ");
    int[] pn = new int[N + 1];
    int[] result = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      pn[i] = Integer.parseInt(nums[i - 1]);
      result[i] = pn[i];
    }

    // Your code

    for (int i = 1; i <= N; i++) {
      for (int j = i - 1; j >= 0; j--) {
        result[i] = Math.max(result[i], result[i - j] + pn[j]);
      }
    }

    System.out.println(result[N]);

    br.close();
  }

}
