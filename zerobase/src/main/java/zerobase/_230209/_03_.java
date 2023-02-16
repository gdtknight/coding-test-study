package zerobase._230209;

import common.Problem;

public class _03_ implements Problem {
  public void solution(String[] args) throws Exception {
    int[][] shapes = new int[][] {
        { 5, 4, 3 }, { 8, 5, 4 }
    };

    int[] colors = { 50, 200 };

    System.out.println(solution(shapes, colors));
  }

  public int[][] solution(int[][] shapes, int[] colors) {
    int M = shapes.length;
    int N = shapes[0].length;

    for (int idx = 0; idx < M; idx++) {
      int x = shapes[idx][0];
      int y = shapes[idx][1];
      int r = shapes[idx][2];

    }

    return new int[M][N];
  }
}
