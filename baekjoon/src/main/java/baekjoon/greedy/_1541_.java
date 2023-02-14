package baekjoon.greedy;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import common.Initialization;
import common.Problem;

public class _1541_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    String[] minuses = br.readLine().split("-");

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < minuses.length; i++) {
      int curSum = 0;

      String[] pluses = minuses[i].split("\\+");

      for (int j = 0; j < pluses.length; j++) {
        curSum += Integer.parseInt(pluses[j]);
      }

      System.out.println(curSum);
      list.add(curSum);
    }

    int answer = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      answer -= list.get(i);
    }

    System.out.println(answer);

    br.close();
  }

}
