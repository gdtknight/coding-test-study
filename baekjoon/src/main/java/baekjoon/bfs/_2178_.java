package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

import baekjoon.common.Problem;

public class _2178_ implements Problem {

  static SearchPos[] dirs = new SearchPos[] { new SearchPos(1, 0), new SearchPos(-1, 0), new SearchPos(0, 1),
      new SearchPos(0, -1) };
  static int width;
  static int height;
  static Queue<SearchPos> queue;
  static Queue<SearchPos> fireQueue;
  static Set<SearchPos> hist;
  static Queue<SearchPos> fireHist;

  public void solution(String[] args) throws Exception {

    String filePath = this.getClass()
        .getName()
        .replaceAll("_", "")
        .replaceAll("\\.", "/");

    System.out.println(filePath);

    File file = new File(this.getClass()
        .getClassLoader()
        .getResource(filePath)
        .getPath());

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

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
    Queue<SearchPos> queue = new LinkedList<>();
    int cnt = 0;

    cnt += 1;
    queue.offer(new SearchPos(0, 0));

    while (!queue.isEmpty()) {
      SearchPos cur = queue.poll();
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
          queue.offer(new SearchPos(nextH, nextW));
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

class SearchPos {
  int h;
  int w;

  public SearchPos(int h, int w) {
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
    SearchPos other = (SearchPos) obj;
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
