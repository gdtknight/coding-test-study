package programmers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.Problem;

public class Main {

  public static void main(String[] args) throws Exception {

    Logger log = LoggerFactory.getLogger(Main.class);

    log.info("Thread {} started", Thread.currentThread().getName());

    Problem problem = new Mbti();

    String[] pathFrag = problem.getClass().getName().replaceAll("_", "").split("\\.");

    log.info("Category: {}", pathFrag[pathFrag.length - 2]);
    log.info("Problem No.{}", pathFrag[pathFrag.length - 1]);

    problem.solution(args);

  }

}
