public class test {
  public static void main(String[] args) {
    System.out.println(Long.MAX_VALUE);
    System.out.println(Long.MAX_VALUE + 100000);
    System.out.println(Long.parseLong((Long.MAX_VALUE + 1) + ""));
    System.out.println(Long.parseLong((Long.MAX_VALUE + 10000) + ""));
  }

}
