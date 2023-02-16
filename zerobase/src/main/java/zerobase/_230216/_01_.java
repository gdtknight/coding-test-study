package zerobase._230216;

import java.util.Arrays;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < N = food.length <= 10000
    // 0 < food[i] <= 1000
    int[] food = new int[] { 6, 3, 4, 5 };

    System.out.println(solution(food));
  }

  public int solution(int[] food) {
    int answer = 0;

    Arrays.sort(food);

    for (int i = 1; i < food.length; i += 2) {
      answer += food[i - 1];
      food[i] -= food[i - 1];
      food[i - 1] = 0;
    }

    for (int j = 1; j < food.length; j += 4) {
      answer += food[j];
      food[j] = 0;
    }

    return answer;
  }

}
