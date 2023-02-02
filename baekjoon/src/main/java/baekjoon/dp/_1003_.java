package baekjoon.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import baekjoon.common.Problem;

public class _1003_ implements Problem {
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
