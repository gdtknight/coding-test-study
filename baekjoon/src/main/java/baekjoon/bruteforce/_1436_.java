package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.Initialization;
import common.Problem;

public class _1436_ implements Problem {

  public void solution(String[] args) throws Exception {

    // BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = 3;

    int cnt = 0;
    int start = 666;

    while (cnt != N) {
      if (Integer.valueOf(start).toString().contains("666")) {
        cnt += 1;
      }
      start += 1;
    }
    System.out.println(start - 1);
    // br.close();
  }

}
