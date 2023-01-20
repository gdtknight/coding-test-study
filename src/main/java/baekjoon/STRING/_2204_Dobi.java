package baekjoon.STRING;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2204_Dobi {
  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources";
    String packagePath = "/testcase/baekjoon/STRING";
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePathRoot + packagePath + "/2204")));

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    while (n != 0) {

      String[] words = new String[n];

      for (int i = 0; i < n; i++) {
        words[i] = br.readLine();
      }

      Arrays.sort(words, (String s1, String s2) -> {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
          if (s1.charAt(i) < s2.charAt(i)) {
            return -1;
          } else if (s1.charAt(i) > s2.charAt(i)) {
            return 1;
          }
        }

        return s1.length() < s2.length()
            ? 1
            : s1.length() > s2.length()
                ? -1
                : 0;
      });

      System.out.println(Arrays.toString(words));

      n = Integer.parseInt(br.readLine());
    }

    br.close();

  }

}
