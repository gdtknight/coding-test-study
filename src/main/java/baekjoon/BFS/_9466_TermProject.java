package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9466_TermProject {

  static Integer numsOfCase;
  static Integer numsOfStudent;
  static Integer[] choice;
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/baekjoon/BFS";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_9466_TestCase")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    numsOfCase = Integer.parseInt(br.readLine());

    for (int n = 0; n < numsOfCase; n++) {
      numsOfStudent = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      choice = new Integer[numsOfStudent + 1];

      for (int i = 1; i <= numsOfStudent; i++) {
        choice[i] = Integer.parseInt(st.nextToken());
      }

      int cnt = 0;

      boolean[] visited = new boolean[numsOfStudent + 1];

      for (int i = 1; i <= numsOfStudent; i++) {
        if (visited[i]) {
          continue;
        }
        visited[i] = true;

        int next = choice[i];
        int pre = next;
        while (!visited[next]) {
          visited[next] = true;
          pre = next;
          next = choice[next];
        }

        int start = i;
        while (start != next) {
          cnt += 1;
          start = choice[start];
        }

      }

      System.out.println(cnt);
    }

    // 결과 출력 부분
    br.close();
  }

}
