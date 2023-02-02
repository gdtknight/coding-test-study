package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.Problem;

public class _5427_ implements Problem {
  static Pos[] dirs = new Pos[] {
      new Pos(1, 0),
      new Pos(-1, 0),
      new Pos(0, 1),
      new Pos(0, -1)
  };

  static int W;
  static int H;
  static int N;

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

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());

      char[][] maze = new char[H][W];

      for (int h = 0; h < H; h++) {
        String line = br.readLine();
        for (int w = 0; w < W; w++) {
          maze[h][w] = line.charAt(w);
        }
      }

      // 결과 출력 부분
      System.out.println(escapeTime(maze));
    }
    br.close();
  }

  public static String escapeTime(char[][] maze) {
    int time = 0;
    Queue<Pos> queue = new LinkedList<>();
    Queue<Pos> fireQueue = new LinkedList<>();
    Queue<Pos> newQueue = new LinkedList<>();
    Queue<Pos> newFireQueue = new LinkedList<>();

    for (int h = 0; h < H; h++) {
      for (int w = 0; w < W; w++) {
        if (maze[h][w] == '@') {
          time += 1;
          maze[h][w] = '-';
          queue.offer(new Pos(h, w));
        }

        if (maze[h][w] == '*') {
          fireQueue.offer(new Pos(h, w));
        }
      }
    }

    while (!queue.isEmpty()) {

      while (!fireQueue.isEmpty()) {
        Pos curFirePos = fireQueue.poll();

        int curH = curFirePos.getH();
        int curW = curFirePos.getW();

        for (int i = 0; i < dirs.length; i++) {
          int nextH = curH + dirs[i].getH();
          int nextW = curW + dirs[i].getW();
          if (isIn(nextH, nextW)
              && (maze[nextH][nextW] == '.' || maze[nextH][nextW] == '-')) {
            maze[nextH][nextW] = '*';
            newFireQueue.offer(new Pos(nextH, nextW));
          }

        }
      }

      while (!queue.isEmpty()) {
        Pos curPos = queue.poll();

        int curH = curPos.getH();
        int curW = curPos.getW();

        if (curH == 0 || curH == H - 1 || curW == 0 || curW == W - 1) {
          return (time) + "";
        }

        for (int i = 0; i < dirs.length; i++) {
          int nextH = curH + dirs[i].getH();
          int nextW = curW + dirs[i].getW();
          if (isIn(nextH, nextW) && maze[nextH][nextW] == '.') {
            maze[nextH][nextW] = '@';
            newQueue.offer(new Pos(nextH, nextW));
          }
        }
        maze[curH][curW] = '-';
      }

      time += 1;
      while (!newFireQueue.isEmpty()) {
        fireQueue.offer(newFireQueue.poll());
      }
      while (!newQueue.isEmpty()) {
        queue.offer(newQueue.poll());
      }
    }

    return "IMPOSSIBLE";
  }

  public static boolean isIn(int h, int w) {
    return (0 <= h && h < H) && (0 <= w && w < W);
  }

}

class Pos {
  int h;
  int w;

  public Pos(int h, int w) {
    this.h = h;
    this.w = w;
  }

  public int getH() {
    return h;
  }

  public int getW() {
    return w;
  }
}
