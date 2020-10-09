// Anastasia Erofeeva
// 05/13/16
// CSE 142
// TA: Rajneil Rana
// Assignment #6
//
// This program will search a file, containing the data of names chosen for children 
// over the past 130 years, for a specific name/gender combination. If the combination
// is found, the program will plot the data for that name/gender combination on a graph.


import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
   public static final int START_YEAR = 1880;
   public static final int NUM_DECADES = 14;
   public static final int HORIZONTAL_WIDTH = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("names.txt"));
      Scanner console = new Scanner(System.in);
      intro();
      System.out.print("name? ");
      String name = console.nextLine().toLowerCase();
      System.out.print("gender (M or F)? ");
      String gender = console.next().toLowerCase();  
      String line1 = find(input, name, gender); 
      System.out.println(line1);
      
      // Converts ranks into y-coordinates.
      Scanner data = new Scanner(line1);
      String name1 = data.next();
      String gender1 = data.next();      
      int numRanks = 0;
      int yCoordinate = 0;
      int rank = 0;
      if (data.hasNextInt()) {
         DrawingPanel panel = new DrawingPanel((NUM_DECADES * HORIZONTAL_WIDTH), 550);
         Graphics g = panel.getGraphics();
         while (numRanks < NUM_DECADES) {
            rank = data.nextInt();
            if (rank == 0) {
               yCoordinate = 525;
            }
            else { //(rank > 0) 
               yCoordinate = (int)(Math.ceil(rank / 2.0) + 24); 
            }
            numRanks++;
            drawGrid(g);
            plotData(g, yCoordinate, name1, gender1, rank, numRanks);
         }
      }
   }
   
   // Introduces the program to the user.
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START_YEAR + ".");
      System.out.println();

   }
   
   // Returns the line from the given input that has the given name/gender combination.
   // If the combination is not found returns: "name/gender combination not found". 
   public static String find(Scanner input, String name, String gender) {
      while (input.hasNextLine()) {
         String line1 = input.nextLine();
         Scanner data = new Scanner(line1);
         String name1 = data.next();
         if (name1.toLowerCase().equals(name) && line1.toLowerCase().contains(gender)) {
            return line1;
         }
         String gender1 = data.next();       
      }
      return "name/gender combination not found";
   }
   
   // Uses DrawingPanel to draw a grid.
   public static int drawGrid(Graphics g) {
      g.setColor(Color.BLACK);
      g.drawLine(0, 25, (NUM_DECADES * HORIZONTAL_WIDTH), 25);
      g.drawLine(0, 525, (NUM_DECADES * HORIZONTAL_WIDTH), 525);
      int line = 0;
      while (line < NUM_DECADES) {
         int year = (START_YEAR - 10); 
         while (year <= 2010) {
            year = year + 10;
            g.drawString(String.valueOf(year),(HORIZONTAL_WIDTH * line), 550);
            g.drawLine((HORIZONTAL_WIDTH * line), 0, (HORIZONTAL_WIDTH * line), 550);
            line++;
         }
      }
      return line;
   }
   
   // Uses the Graphics object, the y-coordinates of the ranks and the number of ranks to 
   // plot the data for the name/gender combination. Also labels each point with the 
   // name/gender combination and the rank of that combination during a certain year.
   public static void plotData(Graphics g, int yCoordinate, String name1, String gender1, int rank, int numRanks) {
      g.setColor(Color.RED);
      Scanner points = new Scanner(Integer.toString(yCoordinate));
      yCoordinate = points.nextInt();
      if (numRanks <= NUM_DECADES) {
         g.drawString(name1 + " " + gender1 + " " + rank, (HORIZONTAL_WIDTH * (numRanks - 1)), yCoordinate);
         if (numRanks <= NUM_DECADES - 1) {
            g.drawLine((HORIZONTAL_WIDTH * (numRanks - 1)), yCoordinate, (HORIZONTAL_WIDTH * numRanks), yCoordinate); 
         }
         numRanks++;
      }   
   }
}
