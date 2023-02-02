package baekjoon.test;

import java.io.BufferedReader;

import baekjoon.Problem;
import baekjoon.common.Initialization;

public class Test implements Problem {

  @Override
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(br.readLine());

    br.close();
  }

}
