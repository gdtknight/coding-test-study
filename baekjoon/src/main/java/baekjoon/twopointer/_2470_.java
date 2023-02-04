package baekjoon.twopointer;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _2470_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    int[] liquid = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      liquid[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(liquid);

    int startIdx = 0;
    int endIdx = liquid.length - 1;

    int curSum = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;

    while (startIdx < endIdx) {
      if (liquid[startIdx] + liquid[endIdx] == 0) {
        System.out.println(liquid[startIdx] + " " + liquid[endIdx]);
        return;
      }

      if (Math.abs(liquid[startIdx] + liquid[endIdx]) < curSum) {
        curSum = Math.abs(liquid[startIdx] + liquid[endIdx]);
        left = liquid[startIdx];
        right = liquid[endIdx];
      }

      if (liquid[startIdx] + liquid[endIdx] < 0) {
        startIdx += 1;
        continue;
      } else {
        endIdx -= 1;
      }

    }

    System.out.println(left + " " + right);

    br.close();
  }

}
