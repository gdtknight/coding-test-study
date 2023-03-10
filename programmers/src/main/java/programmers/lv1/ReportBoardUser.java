package programmers.lv1;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import common.Initialization;
import common.Problem;

public class ReportBoardUser implements Problem {
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int[] solution(String[] id_list, String[] report, int k) {
    HashMap<String, Integer> idIdx = new HashMap<String, Integer>();

    for (int i = 0; i < id_list.length; i++) {
      idIdx.put(id_list[i], i);
    }

    HashSet<String> reportSet = new HashSet<String>(Arrays.asList(report));

    int[] reportedCnt = new int[id_list.length];
    int[] receivedCnt = new int[id_list.length];
    int[][] reportEdge = new int[id_list.length][id_list.length];

    for (String reportLog : reportSet) {
      String[] repo = reportLog.split(" ");
      int reporterIdx = idIdx.get(repo[0]);
      int reportedIdx = idIdx.get(repo[1]);
      reportEdge[reporterIdx][reportedIdx] = 1;
      reportedCnt[reportedIdx] += 1;
    }

    for (int idx = 0; idx < reportedCnt.length; idx++) {
      if (reportedCnt[idx] >= k) {
        for (int i = 0; i < reportEdge.length; i++) {
          if (reportEdge[i][idx] > 0) {
            receivedCnt[i] += 1;
          }
        }
      }
    }

    return receivedCnt;
  }

}
