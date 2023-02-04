package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Problem;

public class _1920_ implements Problem {

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

    // 초기화 단계
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] arr = new int[M];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {

      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(answer(N, nums, M, arr));

    br.close();
  }

  public static String answer(int N, int[] nums, int M, int[] arr) {
    StringBuilder sb = new StringBuilder();

    Arrays.sort(nums);
    System.out.println("nums : " + Arrays.toString(nums));
    System.out.println();

    for (int num : arr) {
      if (binarySearch(nums, num)) {
        sb.append("1\n");
      } else {
        sb.append("0\n");
      }

    }

    return sb.toString();
  }

  public static boolean binarySearch(int[] nums, int num) {
    int startIdx = 0;
    int lastIdx = nums.length - 1;
    if (nums[startIdx] == num || nums[lastIdx] == num) {
      return true;
    }

    while (startIdx < lastIdx) {
      int mid = (startIdx + lastIdx) / 2;

      if (num == 5) {
        System.out.println("startIdx : " + startIdx + ", lastIdx : " + lastIdx + ", midIdx : " + mid);
      }

      if (nums[mid] == num) {
        return true;
      } else if (nums[mid] < num) {
        startIdx = mid + 1;
      } else {
        lastIdx = mid;
      }

    }

    return false;
  }
}
