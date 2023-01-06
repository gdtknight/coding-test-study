package coding.test.study.baekjoon.BFS;

public class Pos {
  int h;
  int w;

  public Pos(int h, int w) {
    this.h = h;
    this.w = w;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + h;
    result = prime * result + w;
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
    if (h != other.h)
      return false;
    if (w != other.w)
      return false;
    return true;
  }

  public int getH() {
    return h;
  }

  public int getW() {
    return w;
  }
}
