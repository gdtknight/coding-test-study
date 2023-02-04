package baekjoon.pqueue;

import java.io.BufferedReader;
import java.util.PriorityQueue;

import common.Initialization;
import common.Problem;

public class Heap implements Problem {

  @Override
  public void solution(String[] args) throws Exception {

    BufferedReader br = Initialization.getBufferedReaderFromClass(this);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    SampleMinHeap minHeap = new SampleMinHeap(N);
    PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (pQueue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(pQueue.poll());
        }

      } else {
        pQueue.offer(num);
      }
    }

    br.close();
  }

  class SampleMinHeap {
    int[] arr;
    int curSize;

    SampleMinHeap(int size) {
      this.curSize = 0;
      this.arr = new int[size];
    }

    public boolean isEmpty() {
      return this.curSize == 0;
    }

    public boolean isFull() {
      return this.curSize == arr.length;
    }

    public void offer(int n) {
      if (isFull()) {
        System.out.println("Heap is full.");
        return;
      }

      if (isEmpty()) {
        arr[0] = n;
        curSize++;
        return;
      }

      int curPos = curSize;
      arr[curSize] = n;
      curSize++;

      int parent = curPos % 2 == 0 ? curPos / 2 - 1 : curPos / 2;

      while (arr[parent] > arr[curPos]) {
        int tmp = arr[parent];
        arr[parent] = arr[curPos];
        arr[curPos] = tmp;

        curPos = parent;
        parent = curPos % 2 == 0 ? curPos / 2 - 1 : curPos / 2;
      }

    }

    public int poll() {
      if (isEmpty()) {
        System.out.println("Heap is empty.");
        return Integer.MIN_VALUE;
      }

      int n = arr[0];

      arr[0] = arr[--curSize];

      int curPos = 0;

      int left = curPos * 2 + 1;
      int right = curPos * 2 + 2;

      while (curPos < curSize) {
        if (right < curSize) {
          int child = left < right ? left : right;

          if (arr[curPos] > arr[child]) {
            int temp = arr[curPos];
            arr[curPos] = arr[child];
            arr[child] = temp;

          }

        }

      }

      return n;
    }

  }

}
