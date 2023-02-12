package baekjoon.backtracking;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _15655_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Initialization
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] nums = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    // Your Code
    Arrays.sort(nums);

    boolean[] visited = new boolean[N];
    int[] selection = new int[M];

    permutation(nums, 0, 0, M, visited, selection);

    br.close();
  }

  private void permutation(int[] nums, int startIdx, int selectedLength, int targetLength, boolean[] visited,
      int[] selection) {
    if (selectedLength == targetLength) {
      String result = Arrays.toString(selection).replaceAll("[\\[\\]\\,]", "");
      // String result = Arrays.toString(selection);
      System.out.println(result);
      return;
    }

    for (int i = startIdx; i < nums.length; i++) {
      visited[i] = true;
      selection[selectedLength] = nums[i];
      permutation(nums, i + 1, selectedLength + 1, targetLength, visited, selection);
      visited[i] = false;

    }
  }
}
