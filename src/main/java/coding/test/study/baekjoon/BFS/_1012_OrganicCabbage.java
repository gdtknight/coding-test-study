package coding.test.study.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_OrganicCabbage {

  static int M;
  static int N;
  static int K;
  static Pos[] dirs = new Pos[] { new Pos(1, 0), new Pos(-1, 0), new Pos(0, 1), new Pos(0, -1) };
  static Queue<CabbagePos> queue;

  public static void main(String[] args) throws IOException {
    String filePathRoot = "/home/ubuntu/workspace/coding-test-study/src/main/resources/BFS/";
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRoot + "_1012_TestCase")));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numsOfTestCase = Integer.parseInt(br.readLine());
    char[][] field = null;
    StringTokenizer st = null;
    for (int i = 0; i < numsOfTestCase; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // 가로길이
      N = Integer.parseInt(st.nextToken()); // 세로길이
      K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

      field = new char[M][N];

      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        field[m][n] = '1';
      }
      // 결과 출력 부분
      System.out.println(countWorm(field));
    }

    br.close();
  }

  public static int countWorm(char[][] field) {
    int cnt = 0;
    for (int m = 0; m < M; m++) {
      for (int n = 0; n < N; n++) {
        if (field[m][n] == '1') {
          cnt += 1;
          bfs(field, m, n);
        }
      }
    }
    return cnt;
  }

  public static void bfs(char[][] field, int m, int n) {
    queue = new LinkedList<>();
    field[m][n] = '2';
    queue.offer(new CabbagePos(m, n));

    while (!queue.isEmpty()) {
      CabbagePos cur = queue.poll();

      for (int i = 0; i < dirs.length; i++) {
        int nextM = cur.getM() + dirs[i].getM();
        int nextN = cur.getN() + dirs[i].getN();
        if (isIn(nextM, nextN) && field[nextM][nextN] == '1') {
          field[nextM][nextN] = '2';
          queue.offer(new CabbagePos(nextM, nextN));
        }
      }
    }
  }

  static boolean isIn(int nextM, int nextN) {
    return (0 <= nextM && nextM < M)
        && (0 <= nextN && nextN < N);
  }
}

class CabbagePos {
  int m;
  int n;

  public CabbagePos(int m, int n) {
    this.m = m;
    this.n = n;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + m;
    result = prime * result + n;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pos other = (Pos) obj;
    if (m != other.m)
      return false;
    if (n != other.n)
      return false;
    return true;
  }

  public int getM() {
    return m;
  }

  public int getN() {
    return n;
  }
}
