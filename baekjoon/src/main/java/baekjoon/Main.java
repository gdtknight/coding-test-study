package baekjoon;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baekjoon.dp._9465_;
import common.Problem;

public class Main {

  public static void main(String[] args) throws Exception {

    Logger log = LoggerFactory.getLogger(Main.class);

    Problem problem = new _9465_();

    String[] pathFrag = problem.getClass().getName().replaceAll("_", "").split("\\.");

    log.info("Thread {} started", Thread.currentThread().getName());
    log.info("Category: {}", pathFrag[pathFrag.length - 2]);
    log.info("Problem No.{}", pathFrag[pathFrag.length - 1]);
    log.info("Start solving problem");

    long start = System.currentTimeMillis();

    problem.solution(args);

    long end = System.currentTimeMillis();

    long time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));

  }

}
