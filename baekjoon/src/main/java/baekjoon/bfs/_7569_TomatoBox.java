package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_TomatoBox {
  static int M;
  static int N;
  static int H;

  static Queue<TomatoPos> queue = new LinkedList<>();

  static TomatoPos[] dirs = new TomatoPos[] {
      new TomatoPos(1, 0, 0),
      new TomatoPos(-1, 0, 0),
      new TomatoPos(0, 1, 0),
      new TomatoPos(0, -1, 0),
      new TomatoPos(0, 0, 1),
      new TomatoPos(0, 0, -1)
  };

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    Integer[][][] tomatoField = new Integer[M][N][H];

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        String[] line = br.readLine().split(" ");
        for (int m = 0; m < M; m++) {
          tomatoField[m][n][h] = Integer.parseInt(line[m]);
        }
      }
    }

    // printField(tomatoField);

    // 결과 출력 부분
    System.out.println(countDay(tomatoField));
    br.close();
  }

  public static int countDay(Integer[][][] tomatoField) {
    int day = 0;
    for (int m = 0; m < M; m++) {
      for (int n = 0; n < N; n++) {
        for (int h = 0; h < H; h++) {
          if (tomatoField[m][n][h] == 1) {
            queue.offer(new TomatoPos(m, n, h));
          }
        }
      }
    }

    day = bfs(tomatoField);

    for (int m = 0; m < M; m++) {
      for (int n = 0; n < N; n++) {
        for (int h = 0; h < H; h++) {
          if (tomatoField[m][n][h] == 0) {
            day = -1;
          }
        }
      }
    }

    return day;
  }

  public static int bfs(Integer[][][] tomatoField) {
    int day = 0;

    while (!queue.isEmpty()) {
      TomatoPos cur = queue.poll();

      int curM = cur.getM();
      int curN = cur.getN();
      int curH = cur.getH();

      day = tomatoField[curM][curN][curH];

      for (int i = 0; i < dirs.length; i++) {
        int nextM = curM + dirs[i].getM();
        int nextN = curN + dirs[i].getN();
        int nextH = curH + dirs[i].getH();
        if (isIn(nextM, nextN, nextH)
            && tomatoField[nextM][nextN][nextH] == 0) {
          tomatoField[nextM][nextN][nextH] = day + 1;
          queue.offer(new TomatoPos(nextM, nextN, nextH));
        }
      }
    }

    return day - 1;
  }

  static boolean isIn(int nextM, int nextN, int nextH) {
    return (0 <= nextM && nextM < M)
        && (0 <= nextN && nextN < N)
        && (0 <= nextH && nextH < H);
  }

  static void printField(Integer[][][] tomatoField) {
    System.out.println();
    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          System.out.print(tomatoField[m][n][h] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }
}

class TomatoPos {
  int m;
  int n;
  int h;

  public TomatoPos(int m, int n, int h) {
    this.m = m;
    this.n = n;
    this.h = h;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + m;
    result = prime * result + n;
    result = prime * result + h;
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
    TomatoPos other = (TomatoPos) obj;
    if (m != other.m)
      return false;
    if (n != other.n)
      return false;
    if (h != other.h)
      return false;
    return true;
  }

  public int getM() {
    return m;
  }

  public int getN() {
    return n;
  }

  public int getH() {
    return h;
  }
}
