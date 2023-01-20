package programmers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZipString {
  /*
   *
   * "aabbaccc" 7
   * "ababcdcdababcdcd" 9
   * "abcabcdede" 8
   * "abcabcabcabcdededededede" 14
   * "xababcdcdababcdcd" 17
   *
   */
  public static void main(String[] args) {

    String origin = "aabbaccc";

    solution(origin);

  }

  public static int solution(String origin) {
    System.out.println("Start string : " + origin);

    Set<String> set = new HashSet<>();
    StringBuilder sb = null;

    for (int i = 1; i < origin.length(); i++) {
      sb = new StringBuilder();

      String target = origin;
      String prefix = origin.substring(0, i);

      System.out.println("Target : " + target + ", prefix : " + prefix);

      String[] result = zip(target, prefix);

      System.out.println("result[0]: " + result[0] + ", result[1]: " + result[1]);

      sb.append(result[0]);

      recursive(result[1], set, sb);
    }

    set.stream().forEach(str -> {
      System.out.println(str);
    });

    return -1;
  }

  public static void recursive(String origin, Set<String> set, StringBuilder sb) {

    if ("".equals(origin)) {
      set.add(sb.toString());
      return;
    }
    if (origin.length() == 1) {
      set.add(sb.append(origin).toString());
      return;
    }

    for (int i = 1; i < origin.length() + 1; i++) {
      StringBuilder newSb = new StringBuilder(sb);
      String target = origin;
      String prefix = origin.substring(0, i);

      String[] result = zip(target, prefix);

      // System.out.println("target : " + target + ", prefix : " + prefix);
      // System.out.println(Arrays.toString(result));

      newSb.append(result[0]);
      recursive(result[1], set, newSb);

      // sb = sb.append(recursive(result[1]));
    }

    return;
  }

  public static String[] zip(String target, String prefix) {
    int cnt = 0;

    while (target.startsWith(prefix)) {
      cnt += 1;
      target = target.substring(prefix.length());
    }

    if (cnt > 1) {
      return new String[] { cnt + prefix, target };
    } else if (cnt == 1) {
      return new String[] { prefix, target };
    } else {
      return new String[] { target, "" };
    }
  }

}
