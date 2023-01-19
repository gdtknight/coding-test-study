package zerobase;

public class _230120_01 {
  public static void main(String[] args) {
    System.out.println(answer(7, 4).intValue());
  }

  public static Double answer(int N, int M) {
    int max = Math.max(N, M);
    int min = Math.min(N, M);
    return Math.ceil((double) max / (double) min) * (double) min;

  }
}
