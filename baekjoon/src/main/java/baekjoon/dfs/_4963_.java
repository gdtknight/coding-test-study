package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import baekjoon.common.Problem;

public class _4963_ implements Problem {

  static int[][] dirs = new int[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 },
      { 1, 1 },
      { -1, -1 },
      { 1, -1 },
      { -1, 1 }
  };

  static int W = -1;
  static int H = -1;

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
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    Stack<Island> stack = new Stack<>();

    while (W != 0 && H != 0) {
      char[][] map = new char[H][W];

      for (int h = 0; h < H; h++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int w = 0; w < W; w++) {
          map[h][w] = st.nextToken().charAt(0);
        }
      }

      // printMap(map);

      int islandCount = 0;

      for (int h = 0; h < H; h++) {
        for (int w = 0; w < W; w++) {
          if (map[h][w] == '1') {
            islandCount += 1;

            map[h][w] = '2';
            stack.push(new Island(h, w));

            while (!stack.isEmpty()) {
              Island cur = stack.pop();

              int curH = cur.getH();
              int curW = cur.getW();

              for (int i = 0; i < dirs.length; i++) {

                int nextH = curH + dirs[i][0];
                int nextW = curW + dirs[i][1];

                if (isIn(nextH, nextW) && map[nextH][nextW] == '1') {
                  map[nextH][nextW] = '2';
                  stack.push(new Island(nextH, nextW));
                }
              }
            }
          }
        }
      }

      // printMap(map);

      System.out.println(islandCount);

      st = new StringTokenizer(br.readLine(), " ");

      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static boolean isIn(int nextH, int nextW) {
    return (0 <= nextH && nextH < H)
        && (0 <= nextW && nextW < W);

  }

  private static void printMap(char[][] map) {
    System.out.println();
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

class Island {
  int h;
  int w;

  public Island(int h, int w) {
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
