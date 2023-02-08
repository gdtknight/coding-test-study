package programmers;

import java.io.BufferedReader;

import common.Initialization;
import common.Problem;

public class ZipString implements Problem {
  public void solution(String[] args) throws Exception {
    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  }

  public static int solution() {
    String origin = "abcabcabcabcdededededede";
    int answer = Integer.MAX_VALUE;

    // 입력 문자열의 길이가 1일 경우 압축 불가능
    if (origin.length() == 1) {
      return origin.length();
    }

    // 압축된 문자열 저장을 위한 StringBuilder
    StringBuilder sb = null;

    // len -> 압축하고자 하는 길이. 문자열 길이의 절반보다 크면 압축이 불가능하다.
    for (int len = 1; len <= origin.length() / 2; len++) {
      sb = new StringBuilder();

      // [ 탐색할 인덱스의 범위 ]

      // ooooooooooooo => 압축하고자 하는 길이가 2일 때
      // _________^___ => 이 부분까지만 탐색하면 된다.

      // 인덱스가 이 부분을 넘어설 경우 남은 부분들은 StringBuilder에 추가한다.

      // 문자열의 처음부터 탐색
      int idx = 0;

      while (idx <= origin.length() - len * 2) {

        String target = origin.substring(idx, origin.length());
        String prefix = origin.substring(idx, idx + len);

        int repeatedCnt = repeatCnt(target, prefix);

        if (repeatedCnt > 1) {
          sb.append(repeatedCnt);
          sb.append(prefix);
        } else {
          sb.append(prefix);
        }

        // 무조건 문자열의 시작부터 len만큼 자르기 때문에
        // 체크해야 할 인덱스는 len의 배수만큼 증가한다.
        idx = idx + len * repeatedCnt;

        // 탐색 범위를 벗어날 경우 남은 부분 빌더에 추가하고 마무리.
        if (idx > origin.length() - len * 2) {
          sb.append(origin.substring(idx, origin.length()));
        }
      }

      if (sb.length() < answer) {
        answer = sb.length();
      }
    }

    return answer;
  }

  public static int repeatCnt(String target, String prefix) {
    int cnt = 0;

    String remain = target;

    while (remain.startsWith(prefix)) {
      cnt += 1;
      remain = remain.substring(prefix.length());
    }

    return cnt;
  }

}
