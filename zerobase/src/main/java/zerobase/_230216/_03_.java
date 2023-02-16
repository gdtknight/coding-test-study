package zerobase._230216;

import common.Problem;

public class _03_ implements Problem {
  public void solution(String[] args) throws Exception {
    // -100 <= points[i][j] <= 1000
    int[][] points = new int[][] { { 0, 0 }, { 0, 10 }, { 10, 5 } };
    // int[][] points = new int[][] { { -2, 3 }, { -2, 6 }, { -2, 9 } };

    System.out.println(solution(points));
  }

  public String solution(int[][] points) {
    int x1 = points[0][0];
    int x2 = points[1][0];
    int x3 = points[2][0];

    int y1 = points[0][1];
    int y2 = points[1][1];
    int y3 = points[2][1];

    if ((y3 - y1) * (x1 - x2) == (y1 - y2) * (x3 - x1)) {
      return "LINE";
    } else if ((y3 - y1) * (x1 - x2) > (y1 - y2) * (x3 - x1)) {
      return "CW";
    } else {
      return "CCW";
    }

  }

}
