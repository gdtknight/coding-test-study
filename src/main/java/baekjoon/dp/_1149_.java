package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1149_ {
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

    int[][] rgb = new int[N][3];
    int[][] costs = new int[N][3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      rgb[i][0] = Integer.parseInt(st.nextToken());
      rgb[i][1] = Integer.parseInt(st.nextToken());
      rgb[i][2] = Integer.parseInt(st.nextToken());
    }

    costs[0][0] = rgb[0][0];
    costs[0][1] = rgb[0][1];
    costs[0][2] = rgb[0][2];

    for (int i = 1; i < N; i++) {
      costs[i][0] = Math.min(costs[i - 1][1] + rgb[i][0], costs[i - 1][2] + rgb[i][0]);
      costs[i][1] = Math.min(costs[i - 1][0] + rgb[i][1], costs[i - 1][2] + rgb[i][1]);
      costs[i][2] = Math.min(costs[i - 1][0] + rgb[i][2], costs[i - 1][1] + rgb[i][2]);
    }
    int min = Arrays.stream(costs[N - 1]).min().orElseThrow();
    System.out.println(min);

    br.close();
  }

}
