package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.Problem;

public class _1822_ implements Problem {
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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int nA = Integer.parseInt(st.nextToken());
    int nB = Integer.parseInt(st.nextToken());

    int[] numsA = new int[nA];
    int[] numsB = new int[nB];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < nA; i++) {
      numsA[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < nB; i++) {
      numsB[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numsA);
    Arrays.sort(numsB);

    int[] list = Arrays.stream(numsA)
        .filter(num -> !binarySearch(numsB, num))
        .map(Integer::valueOf)
        .toArray();

    System.out.println(list.length);

    if (list.length != 0) {
      System.out.println(Arrays.toString(list).replaceAll("[\\[\\]]", "").replaceAll(",", ""));
    }

    br.close();
  }

  private static boolean binarySearch(int[] numsA, int num) {
    int startIdx = 0;
    int endIdx = numsA.length - 1;

    if (numsA[startIdx] == num || numsA[endIdx] == num) {
      return true;
    }

    while (startIdx < endIdx) {

      int mid = (startIdx + endIdx) / 2;

      if (numsA[mid] == num) {
        return true;
      }

      if (numsA[mid] < num) {
        startIdx = mid + 1;
        continue;
      }

      if (numsA[mid] > num) {
        endIdx = mid;
      }

    }

    return false;
  }

}
