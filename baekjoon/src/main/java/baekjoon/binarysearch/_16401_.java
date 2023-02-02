package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.common.Problem;

public class _16401_ implements Problem {
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

    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken()); // 조카수
    int N = Integer.parseInt(st.nextToken()); // 과자개수

    int[] bisket = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      bisket[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(bisket);

    System.out.println(bisket[0] + " , " + bisket[bisket.length - 1]);

    int startLen = 1;
    int lastLen = bisket[bisket.length - 1];

    while (startLen < lastLen) {
      int len = (startLen + lastLen + 1) / 2;

      int cnt = Arrays.stream(bisket).map(bisketLen -> bisketLen / len).sum();

      if (cnt < M) {
        lastLen = len - 1;
      } else {
        startLen = len;
      }

      System.out.println(startLen + " , " + lastLen);
    }

    br.close();
  }

}
