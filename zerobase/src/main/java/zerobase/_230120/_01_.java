package zerobase._230120;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(answer(7, 4).intValue());
  }

  public static Double answer(int N, int M) {
    int max = Math.max(N, M);
    int min = Math.min(N, M);
    return Math.ceil((double) max / (double) min) * (double) min;

  }
}
