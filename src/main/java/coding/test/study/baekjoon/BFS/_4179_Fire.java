package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _4179_Fire {
  static Pos[] dirs = new Pos[] { new Pos(1, 0), new Pos(-1, 0), new Pos(0, 1), new Pos(0, -1) };
  static int width;
  static int height;
  static Queue<Pos> queue;
  static Queue<Pos> fireQueue;
  static Set<Pos> hist;
  static Set<Pos> fireHist;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/";

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_4179_TestCase")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    width = Integer.parseInt(st.nextToken());
    height = Integer.parseInt(st.nextToken());

    queue = new LinkedList<>();
    hist = new HashSet<>();
    fireHist = new HashSet<>();

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

    init(maze);

    while (!queue.isEmpty()) {
      fire(maze);

      Pos curPos = queue.poll();

      int curH = curPos.getH();
      int curW = curPos.getW();

      if (curW == 0 || curW == width - 1 || curH == 0 || curH == height - 1) {
        return (time + 1) + "";
      }

      maze[curPos.getH()][curPos.getW()] = "J";
      addToQueue(maze, curPos);
      maze[curPos.getH()][curPos.getW()] = "-";

      time += 1;
    }

    return "IMPOSSIBLE";
  }

  private static void init(String[][] maze) {

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("J".equals(maze[h][w])) {
          queue.offer(new Pos(h, w));
        }
      }
    }

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("F".equals(maze[h][w])) {
          fireHist.add(new Pos(h, w));
        }
      }
    }

  }

  private static void addToQueue(String[][] maze, Pos curPos) {
    for (int i = 0; i < dirs.length; i++) {
      int nextH = curPos.getH() + dirs[i].getH();
      int nextW = curPos.getW() + dirs[i].getW();
      Pos nextPos = new Pos(nextH, nextW);

      if (inMaze(nextH, nextW) && ".".equals(maze[nextH][nextW]) && hist.add(nextPos)) {
        queue.offer(nextPos);
      }
    }
  }

  public static void fire(String[][] maze) {
    Set<Pos> newFireHist = new HashSet<>();

    for (Pos pos : fireHist) {
      newFireHist.add(pos);
      for (int i = 0; i < dirs.length; i++) {
        int nextH = pos.getH() + dirs[i].getH();
        int nextW = pos.getW() + dirs[i].getW();

        if (inMaze(nextH, nextW) && (".".equals(maze[nextH][nextW]) || "-".equals(maze[nextH][nextW]))) {
          maze[nextH][nextW] = "F";
          newFireHist.add(new Pos(nextH, nextW));
        }
      }
    }

    fireHist = newFireHist;
  }

  public static boolean inMaze(int h, int w) {
    return (0 <= h && h < height) && (0 <= w && w < width);
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
