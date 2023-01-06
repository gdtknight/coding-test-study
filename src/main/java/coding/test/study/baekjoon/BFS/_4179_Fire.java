package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_Fire {
  static Pos[] dirs = new Pos[] { new Pos(1, 0), new Pos(-1, 0), new Pos(0, 1), new Pos(0, -1) };
  static int width;
  static int height;
  static Queue<Pos> queue;
  static Queue<Pos> fireQueue;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/";
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_4179_TestCase")));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    height = Integer.parseInt(st.nextToken());
    width = Integer.parseInt(st.nextToken());

    queue = new LinkedList<>();
    fireQueue = new LinkedList<>();

    String[][] maze = new String[height][];

    for (int h = 0; h < height; h++) {
      String[] w = br.readLine().split("");
      maze[h] = w;
    }

    // 결과 출력 부분
    System.out.println(escapeTime(maze));

    br.close();
  }

  public static String escapeTime(String[][] maze) {
    int time = 0;

    outer: for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("J".equals(maze[h][w])) {
          maze[h][w] = time + "";
          queue.offer(new Pos(h, w));
          break outer;
        }
      }
    }

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("F".equals(maze[h][w])) {
          fireQueue.offer(new Pos(h, w));
        }
      }
    }

    while (!queue.isEmpty()) {
      Pos curPos = queue.poll();

      int curH = curPos.getH();
      int curW = curPos.getW();

      time = Integer.parseInt(maze[curH][curW]) + 1;

      if (curW == 0 || curW == width - 1 || curH == 0 || curH == height - 1) {
        return time + "";
      }

      maze[curH][curW] = "J";

      fire(maze);

      maze[curH][curW] = time + "";
      addToQueue(maze, curPos, time);
      printMaze(maze);
    }

    return "IMPOSSIBLE";
  }

  private static void addToQueue(String[][] maze, Pos curPos, int time) {
    int curH = curPos.getH();
    int curW = curPos.getW();

    for (int i = 0; i < dirs.length; i++) {
      int nextH = curH + dirs[i].getH();
      int nextW = curW + dirs[i].getW();

      if (inMaze(nextH, nextW) && ".".equals(maze[nextH][nextW])) {
        maze[nextH][nextW] = time + "";
        queue.offer(new Pos(nextH, nextW));
      }
    }
  }

  public static void fire(String[][] maze) {
    Queue<Pos> newFireQueue = new LinkedList<>();

    while (!fireQueue.isEmpty()) {
      Pos pos = fireQueue.poll();

      for (int i = 0; i < dirs.length; i++) {
        int nextH = pos.getH() + dirs[i].getH();
        int nextW = pos.getW() + dirs[i].getW();

        if (inMaze(nextH, nextW)
            && !"F".equals(maze[nextH][nextW])
            && !"#".equals(maze[nextH][nextW])
            && !"J".equals(maze[nextH][nextW])) {
          maze[nextH][nextW] = "F";
          newFireQueue.offer(new Pos(nextH, nextW));
        }
      }
    }

    fireQueue = newFireQueue;
  }

  public static boolean inMaze(int h, int w) {
    return (0 <= h && h < height) && (0 <= w && w < width);
  }

  private static void printMaze(String[][] maze) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        System.out.print(maze[h][w] + " ");
      }
      System.out.println();
    }
  }
}

class Pos {
  int h;
  int w;

  public Pos(int h, int w) {
    this.h = h;
    this.w = w;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + h;
    result = prime * result + w;
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
    Pos other = (Pos) obj;
    if (h != other.h)
      return false;
    if (w != other.w)
      return false;
    return true;
  }

  public int getH() {
    return h;
  }

  public int getW() {
    return w;
  }
}
