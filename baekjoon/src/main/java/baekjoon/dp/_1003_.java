package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1003_ {
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
    int[] cases = new int[N];

    for (int i = 0; i < N; i++) {
      cases[i] = Integer.parseInt(br.readLine());
    }

    int max = Arrays.stream(cases).max().orElse(0);

    int[][] zeroOne = new int[41][2];

    zeroOne[0][0] = 1;
    zeroOne[0][1] = 0;
    zeroOne[1][0] = 0;
    zeroOne[1][1] = 1;
    zeroOne[2][0] = 1;
    zeroOne[2][1] = 1;

    for (int i = 2; i <= 40; i++) {
      zeroOne[i][0] = zeroOne[i - 1][0] + zeroOne[i - 2][0];
      zeroOne[i][1] = zeroOne[i - 1][1] + zeroOne[i - 2][1];
    }

    // 출력 부분
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      sb.append(zeroOne[cases[i]][0] + " " + zeroOne[cases[i]][1]);
      if (i != max) {
        sb.append("\n");
      }
    }
    System.out.println(sb.toString());

    br.close();
  }

}
