package baekjoon.hash;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import common.Initialization;
import common.Problem;

public class _9375_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numsOfCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < numsOfCase; i++) {
      System.out.println("TestCase " + i);
      Map<String, Set<String>> map = new HashMap<>();

      int numsOfLook = Integer.parseInt(br.readLine());

      for (int j = 0; j < numsOfLook; j++) {
        String[] look = br.readLine().split(" ");
        Set<String> names = map.getOrDefault(look[1], new HashSet<>());
        names.add(look[0]);

        map.put(look[1], names);
      }

      int sum = 0;

      String[] keyList = (String[]) map.keySet().toArray();

      for (Entry<String, Set<String>> entry : map.entrySet()) {
        sum += entry.getValue().size();
        System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue().toArray()));
      }

      System.out.println();

      boolean[] visitedKey = new boolean[keyList.length];

      for (int r = 1; r <= map.entrySet().size(); r++) {
        int depth = 0;

        while (true) {
          if (depth == r) {
            for (int idx = 0; idx < keyList.length; idx++) {
              if (visitedKey[idx]) {
                System.out.println(keyList[idx]);
              }

            }

          }

        }

      }
    }

    // Your code

    br.close();
  }

}
