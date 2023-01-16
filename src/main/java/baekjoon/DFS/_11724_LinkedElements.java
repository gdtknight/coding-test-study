package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11724_LinkedElements {

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase";
    String packagePath = "/baekjoon/DFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/11724")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int numsOfVertex = Integer.parseInt(st.nextToken());
    int numsOfEdge = Integer.parseInt(st.nextToken());

    boolean[][] network = new boolean[numsOfVertex + 1][numsOfVertex + 1];
    boolean[] visited = new boolean[numsOfVertex + 1];

    Stack<Integer> stack = new Stack<>();

    int count = 0;

    for (int n = 0; n < numsOfEdge; n++) {

      st = new StringTokenizer(br.readLine(), " ");

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      network[start][end] = true;
      network[end][start] = true;
    }

    for (int vertex = 1; vertex <= numsOfVertex; vertex++) {

      if (!visited[vertex]) {

        count += 1;

        stack.push(vertex);

        while (!stack.isEmpty()) {
          int cur = stack.pop();
          for (int i = 1; i <= numsOfVertex; i++) {
            if (cur != i && network[cur][i] && !visited[i]) {
              visited[i] = true;
              stack.push(i);
            }
          }
        }
      }

    }

    System.out.println(count);

    br.close();
  }

}
