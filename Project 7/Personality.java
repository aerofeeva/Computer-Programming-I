// Anastasia Erofeeva
// 05/22/16
// CSE 142
// TA: Rajenil Rana
// Assignment #7
//
// This program will process a file with data from a personality test. 
// First, it will convert the data into counts of A and B answers. 
// Then, it will report the percentages of B answers. 
// Finally, it will convert each B percentage into a letter, 
// which will be used to report the personality type. 

import java.io.*;
import java.util.*;

public class Personality {
   public static final int DIMENSIONS = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      intro();
      Scanner console = new Scanner(System.in);
      System.out.print("input file name? ");
      String inputFile = console.nextLine();
      Scanner input = new Scanner(new File(inputFile));
      System.out.print("output file name? ");
      String outputFile = console.nextLine();
      PrintStream output = new PrintStream(new File(outputFile));
      while (input.hasNextLine()) {
         String name = input.nextLine();
         String answers = input.nextLine().toUpperCase();
         int[] countsOfA = new int[DIMENSIONS];
         int[] countsOfB = new int[DIMENSIONS];
         int[] countsOfDashes = new int[DIMENSIONS];
         counts(answers, countsOfA, countsOfB, countsOfDashes);
         int[] percentagesOfB = percentages(countsOfB, countsOfDashes);
         String personality = personalityType(percentagesOfB);
         output.println(name + ": " + Arrays.toString(percentagesOfB) + " = " + personality);  
      }
   }
   
   // Introduces the program to the user. 
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Takes a String of answers and three sets of counts for different types
   // of answers. Uses these parameters to count how many As, Bs, and dashes 
   // there are in the String of answers.
   public static void counts(String answers, int[] countsOfA, int[] countsOfB, 
                             int[] countsOfDashes) {
      for (int i = 0; i < answers.length(); i++) {
         if (answers.charAt(i) == 'A') {
            countsHelper(i, countsOfA);
         } else if (answers.charAt(i) == 'B') {
            countsHelper(i, countsOfB);
         } else { // (answers.charAt(i) == '-')
            countsHelper(i, countsOfDashes);
         }
      }
   }
   
   // Takes an integer index and a set counts. Uses these parameters
   // to count how many As, Bs, and dashes there are for each dimension.
   public static void countsHelper(int index, int[] arrayOfCounts) {
      if (index % 7 == 0) {
         arrayOfCounts[0]++;
      } else if (index % 7 == 1 || index % 7 == 2) {
         arrayOfCounts[1]++;
      } else if (index % 7 == 3 || index % 7 == 4) {
         arrayOfCounts[2]++;
      } else { // (index % 7 == 5 || index % 7 == 6) 
         arrayOfCounts[3]++;
      }
   }
   
   // Takes two sets of counts. Uses the number of B answers and dashes to
   // return the B percentages.
   public static int[] percentages(int[] countsOfB, int[] countsOfDashes) {
      int[] percentagesOfB = new int[DIMENSIONS];
      percentagesOfB[0] = (int) Math.round((countsOfB[0] / (10.0 - countsOfDashes[0])) * 100);
      for (int i = 1; i <= 3; i++) {
         percentagesOfB[i] = (int) Math.round((countsOfB[i] / (20.0 - countsOfDashes[i])) * 100);
      } 
      return percentagesOfB;
   }
   
   // Takes a set of counts of B percentages. Uses the B percentages to 
   // return the personality type.
   public static String personalityType(int[] percentagesOfB) {
      String traitsOfA = "ESTJ";
      String traitsOfB = "INFP";
      String personality = "";
      for (int i = 0; i < percentagesOfB.length; i++) {
         if (percentagesOfB[i] < 50) {
            personality += traitsOfA.charAt(i);
         } else if (percentagesOfB[i] > 50) {
            personality += traitsOfB.charAt(i);
         } else { // (percentagesOfB[i] == 50)
            personality += "X";
         }
      }
      return personality;
   }  
}

