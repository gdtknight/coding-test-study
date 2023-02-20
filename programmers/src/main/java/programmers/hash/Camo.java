package programmers.hash;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Initialization;
import common.Problem;

public class Camo implements Problem {
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int solution(String[][] clothes) {
    int answer = 0;

    long[] fact = new long[31];

    fact[1] = 1L;
    fact[2] = 2L;

    for (int i = 3; i < fact.length; i++) {
      fact[i] = fact[i - 1] * (long) i;
    }

    Map<String, Integer> map = new HashMap<>();

    // 1 <= clothes.length <= 30

    for (int i = 0; i < clothes.length; i++) {
      answer += 1;
      map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
    }

    for (int i = 1; i <= map.keySet().size(); i++) {
      answer += getNumsOfCase(map, i);

    }

    return answer;
  }

  private int getNumsOfCase(Map<String, Integer> map, int n) {
    boolean[] visited = new boolean[map.keySet().size()];

    return 0;
  }
}
