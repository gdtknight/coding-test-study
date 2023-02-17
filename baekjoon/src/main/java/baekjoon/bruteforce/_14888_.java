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

    permutationNum(nums, opCnts, 1, nums.length);

    System.out.println(maxResult);
    System.out.println(minResult);

    br.close();
  }

  public void permutationNum(long[] nums, int[] opCnts, int selectedCnt, int totalCnt) {
    if (selectedCnt == totalCnt) {
      if (nums[selectedCnt - 1] > maxResult) {
        maxResult = nums[selectedCnt - 1];
      }
      if (nums[selectedCnt - 1] < minResult) {
        minResult = nums[selectedCnt - 1];
      }

      return;
    }

    for (int i = 0; i < 4; i++) {
      long op1 = nums[selectedCnt - 1];
      long op2 = nums[selectedCnt];
      if (opCnts[i] > 0) {
        opCnts[i] -= 1;
        switch (i) {
          // +
          case 0:
            nums[selectedCnt] = op1 + op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
          // -
          case 1:
            nums[selectedCnt] = op1 - op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
          // *
          case 2:
            nums[selectedCnt] = op1 * op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
          // /
          case 3:
            nums[selectedCnt] = op1 / op2;
            permutationNum(nums, opCnts, selectedCnt + 1, totalCnt);
            nums[selectedCnt] = op2;
            break;
        }
        opCnts[i] += 1;
      }

    }
  }
}
