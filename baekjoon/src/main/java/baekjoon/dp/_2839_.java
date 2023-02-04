package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _2839_ implements Problem {
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    System.out.println(solution(N));

    br.close();
  }

  public static int solution(int N) {

    int fiveCnt = N / 5;
    int threeCnt = (N - fiveCnt * 5) / 3;

    while (fiveCnt > 0) {

      if ((N - fiveCnt * 5) % 3 == 0) {
        return fiveCnt + threeCnt;
      }

      fiveCnt -= 1;
      threeCnt = (N - fiveCnt * 5) / 3;
    }

    return (N - fiveCnt * 5) % 3 == 0 ? threeCnt : -1;
  }

}
