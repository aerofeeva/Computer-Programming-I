// Anastasia Erofeeva
// 04/06/16
// CSE 142
// TA: Rajneil Rana
// Assignment #2 (Part 2)
//
// This program will draw a rocket ship, the size of which can be changed. 

public class DrawRocket {
   public static final int SIZE = 3;
   
   public static void main(String[] args) {
      drawEnd();
      drawLine();
      drawCone();
      drawV();
      drawLine();
      drawV();
      drawCone();
      drawLine();
      drawEnd();
   }
   
   // Draws the top and bottom of the rocket ship.
   public static void drawEnd() {
      for (int line = 1; line <= 2 * SIZE - 1; line++) {
         for (int i = 1; i <= -line + (2 * SIZE); i++) {
            System.out.print(" ");
         }
         for (int i = 1; i <= line; i++) {
            System.out.print("/");
         }
         System.out.print("**"); 
         for (int i = 1; i <= line; i++) {
            System.out.print("\\");
         }
         System.out.println();  
      }
   }
   
   // Draws the lines that divide the rocket ship.
   public static void drawLine() {
      System.out.print("+");
      for (int i = 1; i <= 2 * SIZE; i++) {
         System.out.print("=*");
      }   
      System.out.println("+");
   }
   
   // Draws the top half of the diamond and the bottom half of the "X".
   public static void drawCone() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int i = 1; i <= SIZE - line; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= line; i++) {
            System.out.print("/\\");
         }
         for (int i = 1; i <= SIZE - line; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= SIZE - line; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= line; i++) {
            System.out.print("/\\");
         }
         for (int i = 1; i <= SIZE - line; i++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   // Draws the bottom half of the diamond and the top half of the "X".
   public static void drawV() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int i = 1; i <= line - 1; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= SIZE - (line - 1); i++) {
            System.out.print("\\/");
         }
         for (int i = 1; i <= line - 1; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= line - 1; i++) {
            System.out.print(".");
         }
         for (int i = 1; i <= SIZE - (line - 1); i++) {
            System.out.print("\\/");
         }
         for (int i = 1; i <= line - 1; i++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
} 