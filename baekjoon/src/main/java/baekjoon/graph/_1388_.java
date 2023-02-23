package baekjoon.graph;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1388_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = row.charAt(j);
      }
    }

    int result = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == '-') {
          result += 1;
          map[i][j] = '*';

          int next = j + 1;

          while (next < M && map[i][next] == '-') {
            map[i][next] = '*';
            next += 1;
          }

          next = j - 1;
          while (0 <= next && map[i][next] == '-') {
            map[i][next] = '*';
            next -= 1;
          }

        } else if (map[i][j] == '|') {
          result += 1;
          map[i][j] = '*';

          int next = i + 1;

          while (next < N && map[next][j] == '|') {
            map[next][j] = '*';
            next += 1;
          }

          next = i - 1;
          while (0 <= next && map[next][j] == '|') {
            map[next][j] = '*';
            next -= 1;
          }

        }
      }
    }

    System.out.println(result);

    br.close();
  }

}
