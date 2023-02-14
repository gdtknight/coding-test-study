package baekjoon.sorting;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _11399_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    int[] times = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(times);

    int answer = times[0];
    int curSum = times[0];

    for (int i = 1; i < N; i++) {
      curSum += times[i];
      answer += curSum;
      System.out.println((i + 1) + "번째 사람 :" + curSum + ", " + answer);
    }

    System.out.println(answer);

    br.close();
  }

}
