package zerobase._230209;

import java.util.HashSet;
import java.util.Set;

import common.Problem;

public class _01_ implements Problem {
  public void solution(String[] args) throws Exception {
    // int[] arr = new int[] { 10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8 };
    // int[] nums = new int[] { 3, 5, 7, 5 };
    int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 3, 4, 4, 5, 2, 3, 4, 6, 6 };

    System.out.println(solution(nums));
  }

  public int solution(int[] nums) {
    int max = 0;

    Set<Pair> set = new HashSet<>();

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (set.add(new Pair(nums[i], nums[j]))) {
          if ((nums[i] - 1) * (nums[j] - 1) > max) {
            max = (nums[i] - 1) * (nums[j] - 1);
          }
        }
      }
    }

    return max;
  }

  class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public int getI() {
      return i;
    }

    public int getJ() {
      return j;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getEnclosingInstance().hashCode();
      result = prime * result + i;
      result = prime * result + j;
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
      if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
        return false;
      if (i != other.i)
        return false;
      if (j != other.j)
        return false;
      return true;
    }

    private _01_ getEnclosingInstance() {
      return _01_.this;
    }

  }
}
