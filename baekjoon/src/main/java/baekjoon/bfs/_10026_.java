package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import baekjoon.Problem;

public class _10026_ implements Problem {
  static int N;
  static int M;

  static ColorPos[] dirs = new ColorPos[] {
      new ColorPos(1, 0),
      new ColorPos(-1, 0),
      new ColorPos(0, 1),
      new ColorPos(0, -1)
  };

  static Queue<ColorPos> queue;

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
    char[][] colorField1 = new char[N][];
    char[][] colorField2 = new char[N][];

    for (int n = 0; n < N; n++) {
      String str = br.readLine();
      M = str.length();
      colorField1[n] = new char[M];
      colorField2[n] = new char[M];
      for (int m = 0; m < M; m++) {
        colorField1[n][m] = str.charAt(m);
        colorField2[n][m] = str.charAt(m);
      }
    }
    // printField(colorField1);

    // 결과 출력 부분
    System.out.println(countColor(colorField1, false) + " " + countColor(colorField2, true));
    br.close();
  }

  public static int countColor(char[][] colorField, boolean weak) {
    int cnt = 0;
    if (weak) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (colorField[n][m] == 'R' || colorField[n][m] == 'G') {
            colorField[n][m] = 'W';
          }
        }
      }

      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (colorField[n][m] == 'W') {
            cnt += 1;
            bfs(colorField, n, m, 'W');
          }
          if (colorField[n][m] == 'B') {
            cnt += 1;
            bfs(colorField, n, m, 'B');
          }
        }
      }
    } else {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (colorField[n][m] == 'R') {
            cnt += 1;
            bfs(colorField, n, m, 'R');
          }
          if (colorField[n][m] == 'G') {
            cnt += 1;
            bfs(colorField, n, m, 'G');
          }
          if (colorField[n][m] == 'B') {
            cnt += 1;
            bfs(colorField, n, m, 'B');
          }
        }
      }

    }
    return cnt;
  }

  public static void bfs(char[][] colorField, int n, int m, char color) {
    queue = new LinkedList<>();
    colorField[n][m] = '-';
    queue.offer(new ColorPos(n, m));

    while (!queue.isEmpty()) {
      ColorPos cur = queue.poll();

      for (int i = 0; i < dirs.length; i++) {
        int nextN = cur.getN() + dirs[i].getN();
        int nextM = cur.getM() + dirs[i].getM();
        if (isIn(nextN, nextM) && colorField[nextN][nextM] == color) {
          colorField[nextN][nextM] = '-';
          queue.offer(new ColorPos(nextN, nextM));
        }
      }
    }
  }

  static boolean isIn(int nextN, int nextM) {
    return (0 <= nextN && nextN < N)
        && (0 <= nextM && nextM < M);
  }

  static void printField(char[][] colorField) {
    System.out.println();
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        System.out.print(colorField[n][m] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static void printField(String[][] colorField) {
    System.out.println();
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        System.out.print(colorField[n][m] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

class ColorPos {
  int n;
  int m;

  public ColorPos(int n, int m) {
    this.n = n;
    this.m = m;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + m;
    result = prime * result + n;
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
    ColorPos other = (ColorPos) obj;
    if (m != other.m)
      return false;
    if (n != other.n)
      return false;
    return true;
  }

  public int getN() {
    return n;
  }

  public int getM() {
    return m;
  }

}
