package baekjoon.math;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _15651_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] selected = new int[M];

    permutation(0, M, selected);

    br.close();
  }

  public void permutation(int selCnt, int totCnt, int[] selected) {
    int n = selected.length;
    if (selCnt == totCnt) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        sb.append(selected[i] + " ");
      }
      sb.deleteCharAt(sb.length() - 1);
      System.out.println(sb.toString());
      return;
    }

    for (int i = 1; i <= totCnt; i++) {
      selected[selCnt] = i;
      permutation(selCnt + 1, totCnt, selected);
    }
  }
}
