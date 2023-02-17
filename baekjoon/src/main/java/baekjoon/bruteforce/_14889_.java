package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import common.Initialization;
import common.Problem;

public class _14889_ implements Problem {

  static int N = 0;
  static int diff = Integer.MAX_VALUE;

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    N = Integer.parseInt(br.readLine());

    int[][] table = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < N; j++) {
        table[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Set<Integer> teamStart = new HashSet<>();
    Set<Integer> teamLink = new HashSet<>();

    IntStream.range(0, N).forEach(teamStart::add);

    permutation(table, teamLink, teamStart);

    System.out.println(diff);

    br.close();
  }

  public void permutation(int[][] table, Set<Integer> teamLink, Set<Integer> teamStart) {

    if (teamLink.size() == teamStart.size()) {

      int linkPower = teamLink.stream().map(member -> {
        int power = 0;

        for (int another : teamLink) {
          if (member != another) {
            power += table[member][another];
            power += table[another][member];
          }
        }

        return power;
      }).mapToInt(Integer::valueOf).sum();

      int startPower = teamStart.stream().map(member -> {
        int power = 0;

        for (int another : teamStart) {
          if (member != another) {
            power += table[member][another];
            power += table[another][member];
          }
        }

        return power;
      }).mapToInt(Integer::valueOf).sum();

      if (Math.abs(linkPower - startPower) / 2 < diff) {
        diff = Math.abs(linkPower - startPower) / 2;
      }

      return;
    }

    for (int i = 0; i < N; i++) {
      if (teamStart.remove(i)) {
        teamLink.add(i);
        permutation(table, teamLink, teamStart);
        teamLink.remove(i);
        teamStart.add(i);
      }
    }
  }

}
