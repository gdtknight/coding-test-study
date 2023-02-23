package zerobase._230223;

import java.util.Arrays;

import common.Problem;

public class _04_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < nums.length <= 10000
    int[] nums = { 3, 2, -2, 5, -3 };
    System.out.println(solution(nums));
  }

  public int solution(int[] nums) {
    Arrays.sort(nums);

    int negativeIdx = 0;
    int positiveIdx = nums.length - 1;

    while (nums[negativeIdx] < 0 && 0 < nums[positiveIdx]) {
      int negNum = Math.abs(nums[negativeIdx]);
      int pogNum = nums[positiveIdx];

      if (negNum == pogNum) {
        return pogNum;
      } else if (negNum > pogNum) {
        negativeIdx += 1;
      } else {
        positiveIdx -= 1;
      }
    }

    return 0;
  }

}
