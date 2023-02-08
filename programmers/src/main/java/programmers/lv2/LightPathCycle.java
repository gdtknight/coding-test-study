package programmers.lv2;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Stack;

import common.Initialization;
import common.Problem;

public class LightPathCycle implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    String[] arr = br.readLine().replaceAll("[\\[|\\]|\"]", "").split(",");

    System.out.println(Arrays.toString(arr));

    char[][] nodes = new char[arr.length][arr[0].length()];

    Stack<Pos> stack = new Stack<>();

    int cnt = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length(); j++) {
        cnt += 1;
        nodes[i][j] = arr[i].charAt(j);
        stack.push(new Pos(i, j));
      }
    }

    boolean[][] visited = new boolean[cnt][8];

    while (cnt-- > 0) {

    }

    while (stack.isEmpty()) {
      Pos cur = stack.pop();

      int curX = cur.getX();
      int curY = cur.getY();

      switch (nodes[curX][curY]) {

      }

    }

    br.close();
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
