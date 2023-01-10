package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2206_WallMaze {
  static WallPos[] dirs = new WallPos[] {
      new WallPos(1, 0),
      new WallPos(-1, 0),
      new WallPos(0, 1),
      new WallPos(0, -1)
  };

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/baekjoon/BFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_2206_TestCase")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Integer[][] maze = new Integer[N][M];

    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split("");
      for (int m = 0; m < M; m++) {
        maze[n][m] = Integer.parseInt(line[m]) * (-2);
      }
    }

    // 결과 출력 부분
    System.out.println(getDistance(maze));
    br.close();
  }

  public static Integer getDistance(Integer[][] maze) {

    int minDistance = bfs(maze);

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (maze[n][m] == -2) {
          initMaze(maze);

          maze[n][m] = 0;

          int distance = bfs(maze);

          if (distance < minDistance) {
            minDistance = distance;
          }

          maze[n][m] = -2;
        }
      }
    }

    return minDistance == Integer.MAX_VALUE
        ? -1
        : minDistance;
  }

  public static void initMaze(Integer[][] maze) {
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (maze[n][m] != -2) {
          maze[n][m] = 0;
        }
      }
    }
  }

  public static int bfs(Integer[][] maze) {

    Queue<WallPos> queue = new LinkedList<>();

    maze[0][0] = 1;
    maze[N - 1][M - 1] = 0;
    queue.offer(new WallPos(0, 0));

    while (!queue.isEmpty()) {
      WallPos cur = queue.poll();

      int curN = cur.getN();
      int curM = cur.getM();

      int distance = maze[curN][curM];

      for (int i = 0; i < dirs.length; i++) {
        int nextN = curN + dirs[i].getN();
        int nextM = curM + dirs[i].getM();
        if (isIn(nextN, nextM) && maze[nextN][nextM] == 0) {
          maze[nextN][nextM] = distance + 1;
          queue.offer(new WallPos(nextN, nextM));
        }
      }
    }
    return maze[N - 1][M - 1] == 0 ? Integer.MAX_VALUE : maze[N - 1][M - 1];
  }

  public static boolean isIn(int n, int m) {
    return (0 <= n && n < N)
        && (0 <= m && m < M);
  }

  public static void printMaze(Integer[][] maze) {
    System.out.println();
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        System.out.printf("%6d", maze[n][m]);
      }
      System.out.println();
    }
    System.out.println();
  }

}

class WallPos {
  int n;
  int m;

  public WallPos(int n, int m) {
    this.n = n;
    this.m = m;
  }

  public int getN() {
    return n;
  }

  public int getM() {
    return m;
  }
}
