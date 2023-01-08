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

    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split("");
      for (int m = 0; m < M; m++) {
        maze[n][m] = Integer.parseInt(line[m]);
      }
    }

    // 결과 출력 부분
    printMaze(maze);
    System.out.println(getDistance(maze));
    printMaze(maze);
    br.close();
  }

  public static Integer getDistance(Integer[][] maze) {
    WallPos start = new WallPos(0, 0);
    WallPos destination = new WallPos(N - 1, M - 1);

    Queue<WallPos> queue = new LinkedList<>();
    Queue<WallPos> newQueue = new LinkedList<>();

    int curTime = -1;
    maze[0][0] = -1;
    queue.offer(start);

    int minDistance = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      curTime -= 1;

      while (!queue.isEmpty()) {
        WallPos cur = queue.poll();

        int curN = cur.getN();
        int curM = cur.getM();

        for (int i = 0; i < dirs.length; i++) {
          int nextN = curN + dirs[i].getN();
          int nextM = curM + dirs[i].getM();

          if (isIn(nextN, nextM)) {
            if (nextN == N - 1 && nextM == M - 1) {
              int distance = Math.abs(curTime);

              if (distance < minDistance) {
                distance = minDistance;
              }

            } else if (maze[nextN][nextM] == 0) {

              maze[nextN][nextM] = curTime;
              newQueue.offer(new WallPos(nextN, nextM));

            } else if (maze[nextN][nextM] == 1) {
              maze[nextN][nextM] = curTime - 100;
            }
          }
        }
      }

      while (!newQueue.isEmpty()) {
        queue.offer(newQueue.poll());
      }
    }

    curTime = -1;
    maze[N - 1][M - 1] = -1;
    queue.offer(destination);

    while (!queue.isEmpty()) {
      curTime -= 1;

      while (!queue.isEmpty()) {
        WallPos cur = queue.poll();

        int curN = cur.getN();
        int curM = cur.getM();

        for (int i = 0; i < dirs.length; i++) {
          int nextN = curN + dirs[i].getN();
          int nextM = curM + dirs[i].getM();

          if (isIn(nextN, nextM)) {
            if (maze[nextN][nextM] < -100) {
              int distance = Math.abs(curTime + maze[nextN][nextM] + 101);
              if (distance < minDistance) {
                minDistance = distance;
              }
            } else if (maze[nextN][nextM] == 0) {
              maze[nextN][nextM] = curTime;
              newQueue.offer(new WallPos(nextN, nextM));
            }
          }
        }
      }

      while (!newQueue.isEmpty()) {
        queue.offer(newQueue.poll());
      }
    }

    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  public static boolean isIn(int n, int m) {
    return (0 <= n && n < N) && (0 <= m && m < M);
  }

  public static void printMaze(Integer[][] maze) {
    System.out.println();
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        System.out.printf("%5d", maze[n][m]);
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
