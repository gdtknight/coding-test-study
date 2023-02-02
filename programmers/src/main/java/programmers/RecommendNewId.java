package programmers;

public class RecommendNewId {
  public static void main(String[] args) {
    /**
     * no new_id result
     * 예1 "...!@BaT#*..y.abcdefghijklm" "bat.y.abcdefghi"
     * 예2 "z-+.^." "z--"
     * 예3 "=.=" "aaa"
     * 예4 "123_.def" "123_.def"
     * 예5 "abcdefghijklmn.p" "abcdefghijklmn"
     */

    String case1 = "...!@BaT#*..y.abcdefghijklm";
    String case2 = "z-+.^.";
    String case3 = "=.=";
    String case4 = "123_.def";
    String case5 = "abcdefghijklmn.p";

    String answer1 = "bat.y.abcdefghi";
    String answer2 = "z--";
    String answer3 = "aaa";
    String answer4 = "123_.def";
    String answer5 = "abcdefghijklmn";

    Solution solution = new Solution();

    System.out.println("Case1: " + solution.solution(case1).equals(answer1));
    System.out.println("Case2: " + solution.solution(case2).equals(answer2));
    System.out.println("Case3: " + solution.solution(case3).equals(answer3));
    System.out.println("Case4: " + solution.solution(case4).equals(answer4));
    System.out.println("Case5: " + solution.solution(case5).equals(answer5));

  }

}

class Solution {
  public String solution(String new_id) {
    System.out.println("시작 문자열 : " + new_id);

    // 전체 소문자로 변경
    new_id = new_id.toLowerCase();
    System.out.println("     1 단계 : " + new_id);

    // -, _, . 이외의 특수문자 제거
    new_id = new_id.replaceAll("[\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\=\\+\\[\\{\\]\\}\\:\\?\\,\\<\\>\\/]+", "");
    System.out.println("     2 단계 : " + new_id);

    // . 2개 연속해서 나올 경우 . 으로 치환
    new_id = new_id.replaceAll("[\\.]+", ".");
    System.out.println("     3 단계 : " + new_id);

    // 시작이나 끝에 . 있으면 제거
    if (new_id.startsWith(".")) {
      new_id = new_id.substring(1);
    }

    if (new_id.endsWith(".")) {
      new_id = new_id.substring(0, new_id.length() - 1);
    }
    System.out.println("     4 단계 : " + new_id);

    // 공백만 남을 경우 a 추가
    if (new_id.equals("")) {
      new_id += "a";
    }
    System.out.println("     5 단계 : " + new_id);

    if (new_id.length() > 14) {
      new_id = new_id.substring(0, 15);
      if (new_id.endsWith(".")) {
        new_id = new_id.substring(0, 14);
      }
    }
    System.out.println("     6 단계 : " + new_id);

    while (new_id.length() <= 2) {
      new_id += (new_id.charAt(new_id.length() - 1) + "");
    }
    System.out.println("     7 단계 : " + new_id);

    return new_id;
  }
}
