package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _14888_ implements Problem {

  static long maxResult = 0L;
  static long minResult = Long.MAX_VALUE;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());

    long[] nums = new long[N];
    int[] opCnts = new int[4];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < 4; i++) {
      opCnts[i] = Integer.parseInt(st.nextToken());
    }

    permutation(nums, opCnts, 0, nums.length - 1);

    System.out.println(maxResult);
    System.out.println(minResult);

    br.close();
  }

  public void permutation(long[] nums, int[] opCnts, int selectedCnt, int totalCnt) {
    if (selectedCnt == totalCnt) {
      maxResult = Math.max(nums[selectedCnt], maxResult);
      minResult = Math.min(nums[selectedCnt], minResult);
      return;
    }

    for (int i = 0; i < 4; i++) {
      long op1 = nums[selectedCnt];
      long op2 = nums[selectedCnt + 1];
      if (opCnts[i] > 0) {
        opCnts[i] -= 1;
        if (i == 0) {

          nums[selectedCnt + 1] = op1 + op2;
          permutation(nums, opCnts, selectedCnt + 1, totalCnt);
          nums[selectedCnt + 1] = op2;

        } else if (i == 1) {

          nums[selectedCnt + 1] = op1 - op2;
          permutation(nums, opCnts, selectedCnt + 1, totalCnt);
          nums[selectedCnt + 1] = op2;

        } else if (i == 2) {

          nums[selectedCnt + 1] = op1 * op2;
          permutation(nums, opCnts, selectedCnt + 1, totalCnt);
          nums[selectedCnt + 1] = op2;

        } else {

          nums[selectedCnt + 1] = op1 / op2;
          permutation(nums, opCnts, selectedCnt + 1, totalCnt);
          nums[selectedCnt + 1] = op2;
        }

        opCnts[i] += 1;
      }
    }
  }
}
