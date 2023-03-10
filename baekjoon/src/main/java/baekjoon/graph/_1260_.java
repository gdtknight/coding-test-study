package baekjoon.graph;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1260_ implements Problem {

  @Override
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int Vn = Integer.parseInt(st.nextToken());
    int En = Integer.parseInt(st.nextToken());

    int start = Integer.parseInt(st.nextToken());

    boolean[][] map = new boolean[Vn + 1][Vn + 1];

    boolean[] visitedDfs = new boolean[Vn + 1];
    boolean[] visitedBfs = new boolean[Vn + 1];

    for (int i = 0; i < En; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int Vs = Integer.parseInt(st.nextToken());
      int Ve = Integer.parseInt(st.nextToken());

      map[Vs][Ve] = true;
      map[Ve][Vs] = true;
    }

    // dfs
    dfs(map, visitedDfs, start);
    System.out.println();

    // bfs
    bfs(map, visitedBfs, start);
    System.out.println();
  }

  public static void dfs(boolean[][] map, boolean[] visited, int cur) {
    if (visited[cur]) {
      return;
    }

    System.out.print(cur + " ");
    visited[cur] = true;

    for (int i = 1; i < map.length; i++) {
      if (map[cur][i] && !visited[i]) {
        dfs(map, visited, i);
      }
    }
  }

  public static void bfs(boolean[][] map, boolean[] visited, int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);

    StringBuilder sb = new StringBuilder(start + " ");

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int i = 1; i < map.length; i++) {
        if (map[cur][i] && !visited[i]) {
          visited[i] = true;
          sb.append(i + " ");
          queue.offer(i);
        }
      }
    }

    System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
  }
}
