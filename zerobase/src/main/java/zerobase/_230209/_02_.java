package zerobase._230209;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import common.Problem;

public class _02_ implements Problem {
  public void solution(String[] args) throws Exception {
    int[][] value = new int[][] {
        { 5, 3 }, { 6, 9 }, { 4, 5 }, { 6, 3 }, { 2, 8 }, { 5, 4 }
    };

    System.out.println(solution(value));
  }

  public int solution(int[][] value) {
    Set<Pair> set = new HashSet<>();

    Comparator<Pair> p1 = (o1, o2) -> {
      return o1.getX() == o2.getX() ? o2.getY() - o1.getY() : o2.getX() - o1.getX();
    };

    Comparator<Pair> p2 = (o1, o2) -> {
      return o1.getY() == o2.getY() ? o2.getX() - o1.getX() : o2.getY() - o1.getY();
    };

    PriorityQueue<Pair> p1Queue = new PriorityQueue<>(p1);
    PriorityQueue<Pair> p2Queue = new PriorityQueue<>(p2);

    for (int i = 0; i < value.length; i++) {
      p1Queue.add(new Pair(value[i][0], value[i][1]));
      p2Queue.add(new Pair(value[i][0], value[i][1]));
    }

    int point1 = 0;
    int point2 = 0;

    for (int i = 0; i < value.length; i++) {
      // 플레이어 1 차례
      if (i % 2 == 0) {
        Pair current = p1Queue.poll();
        while (set.contains(current)) {
          current = p1Queue.poll();
        }
        System.out.println("player1 choice : " + current);
        point1 += current.getX();
        set.add(current);
      }
      // 플레이어 2 차례
      else {
        Pair current = p2Queue.poll();
        while (set.contains(current)) {
          current = p2Queue.poll();
        }
        System.out.println("player2 choice : " + current);
        point2 += current.getY();
        set.add(current);
      }
    }

    System.out.println("point1: " + point1 + ", point2: " + point2);
    return point1 > point2 ? 1 : point1 == point2 ? 0 : -1;
  }
}

class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
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
    Pair other = (Pair) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "[ " + x + ", " + y + " ]";
  }

}
