package zerobase._230309;

import common.Problem;

public class _02_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < s.length <= 100000
    // 0 < t.length <= 100000
    String s = "zEroBase";
    String t = "zerOBase";

    System.out.println(solution(s, t));
  }

  public boolean solution(String s, String t) {

    // 길이가 2이상 차이 나는 경우
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    // 길이가 같은 문자열에서 다른 문자가 2개 이상일 때
    if (s.length() == t.length()) {
      int cnt = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          cnt++;
        }
      }
      if (cnt > 1) {
        return false;
      }
    }

    // s에서 문자 하나를 삭제하여 t를 만들 수 있다.
    if (s.length() == t.length() + 1) {
      int idx = -1;

      for (int i = 0; i < t.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          idx = i;
          break;
        }
      }

      if (idx != -1) {
        return new StringBuilder(s).deleteCharAt(idx).toString().equals(t);
      }
    }

    // s에서 문자 하나를 추가하여 t를 만들 수 있다.
    if (s.length() + 1 == t.length()) {
      int idx = -1;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          idx = i;
          break;
        }
      }

      if (idx != -1) {
        return new StringBuilder(s).insert(idx, t.charAt(idx)).toString().equals(t);
      }
    }

    return true;
  }
}
