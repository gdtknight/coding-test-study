package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _1926_Picture {

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
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_1926_TestCase")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    height = Integer.parseInt(st.nextToken());
    width = Integer.parseInt(st.nextToken());
    System.out.println("height: " + height + ", width: " + width);

    String[][] pic = new String[height][];

    for (int h = 0; h < height; h++) {
      String[] w = br.readLine().split(" ");
      pic[h] = w;
    }

    // 결과 출력 부분
    findMaxArea(pic);

    br.close();
  }

  public static void findMaxArea(String[][] pic) {
    int picCnt = 0;
    int maxArea = 0;
    int area = 0;

    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("1".equals(pic[h][w])) {
          picCnt += 1;
          area = calculateArea(pic, h, w);
        }

        if (area > maxArea) {
          maxArea = area;
        }
      }
    }

    System.out.println(picCnt);
    System.out.println(maxArea);
  }

  private static int calculateArea(String[][] pic, int h, int w) {
    int area = 1;

    Queue<Pos> queue = new LinkedList<>();

    pic[h][w] = "2";
    queue.offer(new Pos(h, w));

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();
      for (int i = 0; i < dirs.length; i++) {
        int nextH = cur.getH() + dirs[i].getH();
        int nextW = cur.getW() + dirs[i].getW();
        if (isIn(nextH, nextW) && "1".equals(pic[nextH][nextW])) {
          pic[nextH][nextW] = "2";
          area += 1;
          queue.offer(new Pos(nextH, nextW));
        }
      }
    }

    return area;
  }

  private static void printPic(String[][] pic) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        System.out.print(pic[h][w] + " ");
      }
      System.out.println();
    }
  }

  private static boolean isIn(int nextH, int nextW) {
    return (0 <= nextH && nextH < height)
        && (0 <= nextW && nextW < width);
  }
}
