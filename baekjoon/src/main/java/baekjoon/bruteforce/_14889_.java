package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.util.Arrays;
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
    int[] selection = new int[N / 2];

    divideTeam(table, 0, N / 2, 0, selection);

    System.out.println(diff);

    br.close();
  }

  public void divideTeam(int[][] table, int selectedCnt, int totalCnt, int start, int[] selection) {
    if (selectedCnt == totalCnt) {
      int[] teamLink = new int[N / 2];
      int[] teamStart = new int[N / 2];

      int linkIdx = 0;
      int startIdx = 0;

      for (int i = 0; i < N; i++) {
        boolean isLink = false;

        for (int j = 0; j < selection.length; j++) {
          if (selection[j] == i) {
            isLink = true;
            break;
          }
        }

        if (isLink) {
          teamLink[linkIdx++] = i;
        } else {
          teamStart[startIdx++] = i;
        }
      }

      int linkPower = 0;
      int startPower = 0;

      for (int i = 0; i < teamLink.length - 1; i++) {
        for (int j = i + 1; j < teamLink.length; j++) {
          linkPower += table[teamLink[i]][teamLink[j]];
          linkPower += table[teamLink[j]][teamLink[i]];
        }
      }

      for (int i = 0; i < teamLink.length - 1; i++) {
        for (int j = i + 1; j < teamLink.length; j++) {
          startPower += table[teamStart[i]][teamStart[j]];
          startPower += table[teamStart[j]][teamStart[i]];
        }
      }

      if (Math.abs(startPower - linkPower) < diff) {
        diff = Math.abs(startPower - linkPower);
      }

      return;
    }

    for (int i = start; i < N; i++) {
      selection[selectedCnt] = i;
      divideTeam(table, selectedCnt + 1, totalCnt, i + 1, selection);
    }

  }

}
