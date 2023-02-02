package baekjoon.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Initialization {

  public static BufferedReader getBufferedReaderFromClass(Object object) throws Exception {

    String filePath = object.getClass()
        .getName()
        .replaceAll("_", "")
        .replaceAll("\\.", "/");

    File file = new File(object.getClass()
        .getClassLoader()
        .getResource(filePath)
        .getPath());

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    return br;

  }

}
