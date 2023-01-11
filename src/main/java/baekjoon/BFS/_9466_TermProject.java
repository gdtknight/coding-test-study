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
    // String filePathRoot =
    // "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    // String packagePath = "/baekjoon/BFS";
    // BufferedReader br = new BufferedReader(new InputStreamReader(
    // new FileInputStream(filePathRoot + packagePath + "/_9466_TestCase")));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    numsOfCase = Integer.parseInt(br.readLine());

    for (int n = 0; n < numsOfCase; n++) {
      numsOfStudent = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      choice = new Integer[numsOfStudent + 1];

      for (int i = 1; i <= numsOfStudent; i++) {
        choice[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(countSolo());
    }

    // 결과 출력 부분
    br.close();
  }

  public static int countSolo() {
    int cnt = 0;

    boolean[] haveTeam = new boolean[numsOfStudent + 1];
    boolean[] visited = new boolean[numsOfStudent + 1];

    for (int i = 1; i <= numsOfStudent; i++) {
      if (haveTeam[i] || visited[i]) {
        continue;
      }

      visited[i] = true;
      queue.offer(i);
      int next = choice[i];

      while (!visited[next]) {
        visited[next] = true;
        queue.offer(next);
        next = choice[next];
      }

      while (!queue.isEmpty()) {
        int cur = queue.poll();
        if (next == cur) {
          haveTeam[cur] = true;
          next = choice[cur];
        }
      }

      if (!haveTeam[i]) {
        cnt += 1;
      }
    }

    return cnt;
  }
}
