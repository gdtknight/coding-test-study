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

    for (int i = 0; i < K; i++) {
      lans[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(lans);

    int minLen = 0;
    int maxLen = lans[lans.length - 1];
    int len = 0;
    int result = 0;

    while (minLen < maxLen) {
      len = (minLen + maxLen) / 2;

      result = 0;
      for (int i = 0; i < K; i++) {
        result += lans[i] / len;
      }

      if (result < N) {
        maxLen = len;
      } else {
        minLen = len + 1;
      }
    }

    System.out.println(minLen - 1);

    br.close();
  }

}
