package baekjoon.dp;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1912_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int curNum = Integer.parseInt(st.nextToken());
    int curSum = curNum;
    int maxSum = curNum;

    for (int i = 1; i < n; i++) {
      curNum = Integer.parseInt(st.nextToken());

      curSum = Math.max(curSum + curNum, curNum);
      maxSum = Math.max(maxSum, curSum);
    }

    System.out.println(maxSum);

    br.close();
  }

}
