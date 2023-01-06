package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _5427_Fire {
  static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
  static int width;
  static int height;
  static Queue<List<Integer>> queue;
  static Set<List<Integer>> hist;
  static Set<List<Integer>> fireHist;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/";

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_5427_TestCase")));
    int numsOfTestCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < numsOfTestCase; i++) {
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
    }
    br.close();
  }

  public static String escapeTime(String[][] maze) {
    int time = 0;

    initFireHist(maze);

    List<Integer> curPos = findPos(maze);
    queue.offer(curPos);
    hist.add(curPos);
    fire(maze);
    findWayAndAddToQueue(maze, curPos);
    while (!queue.isEmpty()) {
      curPos = queue.poll();
      int curX = curPos.get(0);
      int curY = curPos.get(1);
      if (curX == 0 || curX == width || curY == 0 || curY == height) {
        return (time + 1) + "";
      }
      fire(maze);
      findWayAndAddToQueue(maze, curPos);
      time += 1;
    }

    return "IMPOSSIBLE";
  }

  private static List<Integer> findPos(String[][] maze) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("@".equals(maze[h][w])) {
          return Arrays.asList(h, w);

        }
      }
    }
    return null;
  }

  private static void findWayAndAddToQueue(String[][] maze, List<Integer> curPos) {
    for (int i = 0; i < 4; i++) {
      int nextH = curPos.get(0) + dirs[i][0];
      int nextW = curPos.get(1) + dirs[i][1];
      boolean inMaze = isIn(nextH, nextW);
      if (inMaze) {
        List<Integer> nextPos = Arrays.asList(nextH, nextW);
        if (".".equals(maze[nextH][nextW]) && !hist.add(nextPos)) {
          queue.offer(Arrays.asList(nextH, nextW));
        }
      }
    }
  }

  private static void initFireHist(String[][] maze) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if ("*".equals(maze[h][w])) {
          fireHist.add(Arrays.asList(w, h));
        }
      }
    }
  }

  public static void fire(String[][] maze) {
    Set<List<Integer>> newFireHist = new HashSet<>();
    for (List<Integer> pos : fireHist) {
      newFireHist.add(pos);
      for (int i = 0; i < dirs.length; i++) {
        int nextH = pos.get(0) + dirs[i][0];
        int nextW = pos.get(1) + dirs[i][1];

        boolean inMaze = isIn(nextH, nextW);

        if (inMaze && ".".equals(maze[nextH][nextW])) {
          maze[nextH][nextW] = "*";
          newFireHist.add(Arrays.asList(nextH, nextW));
        }
      }
    }
    fireHist = newFireHist;
  }

  public static boolean isIn(int h, int w) {
    return (0 <= h && h < height) && (0 <= w && w < width);
  }

}
