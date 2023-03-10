package zerobase._230309;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import common.Problem;

public class _05_ implements Problem {
  public void solution(String[] args) throws Exception {
    // 0 < s.length <= 10000

    String[] strings = {
        "mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "movie.mkv 10000b"
    };

    System.out.println(Arrays.toString(sol(strings)));
  }

  public int[] sol(String[] strings) {

    Map<String, String> fileTypeMap = new HashMap<>();
    Map<String, Integer> fileGroupIndex = new HashMap<>();

    fileTypeMap.put("mp3", "music");
    fileTypeMap.put("aac", "music");
    fileTypeMap.put("flac", "music");

    fileTypeMap.put("jpg", "image");
    fileTypeMap.put("bmp", "image");
    fileTypeMap.put("gif", "image");

    fileTypeMap.put("mp4", "movie");
    fileTypeMap.put("avi", "movie");
    fileTypeMap.put("mkv", "movie");

    fileGroupIndex.put("music", 0);
    fileGroupIndex.put("image", 1);
    fileGroupIndex.put("movie", 2);
    fileGroupIndex.put("other", 3);

    int[] sizes = new int[4];

    Arrays.stream(strings).forEach(info -> {
      String[] file = info.split(" ");
      String[] name = file[0].split("\\.");

      String fileType = name[name.length - 1];
      Integer fileSize = Integer.parseInt(file[1].substring(0, file[1].length() - 1));

      if (fileTypeMap.containsKey(fileType)) {
        String fileGroup = fileTypeMap.get(fileType);
        sizes[fileGroupIndex.get(fileGroup)] += fileSize;
      } else {
        String fileGroup = "other";
        sizes[fileGroupIndex.get(fileGroup)] += fileSize;
      }
    });

    return sizes;
  }

}
