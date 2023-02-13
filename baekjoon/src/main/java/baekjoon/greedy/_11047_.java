package baekjoon.greedy;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _11047_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int numOfCoins = Integer.parseInt(st.nextToken());
    int amount = Integer.parseInt(st.nextToken());

    int[] coins = new int[numOfCoins];

    for (int i = 0; i < numOfCoins; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int idx = numOfCoins - 1;
    int cnt = 0;
    while (amount > 0) {
      cnt += amount / coins[idx];
      amount %= coins[idx--];
    }
    System.out.println(cnt);

    br.close();
  }

}
