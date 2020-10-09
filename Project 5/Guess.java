// Anastasia Erofeeva
// 04/27/16
// CSE 142
// TA: Rajneil Rana
// Assignment #5
//
// This program allows the user to play a guessing game, in which the user
// must guess the random integer chosen by the program. Hints will be 
// provided until the user guesses the right integer.

import java.util.*; 

public class Guess {
   public static final int MAX = 100;
   public static void main(String[] args) { 
      intro();
      Scanner console = new Scanner(System.in);
      int numGuesses = game(console);
      int totalGuesses = numGuesses;
      int bestGame = numGuesses;     
      String answer = answer(console);
      int numGames = 1; 
      while (answer.startsWith("y") || answer.startsWith("Y")) {
         numGuesses = game(console);
         totalGuesses += numGuesses;
         if (numGuesses < bestGame) {
            bestGame = numGuesses;
         }
         answer = answer(console);
         numGames++;
      }
      results(numGames, totalGuesses, bestGame);
   }
      
   // Provides an introduction to the program.   
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(MAX + " and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println(); 
   }
   
   // Uses the console Scanner to play one game with the user. Returns the
   // number of guesses used in this game. 
   public static int game(Scanner console) {
      Random rand = new Random();
      int number = rand.nextInt(MAX) + 1;
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int numGuesses = 1; 
      while (guess != number) {
         hints(number, guess);
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numGuesses++;
      }
      if (numGuesses != 1) {
         System.out.println("You got it right in " + numGuesses + " guesses");
      } else { // numGuesses == 1
         System.out.println("You got it right in " + numGuesses + " guess");
      }
      return numGuesses;
   }
   
   // Uses the console Scanner to ask the user if they want to play again.
   // Returns the user's answer as a String.
   public static String answer(Scanner console) {
      System.out.print("Do you want to play again? ");    
      String answer = console.next();
      System.out.println();
      return answer;      
   }
   
   // Takes a number and a guess, and gives hints by telling the user whether
   // the right answer is higher or lower than their guess.
   public static void hints(int number, int guess) {
      int hint = 0;
      if (guess < number) {
         System.out.println("It's higher.");
      } else { // guess > number
         System.out.println("It's lower.");
      }
   }
   
   // Reports the results to the user given the total number of games, the
   // total number of guesses, and the best (fewest) number of guesses used
   // in any single game.
   public static void results(int numGames, int totalGuesses, int bestGame) {
      System.out.println("Overall results:");
      System.out.println("    total games   = " + numGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round1((double) totalGuesses / numGames));
      System.out.println("    best game     = " + bestGame); 
   }
   
   // Returns the result of rounding n to 1 digit after the decimal point.
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   } 
}