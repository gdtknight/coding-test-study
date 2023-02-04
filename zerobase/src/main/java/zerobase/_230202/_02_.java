package zerobase._230202;

import java.util.HashSet;
import java.util.Set;

import common.Problem;

public class _02_ implements Problem {
  public void solution(String[] args) throws Exception {
    // int[] arr = new int[] { 10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8 };
    int[] arr = new int[] { 7, 9, 1, 5, 8, 3 };

    boolean[] visited = new boolean[arr.length];

    Set<Integer> result = new HashSet<>();

    permutation(arr, 0, 0, arr.length / 3, visited);

  }

  /**
   * @param arr           : 뽑을 숫자들이 저장되어 있는 배열
   * @param selectCnt     : 현재까지 선택된 숫자 개수
   * @param nextSearchIdx : 다음번 선택을 위해 탐색을 시작할 인덱스
   * @param totalCnt      : 총 뽑아야 할 숫자 개수
   * @param selected      : 선택된 숫자 표시
   */
  public void permutation(int[] arr, int selectCnt, int nextSearchIdx, int totalCnt, boolean[] selected) {
    if (selectCnt == totalCnt) {
      for (int i = 0; i < arr.length; i++) {
        if (!selected[i]) {
          System.out.printf("%2d ", arr[i]);
        }
      }
      System.out.println();
      System.out.println("------");

      return;
    }

    for (int i = nextSearchIdx; i < arr.length; i++) {
      selected[i] = true;
      // 현재 인덱스 선택 표시 후
      // 현재 인덱스 다음번 인덱스부터 다시 탐색을 시작
      permutation(arr, selectCnt + 1, nextSearchIdx + 1, totalCnt, selected);
      selected[i] = false;
    }

  }
}
