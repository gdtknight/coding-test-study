package zerobase._230309;

import java.util.Arrays;
import java.util.Stack;

import common.Problem;

public class _04_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 3 < board.length <= 20
    // 3 < board[i].length <= 10
    // 0 <= board[i][j] <= 100
    int[][] board = {
        { 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0 },
        { 0, 3, 0, 0, 0, 0, 0 },
        { 0, 3, 4, 0, 0, 0, 0 },
        { 0, 2, 2, 2, 0, 0, 0 },
        { 0, 1, 1, 1, 0, 0, 0 },
        { 1, 1, 1, 2, 0, 0, 0 },
    };
    System.out.println(solution(board));
  }

  public int[][] solution(int[][] board) {
    for (int i = board.length - 1; i >= 0; i--) {
      for (int j = board[0].length - 1; j >= 0; j--) {
        if (board[i][j] == 0) {
          continue;
        }

        if (check(board, i, j)) {

        }
      }
    }
    return board;
  }

  public boolean check(int[][] board, int y, int x) {
    Stack<int[]> stack = new Stack<>();
    int num = board[y][x];

    boolean[][] visited = new boolean[board.length][board[0].length];

    int cnt = 1;

    stack.push(new int[] { y, x });

    while (!stack.isEmpty()) {
      int[] cur = stack.pop();

      if (visited[cur[0]][cur[1]]) {
        continue;
      }

      visited[cur[0]][cur[1]] = true;

      for (int i = 0; i < dirs.length; i++) {
        int nextY = cur[0] + dirs[i][0];
        int nextX = cur[1] + dirs[i][1];
        if (isIn(nextY, nextX) && board[nextY][nextX] == num && !visited[nextY][nextX]) {
          cnt++;
          stack.push(new int[] { nextY, nextX });
        }
      }
    }

    return cnt >= 3 ? true : false;
  }

  static int[][] dirs = {
      { 0, 1 },
      { 0, -1 },
      { 1, 0 },
      { -1, 0 }
  };

  boolean isIn(int y, int x) {
    return (0 <= y && y < 20)
        && (0 <= x && x < 10);
  }
}
