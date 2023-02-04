package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _1904_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int n = Integer.parseInt(br.readLine());

    // 길이가 n인 2진 수열
    // 00, 1 -> 둘로 조합
    // 15746으로 나눈 나머지

    int[] result = new int[1_000_000];
    result[0] = 1;
    result[1] = 2;

    if (n < 3) {
      System.out.println(result[n - 1]);
      return;
    }

    for (int i = 2; i < n; i++) {
      result[i] = result[i - 1] + result[i - 2];
    }

    System.out.println(result[n - 1]);

    br.close();
  }

}
