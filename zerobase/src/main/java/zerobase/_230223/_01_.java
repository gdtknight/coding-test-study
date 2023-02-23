package zerobase._230223;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < s.length <= 10000
    // 0 < t.length <= 10000
    String s = "abcdef";
    String t = "efabcd";

    System.out.println(solution(s, t));
  }

  public boolean solution(String s, String t) {
    StringBuilder sb = new StringBuilder(s);

    do {
      if (sb.toString().equals(t)) {
        return true;
      }
      char first = sb.charAt(0);
      sb.deleteCharAt(0);
      sb.append(first);
    } while (!sb.toString().equals(s));

    return false;
  }

}
