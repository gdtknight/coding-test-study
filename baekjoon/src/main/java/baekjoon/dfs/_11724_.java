package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import baekjoon.Problem;

public class _11724_ implements Problem {

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
