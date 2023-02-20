package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import common.Problem;

public class BestAlbum implements Problem {
  public void solution(String[] args) throws Exception {

    String[] genres = { "classic", "pop", "classic", "classic", "pop" };
    int[] plays = { 500, 600, 150, 800, 2500 };

    System.out.println(Arrays.toString(solution(genres, plays)));
  }

  public int[] solution(String[] genres, int[] plays) {

    Map<String, Integer> totalPlays = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
    }

    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<Entry<String, Integer>>(
        (Entry<String, Integer> e1, Entry<String, Integer> e2) -> e2.getValue().compareTo(e1.getValue()));

    for (Entry<String, Integer> entry : totalPlays.entrySet()) {
      pq.offer(entry);
    }

    List<Integer> ansList = new ArrayList<>();

    while (!pq.isEmpty()) {
      Entry<String, Integer> entry = pq.poll();

      PriorityQueue<Song> songPq = new PriorityQueue<>(
          (song1, song2) -> song2.getPlayCnt().compareTo(song1.getPlayCnt()));

      for (int i = 0; i < genres.length; i++) {
        if (genres[i].equals(entry.getKey())) {
          songPq.offer(new Song(i, genres[i], plays[i]));
        }
      }

      int cnt = 0;
      while (!songPq.isEmpty() && cnt < 2) {
        ansList.add(songPq.poll().getId());
        cnt += 1;
      }
    }

    return ansList.stream().mapToInt(Integer::valueOf).toArray();
  }

  class Song {
    int id;
    String genre;
    Integer playCnt;

    public Song(int id, String genre, int playCnt) {
      this.id = id;
      this.genre = genre;
      this.playCnt = playCnt;
    }

    public int getId() {
      return id;
    }

    public String getGenre() {
      return genre;
    }

    public Integer getPlayCnt() {
      return playCnt;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getEnclosingInstance().hashCode();
      result = prime * result + id;
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
      Song other = (Song) obj;
      if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
        return false;
      if (id != other.id)
        return false;
      return true;
    }

    private BestAlbum getEnclosingInstance() {
      return BestAlbum.this;
    }
  }
}
