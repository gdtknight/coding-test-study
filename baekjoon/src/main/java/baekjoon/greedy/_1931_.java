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

    List<int[]> meetingList = new ArrayList<>();

    int[] curMeet = meetings[0];
    meetingList.add(curMeet);

    for (int i = 1; i < N; i++) {
      if (curMeet[1] < meetings[i][0]) {
        curMeet = meetings[i];
        meetingList.add(curMeet);
      }
    }

    // meetingList.stream().forEach(meet ->
    // System.out.println(Arrays.toString(meet)));
    System.out.println(meetingList.size());

    br.close();
  }

}
