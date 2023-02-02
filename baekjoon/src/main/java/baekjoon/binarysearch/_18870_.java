package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _18870_ {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
