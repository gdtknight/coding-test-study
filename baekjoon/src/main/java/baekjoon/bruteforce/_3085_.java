package baekjoon.bruteforce;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _3085_ implements Problem {
  static int[][] dirs = new int[][] {
      { 0, 1 },
      { 0, -1 },
      { 1, 0 },
      { -1, 0 }
  };

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 3 <= N <= 50
    int N = Integer.parseInt(br.readLine());

    char[][] box = new char[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        box[i][j] = str.charAt(j);
      }
    }

    int maxCnt = 0;

    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        for (int i = 0; i < dirs.length; i++) {
          int nextX = x + dirs[i][0];
          int nextY = y + dirs[i][1];
          switchCandy(box, x, y, nextX, nextY);
          int cnt = countCandy(box, x, y);
          if (maxCnt < cnt) {
            maxCnt = cnt;
          }
          switchCandy(box, x, y, nextX, nextY);
        }
      }
    }
    System.out.println(maxCnt);

    br.close();
  }

  public int countCandy(char[][] box, int x, int y) {
    char curCandy = box[x][y];

    int cnt = 0;
    int tempCnt = 0;

    for (int i = 0; i < 2; i++) {
      int nextX = x + dirs[i][0];
      int nextY = y + dirs[i][1];
      while (isIn(box, nextX, nextY) && box[nextX][nextY] == curCandy) {
        cnt += 1;
        nextX = nextX + dirs[i][0];
        nextY = nextY + dirs[i][1];
      }
    }

    tempCnt = cnt;

    cnt = 0;
    for (int i = 2; i < 4; i++) {
      int nextX = x + dirs[i][0];
      int nextY = y + dirs[i][1];

      while (isIn(box, nextX, nextY) && box[nextX][nextY] == curCandy) {
        cnt += 1;
        nextX = nextX + dirs[i][0];
        nextY = nextY + dirs[i][1];
      }
    }

    return Math.max(tempCnt, cnt) + 1;
  }

  public void switchCandy(char[][] box, int x, int y, int nextX, int nextY) {
    if (isIn(box, nextX, nextY) && box[x][y] != box[nextX][nextY]) {
      char temp = box[x][y];
      box[x][y] = box[nextX][nextY];
      box[nextX][nextY] = temp;
      return;
    }
  }

  public boolean isIn(char[][] box, int x, int y) {
    return (0 <= x && x < box.length)
        && (0 <= y && y < box[0].length);
  }
}
