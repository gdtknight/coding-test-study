package programmers;

import java.util.HashMap;

public class Mbti {

}

class Solution {

  public String solution(String[] survey, int[] choices) {

    String[] MBTI = { "RT", "CF", "JM", "AN" };
    int[] point = new int[4];

    for (int i = 0; i < survey.length; i++) {

      if (survey[i].charAt(0) > survey[i].charAt(1)) {
        survey[i] = new StringBuffer(survey[i]).reverse().toString();
        choices[i] = (-1) * (choices[i] - 4);
      } else {
        choices[i] = (choices[i] - 4);
      }

      for (int j = 0; j < MBTI.length; j++) {
        if (survey[i].equals(MBTI[j])) {
          point[j] += choices[i];
        }
      }
    }

    String answer = "";

    for (int i = 0; i < point.length; i++) {
      int idx = point[i] <= 0 ? 0 : 1;
      answer += MBTI[i].charAt(idx);
    }

    return answer;
  }
}
