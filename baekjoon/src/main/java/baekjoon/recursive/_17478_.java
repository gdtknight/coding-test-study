
package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _17478_ {

  // 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
  // "재귀함수가 뭔가요?"
  // "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
  // 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
  // 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
  // ____"재귀함수가 뭔가요?"
  // ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
  // ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
  // ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
  // ________"재귀함수가 뭔가요?"
  // ________"재귀함수는 자기 자신을 호출하는 함수라네"
  // ________라고 답변하였지.
  // ____라고 답변하였지.
  // 라고 답변하였지.

  public static int N = 0;

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
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
    N = Integer.parseInt(br.readLine());

    recursiveChat(0);
    br.close();
  }

  public static void recursiveChat(int n) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append("____");
    }

    if (n == N) {
      System.out.println(sb.toString() + "\"재귀함수가 뭔가요?\"");
      System.out.println(sb.toString() + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
      System.out.println(sb.toString() + "라고 답변하였지.");
      return;
    }

    System.out.println(sb.toString() + "\"재귀함수가 뭔가요?\"");
    System.out.println(sb.toString() + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
    System.out.println(sb.toString() + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
    System.out.println(sb.toString() + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
    recursiveChat(n + 1);
    System.out.println(sb.toString() + "라고 답변하였지.");

  }
}
