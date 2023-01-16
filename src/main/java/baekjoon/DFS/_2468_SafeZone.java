package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2468_SafeZone {

  static int[][] dirs = new int[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 },
  };

  static int N = 0;
  static int min = Integer.MAX_VALUE;
  static int max = 0;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase";
    String packagePath = "/baekjoon/DFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/2468")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    int[][] map = new int[N][N];

    StringTokenizer st = null;

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine(), " ");

      for (int m = 0; m < N; m++) {
        map[n][m] = Integer.parseInt(st.nextToken());

        if (map[n][m] < min) {
          min = map[n][m];
        }

        if (map[n][m] > max) {
          max = map[n][m];
        }
      }
    }
    // printMap(map);
    // System.out.println(min);
    // System.out.println(max);

    Stack<Pos> stack = new Stack<>();

    boolean[][] visitedMap = null;

    int maxCountSafeArea = 1;

    for (int height = min; height < max; height++) {
      visitedMap = new boolean[N][N];

      int cnt = 0;

      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {

          // printMap(map, visitedMap);

          if (map[x][y] > height && !visitedMap[x][y]) {
            cnt += 1;
            visitedMap[x][y] = true;

            stack.push(new Pos(x, y));

            while (!stack.isEmpty()) {
              Pos cur = stack.pop();

              int curX = cur.getX();
              int curY = cur.getY();

              for (int i = 0; i < dirs.length; i++) {
                int nextX = curX + dirs[i][0];
                int nextY = curY + dirs[i][1];
                if (isIn(nextX, nextY) && map[nextX][nextY] > height && !visitedMap[nextX][nextY]) {
                  visitedMap[nextX][nextY] = true;
                  stack.push(new Pos(nextX, nextY));
                }
              }

            }

          }

          // printMap(map, visitedMap);
        }
      }

      if (cnt > maxCountSafeArea) {
        maxCountSafeArea = cnt;
      }

    }

    System.out.println(maxCountSafeArea);

    br.close();
  }

  private static boolean isIn(int nextX, int nextY) {
    return (0 <= nextX && nextX < N)
        && (0 <= nextY && nextY < N);

  }

  private static void printMap(int[][] map) {
    System.out.println();

    for (int x = 0; x < map.length; x++) {

      for (int y = 0; y < map[0].length; y++) {
        System.out.print(map[x][y] + " ");
      }

      System.out.println();
    }

    System.out.println();
  }

  private static void printMap(int[][] map, boolean[][] visitedMap) {
    System.out.println();

    for (int x = 0; x < visitedMap.length; x++) {

      for (int y = 0; y < visitedMap[0].length; y++) {
        System.out.printf("%3d", (visitedMap[x][y] ? -1 : map[x][y]));
      }

      System.out.println();
    }

    System.out.println();
  }
}

class Pos {
  int x;
  int y;

  public Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
