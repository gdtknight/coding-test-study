package baekjoon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baekjoon.pqueue._11279_;

public class Main {

  public static void main(String[] args) throws Exception {

    Problem problem = new _11279_();

    Logger log = LoggerFactory.getLogger(Main.class);

    log.info("Thread {} started", Thread.currentThread().getName());

    String[] pathFrag = problem.getClass().getName().replaceAll("_", "").split("\\.");

    log.info("Category: {}", pathFrag[pathFrag.length - 2]);
    log.info("Problem No.{}", pathFrag[pathFrag.length - 1]);
    log.info("Start solving problem\n");

    problem.solution(args);

  }

}