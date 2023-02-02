package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_Knight {

  static KnightPos[] dirs = new KnightPos[] {
      new KnightPos(1, 2),
      new KnightPos(-1, 2),
      new KnightPos(1, -2),
      new KnightPos(-1, -2),
      new KnightPos(2, 1),
      new KnightPos(2, -1),
      new KnightPos(-2, 1),
      new KnightPos(-2, -1)
  };

  static int N;
  static int I;

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //

    // 테스트 케이스 수
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      I = Integer.parseInt(br.readLine());
      boolean[][] visited = new boolean[I][I];

      StringTokenizer st = new StringTokenizer(br.readLine());
      KnightPos startPos = new KnightPos(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));

      st = new StringTokenizer(br.readLine());
      KnightPos targetPos = new KnightPos(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));

      // 결과 출력 부분
      System.out.println(time(visited, startPos, targetPos));
    }
    br.close();
  }

  public static String time(boolean[][] visited, KnightPos startPos, KnightPos targetPos) {
    int time = 0;

    Queue<KnightPos> queue = new LinkedList<>();
    Queue<KnightPos> newQueue = new LinkedList<>();
    visited[startPos.getX()][startPos.getY()] = true;
    queue.offer(startPos);

    while (!queue.isEmpty()) {
      while (!queue.isEmpty()) {
        KnightPos curPos = queue.poll();

        if (curPos.getX() == targetPos.getX()
            && curPos.getY() == targetPos.getY()) {
          return time + "";
        }

        int curX = curPos.getX();
        int curY = curPos.getY();

        for (int i = 0; i < dirs.length; i++) {
          int nextX = curX + dirs[i].getX();
          int nextY = curY + dirs[i].getY();

          if (isIn(nextX, nextY) && !visited[nextX][nextY]) {
            visited[nextX][nextY] = true;
            newQueue.offer(new KnightPos(nextX, nextY));
          }
        }
      }

      time += 1;

      while (!newQueue.isEmpty()) {
        queue.offer(newQueue.poll());
      }
    }

    return time + "";

  }

  public static boolean isIn(int x, int y) {
    return (0 <= x && x < I) && (0 <= y && y < I);
  }

}

class KnightPos {
  int x;
  int y;

  public KnightPos(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
