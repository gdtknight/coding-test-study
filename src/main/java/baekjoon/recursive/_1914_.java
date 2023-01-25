package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class _1914_ {
  public static int cnt = 0;

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new FileReader(new File(fullPath)));
    //

    int N = Integer.parseInt(br.readLine());

    hanoi(N, 1, 3, 2);
  }

  public static void hanoi(int n, int from, int to, int by) {
    if (n == 0) {
      return;
    }

    hanoi(n - 1, from, by, to);
    cnt += 1;
    System.out.println(n + "이동 [" + from + " -> " + to + "]" + " 이동 횟수 : " + cnt);
    hanoi(n - 1, by, to, from);

  }
}
