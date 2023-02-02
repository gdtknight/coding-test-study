package baekjoon.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import baekjoon.Problem;

public class _2839_ implements Problem {
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

    System.out.println(solution(N));

    br.close();
  }

  public static int solution(int N) {

    int fiveCnt = N / 5;
    int threeCnt = (N - fiveCnt * 5) / 3;

    while (fiveCnt > 0) {

      if ((N - fiveCnt * 5) % 3 == 0) {
        return fiveCnt + threeCnt;
      }

      fiveCnt -= 1;
      threeCnt = (N - fiveCnt * 5) / 3;
    }

    return (N - fiveCnt * 5) % 3 == 0 ? threeCnt : -1;
  }

}
