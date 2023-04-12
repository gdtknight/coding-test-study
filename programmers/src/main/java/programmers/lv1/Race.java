package programmers.lv1;

import common.Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Race implements Problem {
  
  public void solution(String[] args) throws Exception {
    System.out.println(
        Arrays.toString(
            solution(
                new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})
        )
    );
  }
  
  public String[] solution(String[] players, String[] callings) {
    TreeMap<Integer, String> raceMap = new TreeMap<>();
    Map<String, Integer> curRankMap = new HashMap<>();
    
    for (int i = 0; i < players.length; i++) {
      raceMap.put(i + 1, players[i]);
      curRankMap.put(players[i], i + 1);
    }
    
    for (String player : callings) {
      int rank = curRankMap.get(player);
      String inFrontOfPlayer = raceMap.get(rank - 1);
      raceMap.replace(rank, inFrontOfPlayer);
      raceMap.replace(rank - 1, player);
      curRankMap.put(inFrontOfPlayer, rank);
      curRankMap.put(player, rank - 1);
    }
    
    return raceMap.values().toArray(String[]::new);
  }
}
