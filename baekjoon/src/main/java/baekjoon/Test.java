package baekjoon;

import java.io.IOException;
import java.util.Arrays;

public class Test {
  public static void main(String[] args) throws IOException {
    String sample = "sample";
    sample.lastIndexOf('e');
    byte[] values = sample.getBytes();
    System.out.println(Arrays.toString(sample.getBytes()));
    int off = sample.getBytes().length - 1;

    long start = System.currentTimeMillis();
    for (; off >= 0; off--) {
      if (values[off] == (byte) 'e') {
      }
    }
    long end = System.currentTimeMillis();

    System.out.println((end - start) + "ms");

    start = System.currentTimeMillis();
    for (; off >= 0; off--) {
      if (values[off] == (byte) 'z') {
      }
    }
    end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");

    // 현재 힙 메모리 사이즈를 바이트 단위로 반환
    long heapSize = Runtime.getRuntime().totalMemory();
    System.out.println("heapSize (b) : " + heapSize);
    System.out.println("heapSize (kb): " + heapSize / 1024L);
    System.out.println("heapSize (mb): " + heapSize / 1024L / 1024L);

    // 애플리케이션에 할당된 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM 발생
    long heapMaxSize = Runtime.getRuntime().maxMemory();
    System.out.println("heapMaxSize (b) : " + heapMaxSize);
    System.out.println("heapMaxSize (kb): " + heapMaxSize / 1024L);
    System.out.println("heapMaxSize (mb): " + heapMaxSize / 1024L / 1024L);

    // 현재 남아있는 free메모리. 프로그램이 실행되는 동안 증감을 반복
    long heapFreeSize = Runtime.getRuntime().freeMemory();
    System.out.println("heapFreeSize (b) :" + heapFreeSize);
    System.out.println("heapFreeSize (kb): " + heapFreeSize / 1024L);
    System.out.println("heapFreeSize (mb): " + heapFreeSize / 1024L / 1024L);
  }
}
