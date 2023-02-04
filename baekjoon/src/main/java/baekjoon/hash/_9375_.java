package baekjoon.hash;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import common.Initialization;
import common.Problem;

public class _9375_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int numsOfCase = Integer.parseInt(br.readLine());
    List<Map> list = new ArrayList<>();

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
        System.out.println(map.entrySet().iterator().next().getValue().size());
      } else {
        int result = 0;

        for (Entry<String, Set<String>> entry : map.entrySet()) {
          result += entry.getValue().size();
        }

        String[] keyArr = new String[map.keySet().size()];
        map.keySet().toArray(keyArr);

        for (int totalCnt = 2; totalCnt <= keyArr.length; totalCnt++) {
          result += getCnt(map, keyArr, totalCnt);
        }
        System.out.println(result);
      }

    }

    br.close();
  }

  public int getCnt(Map<String, Set<String>> map, String[] keyArr, int totalCnt) {
    int result = 0;
    boolean[] selected = new boolean[keyArr.length];
    List<String[]> list = new ArrayList<>();

    permutation(keyArr, 0, totalCnt, 0, selected, list);
    for (String[] pair : list) {
      int sum = 1;
      for (int i = 0; i < pair.length; i++) {
        sum *= map.get(pair[i]).size();
      }
      result += sum;
    }

    return result;
  }

  public void permutation(
      String[] keyArr,
      int selectedCnt,
      int totalCnt,
      int nextSearchIdx,
      boolean[] selected,
      List<String[]> list) {

    if (totalCnt == selectedCnt) {
      String[] newPair = new String[totalCnt];
      int idx = 0;
      for (int i = 0; i < keyArr.length; i++) {
        if (selected[i]) {
          newPair[idx++] = keyArr[i];
        }
      }
      list.add(newPair);
      return;
    }

    for (int i = nextSearchIdx; i < keyArr.length; i++) {
      selected[i] = true;
      permutation(keyArr, selectedCnt + 1, totalCnt, i + 1, selected, list);
      selected[i] = false;
    }

  }
}
