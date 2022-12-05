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

        //If the array is empty returns 0.00
       if (scores.length ==0){
          return  0.00;
      }
       //Loops through array
        for (int score : scores) {
            //If one of the numbers are negative it will display an error message
            if (score < 0){
                throw new IllegalArgumentException("scores must be positive");
            }
            total = total + score;

        }
        avg = total / scores.length;

        //Formats the avg to have 2 decimal places
        DecimalFormat avgTwo = new DecimalFormat("#0.00");
        avg= Double.parseDouble(avgTwo.format(avg));
        return avg;
    }

    @Override
    public int lastWordLength(String text) {
        //Link that helped me with this problem
        //https://www.geeksforgeeks.org/length-of-last-word-in-a-string/

        //Holds the length of the last word
        int lengthOfLastWord = 0;
        //Gets rid of unnecessary whitespace they may in the word
        String word = text.trim();

        //Display the error message if the input is empty
        if (text.length() == 0){
            throw new IllegalArgumentException("input must not be an empty string");
        }

        //Loops through the word
        for (int i = 0; i < word.length(); i++) {
            //If it encounters a whitespace sets the count back to 0
            if (word.charAt(i) == ' ') {
                lengthOfLastWord = 0;
            } else {
                lengthOfLastWord++;
            }
        }
            return lengthOfLastWord;
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
