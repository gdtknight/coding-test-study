package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
    Integer[][] tmpMaze = new Integer[N][M];

    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split("");
      for (int m = 0; m < M; m++) {
        maze[n][m] = Integer.parseInt(line[m]) * -2;
        tmpMaze[n][m] = Integer.parseInt(line[m]) * -2;
      }
    }

    // 결과 출력 부분
    System.out.println(getDistance(maze, tmpMaze));
    br.close();
  }

  public static Integer getDistance(Integer[][] maze, Integer[][] tmpMaze) {
    maze[0][0] = 1;

    int minDistance = Integer.MAX_VALUE;

    WallPos start = new WallPos(0, 0);
    WallPos dest = new WallPos(N - 1, M - 1);

    Queue<WallPos> queue = new LinkedList<>();

    queue.offer(start);

    while (!queue.isEmpty()) {
      WallPos cur = queue.poll();

      int curN = cur.getN();
      int curM = cur.getM();

      int curDistance = maze[curN][curM];

      for (int i = 0; i < dirs.length; i++) {
        int nextN = curN + dirs[i].getN();
        int nextM = curM + dirs[i].getM();

        if (isIn(nextN, nextM)) {
          if (maze[nextN][nextM] == 0) {
            maze[nextN][nextM] = curDistance + 1;
            queue.offer(new WallPos(nextN, nextM));
          } else if (maze[nextN][nextM] == -2) {
            maze[nextN][nextM] = curDistance + 10001;
            tmpMaze[nextN][nextM] = maze[nextN][nextM];
          }
        }
      }
    }

    // printMaze(maze);
    // printMaze(tmpMaze);

    if (maze[N - 1][M - 1] != 0) {
      minDistance = maze[N - 1][M - 1];

      tmpMaze[N - 1][M - 1] = 1;
      queue.offer(dest);

      while (!queue.isEmpty()) {
        WallPos cur = queue.poll();

        int curN = cur.getN();
        int curM = cur.getM();

        int curDistance = tmpMaze[curN][curM];

        for (int i = 0; i < dirs.length; i++) {
          int nextN = curN + dirs[i].getN();
          int nextM = curM + dirs[i].getM();

          if (isIn(nextN, nextM)) {
            if (tmpMaze[nextN][nextM] == 0) {

              tmpMaze[nextN][nextM] = curDistance + 1;
              queue.offer(new WallPos(nextN, nextM));

            } else if (tmpMaze[nextN][nextM] > 10000) {
              int distance = curDistance + tmpMaze[nextN][nextM] - 10000;
              if (distance < minDistance) {
                minDistance = distance;
              }
            }
          }
        }
      }

    } else {
      tmpMaze[N - 1][M - 1] = 1;
      queue.offer(dest);

      while (!queue.isEmpty()) {
        WallPos cur = queue.poll();

        int curN = cur.getN();
        int curM = cur.getM();

        int curDistance = tmpMaze[curN][curM];

        for (int i = 0; i < dirs.length; i++) {
          int nextN = curN + dirs[i].getN();
          int nextM = curM + dirs[i].getM();

          if (isIn(nextN, nextM)) {
            if (tmpMaze[nextN][nextM] == 0) {

              tmpMaze[nextN][nextM] = curDistance + 1;
              queue.offer(new WallPos(nextN, nextM));

            } else if (tmpMaze[nextN][nextM] > 10000) {
              int distance = curDistance + tmpMaze[nextN][nextM] - 10000;
              if (distance < minDistance) {
                minDistance = distance;
              }
            }
          }
        }
      }
    }

    // printMaze(maze);
    // printMaze(tmpMaze);

    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + n;
    result = prime * result + m;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WallPos other = (WallPos) obj;
    if (n != other.n)
      return false;
    if (m != other.m)
      return false;
    return true;
  }
}
