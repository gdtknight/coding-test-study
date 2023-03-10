package zerobase;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.Problem;
import zerobase._230309._01_;
import zerobase._230309._02_;
import zerobase._230309._03_;
import zerobase._230309._04_;
import zerobase._230309._05_;

public class Main {

  public static void main(String[] args) throws Exception {
    Problem problem1 = new _01_();
    Problem problem2 = new _02_();
    Problem problem3 = new _03_();
    Problem problem4 = new _04_();
    Problem problem5 = new _05_();

    Logger log = LoggerFactory.getLogger(Main.class);

    String[] pathFrag1 = problem1.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag1[pathFrag1.length - 2]);
    log.info("Problem No.{}", pathFrag1[pathFrag1.length - 1]);

    long start = System.currentTimeMillis();

    problem1.solution(args);

    long end = System.currentTimeMillis();

    long time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));
    System.out.println("\n----------------------------------------------------------\n");

    String[] pathFrag2 = problem2.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag2[pathFrag2.length - 2]);
    log.info("Problem No.{}", pathFrag2[pathFrag2.length - 1]);

    start = System.currentTimeMillis();

    problem2.solution(args);

    end = System.currentTimeMillis();

    time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));
    System.out.println("\n----------------------------------------------------------\n");

    String[] pathFrag3 = problem3.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag3[pathFrag3.length - 2]);
    log.info("Problem No.{}", pathFrag3[pathFrag3.length - 1]);

    start = System.currentTimeMillis();

    problem3.solution(args);

    end = System.currentTimeMillis();

    time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));
    System.out.println("\n----------------------------------------------------------\n");

    String[] pathFrag4 = problem4.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag4[pathFrag4.length - 2]);
    log.info("Problem No.{}", pathFrag4[pathFrag4.length - 1]);

    start = System.currentTimeMillis();

    problem4.solution(args);

    end = System.currentTimeMillis();

    time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));
    System.out.println("\n----------------------------------------------------------\n");

    String[] pathFrag5 = problem5.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag5[pathFrag5.length - 2]);
    log.info("Problem No.{}", pathFrag5[pathFrag5.length - 1]);

    start = System.currentTimeMillis();

    problem5.solution(args);

    end = System.currentTimeMillis();

    time = end - start;

    log.info("Time(ms) : {}", time);
    log.info("Time(s)  : {}", BigDecimal.valueOf(time).divide(BigDecimal.valueOf(1000L)));
    System.out.println();
  }

}
