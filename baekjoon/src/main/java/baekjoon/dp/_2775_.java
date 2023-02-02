package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2775_ {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      System.out.println(solution(k, n));

    }

    br.close();
  }

  private static int solution(int k, int n) {

    // k : 0 ~ k 층까지
    // n : 1 ~ n 호까지
    // n[i] = i

    // 0 층 : _1, _2, _3, _4, _5, _6, _7, __8, __9, ... , i
    // 1 층 : _1, _3, _6, 10, 15, 21, 28, _36, _45
    // 2 층 : _1, _4, 10, 20, 35, 56, 84, 120, 165

    int[][] apt = new int[k + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      apt[0][i] = i;
    }

    for (int j = 1; j <= k; j++) {
      apt[j][1] = 1;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = 2; j <= n; j++) {
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
      }
    }
    return apt[k][n];
  }

}
