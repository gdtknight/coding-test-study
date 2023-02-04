package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import common.Problem;

public class _18870_ implements Problem {

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

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] cors = new int[N];

    for (int i = 0; i < N; i++) {
      cors[i] = Integer.parseInt(st.nextToken());
    }

    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    int[] sorted = Arrays.stream(cors).filter(cor -> set.add(cor)).sorted().toArray();

    for (int i = 0; i < sorted.length; i++) {
      map.put(sorted[i], i);
    }

    int[] answerCors = Arrays.stream(cors).map(cor -> map.get(cor)).toArray();

    System.out.println(Arrays.toString(cors));
    System.out.println(Arrays.toString(sorted));
    System.out.println(Arrays.toString(answerCors));

    br.close();
  }

}
