package baekjoon.stack;

import java.io.BufferedReader;
import java.util.Stack;

import common.Initialization;
import common.Problem;

public class _1874_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    StringBuilder sb = new StringBuilder();

    boolean[] visited = new boolean[N + 1];

    stack.push(1);
    sb.append("+\n");
    visited[1] = true;

    for (int i = 0; i < N; i++) {
      // System.out.println("현재 : " + sb.toString());

      int cur = Integer.parseInt(br.readLine());

      if (stack.isEmpty()) {
        System.out.println("NO");
        br.close();
        return;
      }

      int top = stack.peek();

      if (top < cur) {

        while (!visited[cur]) {
          if (!visited[++top]) {
            visited[top] = true;
            sb.append("+\n");
            stack.push(top);
          }
        }

        top = cur;
      }

      if (top == cur) {

        sb.append("-\n");
        stack.pop();

      } else {

        System.out.println("NO");
        br.close();
        return;

      }
    }

    System.out.println(sb.toString());

    br.close();
  }

}
