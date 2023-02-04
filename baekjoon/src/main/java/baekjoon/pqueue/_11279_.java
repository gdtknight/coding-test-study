package baekjoon.pqueue;

import java.io.BufferedReader;
import java.util.PriorityQueue;

import common.Initialization;
import common.Problem;

public class _11279_ implements Problem {

  @Override
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (pQueue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(pQueue.poll());
        }

      } else {
        pQueue.offer(num);
      }
    }

    br.close();
  }

}
