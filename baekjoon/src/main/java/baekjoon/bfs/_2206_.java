package baekjoon.bfs;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _2206_ implements Problem {
  static int[][] dirs = new int[][] {
      { 1, 0 },
      { 0, 1 },
      { -1, 0 },
      { 0, -1 }
  };

  static int N;
  static int M;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Integer[][][] maze = new Integer[2][N][M];

    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split("");
      for (int m = 0; m < M; m++) {
        maze[0][n][m] = Integer.parseInt(line[m]) * (-1);
        maze[1][n][m] = maze[0][n][m];
      }
    }

    // 결과 출력 부분
    System.out.println(getDistance(maze));

    br.close();
  }

  public static Integer getDistance(Integer[][][] maze) {
    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[] { 0, 0, 0 });
    maze[0][0][0] = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      int curX = cur[0];
      int curY = cur[1];
      int destroy = cur[2];
      int nextStep = Math.abs(maze[destroy][curX][curY]) + 1;

      find: for (int i = 0; i < dirs.length; i++) {
        int nextX = curX + dirs[i][0];
        int nextY = curY + dirs[i][1];

        if (!isIn(nextX, nextY)) {
          continue find;
        }

        if (destroy == 1 && maze[1][nextX][nextY] <= -1) {
          continue find;
        } else if (destroy == 1 && maze[1][nextX][nextY] == 0) {
          maze[1][nextX][nextY] = nextStep;
          queue.offer(new int[] { nextX, nextY, destroy });
        } else if (destroy == 0 && maze[0][nextX][nextY] == -1) {
          maze[1][nextX][nextY] = nextStep * (-1);
          queue.offer(new int[] { nextX, nextY, 1 });
        } else if (destroy == 0 && maze[0][nextX][nextY] == 0) {
          maze[0][nextX][nextY] = nextStep;
          queue.offer(new int[] { nextX, nextY, destroy });
        }

      }

    }

    return Math.min(maze[0][N - 1][M - 1], maze[1][N - 1][M - 1]) != 0
        ? Math.min(maze[0][N - 1][M - 1], maze[1][N - 1][M - 1])
        : Math.max(maze[0][N - 1][M - 1], maze[1][N - 1][M - 1]) == 0
            ? -1
            : Math.max(maze[0][N - 1][M - 1], maze[1][N - 1][M - 1]);
  }

  public static boolean isIn(int x, int y) {
    return (0 <= x && x < N)
        && (0 <= y && y < M);
  }

}
