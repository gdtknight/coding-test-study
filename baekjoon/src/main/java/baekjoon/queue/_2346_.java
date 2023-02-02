package baekjoon.queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.common.Problem;

public class _2346_ implements Problem {
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

    int N = Integer.parseInt(br.readLine());

    DoubleLinkedList dl = new DoubleLinkedList(N);
    int[] next = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      dl.addLast(i);
    }

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int idx = 1;
    while (st.hasMoreTokens()) {
      next[idx++] = Integer.parseInt(st.nextToken());
    }

    while (!dl.isEmpty()) {
      int cur = dl.removeFirst();
      System.out.print(cur + " ");
      int nextStep = next[cur];
      while (!dl.isEmpty() && nextStep > 1) {
        dl.addLast(dl.removeFirst());
        nextStep -= 1;
      }
      while (!dl.isEmpty() && nextStep < 0) {
        dl.addFirst(dl.removeLast());
        nextStep += 1;
      }
    }

    br.close();

  }

}

class DoubleLinkedList {
  int[] arr;
  int startIdx;
  int endIdx;

  DoubleLinkedList(int size) {
    this.startIdx = 1;
    this.endIdx = 2;
    arr = new int[size + 1];
  }

  public boolean isEmpty() {
    return startIdx == (endIdx - 1 + arr.length) % arr.length;
  }

  public boolean isFull() {
    return endIdx == startIdx;
  }

  public void addFirst(int n) {
    if (isFull()) {
      System.out.println("DoubleLinkedList full");
      return;
    }

    arr[startIdx] = n;
    startIdx = (startIdx - 1 + arr.length) % arr.length;
    return;
  }

  public void addLast(int n) {
    if (isFull()) {
      System.out.println("DoubleLinkedList is full.");
      return;
    }

    arr[endIdx] = n;
    endIdx = (endIdx + 1) % arr.length;

    return;
  }

  public int removeFirst() {
    if (isEmpty()) {
      System.out.println("DoubleLinkedList is empty.");
      return -1;
    }

    startIdx = (startIdx + 1) % arr.length;
    int n = arr[startIdx];

    return n;
  }

  public int removeLast() {
    if (isEmpty()) {
      System.out.println("DoubleLinkedList is empty.");
      return -1;
    }

    endIdx = (endIdx - 1 + arr.length) % arr.length;
    int n = arr[endIdx];

    return n;
  }
}
