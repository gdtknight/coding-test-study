package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.Problem;

public class _4179_ implements Problem {
  static FirePos[] dirs = new FirePos[] {
      new FirePos(1, 0),
      new FirePos(-1, 0),
      new FirePos(0, 1),
      new FirePos(0, -1)
  };

  static int cols;
  static int rows;

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
    rows = Integer.parseInt(st.nextToken());
    cols = Integer.parseInt(st.nextToken());

    char[][] maze = new char[rows][cols];

    for (int r = 0; r < rows; r++) {
      String line = br.readLine();
      for (int c = 0; c < cols; c++) {
        maze[r][c] = line.charAt(c);
      }
    }

    // 결과 출력 부분
    printMaze(maze);
    System.out.println(escapeTime(maze));
    printMaze(maze);
    br.close();
  }

  public static String escapeTime(char[][] maze) {
    int time = 0;

    Queue<FirePos> queue = new LinkedList<>();
    Queue<FirePos> fireQueue = new LinkedList<>();
    Queue<FirePos> newQueue = new LinkedList<>();
    Queue<FirePos> newFireQueue = new LinkedList<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (maze[r][c] == 'J') {
          time += 1;
          maze[r][c] = '-';
          queue.offer(new FirePos(r, c));
        }

        if (maze[r][c] == 'F') {
          fireQueue.offer(new FirePos(r, c));
        }
      }
    }

    while (!queue.isEmpty()) {

      while (!fireQueue.isEmpty()) {
        FirePos curFirePos = fireQueue.poll();

        int curH = curFirePos.getR();
        int curW = curFirePos.getC();

        for (int i = 0; i < dirs.length; i++) {
          int nextH = curH + dirs[i].getR();
          int nextW = curW + dirs[i].getC();
          if (isIn(nextH, nextW)
              && (maze[nextH][nextW] == '.' || maze[nextH][nextW] == '-')) {
            maze[nextH][nextW] = 'F';
            newFireQueue.offer(new FirePos(nextH, nextW));
          }

        }
      }

      while (!queue.isEmpty()) {
        FirePos curPos = queue.poll();

        int curH = curPos.getR();
        int curW = curPos.getC();

        if (curH == 0 || curH == rows - 1 || curW == 0 || curW == cols - 1) {
          return time + "";
        }

        for (int i = 0; i < dirs.length; i++) {
          int nextH = curH + dirs[i].getR();
          int nextW = curW + dirs[i].getC();
          if (isIn(nextH, nextW) && maze[nextH][nextW] == '.') {
            maze[nextH][nextW] = 'J';
            newQueue.offer(new FirePos(nextH, nextW));
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
    return (0 <= h && h < rows) && (0 <= w && w < cols);
  }

  public static void printMaze(char[][] maze) {
    System.out.println();
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        System.out.print(maze[r][c] + " ");
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

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}
