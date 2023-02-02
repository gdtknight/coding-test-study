package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816_ {

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
    int[] numCards = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      numCards[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] numsArr = new int[M];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {

      numsArr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(answer(N, numCards, M, numsArr));

    br.close();
  }

  public static String answer(int N, int[] numCards, int M, int[] numsArr) {
    StringBuilder sb = new StringBuilder();

    Arrays.sort(numCards);

    for (int num : numsArr) {
      sb.append(binarySearch(numCards, num) + " ");
    }

    return sb.toString();
  }

  public static int binarySearch(int[] numCards, int num) {
    int startIdx = 0;
    int endIdx = numCards.length;

    // num 이 삽입 가능한 가장 왼쪽 위치를 찾는다.
    while (startIdx < endIdx) {
      int mid = (startIdx + endIdx) / 2;

      if (numCards[mid] >= num) {
        endIdx = mid;
      } else if (numCards[mid] < num) {
        startIdx = mid + 1;
      }
    }

    int leftIdx = startIdx;

    startIdx = 0;
    endIdx = numCards.length;

    // num 이 삽입 가능한 가장 오른쪽 위치를 찾는다.
    while (startIdx < endIdx) {
      int mid = (startIdx + endIdx) / 2;

      if (numCards[mid] > num) {
        endIdx = mid;
      } else if (numCards[mid] <= num) {
        startIdx = mid + 1;
      }
    }
    int rightIdx = startIdx;

    // 둘의 차이를 계산하면 해당 숫자가 나온 횟수를 알 수 있다.
    return rightIdx - leftIdx;
  }
}
