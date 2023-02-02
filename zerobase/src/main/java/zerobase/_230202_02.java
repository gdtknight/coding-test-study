package zerobase;

import java.util.HashSet;
import java.util.Set;

public class _230202_02 {
  public static void main(String[] args) {

    // [10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8]
    int[] arr = new int[] { 10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8 };
    // int[] arr = new int[] { 7, 9, 1, 5, 8, 3 };

    _230202_02.Solution solution = new _230202_02().new Solution();
    solution.solution(arr);
    System.out.println("결과 리스트: " + solution.result.toString());
    System.out.println(
        solution.result.stream()
            .min((a, b) -> a.compareTo(b))
            .orElseThrow(() -> new NullPointerException("뭔가 잘못되었다.")));
  }

  class Solution {
    Set<Integer> result = new HashSet<>();

    public int solution(int[] arr) {
      boolean[] visited = new boolean[arr.length];

      // permutation(arr, 0, arr.length, arr.length / 3 * 2);
      extract(arr, 0, arr.length / 3, visited);

      return -1;
    }

    public void extract(int[] arr, int depth, int r, boolean[] visited) {
      if (depth == r) {
        int cnt = 0;
        int first = 0;
        int second = 0;
        for (int i = 0; i < arr.length; i++) {
          if (!visited[i]) {
            cnt += 1;
            if (cnt <= r) {
              first += arr[i];
            } else {
              second += arr[i];
            }
          }
        }

        if (cnt == r * 2) {
          result.add(first - second);
        }

        return;
      }

      for (int i = depth; i < arr.length; i++) {
        if (!visited[i]) {
          visited[i] = true;
          extract(arr, depth + 1, r, visited);
          visited[i] = false;
        }
      }

    }
  }

}
