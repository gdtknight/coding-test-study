package baekjoon.recursive;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _1914_ implements Problem {
  public static int cnt = 0;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    hanoi(N, 1, 3, 2);
    br.close();
  }

  public static void hanoi(int n, int from, int to, int by) {
    if (n == 0) {
      return;
    }

    hanoi(n - 1, from, by, to);
    cnt += 1;
    System.out.println(n + "이동 [" + from + " -> " + to + "]" + " 이동 횟수 : " + cnt);
    hanoi(n - 1, by, to, from);

  }
}
