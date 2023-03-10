package baekjoon.hash;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import common.Initialization;
import common.Problem;

public class _9375_ implements Problem {
  static int result = 0;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int numsOfCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < numsOfCase; i++) {
      int numsOfLook = Integer.parseInt(br.readLine());

      result = 0;
      Map<String, Integer> map = new HashMap<>();

      for (int j = 0; j < numsOfLook; j++) {
        String[] str = br.readLine().split(" ");
        map.put(str[1], map.getOrDefault(str[1], 1) + 1);
      }

      System.out.println(map.values().stream().reduce((n1, n2) -> n1 * n2).orElse(1) - 1);
    }

    br.close();
  }

}
