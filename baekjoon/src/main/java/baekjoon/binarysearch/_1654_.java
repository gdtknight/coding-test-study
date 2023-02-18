package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1654_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] lans = new int[K];

    int minLen = 1;
    int maxLen = 0;

    for (int i = 0; i < K; i++) {
      lans[i] = Integer.parseInt(br.readLine());
      if (lans[i] > maxLen) {
        maxLen = lans[i];
      }
    }

    maxLen += 1;

    while (minLen < maxLen) {
      int midLen = (minLen + maxLen) / 2;
      int result = 0;

      for (int i = 0; i < K; i++) {
        result += lans[i] / midLen;
      }

      if (result < N) {
        maxLen = midLen;
      } else {
        minLen = midLen + 1;
      }
    }

    System.out.println(minLen - 1);

    br.close();
  }

}
