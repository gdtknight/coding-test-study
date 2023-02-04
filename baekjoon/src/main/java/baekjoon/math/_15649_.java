package baekjoon.math;

import java.io.BufferedReader;
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
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }

    permutation(arr, 0, 0, M, visited);

    br.close();
  }

  public void permutation(int[] arr, int depth, int startIdx, int M, boolean[] visited) {
    if (depth == M) {
      for (int i = 0; i < arr.length; i++) {
        if (visited[i]) {
          System.out.print(arr[i] + " ");
        }
      }
      System.out.println();
      System.out.println("-------");
      return;
    }

    for (int i = startIdx; i < arr.length; i++) {
      visited[i] = true;
      permutation(arr, depth + 1, i + 1, M, visited);
      visited[i] = false;
    }

  }

}
