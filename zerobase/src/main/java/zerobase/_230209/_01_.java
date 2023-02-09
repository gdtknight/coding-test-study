package zerobase._230209;

import java.util.Arrays;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {
    // int[] arr = new int[] { 10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8 };
    // int[] nums = new int[] { 3, 5, 7, 5 };
    int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 3, 4, 4, 5, 2, 3, 4, 6, 6 };

    System.out.println(solution(nums));
  }

  public int solution(int[] nums) {

    int[] max1 = new int[2];
    int[] max2 = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (i != max1[0] && nums[i] >= max1[1]) {
        max2[0] = max1[0];
        max2[1] = max1[1];
        max1[0] = i;
        max1[1] = nums[i];
      }
    }

    System.out.println(Arrays.toString(max1));
    System.out.println(Arrays.toString(max2));

    return (max1[1] - 1) * (max2[1] - 1);
  }

}
