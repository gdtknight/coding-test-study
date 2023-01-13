package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2606_Virus {

  static Integer[][] dirs = new Integer[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 }
  };

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/baekjoon/DFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_2606_TestCase")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numsOfComputer = Integer.parseInt(br.readLine());
    int numsOfpair = Integer.parseInt(br.readLine());

    boolean[][] network = new boolean[numsOfComputer + 1][numsOfComputer + 1];
    boolean[] infected = new boolean[numsOfComputer + 1];

    Stack<Integer> stack = new Stack<>();
    infected[1] = true;

    int count = 0;

    for (int n = 0; n < numsOfpair; n++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      network[start][end] = true;

      if (start == 1) {
        count += 1;
        infected[end] = true;
        stack.push(end);
      }
    }

    while (!stack.isEmpty()) {
      int start = stack.pop();

      for (int end = 1; end <= numsOfComputer; end++) {
        if (network[start][end] && !infected[end]) {
          count += 1;
          infected[end] = true;
          stack.push(end);
        }
      }
    }

    System.out.println(count);

    br.close();
  }

}
