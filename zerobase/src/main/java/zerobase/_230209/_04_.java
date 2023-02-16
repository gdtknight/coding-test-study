package zerobase._230209;

import java.util.LinkedList;
import java.util.Queue;

import common.Problem;

public class _04_ implements Problem {
  static int[][] dirs = new int[][] {
      { 0, 1 },
      { 0, -1 },
      { 1, 0 },
      { -1, 0 }
  };

  public void solution(String[] args) throws Exception {
    int[][] map = new int[][] {
        { 2, 2, 2, 2, 2 },
        { 2, 0, 2, 2, 2 },
        { 4, 0, 0, 0, 0 },
        { 2, 0, 2, 2, 0 },
        { 2, 3, 2, 2, 0 },
        { 2, 0, 2, 2, 0 },
        { 2, 1, 0, 0, 0 },
    };

    System.out.println(solution(map));
  }

  public int solution(int[][] map) {

    int[] destination = new int[2];
    int[] boxPos = new int[2];
    int[] startPos = new int[2];

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == 4) {
          destination = new int[] { i, j };
        } else if (map[i][j] == 3) {
          boxPos = new int[] { i, j };
        } else if (map[i][j] == 1) {
          startPos = new int[] { i, j };
        }
      }
    }

    System.out.println("Initialized...");

    System.out.println("bosPos: [ " + boxPos[0] + ", " + boxPos[1] + " ]");
    System.out.println("startPos: [ " + startPos[0] + ", " + startPos[1] + " ]");
    System.out.println("destination: [ " + destination[0] + ", " + destination[1] + " ]");

    Queue<Integer[]> bfsQueue = new LinkedList<>();
    map[boxPos[0]][boxPos[1]] = -1;
    bfsQueue.offer(new Integer[] { boxPos[0], boxPos[1] });

    int moveCnt = 0;

    outer: while (!bfsQueue.isEmpty()) {
      Integer[] cur = bfsQueue.poll();
      System.out.println("cur: [ " + cur[0] + ", " + cur[1] + " ]");

      for (int i = 0; i < dirs.length; i++) {
        int nextX = cur[0] + dirs[i][0];
        int nextY = cur[1] + dirs[i][1];

        // 목표지점 바로 옆칸
        if (isIn(map, nextX, nextY) && map[nextX][nextY] == 4) {
          map[nextX][nextY] = map[cur[0]][cur[1]] - 1;
          moveCnt = map[cur[0]][cur[1]] * (-1);
          System.out.println("found! : [ " + nextX + ", " + nextY + " ]");
          break outer;
        }
        // 이동이 가능한 경우
        else if (isIn(map, nextX, nextY) && (map[nextX][nextY] == 0 || map[nextX][nextY] == 1)) {
          map[nextX][nextY] = map[cur[0]][cur[1]] - 1;
          bfsQueue.offer(new Integer[] { nextX, nextY });
          System.out.println("offered: [ " + nextX + ", " + nextY + " ]");
        }
      }
    }

    if (moveCnt == 0) {
      return -1;
    }

    bfsQueue.clear();

    return moveCnt;
  }

  public boolean isIn(int[][] map, int x, int y) {
    return (0 <= x && x < map.length)
        && (0 <= y && y < map[0].length);
  }

  public boolean canMoveBox(int[][] map, int x, int y) {

    return true;
  }
}
