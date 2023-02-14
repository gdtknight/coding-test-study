package baekjoon.math;

import java.io.BufferedReader;
import java.util.Deque;
import java.util.LinkedList;

import common.Initialization;
import common.Problem;

public class _27435_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int T = Integer.parseInt(br.readLine());

    // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9

    for (int i = 0; i < T; i++) {
      Deque<Long> deque = new LinkedList<>();
      Long curNum = Long.parseLong(br.readLine());
      deque.offerLast(1L);
      deque.offerLast(1L);
      deque.offerLast(1L);
      deque.offerLast(2L);
      deque.offerLast(2L);

      for (long num = 5; num < curNum; num++) {
        long num_b5 = deque.pollFirst();
        long num_b1 = deque.peekLast();
        deque.offerLast((num_b5 + num_b1) % 998_244_353L);
      }

      System.out.println(deque.peekLast());
    }

    br.close();
  }

}
