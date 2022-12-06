package io.catalyte.training;

import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicProblemsImplTest {
    LogicProblemsImpl exercise = new LogicProblemsImpl();
    @Test
    void averageGoodTest() {
        int[] test = {1,2,4};
        Double expected= 2.33;
        Double result = exercise.average(test);
        assertEquals(expected,result, ()-> "Wrong answer was given" + result);
    }

    @Test
    void averageEmptyTest() {
        int[] test = {};
        Double expected= 0.00;
        Double result = exercise.average(test);
        assertEquals(expected,result, ()-> "Wrong answer was given" + result);
    }

    @Test
    void averageOneNumberTest() {
        int[] test = {10};
        Double expected= 10.00;
        Double result = exercise.average(test);
        assertEquals(expected,result, ()-> "Wrong answer was given" + result);
    }

    @Test
    void averageNegativeNumber() {
        //Link that helped me with creating the testing
        //https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown
        int[] test = {1,2,5,-6};
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () ->{
                    exercise.average(test);
                }
        );
        assertEquals("scores must be positive",exception.getMessage(), ()-> "Wrong answer was given");
    }

    @Test
    void lastWordLengthTest() {
        String test = "test this String";
        int expected = 6;
        int results = exercise.lastWordLength(test);
        assertEquals(expected,results,()->"Wrong answer was given" +results);
    }

    @Test
    void lastWordLengthWhiteSpaceTest() {
        String test = "      ";
        int expected = 0;
        int results = exercise.lastWordLength(test);
        assertEquals(expected,results,()->"Wrong answer was given" +results);
    }
    @Test
    void lastWordLengthEmpty() {
        String test = "";
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () ->{
                    exercise.lastWordLength(test);
                }
        );
        assertEquals("input must not be an empty string",exception.getMessage(), ()-> "Wrong answer was given");
    }

    @Test
    void distinctLadderPathsTest() {
        int test = 3;
        BigDecimal expected = BigDecimal.valueOf(3);
        BigDecimal results = exercise.distinctLadderPaths(test);
        assertEquals(expected,results,()->"Wrong answer was given "+results);
    }

    @Test
    void distinctLadderPaths100Test() {
        int test = 100;
        BigDecimal expected = new BigDecimal(String.valueOf("573147844013817084101"));
        BigDecimal results = exercise.distinctLadderPaths(test);
        assertEquals(expected,results,()->"Wrong answer was given "+results);
    }

    @Test
    void distinctLadderPathsEmptyTest() {
        int test= 0;
        BigDecimal expected = BigDecimal.valueOf(0);
        BigDecimal results = exercise.distinctLadderPaths(test);
        assertEquals(expected,results,()->"Wrong answer was given"+results);
    }

    @Test
    void distinctLadderPathsNegative() {
        int test = -6;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    exercise.distinctLadderPaths(test);
                }
        );
        assertEquals("ladders can't have negative rungs",exception.getMessage(), ()-> "Wrong answer was given");
    }

    @Test
    void groupStringsTest() {
        String [] test = {"arrange", "act", "assert", "ace"};
        List<String> test1 = List.of(new String[]{"arrange", "ace"});
        List<String> test2 = List.of(new String[]{"act", "assert"});
        List<List<String>> exptected = new ArrayList<List<String>>();
        exptected.add(test1);
        exptected.add(test2);
        List<List<String>> results = exercise.groupStrings(test);
        assertEquals(exptected,results,()->"Wrong asnwer was given " + results);
    }

    @Test
    void groupStringsTestEmpty() {
        String [] test = {};
        List<List<String>> exptected = new ArrayList<List<String>>();;
        List<List<String>> results = exercise.groupStrings(test);
        assertEquals(exptected,results,()->"Wrong asnwer was given " + results);
    }

    @Test
    void groupStringsTestEmptyStrings() {
        String[] test = {"","test","","tet",""};
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    exercise.groupStrings(test);
                }
        );
        assertEquals("strings must not be empty", exception.getMessage(), () -> "Wrong answer was given");
    }
    //TODO: Implement all requirements as specified in the requirements document
}