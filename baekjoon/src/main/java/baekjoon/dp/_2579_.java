package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_ {

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

    int[] stairs = new int[N + 1];
    int[] points = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    if (N == 1) {
      System.out.println(stairs[N]);
      br.close();
      return;
    }

    // 연속된 3개의 계단을 밟아서는 안된다.
    points[1] = stairs[1];

    if (stairs[1] + stairs[2] > stairs[2]) {
      points[2] = stairs[2] + stairs[1];
    } else {
      points[2] = stairs[2];
    }

    if (N == 2) {
      System.out.println(points[N]);
      br.close();
      return;
    }

    for (int i = 3; i <= N; i++) {
      points[i] = Math.max(points[i - 3] + stairs[i - 1] + stairs[i], points[i - 2] + stairs[i]);
    }

    System.out.println(points[N]);

    br.close();
  }

}
