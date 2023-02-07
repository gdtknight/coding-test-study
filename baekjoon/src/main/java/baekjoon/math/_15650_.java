package baekjoon.math;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _15650_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[] selected = new boolean[N];

    permutation(0, M, 0, selected);

    br.close();
  }

  public void permutation(int selCnt, int totCnt, int startIdx, boolean[] selected) {
    int n = selected.length;
    if (selCnt == totCnt) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (selected[i]) {
          sb.append((i + 1) + " ");
        }
      }
      sb.deleteCharAt(sb.length() - 1);
      System.out.println(sb.toString());
    }

    for (int i = startIdx; i < n; i++) {
      selected[i] = true;
      permutation(selCnt + 1, totCnt, i + 1, selected);
      selected[i] = false;
    }
  }
}
