package baekjoon.math;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1407_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long answer = 0;

    // solve

    for (long i = A; i <= B; i++) {
      String binary = Long.toBinaryString(i);
      int lastIdxOfOne = binary.lastIndexOf('1');
      if (lastIdxOfOne != binary.length()) {
        answer += Long.parseLong(binary.substring(lastIdxOfOne, binary.length()), 2);
      } else {
        answer += 1L;
      }
    }

    System.out.println(answer);

    br.close();

  }
}
