package baekjoon.backtracking;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _15649_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }

    boolean[] visited = new boolean[N];
    int[] selection = new int[M];

    permutation(arr, 0, M, visited, selection);

    br.close();
  }

  public static void permutation(int[] arr, int selectedCnt, int totalCnt, boolean[] visited, int[] selection) {
    if (selectedCnt == totalCnt) {
      System.out.println(Arrays.toString(selection).replaceAll("[\\[\\]\\,]", ""));
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selection[selectedCnt] = arr[i];
        permutation(arr, selectedCnt + 1, totalCnt, visited, selection);
        visited[i] = false;
      }
    }

  }

}
