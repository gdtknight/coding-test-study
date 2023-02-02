package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import baekjoon.common.Problem;

public class _2606_ implements Problem {

  static Integer[][] dirs = new Integer[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 }
  };

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
      network[end][start] = true;
    }

    infected[1] = true;
    stack.push(1);

    while (!stack.isEmpty()) {
      int start = stack.pop();

      for (int end = 1; end <= numsOfComputer; end++) {
        if (start == end) {
          continue;
        }

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
