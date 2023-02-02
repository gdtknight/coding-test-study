package programmers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class RecommendNewId implements Problem {
  public void solution(String[] args) throws Exception {

    String filePath = this.getClass()
        .getName()
        .replaceAll("_", "")
        .replaceAll("\\.", "/");

    System.out.println(filePath);

    File file = new File(this.getClass()
        .getClassLoader()
        .getResource(filePath)
        .getPath());

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  }

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
