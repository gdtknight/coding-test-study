package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_ {
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

    int answer = 0;
    int[] factorial = new int[1001];

    factorial[0] = 1;
    factorial[1] = 1;
    factorial[2] = 2;

    for (int i = 3; i <= N; i++) {
      factorial[i] = factorial[i - 1] * i;
    }

    for (int twoCnt = 0; twoCnt <= N / 2; twoCnt++) {
      int oneCnt = N - 2 * twoCnt;
      int sum = twoCnt + oneCnt;
      answer += factorial[sum] / (factorial[twoCnt] * factorial[oneCnt]);
    }

    System.out.println(answer % 10007);

    br.close();
  }

}
