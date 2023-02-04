package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import common.Problem;

public class _9466_ implements Problem {

  static Integer numsOfCase;
  static Integer numsOfStudent;
  static Integer[] choice;
  static Queue<Integer> queue = new LinkedList<>();

  public void solution(String[] args) throws IOException {
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

        while (!visited[next]) {
          visited[next] = true;
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
