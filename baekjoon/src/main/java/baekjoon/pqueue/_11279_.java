package baekjoon.pqueue;

import java.io.BufferedReader;

import baekjoon.Problem;
import baekjoon.common.Initialization;

public class _11279_ implements Problem {

  @Override
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(num);
    }

  }

}
