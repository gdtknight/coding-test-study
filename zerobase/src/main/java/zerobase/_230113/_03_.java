package zerobase._230113;

import java.io.BufferedReader;
import java.util.Stack;

import common.Initialization;
import common.Problem;

public class _03_ implements Problem {

  // 0 < N <= 100
  // 0 < edges.length <= 1000
  static int N = 13;
  static int[][] edges = new int[][] {
      { 1, 2 },
      { 1, 3 },
      { 2, 4 },
      { 2, 5 },
      { 3, 6 },
      { 4, 7 },
      { 5, 7 },
      { 6, 5 },
      { 6, 8 },
      { 7, 9 },
      { 8, 10 },
      { 9, 10 },
      { 10, 11 },
      { 11, 12 },
      { 12, 13 }
  };

  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int answer(int N, int[][] edges) {
    boolean[][] map = new boolean[N + 1][N + 1];
    for (int i = 0; i < edges.length; i++) {
      map[edges[i][0]][edges[i][1]] = true;
    }

    Stack<Integer> stack = new Stack<>();
    int[] distance = new int[N + 1];
    boolean[] visited = new boolean[N + 1];
    int minDistance = 0;
    distance[1] = 0;
    visited[1] = true;
    stack.push(1);
    while (!stack.isEmpty()) {
      int cur = stack.pop();

      for (int i = 1; i <= N; i++) {
        if (map[cur][i] && !visited[i]) {
          visited[i] = true;
          distance[i] = distance[cur] + 1;
          stack.push(i);
        } else if (map[cur][i] && visited[i]) {
          distance[i] = Math.min(distance[i], distance[cur] + 1);
        }
      }
    }

    System.out.printf("   ");
    for (int i = 1; i <= N; i++) {
      System.out.printf("%3d", i);
    }
    System.out.println();
    for (int i = 1; i <= N; i++) {
      System.out.printf("%3d", i);
      for (int j = 1; j <= N; j++) {
        if (i == j) {
          System.out.print(" - ");
        } else {
          System.out.printf("%3d", distance[j]);
        }
      }
      System.out.println();
    }

    return minDistance;
  }
}
