// Anastasia Erofeeva
// 04/06/16
// CSE 142
// TA: Rajneil Rana
// Assignment #2 (Part 1)
//
// This program draws a mouse. 

public class AsciiArt {
   
   public static void main(String[] args) {
      drawTail();
      drawMouse();
   }
   
   // Draws the tail of the mouse
   public static void drawTail() {
      spaces(6);
      System.out.println("_____");
      spaces(5);
      System.out.println("/ ___ \\");
      spaces(4);
      System.out.println("( (   ) )");
      spaces(4);
      System.out.println("/ /   \\ \\");
      spaces(4);
      System.out.println(") )   | |");
      spaces(1);
      System.out.println("__/ /    | |");
      System.out.println("<___/  ___|_|___");
   }
   
   // Draws the body of the mouse
   public static void drawMouse() {
      spaces(6);
      System.out.println("/         \\");
      spaces(5);
      System.out.println("/           \\");
      spaces(4);
      System.out.println("/             \\");
      drawLines(3);
      spaces(4);
      System.out.println("|____      ___|");
      spaces(4);
      System.out.println("/    \\    /    \\");
      spaces(3);
      System.out.println("(                )");
      spaces(4);
      System.out.println("\\___        ___/");
      spaces(8);
      System.out.println("\\  0 0  /");
      spaces(7);
      System.out.println("==\\=   =/==");
      spaces(8);
      System.out.println("==\\= =/==");
      spaces(11);
      System.out.println("(_)");
   }
   
   // Prints a certain number of spaces
   public static void spaces(int number){
      for (int i = 1; i <= number; i++) {
         System.out.print(" ");
      }   
   }
   
   // Prints a certain number of "|"
   public static void drawLines(int number) {
         for (int j = 1; j <= number; j++) {
         System.out.println("    |             |");
      }
   } 
}


