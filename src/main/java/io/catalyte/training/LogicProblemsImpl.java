package io.catalyte.training;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class LogicProblemsImpl implements LogicProblems {
    /**
     * This method takes an int array and will return the average of it to 2 decimals places
     * @param scores the int array of numbers
     * @return the average of the int array
     */
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

    /**
     * This method will take a String and return the length of the last word inside the String.
     * For example "Test this String" will return a int of 6
     * @param text the String that is being tested
     * @return an int of the length of the last word inside the String
     */
    @Override
    public int lastWordLength(String text) {
        //Link that helped me with this problem
        //https://www.geeksforgeeks.org/length-of-last-word-in-a-string/

        //Holds the length of the last word
        int lengthOfLastWord = 0;
        //Gets rid of unnecessary whitespace they may in the word
        String word = text.trim();

        //Display the error message if the input is empty
        if (text.length() == 0) {
            throw new IllegalArgumentException("input must not be an empty string");
        }

        //Loops through the word
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case ' ':
                    lengthOfLastWord = 0;
                    break;
                default:
                    lengthOfLastWord++;
            }
        }
        return lengthOfLastWord;
    }

    /**
     * This method will find the number of different paths a person can take up a ladder if they can only climb 1 or 2
     * steps at a time. For example if rungs = 3 then it will return a 3 since there are 3 different ways to go up the
     * ladder 1.(1,1,1) 2.(1,2) 3.(2,1)
     * @param rungs is the length of the ladder
     * @return a BigDecimal of the number of different ways a user can climb the ladder
     */
    @Override
    public BigDecimal distinctLadderPaths(int rungs) {
        //Link that helped me with this problem and helped explained the Fibonacci sequence
        //https://www.interviewbit.com/blog/climbing-stairs-problem/
        //https://dev.to/alisabaj/the-climbing-staircase-problem-how-to-solve-it-and-why-the-fibonacci-numbers-are-relevant-3c4o#:~:text=We%20can%20see%20the%20Fibonacci,until%20we%20get%20to%20n.
        //Link that helped me with my problem whenever I would do my test of 100 I would always get a negative number
        //https://medium.com/nerd-for-tech/why-i-love-the-fibonacci-programme-bff9a1244cfc

        //Here we are setting up the 2 number we will be adding
        BigInteger oneStep = BigInteger.valueOf(1);
        BigInteger twoStep = BigInteger.valueOf(2);

        //If rungs is 0 it returns a value of 0
        if (rungs == 0){
            return BigDecimal.valueOf(0);
        } else if (rungs==2 ||rungs ==1){
            return BigDecimal.valueOf(rungs);
        }
        //If rungs is a negative number it will display the error exception
        else if (rungs < 0){
            throw new IllegalArgumentException("ladders can't have negative rungs");
        }
        //We are starting at 3 since when oneStep and twoStep are added up it equals 3
        for (int i = 3; i <= rungs; i++) {
            BigInteger bothSteps = oneStep.add(twoStep);
            //This allows us to keep adding them up
            oneStep = twoStep;
            twoStep = bothSteps;
        }
        return new BigDecimal(twoStep);
    }

    /**
     * This method will look through a String array and group together words that share the same first and last letter.
     * It will then return inside another list for example. ["arrange", "act", "assert", "ace"] will return a
     * [["arrange", "ace"], ["act", "assert"]]
     * @param strs the String array that we are testing
     * @return List<List<String>> of the words that share the same first and last letter
     */
    @Override
    public List<List<String>> groupStrings(String[] strs) {
        //Link that helped me with this problem
        //https://www.geeksforgeeks.org/how-to-find-the-first-and-last-character-of-a-string-in-java/#:~:text=The%20idea%20is%20to%20use,index%20length%20of%20string%2D1%20.

        //This will hold the groups of strings that share the same first and last letter
        List<List<String>> answer = new ArrayList<List<String>>();

        for (int i = 0; i < strs.length; i++) {
            //Stores each of the groups of sim words
            List<String> words = new ArrayList<>();
            String fullWord =strs[i];

            //This will check to see if any of the strings are "" empty and throw the error message
            if (fullWord.trim().length()==0){
                throw new IllegalArgumentException("strings must not be empty");
            }

            //Grabs the first and last letter of each word, so we can compare
            char lastLetter = fullWord.charAt(fullWord.length() - 1);
            char firstLetter = strs[i].charAt(0);

            for (int j = 0; j < strs.length; j++) {

                String fullWord2 = strs[j];
                //Grabs the first and last letter of each word, so we can compare
                char lastLetter2 = fullWord2.charAt(fullWord2.length() - 1);
                char firstLetter2 = strs[j].charAt(0);

                //If the first and last letter of each word match then it adds it to the array
                if (firstLetter == firstLetter2 && lastLetter == lastLetter2){
                    words.add(fullWord2);
                }
            }
            //This make sure that there are not duplicates inside the answer since we used a nested for loop
            if (!answer.contains(words)){
                answer.add(words);
            }
          }
        return answer;
    }
    //TODO: Implement all requirements as defined in the project description.


}
