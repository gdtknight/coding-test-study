package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _2133_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 3 * N => 2 * 1, 1 * 2 타일로 채우기
    // 1<= N <= 30

    // Your code
    int N = Integer.parseInt(br.readLine());
    int[] memo = new int[N + 1];

    memo[0] = 1;

    for (int i = 2; i <= N; i += 2) {
      memo[i] = memo[i - 2] * 3;

      for (int j = i - 4; j >= 0; j += 2) {
        memo[i] += memo[j] * 2;
      }
    }

    System.out.println(memo[N]);

    br.close();
  }

}
