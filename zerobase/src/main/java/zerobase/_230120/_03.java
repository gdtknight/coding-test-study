package zerobase._230120;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import zerobase.Problem;

public class _03 implements Problem {
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
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] maze = new int[N][M];

    for (int n = 0; n < N; n++) {
      String line = br.readLine();

      for (int m = 0; m < M; m++) {
        maze[n][m] = line.charAt(m);
      }

    }

    System.out.println(answer(maze));

    br.close();
  }

  public static int answer(int[][] maze) {
    int[][] dirs = {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 }
    };

    Stack<Pos> stack = new Stack<>();

    maze[0][0] = 1;
    stack.push(new Pos(0, 0));

    while (!stack.isEmpty()) {
      Pos cur = stack.pop();

      int curX = cur.getX();
      int curY = cur.getY();
      int turn = maze[curX][curY];

      boolean day = ((maze[curX][curY] - 1) / 5) % 2 == 0 ? true : false;

      for (int i = 0; i < dirs.length; i++) {
        int nextX = curX + dirs[i][0];
        int nextY = curY + dirs[i][1];

        if (nextX < 0 || nextY < 0 || nextX >= maze.length || nextY >= maze[0].length) {
          continue;
        }

        if (day) {
          maze[nextX][nextY] = turn + 1;
          stack.push(new Pos(nextX, nextY));
        } else {
          if (maze[nextX][nextY] == 2) {
            maze[curX][curY] += 2;
            maze[nextX][nextY] = maze[curX][curY] + 1;
          } else {
            maze[nextX][nextY] = turn + 1;
            stack.push(new Pos(nextX, nextY));
          }
        }
      }
    }

    return -1;
  }

}

class Pos {
  int x;
  int y;

  Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }

}
