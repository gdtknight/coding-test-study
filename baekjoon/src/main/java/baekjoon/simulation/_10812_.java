package baekjoon.simulation;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import common.Initialization;
import common.Problem;

public class _10812_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // Your code

    // 도현이가 선택한 바구니의 범위가 begin, end이고,
    // 기준이 되는 바구니를 mid라고 했을 때,
    // begin, begin+1, ..., mid-1, mid, mid+1, ..., end-1,end 순서로 되어있는 바구니의 순서를
    // mid, mid+1, ..., end-1, end, begin, begin+1, ...,mid-1로 바꾸게 된다.

    int[] baskets = IntStream.range(0, N + 1).toArray();

    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());

      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      baskets = rotate(baskets, i, j, k);
    }

    StringBuilder sb = new StringBuilder();

    for (int idx = 1; idx < baskets.length; idx++) {
      sb.append(baskets[idx]);
      if (idx != baskets.length - 1) {
        sb.append(" ");
      }
    }
    System.out.println(sb.toString());

    br.close();
  }

  private int[] rotate(int[] baskets, int begin, int end, int mid) {

    int[] result = new int[baskets.length];
    System.arraycopy(baskets, 0, result, 0, begin - 0);
    System.arraycopy(baskets, mid, result, begin, end - mid + 1);
    System.arraycopy(baskets, begin, result, begin + end - mid + 1, mid - begin);
    System.arraycopy(baskets, end + 1, result, end + 1, baskets.length - 1 - end);
    return result;
  }

}
