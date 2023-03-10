package baekjoon;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaPathApiTest {
  @Test
  void givenPath_whenRequest_thenShowPath() throws Exception {
    System.out.println(Paths.get("").toAbsolutePath().toRealPath());
  }

}
