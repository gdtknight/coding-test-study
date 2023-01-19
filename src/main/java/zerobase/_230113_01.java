package zerobase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _230113_01 {
  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/zerobase";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/_220113_01")));
    int N = Integer.parseInt(br.readLine());
    for (int n = 0; n < N; n++) {
      String s = br.readLine().stripLeading().replaceAll(" ", "").toLowerCase();
      System.out.println(answer(s));

    }

  }

  public static int answer(String str) {
    String s = str.stripLeading().replaceAll(" ", "").toLowerCase();
    // boolean isMinus = s.charAt(0) == '-' ? true : false;

    System.out.println(s);
    int startIdx = 0;
    while (!('0' <= s.charAt(startIdx) && s.charAt(startIdx) <= '9')) {
      startIdx++;
    }
    String s1 = s.substring(0, startIdx);
    System.out.println("s1 : " + s1);

    boolean isMinus = s1.contains("-") ? true : false;
    s = s.substring(startIdx);
    System.out.println("s2 : " + s);
    System.out.println("isMinus ? " + isMinus);

    int idx = 0;

    for (int i = 0; i < s.length(); i++) {
      if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
        continue;
      } else {
        idx = i;
        break;
      }
    }

    Long longNum = Long.parseLong(s.substring(0, idx));

    if (!isMinus && longNum < 0) {
      return Integer.MAX_VALUE;
    } else if (isMinus && longNum < 0) {
      return Integer.MIN_VALUE;
    } else if (isMinus && longNum > 0) {
      longNum = longNum * (-1);
      if (longNum <= Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    } else if (!isMinus && longNum > 0) {
      if (longNum >= Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else {
        return longNum.intValue();
      }
    }

    return longNum.intValue();
  }

}
