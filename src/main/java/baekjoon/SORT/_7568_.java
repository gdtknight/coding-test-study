
package baekjoon.SORT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _7568_ {

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String rootPath = "/home/ubuntu/workspace/coding-test-study/src/main/resources/testcase/";
    String className = new Object() {
    }
        .getClass()
        .getEnclosingClass()
        .getName();

    BufferedReader br = new BufferedReader(new FileReader(
        new File(rootPath + "/" + className.replaceAll("_", "").replaceAll("[.]", "/"))));

    int N = Integer.parseInt(br.readLine());

    List<Size> list = new ArrayList<>();
    List<Size> original = new ArrayList<>();

    Map<Size, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());

      list.add(new Size(weight, height));
      original.add(new Size(weight, height));
    }

    System.out.println(list.toString());
    Collections.sort(list);
    System.out.println(list.toString());

    for (int i = 0; i < list.size() - 1; i++) {
      Size cur = list.get(i);
      for (int j = i; j < list.size(); j++) {
        Size next = list.get(j);
        if (cur.getWeight() < next.getWeight() && cur.getHeight() < next.getHeight()) {
          map.put(cur, map.getOrDefault(cur, 1) + 1);
        }
      }
    }

    map.put(list.get(list.size() - 1), 1);

    for (Size size : list) {
      System.out.println(size + " : " + map.get(size));
    }

    System.out.println("답 출력");
    for (Size size : original) {
      System.out.print(map.get(size) + " ");
    }
    br.close();

  }

}

class Size implements Comparable<Size> {
  int weight;
  int height;

  public Size(int weight, int height) {
    this.weight = weight;
    this.height = height;
  }

  @Override
  public int compareTo(Size o) {
    if (!(o instanceof Size)) {
      throw new IllegalArgumentException();
    }

    Size other = (Size) o;

    // TODO Auto-generated method stub
    if (this.weight > other.weight && this.height > other.height) {
      return 1;
    } else if (this.weight < other.weight && this.height < other.height) {
      return -1;
    }

    return 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + weight;
    result = prime * result + height;
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
    Size other = (Size) obj;
    if (weight != other.weight)
      return false;
    if (height != other.height)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Size [weight=" + weight + ", height=" + height + "]";
  }

  public int getWeight() {
    return weight;
  }

  public int getHeight() {
    return height;
  }
}
