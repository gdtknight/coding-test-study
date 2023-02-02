package baekjoon.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import baekjoon.Problem;

public class _11726_ implements Problem {
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

    int answer = 0;
    int[] factorial = new int[1001];

    factorial[0] = 1;
    factorial[1] = 1;
    factorial[2] = 2;

    for (int i = 3; i <= N; i++) {
      factorial[i] = factorial[i - 1] * i;
    }

    for (int i = 2; i < N; i++) {

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
