package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_HideAndSeek {

  static int K;
  static int N;
  static Queue<Integer> queue = new LinkedList<>();
  static int[] distance = new int[100_001];

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    Object o = new Object() {
    };
    String className = o.getClass().getEnclosingClass().getName();
    String fullPath = rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fullPath)));
    //

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    // System.out.println("height: " + height + ", width: " + width);

    // 결과 출력 부분
    System.out.println(seek());

    br.close();
  }

  public static int seek() {
    distance[N] = 1;
    queue.offer(N);

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur != K) {
        int next1 = cur + 1;
        int next2 = cur - 1;
        int next3 = 2 * cur;
        if (isIn(next1)) {
          if (distance[next1] == 0) {
            distance[next1] = distance[cur] + 1;
            queue.offer(next1);
          }
        }

        if (isIn(next2)) {
          if (distance[next2] == 0) {
            distance[next2] = distance[cur] + 1;
            queue.offer(next2);
          }
        }

        if (isIn(next3)) {
          if (distance[next3] == 0) {
            distance[next3] = distance[cur] + 1;
            queue.offer(next3);
          }
        }
      } else {
        return distance[cur] - 1;
      }
    }
    return distance[K] - 1;
  }

  static boolean isIn(int pos) {
    return (0 <= pos && pos <= 100_000);
  }
}
