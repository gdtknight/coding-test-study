package zerobase._230309;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import common.Problem;

public class _03_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < trans.length <= 100000
    // 0 < trans[i][0] < = 10
    // 0 < trans[i][1] < = 10
    // 0 < trans[i][2] <= 100000

    int[][] trans = {
        { 0, 1, 1000 },
        { 1, 0, 500 },
        { 0, 2, 5000 }
    };

    System.out.println(solution(trans));
  }

  public int solution(int[][] trans) {
    Map<Transaction, Integer> transMap = new HashMap<>();

    Arrays.stream(trans)
        .forEach(t -> {
          if (t[0] < t[1]) {
            Transaction cur = new Transaction(t[0], t[1]);
            int amount = transMap.getOrDefault(cur, 0);
            transMap.put(cur, amount + t[2]);
          } else {
            Transaction cur = new Transaction(t[1], t[0]);
            int amount = transMap.getOrDefault(cur, 0);
            transMap.put(cur, amount - t[2]);
          }
        });

    return transMap.size();
  }
}

class Transaction {
  int sender;
  int receiver;

  public Transaction(int sender, int receiver) {
    this.sender = sender;
    this.receiver = receiver;
  }

  public int getSender() {
    return sender;
  }

  public int getReceiver() {
    return receiver;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + sender;
    result = prime * result + receiver;
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
    Transaction other = (Transaction) obj;
    if (sender != other.sender)
      return false;
    if (receiver != other.receiver)
      return false;
    return true;
  }

}
