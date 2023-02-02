package zerobase._230113;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import zerobase.Problem;

public class _02 implements Problem {
  public void solution(String[] args) throws Exception {

    String filePath = this.getClass()
        .getName()
        .replaceAll("_", "")
        .replaceAll("\\.", "/");

    System.out.println(filePath);

    File file = new File(this.getClass()
        .getClassLoader()
        .getResource(filePath)
        .getPath());

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  }

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
