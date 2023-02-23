package baekjoon.greedy;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import common.Initialization;
import common.Problem;

public class _1931_ implements Problem {

  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Your code
    int N = Integer.parseInt(br.readLine());
    int[][] meetings = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      meetings[i][0] = Integer.parseInt(st.nextToken());
      meetings[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meetings, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

    List<int[]> list = new ArrayList<>();

    int[] cur = meetings[0];
    int cnt = 1;
    list.add(cur);

    for (int next = 1; next < N; next++) {
      if (cur[1] < meetings[next][0]) {
        cur = meetings[next];
        cnt += 1;
      }
    }

    // meetingList.stream().forEach(meet ->
    // System.out.println(Arrays.toString(meet)));
    System.out.println(cnt);

    br.close();
  }

}
