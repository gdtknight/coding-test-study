package zerobase._230309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < phrase.length <= 10000
    // 0 < phrase[i].length <= 10000
    String[] phrase = new String[] {
        "zerobase is",
        "is the greatest platform"
    };

    System.out.println(Arrays.toString(answer(phrase)));
  }

  public String[] answer(String[] phrase) {
    Map<String, List<String>> preMap = new HashMap<>();
    Map<String, List<String>> postMap = new HashMap<>();

    Arrays.stream(phrase)
        .forEach(str -> {
          int firstSpace = str.indexOf(" ");
          int lastSpace = str.lastIndexOf(" ");

          String prefix = str.substring(0, firstSpace);
          String preElse = str.substring(firstSpace + 1, str.length());

          List<String> pre = preMap.getOrDefault(prefix, new ArrayList<String>());
          pre.add(preElse);
          preMap.put(prefix, pre);

          String postfix = str.substring(lastSpace + 1, str.length());
          String postElse = str.substring(0, lastSpace);

          List<String> post = postMap.getOrDefault(postfix, new ArrayList<String>());
          post.add(postElse);
          postMap.put(postfix, post);
        });

    List<String> results = new ArrayList<>();

    for (String key : preMap.keySet()) {
      if (postMap.containsKey(key)) {
        postMap.get(key).stream().forEach(
            postElse -> preMap.get(key).stream().forEach(
                preElse -> {
                  String result = postElse + " " + key + " " + preElse;
                  results.add(result);
                }));
      }
    }
    String[] ans = new String[results.size()];

    return results.toArray(ans);
  }

}
