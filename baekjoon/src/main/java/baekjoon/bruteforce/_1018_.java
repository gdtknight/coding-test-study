package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1018_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[][] board = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        if (str.charAt(j) == 'W') {
          board[i][j] = true;
        }
      }
    }

    int minCnt = Integer.MAX_VALUE;

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        int cnt = count(board, i, j);
        if (cnt < minCnt) {
          minCnt = cnt;
        }
      }
    }

    System.out.println(minCnt);

    br.close();
  }

  public int count(boolean[][] board, int startX, int startY) {
    boolean start = board[startX][startY];
    boolean neighbor = !start;

    int cnt = 0;

    for (int i = startX; i < startX + 8; i = i + 2) {
      for (int j = startY; j < startY + 8; j = j + 2) {
        if (board[i][j] != start) {
          cnt += 1;
        }
        if (i + 1 < startX + 8 && board[i + 1][j] != neighbor) {
          cnt += 1;
        }
        if (j + 1 < startY + 8 && board[i][j + 1] != neighbor) {
          cnt += 1;
        }
        if (i + 1 < startX + 8 && j + 1 < startY + 8 && board[i + 1][j + 1] != start) {
          cnt += 1;
        }
      }
    }

    return cnt;
  }

}
