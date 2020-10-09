// Anastasia Erofeeva
// 05/13/16
// CSE 142
// TA: Rajneil Rana
// Assignment #6
//
// This program will search a file, containing the data of names chosen
// for children since 1890, for a specific name/gender combination. If 
// the combination is found, the program will print the name and its meaning. 
// It will also plot the data for that name/gender combination on a graph.

import java.io.*;
import java.util.*;
import java.awt.*;

public class BabyNames {
   public static final int START_YEAR = 1890;
   public static final int NUM_DECADES = 13;
   public static final int WIDTH = 60;
   public static final int HEIGHT = 30;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner nameScanner = new Scanner(new File("names2.txt"));
      Scanner meaningScanner = new Scanner(new File("meanings.txt"));
      Scanner console = new Scanner(System.in);
      intro();
      System.out.print("Name: ");
      String name = console.next();
      System.out.print("Gender (M or F): ");
      String gender = console.next();
      String line = find(nameScanner, name, gender); 
      String meaning = ""; 
      if (line.toLowerCase().contains(name.toLowerCase())) {
         meaning = find(meaningScanner, name, gender); 
         System.out.println(line);
         System.out.println(meaning);
         drawGrid(meaning, line);
      } else {
         System.out.println("\"" + name + "\" not found.");
      }
   }
   
   // Introduces the program to the user. 
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START_YEAR + ".");
      System.out.println();
   }
   
   // Takes a Scanner input, a Sting name and a String gender. Uses 
   // these parameters to read lines of input from a file, until the 
   // given name/gender combination has been found. Returns the line
   // containing the given name/gender combination. If the combination
   // is not found, returns an empty string. 
   public static String find(Scanner input, String name, String gender) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner data = new Scanner(line);
         String nameFromFile = data.next();
         String genderFromFile = data.next();
         if (nameFromFile.toLowerCase().equals(name.toLowerCase()) && 
            genderFromFile.toLowerCase().equals(gender.toLowerCase())) {
            return line;
         }
      }
      return "";
   }
   
   // Takes a String meaning and a String line. Uses these parameters
   // and DrawingPanel to draw the gray legend rectangles and the meaning
   // of the name. 
   public static void drawGrid(String meaning, String line) {
      DrawingPanel panel = new DrawingPanel(780, ((2 * HEIGHT) + 500));
      Graphics g = panel.getGraphics();
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 0, 780, HEIGHT);
      g.fillRect(0, (HEIGHT + 500), 780, HEIGHT);
      g.setColor(Color.BLACK);
      g.drawLine(0, HEIGHT, 780, HEIGHT);
      g.drawLine(0, (HEIGHT + 500), 780, (HEIGHT + 500));
      g.drawString("" + meaning, 0, 16);
      drawBars(g, line);
   }
   
   // Takes a Graphics g and a String line. Uses these parameters to draw
   // the green bars and ranks representing the data from the file. 
   public static void drawBars(Graphics g, String line) {
      Scanner data = new Scanner(line);
      String name = data.next();
      String gender = data.next();
      int decade = 0;
      int year = (START_YEAR - 10);
      int rank = 0;
      while (decade < NUM_DECADES) {
         year += 10;
         g.setColor(Color.BLACK);
         g.drawString("" + year,(WIDTH * decade), ((HEIGHT * 2) + 500) - 8);
         rank = data.nextInt();
         if (rank == 0) {
            g.drawString("" + rank, (WIDTH * decade), (HEIGHT + 500));
         } else {
            g.drawString("" + rank, (WIDTH * decade), (HEIGHT + (rank / 2)));
            g.setColor(Color.GREEN);
            g.fillRect((WIDTH * decade), (HEIGHT + (rank / 2)), (WIDTH / 2), (500 - (rank / 2))); 
         }
         decade++;       
      }
   } 
}