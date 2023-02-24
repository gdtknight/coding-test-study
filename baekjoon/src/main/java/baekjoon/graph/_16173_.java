package baekjoon.graph;

import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _16173_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // git commit --amend --no-edit --date "Fri 14 Feb 2023 01:35:10 KST"

    int N = Integer.parseInt(br.readLine());

    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dirs = { { 1, 0 }, { 0, 1 } };

    Stack<Pos> stack = new Stack<>();
    stack.push(new Pos(0, 0));

    while (!stack.isEmpty()) {
      Pos cur = stack.pop();
      if (board[cur.getX()][cur.getY()] == -1) {
        System.out.println("HaruHaru");
        return;
      }
      int curStep = board[cur.getX()][cur.getY()];
      board[cur.getX()][cur.getY()] = -2;

      for (int i = 0; i < 2; i++) {
        int nextX = cur.getX() + dirs[i][0] * curStep;
        int nextY = cur.getY() + dirs[i][1] * curStep;
        if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
          stack.push(new Pos(nextX, nextY));
        }
      }
    }

    System.out.println("Hing");

    br.close();
  }

}

class Pos {
  int x;
  int y;

  public Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pos other = (Pos) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }
}
