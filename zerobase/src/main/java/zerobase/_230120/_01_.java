package zerobase._230120;

import java.math.BigDecimal;
import java.math.RoundingMode;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {

    System.out.println(answer(4, 9));
  }

  public static int answer(int N, int M) {
    BigDecimal min = new BigDecimal(Math.min(N, M));
    BigDecimal max = new BigDecimal(Math.max(N, M));
    min.setScale(20);
    max.setScale(20);
    BigDecimal tan = min.divide(max, 10, RoundingMode.HALF_EVEN);
    System.out.println(tan);

    int cnt = 0;
    BigDecimal preHeight = new BigDecimal(0.0);
    preHeight.setScale(20);
    for (int i = 1; i <= Math.max(N, M); i++) {

      BigDecimal curHeight = tan.multiply(BigDecimal.valueOf(i));
      curHeight.setScale(20);
      int preIntHeight = preHeight.intValue();
      int curIntHeight = curHeight.subtract(BigDecimal.ONE).intValue();

      System.out.println(i + "th " + "preHeight : " + preHeight + ", curHeight : " + curHeight);
      if (preIntHeight >= curIntHeight) {
        cnt += 1;
      } else {
        cnt += 2;
      }

      preHeight = curHeight;
    }

    return cnt;
  }
}
