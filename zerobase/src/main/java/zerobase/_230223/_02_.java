package zerobase._230223;

import common.Problem;

public class _02_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < s.length <= 1000
    String s = "zer0Bas3";

    System.out.println(solution(s));
  }

  public boolean solution(String s) {
    boolean containDigit = false;
    boolean containUppercase = false;

    if (s.length() < 5) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        containDigit = true;
      }
      if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
        containUppercase = true;
      }
    }

    return containDigit && containUppercase;
  }

}
