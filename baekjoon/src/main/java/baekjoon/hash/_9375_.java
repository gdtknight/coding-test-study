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
      Map<String, String> map = new HashMap<>();
      result = 0;

      int numsOfLook = Integer.parseInt(br.readLine());

      for (int j = 0; j < numsOfLook; j++) {
        String[] str = br.readLine().split(" ");
        map.put(str[0], str[1]);
      }

      String[] names = new String[map.keySet().size()];
      map.keySet().toArray(names);

      for (int totalCnt = 1; totalCnt <= map.keySet().size(); totalCnt++) {
        boolean[] selected = new boolean[map.size()];
        permutation(map, names, 0, totalCnt, 0, selected);
      }
      System.out.println(result);
    }

    br.close();
  }

  public void permutation(
      Map<String, String> map,
      String[] keyArr,
      int selectedCnt,
      int totalCnt,
      int nextSearchIdx,
      boolean[] selected) {

    if (selectedCnt == totalCnt) {
      Set<String> selection = new HashSet<>();
      for (int i = 0; i < keyArr.length; i++) {
        if (selected[i] && !selection.add(map.get(keyArr[i]))) {
          return;
        }
      }

      result += 1;
      return;
    }

    for (int i = nextSearchIdx; i < keyArr.length; i++) {
      selected[i] = true;
      permutation(map, keyArr, selectedCnt + 1, totalCnt, i + 1, selected);
      selected[i] = false;
    }

  }
}
