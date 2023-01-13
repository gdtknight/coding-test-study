package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _2667_AptBlock {

  static Integer[][] dirs = new Integer[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 }
  };

  static Stack<AptPos> stack = new Stack<>();
  static int N;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/baekjoon/DFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_2667_TestCase")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    Integer[][] map = new Integer[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = Character.getNumericValue(line.charAt(j));
      }
    }

    int count = 0;

    List<Integer> aptNums = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          count += 1;
          map[i][j] = -1;
          stack.push(new AptPos(i, j));
          aptNums.add(dfs(map));
        }
      }
    }

    Collections.sort(aptNums);

    System.out.println(count);
    aptNums.stream()
        .forEach(num -> System.out.println(num));

    br.close();
  }

  public static int dfs(Integer[][] map) {
    int aptNum = 1;

    while (!stack.isEmpty()) {
      AptPos cur = stack.pop();

      int curN = cur.getN();
      int curM = cur.getM();

      for (int i = 0; i < dirs.length; i++) {
        int nextN = curN + dirs[i][0];
        int nextM = curM + dirs[i][1];
        if (isIn(nextN, nextM) && map[nextN][nextM] == 1) {
          aptNum += 1;
          map[nextN][nextM] = -1;
          stack.push(new AptPos(nextN, nextM));
        }
      }

    }
    return aptNum;
  }

  public static boolean isIn(int n, int m) {
    return (0 <= n && n < N) && (0 <= m && m < N);
  }

}

class AptPos {
  int n;
  int m;

  public AptPos(int n, int m) {
    this.n = n;
    this.m = m;
  }

  public int getN() {
    return n;
  }

  public int getM() {
    return m;
  }
}
