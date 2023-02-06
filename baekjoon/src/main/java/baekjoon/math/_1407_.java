package baekjoon.math;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1407_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int result = 0;

    for (int i = A; i <= B; i++) {
      int start = i;
      int cnt = 0;
      while (start % 2 == 0) {
        cnt += 1;

        start = start / 2;
      }
      result += Double.valueOf(Math.pow(2, cnt)).intValue();
    }
    System.out.println(result);

    br.close();
  }

}
