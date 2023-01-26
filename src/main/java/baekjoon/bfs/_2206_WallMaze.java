package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_WallMaze {
  static int[][] dirs = new int[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 }
  };

  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Integer[][] maze = new Integer[N][M];

    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split("");
      for (int m = 0; m < M; m++) {
        maze[n][m] = Integer.parseInt(line[m]) * (-1);
      }
    }

    // 결과 출력 부분
    System.out.println(getDistance(maze));
    br.close();
  }

  public static Integer getDistance(Integer[][] maze) {
    Queue<WallPos> queue = new LinkedList<>();
    Queue<WallPos> wallQueue = new LinkedList<>();

    // 1차 탐색
    maze[0][0] = 1;
    queue.offer(new WallPos(0, 0));

    while (!queue.isEmpty()) {
      WallPos cur = queue.poll();

      int curN = cur.getN();
      int curM = cur.getM();

      int distance = maze[curN][curM];

      for (int i = 0; i < dirs.length; i++) {

        int nextN = curN + dirs[i][0];
        int nextM = curN + dirs[i][1];

        if (isIn(nextN, nextM)) {
          if (maze[nextN][nextM] == 0) {
            maze[nextN][nextM] = distance + 1;
            queue.offer(new WallPos(nextN, nextM));

          } else if (maze[nextN][nextM] == -1) {

            // 벽을 뚫었을 때 길이 통한다면 queue 에 추가
            for (int j = 0; j < dirs.length; j++) {
              int n = nextN + dirs[j][0];
              int m = nextM + dirs[j][1];
              if (isIn(n, m) && maze[n][m] == 0) {
                maze[n][m] = distance + 2;
                wallQueue.offer(new WallPos(n, m));
              }
            }

            while (!wallQueue.isEmpty()) {
              for (int j = 0; j < dirs.length; j++) {
                int n = nextN + dirs[j][0];
                int m = nextM + dirs[j][1];
                if (isIn(n, m) && maze[n][m] == 0) {
                  maze[n][m] = distance + 2;
                  wallQueue.offer(new WallPos(n, m));
                }
              }
            }
          }
        }
      }
    }

    return maze[N - 1][M - 1] == 0
        ? Integer.MAX_VALUE
        : maze[N - 1][M - 1];
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