package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2839_ {
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
