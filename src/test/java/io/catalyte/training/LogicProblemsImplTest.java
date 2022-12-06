package io.catalyte.training;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
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
    void distinctLadderPathsTest() {
        int test = 3;
        BigDecimal expected = BigDecimal.valueOf(3);
        BigDecimal results = exercise.distinctLadderPaths(test);
        assertEquals(expected,results,()->"Wrong answer was given"+results);
    }
    //TODO: Implement all requirements as specified in the requirements document
}