package zerobase._230120;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class _02_ implements Problem {
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1122911,1,112211
    // 1022911,1,22911
    // 1022911,2,2211
    String num = "1230911";
    int k = 2;
    // 12011
    // 9230111,2,20111

    System.out.println(check(num, k));
  }

  // public static String soluion(String num, int k) {

  // return check(num, k);
  // }

  public static String check(String num, int k) {
    if (k == 0) {
      return num;
    }

    int firstZeroIdx = num.indexOf("0");

    if (firstZeroIdx == -1) {
      while (k > 0) {
        int max = 1;
        int maxIdx = 0;
        for (int i = 0; i < num.length(); i++) {
          int n = Character.getNumericValue(num.charAt(i));

        }
        k--;
      }

    } else if (firstZeroIdx > k) {

    }

    return firstZeroIdx + "";
  }

}
