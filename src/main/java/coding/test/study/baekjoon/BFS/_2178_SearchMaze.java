package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _2178_SearchMaze {

  static Pos[] dirs = new Pos[] { new Pos(1, 0), new Pos(-1, 0), new Pos(0, 1), new Pos(0, -1) };
  static int width;
  static int height;
  static Queue<Pos> queue;
  static Queue<Pos> fireQueue;
  static Set<Pos> hist;
  static Queue<Pos> fireHist;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/";

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_2178_TestCase")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    height = Integer.parseInt(st.nextToken());
    width = Integer.parseInt(st.nextToken());
    System.out.println("height: " + height + ", width: " + width);

    String[][] maze = new String[height][];

    for (int h = 0; h < height; h++) {
      String[] w = br.readLine().split("");
      maze[h] = w;
    }

    // 결과 출력 부분
    findDestination(maze);

    br.close();
  }

  public static void findDestination(String[][] maze) {
    Queue<Pos> queue = new LinkedList<>();
    int cnt = 0;

    cnt += 1;
    queue.offer(new Pos(0, 0));

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();
      if (cur.getH() == height - 1 && cur.getW() == width - 1) {
        System.out.println(maze[cur.getH()][cur.getW()]);
        break;
      }

      cnt = Integer.parseInt(maze[cur.getH()][cur.getW()]) + 1;

      for (int i = 0; i < dirs.length; i++) {
        int nextH = cur.getH() + dirs[i].getH();
        int nextW = cur.getW() + dirs[i].getW();
        if (isIn(nextH, nextW) && "1".equals(maze[nextH][nextW])) {
          maze[nextH][nextW] = cnt + "";
          queue.offer(new Pos(nextH, nextW));
        }
      }
    }
  }

  private static boolean isIn(int nextH, int nextW) {
    return (0 <= nextH && nextH < height)
        && (0 <= nextW && nextW < width);
  }

  private static void printPic(String[][] pic) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        System.out.print(pic[h][w] + " ");
      }
      System.out.println();
    }
  }
}
