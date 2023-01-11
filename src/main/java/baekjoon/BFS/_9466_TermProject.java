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

      int cnt = 0;

      boolean[] haveTeam = new boolean[numsOfStudent + 1];
      boolean[] visited = new boolean[numsOfStudent + 1];

      // System.out.println("===== 테스트케이스 " + (n + 1) + " 번 시작 =====");
      for (int i = 1; i <= numsOfStudent; i++) {

        if (haveTeam[i] || visited[i]) {
          // System.out.println(i + " 번 학생은 체크 완료됨.");
          continue;
        }

        // System.out.println(i + " 번 학생 체크");
        visited[i] = true;
        int next = choice[i];

        while (!visited[next]) {
          // System.out.println(next + " 번 학생 체크");
          visited[next] = true;
          next = choice[next];
        }

        if (next < i && !haveTeam[next]) {
          // System.out.println(i + " 번 학생은 팀이 없는 " + next + " 번 학생을 선택함. 따라서 팀이 없음.");
          cnt += 1;
          continue;
        }

        int start = next;

        do {
          // System.out.println(next + " 번 학생 팀 표시");
          haveTeam[next] = true;
          next = choice[next];
        } while (next != start);

        start = i;
        do {
          if (!haveTeam[start]) {
            cnt += 1;
            // System.out.println(i + " 번 학생은 팀 없음.");
          }
          start = choice[start];
        } while (next != start);
      }

      System.out.println(cnt);
      // System.out.println("===== 테스트케이스 종료 =====");
      // System.out.println();
    }

    // 결과 출력 부분
    br.close();
  }

}
