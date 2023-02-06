package baekjoon.bruteforce;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _2231_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    for (int i = 1; i < N; i++) {
      int digitSum = 0;
      String[] digits = String.valueOf(i).split("");

      for (int j = 0; j < digits.length; j++) {
        digitSum += Integer.parseInt(digits[j]);
      }
      if (i + digitSum == N) {
        System.out.println(i);
        return;
      }
    }

    System.out.println(0);

    br.close();
  }

}
