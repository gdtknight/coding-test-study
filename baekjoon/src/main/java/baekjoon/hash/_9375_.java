package baekjoon.hash;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import baekjoon.common.Initialization;
import baekjoon.common.Problem;

public class _9375_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numsOfCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < numsOfCase; i++) {
      Map<String, Set<String>> map = new HashMap<>();

      int numsOfLook = Integer.parseInt(br.readLine());

      for (int j = 0; j < numsOfLook; j++) {
        String[] look = br.readLine().split(" ");
        Set<String> names = map.getOrDefault(look[1], new HashSet<>());
        names.add(look[0]);

        map.put(look[1], names);
      }

      if (map.keySet().size() == 1) {
        for (Entry<String, Set<String>> entry : map.entrySet()) {
          // System.out.println(entry.getKey());
          // System.out.println(Arrays.toString(entry.getValue().toArray()));
        }
        System.out.println(map.get(map.keySet().iterator().next()).size());
      } else {

        int result = 0;
        int gop = 1;

        for (Entry<String, Set<String>> entry : map.entrySet()) {
          // System.out.println(entry.getKey());
          // System.out.println(Arrays.toString(entry.getValue().toArray()));
          result += entry.getValue().size();
          gop *= entry.getValue().size();
        }

        System.out.println(result + gop);
      }

    }

    // Your code

    br.close();
  }

}
