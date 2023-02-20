package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import common.Problem;

public class Camo implements Problem {
  public void solution(String[] args) throws Exception {

    String[][] clothes = {
        { "yellow_hat", "headgear" },
        { "blue_sunglasses", "eyewear" },
        { "green_truban", "headgear" }
    };

    System.out.println(solution(clothes));
  }

  public int solution(String[][] clothes) {

    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < clothes.length; i++) {
      List<String> list = null;
      if (map.containsKey(clothes[i][1])) {
        list = map.get(clothes[i][1]);
        list.add(clothes[i][0]);
        map.put(clothes[i][1], list);
      } else {
        list = new ArrayList<>();
        list.add("");
        list.add(clothes[i][0]);
        map.put(clothes[i][1], list);
      }
    }

    for (Entry<String, List<String>> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue().toArray()));
    }

    int answer = 1;

    for (String key : map.keySet()) {
      answer *= map.get(key).size();
    }

    return answer - 1;
  }
}
