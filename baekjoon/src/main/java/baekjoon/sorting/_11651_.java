package baekjoon.sorting;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _11651_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      arr[i] = new int[] {
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())
      };
    }
    Arrays.sort(arr,
        (int[] a, int[] b) -> {
          return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });

    for (int[] num : arr) {
      System.out.println(Arrays.toString(num));
    }

    br.close();
  }

}
