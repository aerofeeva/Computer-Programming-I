// Anastasia Erofeeva
// 04/22/16
// CSE 142
// TA: Rajneil Rana
// Assignment #4
//
// This program will compare the exam scores (SAT or ACT) and weighted GPAs 
// of two applicants in order to determine which one is a stronger applicant. 

import java.util.*; 

public class Admit {
   public static void main(String[] args) {
      intro();
      Scanner console = new Scanner(System.in);
      double score1 = score(console, 1);
      double score2 = score(console, 2);
      reportResult(score1, score2);
   }
   
   // Provides an introduction to the program. 
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println(); 
   }
   
   // Uses the console Scanner and the number of the applicant (1 or 2)
   // to prompt for applicant's statistics. Then returns the overall scores
   // for each applicant. 
   public static double score(Scanner console, int applicantNumber) {
      System.out.println("Information for applicant #" + applicantNumber + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int number = console.nextInt();
      double examScore = 0.0;
      if (number == 1) {
         examScore = scoreSat(console);
      } else { // number == 2
         examScore = scoreAct(console);
      }
      double gpa = scoreGpa(console);
      double overallScore = examScore + gpa;
      System.out.println();
      return overallScore;
   }
   
   // Uses the console Scanner to prompt for SAT math, critical reading, 
   // and writing scores. Then returns the total SAT score. 
   public static double scoreSat(Scanner console) {
      System.out.print("    SAT math? ");
      int math = console.nextInt();
      System.out.print("    SAT critical reading? ");
      int reading = console.nextInt();
      System.out.print("    SAT writing? ");
      int writing = console.nextInt();
      double satExamScore = satFor(math, reading, writing);
      System.out.println("    exam score = " + round1(satExamScore));
      return satExamScore;
   }
    
   // Uses the console Scanner to prompt for ACT English, math, reading, 
   // and science scores. Then returns the total ACT score. 
   public static double scoreAct(Scanner console) {
      System.out.print("    ACT English? ");
      int english = console.nextInt();
      System.out.print("    ACT math? ");
      int math = console.nextInt();
      System.out.print("    ACT reading? ");
      int reading = console.nextInt();
      System.out.print("    ACT science? ");
      int science = console.nextInt();
      double actExamScore = actFor(english, math, reading, science);
      System.out.println("    exam score = " + round1(actExamScore));
      return actExamScore;
    }

   // Returns the total SAT exam score for the given math, reading,
   // and writing scores. 
   public static double satFor(int math, int reading, int writing) {
      return (2.0 * math + reading + writing) / 32;
   } 
        
   // Returns the total ACT exam score for the given English, math, 
   // reading, and science scores. 
   public static double actFor(int English, int math, int reading, int science) {
      return (English + 2 * math + reading + science) / 1.8;
   }
    
   // Uses the console Scanner to prompt for each applicant's overall GPA, 
   // max GPA, and Transcript Multiplier. Then returns each applicant's 
   // GPA score. 
   public static double scoreGpa(Scanner console) {
      System.out.print("    overall GPA? ");
      double overallGpa = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGpa = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double transcript = console.nextDouble();
      double gpa = gpaFor(overallGpa, maxGpa, transcript);
      System.out.println("    GPA score = " + round1(gpa));
      return gpa;
   }
    
   // Returns the GPA score for the given overall GPA, max GPA,
   // and Transcript Multiplier.
   public static double gpaFor(double overallGpa, double maxGpa, double transcript) {
       return overallGpa / maxGpa * 100 * transcript;
   }
    
   // Takes each applicant's overall score and rounds it to one decimal place.
   // Reports each applicant's rounded overall score. Compares the overall 
   // scores to determine which applicant seems better. 
   public static void reportResult(double score1, double score2) {
      System.out.println("First applicant overall score  = " + round1(score1));
      System.out.println("Second applicant overall score = " + round1(score2));
      if (score1 > score2) {
         System.out.println("The first applicant seems to be better");
      } else if (score1 < score2) {
         System.out.println("The second applicant seems to be better");
      } else { // score1 == score2
         System.out.println("The two applicants seem to be equal");
      }   
   }
    
   // Returns the result of rounding n to 1 digit after the decimal point.
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}
