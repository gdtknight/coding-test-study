package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.Initialization;
import common.Problem;

public class _2503_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());
    String[][] scoreInfo = new String[N][3];

    for (int i = 0; i < N; i++) {
      scoreInfo[i] = br.readLine().split(" ");
    }

    List<String> nums = new ArrayList<>();

    for (int baek = 1; baek <= 9; baek++) {
      for (int sip = 1; sip <= 9; sip++) {
        if (baek == sip) {
          continue;
        }
        for (int ill = 1; ill <= 9; ill++) {
          if (baek == ill || sip == ill) {
            continue;
          }

          String curNum = (baek * 100 + sip * 10 + ill) + "";
          boolean found = canMatch(scoreInfo, curNum);

          if (found) {
            nums.add(curNum);
          }
        }
      }
    }
    System.out.println(nums.size());

    br.close();
  }

  public boolean canMatch(String[][] scoreInfo, String curNum) {
    for (int i = 0; i < scoreInfo.length; i++) {
      int strikeCnt = 0;
      int ballCnt = 0;

      Set<Integer> checkedDigit = new HashSet<>();

      for (int numDigit = 0; numDigit < 3; numDigit++) {
        for (int infoDigit = 0; infoDigit < 3; infoDigit++) {

          if (!checkedDigit.contains(infoDigit)
              && numDigit == infoDigit
              && curNum.charAt(numDigit) == scoreInfo[i][0].charAt(infoDigit)) {

            checkedDigit.add(infoDigit);
            strikeCnt++;

          } else if (!checkedDigit.contains(infoDigit)
              && curNum.charAt(numDigit) == scoreInfo[i][0].charAt(infoDigit)) {
            checkedDigit.add(infoDigit);

            ballCnt++;
          }

        }
      }

      if (Integer.parseInt(scoreInfo[i][1]) != strikeCnt
          || Integer.parseInt(scoreInfo[i][2]) != ballCnt) {

        return false;
      }

    }

    return true;
  }
}
