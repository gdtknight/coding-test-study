package zerobase._230120;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import zerobase.Problem;

public class _01 implements Problem {
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

    System.out.println(answer(7, 4).intValue());
  }

  public static Double answer(int N, int M) {
    int max = Math.max(N, M);
    int min = Math.min(N, M);
    return Math.ceil((double) max / (double) min) * (double) min;

  }
}
