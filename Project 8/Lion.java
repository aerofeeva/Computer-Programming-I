// Anastasia Erofeeva
// 05/29/16
// CSE 142
// TA: Rajneil Rana
// Assignment #8 (Lion)
//
// This defines a class of critters known as "Lion".
// Lions infect if an enemy critter is in front of them. 
// Lions turn left if a wall is in front or to the right of them.
// Lions turn right if another Lion is in front of them.
// Lions hop if the space in front of them is empty.

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   private int count;
   private Color storeColor;
   private Random color;
   
   // Constructs a Lion critter. 
   public Lion() {
      count = 0;
      color = new Random();
   }
   
   // Takes a CritterInfo info and uses it to identify which move the
   // Lion should make. Returns infect if an enemy is in front, otherwise
   // returns turn left if a wall is in front or to the right, otherwise
   // returns turn right if a fellow Lion is in front, otherwise returns
   // hop. 
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL ||
                 info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   // Returns the color of the Lion by randomly picking either red, green, 
   // or blue. 
   public Color getColor() {
      if (count % 3 == 0) {
         int randomColor = color.nextInt(3);
         if (randomColor % 3 == 0) {
            storeColor = Color.RED;
         } else if (randomColor % 3 == 1) {
            storeColor = Color.GREEN;
         } else {
            storeColor = Color.BLUE;
         }
      }
      return storeColor;
   }
   
   // Returns the String representation of the Lion, which is "L". 
   public String toString() {
      return "L";
   }
}