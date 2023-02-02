package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920_ {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //

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
