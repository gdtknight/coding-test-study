package zerobase._230223;

import java.util.Arrays;

import common.Problem;

public class _03_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < nums.length <= 10000

    int[] nums = { 1, 5, 6, 4 };

    System.out.println(solution(nums));
  }

  public int solution(int[] nums) {
    int answer = 0;

    Arrays.sort(nums);

    int curNum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (curNum != nums[i] - 1) {
        while (curNum != nums[i] - 1) {
          answer += 1;
          curNum += 1;
        }
      }

      curNum = nums[i];
    }

    return answer;
  }

}
