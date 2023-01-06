package coding.test.study.baekjoon.BFS;

public class Pos {
  int m;
  int n;

  public Pos(int m, int n) {
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
