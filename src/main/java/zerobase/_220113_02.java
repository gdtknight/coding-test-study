package zerobase;

import java.util.*;

public class _220113_02 {

}

class Solution {
  public int solution(int[] arr, int target) {
    int min = Integer.MAX_VALUE;
    int answer = 0;

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      int j = i + 1;
      int k = arr.length - 1;

      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        int diff = Math.abs(sum - target);

        if (diff == 0)
          return sum;

        if (diff < min) {
          min = diff;
          answer = sum;
        }

        if (sum <= target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return answer;
  }
}
