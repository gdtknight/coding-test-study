package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_Fire {
  static FirePos[] dirs = new FirePos[] { new FirePos(1, 0), new FirePos(-1, 0), new FirePos(0, 1),
      new FirePos(0, -1) };
  static int rows;
  static int cols;
  static Queue<FirePos> queue;
  static Queue<FirePos> fireQueue;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/baekjoon/BFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_4179_TestCase")));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    rows = Integer.parseInt(st.nextToken());
    cols = Integer.parseInt(st.nextToken());

    queue = new LinkedList<>();
    fireQueue = new LinkedList<>();

    String[][] maze = new String[rows][];

    for (int r = 0; r < rows; r++) {
      String[] c = br.readLine().split("");
      maze[r] = c;
    }

    // 결과 출력 부분
    System.out.println(escapeTime(maze));

    br.close();
  }

  public static String escapeTime(String[][] maze) {
    int time = 0;

    outer: for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if ("J".equals(maze[r][c])) {
          maze[r][c] = time + "";
          queue.offer(new FirePos(r, c));
          break outer;
        }
      }
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if ("F".equals(maze[r][c])) {
          fireQueue.offer(new FirePos(r, c));
        }
      }
    }

    while (!queue.isEmpty()) {
      if (checkQueue(maze)) {

      }

      FirePos curFirePos = queue.poll();

      int curR = curFirePos.getR();
      int curC = curFirePos.getC();

      time = Integer.parseInt(maze[curR][curC]);

      maze[curR][curC] = "J";
      fire(maze);
      maze[curR][curC] = time + "";
      time += 1;
      addToQueue(maze, curFirePos, time);
      printMaze(maze);
    }

    return "IMPOSSIBLE";
  }

  private static boolean checkQueue(String[][] maze) {
    Queue<FirePos> tmpQueue = new LinkedList<>();

    while (!queue.isEmpty()) {
      FirePos pos = queue.poll();

      int curR = pos.getR();
      int curC = pos.getC();

      if (curC == 0 || curC == cols - 1 || curR == 0 || curR == rows - 1) {
        return true;
      }
      tmpQueue.add(pos);
    }

    queue = tmpQueue;
    return false;
  }

  private static void addToQueue(String[][] maze, FirePos curFirePos, int time) {
    int curR = curFirePos.getR();
    int curC = curFirePos.getC();

    for (int i = 0; i < dirs.length; i++) {
      int nextR = curR + dirs[i].getR();
      int nextC = curC + dirs[i].getC();

      if (inMaze(nextR, nextC) && ".".equals(maze[nextR][nextC])) {
        maze[nextR][nextC] = time + "";
        queue.offer(new FirePos(nextR, nextC));
      }
    }
  }

  public static void fire(String[][] maze) {
    Queue<FirePos> newFireQueue = new LinkedList<>();

    while (!fireQueue.isEmpty()) {
      FirePos FirePos = fireQueue.poll();

      for (int i = 0; i < dirs.length; i++) {
        int nextR = FirePos.getR() + dirs[i].getR();
        int nextC = FirePos.getC() + dirs[i].getC();

        if (inMaze(nextR, nextC)
            && !"F".equals(maze[nextR][nextC])
            && !"#".equals(maze[nextR][nextC])
            && !"J".equals(maze[nextR][nextC])) {
          maze[nextR][nextC] = "F";
          newFireQueue.offer(new FirePos(nextR, nextC));
        }
      }
    }

    fireQueue = newFireQueue;
  }

  public static boolean inMaze(int h, int w) {
    return (0 <= h && h < rows) && (0 <= w && w < cols);
  }

  private static void printMaze(String[][] maze) {
    System.out.println();
    for (int h = 0; h < rows; h++) {
      for (int w = 0; w < cols; w++) {
        System.out.print(maze[h][w] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

class FirePos {
  int r;
  int c;

  public FirePos(int r, int c) {
    this.r = r;
    this.c = c;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + r;
    result = prime * result + c;
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
    FirePos other = (FirePos) obj;
    if (r != other.r)
      return false;
    if (c != other.c)
      return false;
    return true;
  }

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}
