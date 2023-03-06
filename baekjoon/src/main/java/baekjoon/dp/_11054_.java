package baekjoon.dp;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _11054_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    // 1 <= N <= 1,000

    int N = Integer.parseInt(br.readLine());

    String[] strNums = br.readLine().split(" ");

    int[] nums = new int[N];
    int[] leftMemo = new int[N];
    int[] rightMemo = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(strNums[i]);
      leftMemo[i] = 1;
      rightMemo[i] = 1;
    }

    for (int i = 1; i < N; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          leftMemo[i] = leftMemo[j] + 1 > leftMemo[i] ? leftMemo[j] + 1 : leftMemo[i];
        }
      }
      leftMemo[i] = leftMemo[i] == 0 ? 1 : leftMemo[i];
    }

    for (int i = N - 2; i >= 0; i--) {
      for (int j = i + 1; j < N; j++) {
        if (nums[i] > nums[j]) {
          rightMemo[i] = rightMemo[j] + 1 > rightMemo[i] ? rightMemo[j] + 1 : rightMemo[i];
        }
      }
      rightMemo[i] = rightMemo[i] == 0 ? 1 : rightMemo[i];
    }

    int maxCnt = 0;

    for (int i = 0; i < N; i++) {
      if (leftMemo[i] + rightMemo[i] > maxCnt) {
        maxCnt = leftMemo[i] + rightMemo[i];
      }
    }

    System.out.println(maxCnt - 1);

    br.close();
  }

}
