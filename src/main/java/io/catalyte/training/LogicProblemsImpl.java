package io.catalyte.training;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LogicProblemsImpl implements LogicProblems {
    @Override
    public Double average(int[] scores) {
        double total = 0.00;
        double avg = 0.00;

       if (scores.length ==0){
          return  0.00;
      }
        for (int score : scores) {
            if (score < 0){
                throw new IllegalArgumentException("scores must be positive");
            }
            total = total + score;

        }
        avg = total / scores.length;

        DecimalFormat avgTwo = new DecimalFormat("#0.00");
        avg= Double.parseDouble(avgTwo.format(avg));
        System.out.println(avg);
        return avg;
    }

    @Override
    public int lastWordLength(String text) {
        return 0;
    }

    @Override
    public BigDecimal distinctLadderPaths(int rungs) {
        return null;
    }

    @Override
    public List<List<String>> groupStrings(String[] strs) {
        return null;
    }
    //TODO: Implement all requirements as defined in the project description.


}
