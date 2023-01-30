package baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _1463_ {

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
    int[] useCnt = new int[N + 1];
    useCnt[2] = 1;
    useCnt[3] = 1;
    for (int i = 4; i <= N; i++) {
      if (i % 2 == 0) {
        useCnt[i] = useCnt[i] == 0 ? useCnt[i / 2] + 1 : Math.min(useCnt[i], useCnt[i / 2] + 1);
      }
      if (i % 3 == 0) {
        useCnt[i] = useCnt[i] == 0 ? useCnt[i / 3] + 1 : Math.min(useCnt[i], useCnt[i / 3] + 1);
      }
      if (useCnt[i - 1] != 0) {
        useCnt[i] = useCnt[i] == 0 ? useCnt[i - 1] + 1 : Math.min(useCnt[i], useCnt[i - 1] + 1);
      }
    }

    // StringBuilder sb = new StringBuilder();
    // sb.append(" ");
    // IntStream.range(1, N + 1).forEach(n -> sb.append(String.format("%3d", n)));
    // System.out.println(sb.toString());
    // System.out.println(Arrays.toString(useCnt).replaceAll(",", " "));

    System.out.println(useCnt[N]);
    br.close();
  }

}
