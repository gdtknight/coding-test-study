package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9466_TermProject {

  static Integer numsOfCase;
  static Integer numsOfStudent;
  static Integer[] choice;

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
        // System.out.print(choice[i] + " ");
      }
      // System.out.println();
      // System.out.println("===== start =====");
      // System.out.println("아웃사이더 수: " + getCount());
      System.out.println(countSolo());
      // System.out.println("===== end =====");
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

      int start = i;

      boolean foundTeam = false;
      System.out.println("start number : " + start);
      visited[start] = true;

      int next = choice[start];
      System.out.println(start + " 번은 " + next + " 번 선택");

      // 자기 자신을 지목한 경우
      if (start == next) {
        foundTeam = true;
        haveTeam[start] = true;
        continue;
      }

      // 이미 확인된 번호
      if (visited[next]) {
        continue;
      }

      while (!haveTeam[next] && !visited[next] && next != start) {
        System.out.println(next + " 번 학생은 " + choice[next] + " 번를 지명");
        visited[next] = true;
        next = choice[next];
        if (visited[next]) {
          foundTeam = true;
          start = next;
          break;
        }
      }

      System.out.println();

      if (foundTeam) {
        System.out.println("팀을 찾았습니다 !!");
        System.out.print("멤버: " + start + " ");
        haveTeam[start] = true;
        next = choice[start];
        while (next != start) {
          System.out.print(next + " ");
          haveTeam[next] = true;
          visited[next] = true;
          next = choice[next];
        }
        System.out.println();
        System.out.println("팀 순회 완료");
        System.out.println();
      } else {
        System.out.println("팀 없음");
      }
    }

    for (int i = 1; i < numsOfStudent; i++) {
      if (!haveTeam[i]) {
        cnt += 1;
      }
    }
    return cnt;
  }
}
