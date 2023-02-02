package baekjoon.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import baekjoon.common.Problem;

public class _9095_ implements Problem {
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

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(solution(num));

    }

    br.close();
  }

  public static int solution(int num) {
    int answer = 0;

    for (int threeCnt = 0; threeCnt <= num / 3; threeCnt++) {
      int remain = num - threeCnt * 3;

      for (int twoCnt = 0; twoCnt <= remain / 2; twoCnt++) {
        int oneCnt = remain - twoCnt * 2;

        int sum = threeCnt + twoCnt + oneCnt;
        answer += fact(sum) / (fact(threeCnt) * fact(twoCnt) * fact(oneCnt));

      }

    }

    // caseCnt[n] = 1 + (n - 1) * caseCnt[n-1]

    return answer;
  }

  public static int fact(int n) {
    if (n <= 1) {
      return 1;
    }

    int result = 1;

    for (int i = n; i > 1; i--) {
      result *= i;
    }
    return result;
  }

}
