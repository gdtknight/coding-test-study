package baekjoon.dp;

import java.io.BufferedReader;
import java.math.BigInteger;

import common.Initialization;
import common.Problem;

public class _11727_ implements Problem {
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] answer = new int[1001];
    answer[1] = 1;
    answer[2] = 3;

    for (int i = 3; i <= N; i++) {
      answer[i] = (answer[i - 1] + answer[i - 2] + answer[i - 2]) % 10007;
    }

    System.out.println(answer[N]);

    br.close();
  }

}
