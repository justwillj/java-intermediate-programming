package io.catalyte.training;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int[] test = {1,2,5,-6};
       String expected= "Scores must be positive";
        Double result = exercise.average(test);
        assertEquals(expected,result, ()-> "Wrong answer was given" + result);
    }

    @Test
    void lastWordLength() {
        String test = "test this String";
        int expected = 6;
        int results = exercise.lastWordLength(test);
        assertEquals(expected,results,()->"Wrong answer was given" +results);
    }
    //TODO: Implement all requirements as specified in the requirements document
}