package baekjoon.greedy;

import java.io.BufferedReader;
import java.util.PriorityQueue;

import common.Initialization;
import common.Problem;

public class _1715_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1.compareTo(i2));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(br.readLine());
      return;
    }

    for (int i = 0; i < N; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    int result = 0;

    while (pq.size() > 1) {
      int deck1 = pq.poll();
      int deck2 = pq.poll();
      pq.offer(deck1 + deck2);
      result += (deck1 + deck2);
    }

    System.out.println(result);
    System.out.println(pq.isEmpty());

    br.close();
  }

}
