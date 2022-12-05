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
    //TODO: Implement all requirements as specified in the requirements document
}