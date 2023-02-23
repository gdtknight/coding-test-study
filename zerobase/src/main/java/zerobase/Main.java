package zerobase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.Problem;
import zerobase._230223._01_;
import zerobase._230223._02_;
import zerobase._230223._03_;
import zerobase._230223._04_;
import zerobase._230223._05_;

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

    problem1.solution(args);
    System.out.println();

    String[] pathFrag2 = problem2.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag2[pathFrag2.length - 2]);
    log.info("Problem No.{}", pathFrag2[pathFrag2.length - 1]);

    problem2.solution(args);
    System.out.println();

    String[] pathFrag3 = problem3.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag3[pathFrag3.length - 2]);
    log.info("Problem No.{}", pathFrag3[pathFrag3.length - 1]);

    problem3.solution(args);
    System.out.println();

    String[] pathFrag4 = problem4.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag4[pathFrag4.length - 2]);
    log.info("Problem No.{}", pathFrag4[pathFrag4.length - 1]);

    problem4.solution(args);
    System.out.println();

    String[] pathFrag5 = problem5.getClass().getName().replaceAll("_", "").split("\\.");
    log.info("Category: {}", pathFrag5[pathFrag5.length - 2]);
    log.info("Problem No.{}", pathFrag5[pathFrag5.length - 1]);

    problem5.solution(args);
    System.out.println();
  }

}
