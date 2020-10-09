// Anastasia Erofeeva
// 05/29/16
// CSE 142
// TA: Rajneil Rana
// Assignment #8 (Bear)
//
// This defines a class of critters known as "Bear". 
// Bears infect if an enemy critter is in front of them. 
// Bears hop if the space in front of them is empty.
// Bears turn left if a wall or another Bear is in front of them.  

import java.awt.*;

public class Bear extends Critter {
   private int count;
   private boolean polarBear;
   
   // Takes a boolean polar and uses it to construct a Bear critter. 
   public Bear(boolean polar) {
      count = 0;
      polarBear = polar;
   }
   
   // Takes a CritterInfo info and uses it to identify which move the
   // Bear should make. Returns infect if an enemy is in front, otherwise
   // returns hop if possible, otherwise returns turn left. 
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }      
   }
   
   // Returns the color white if the Bear is a polar bear, and the color
   // black if the Bear is not a polar bear. 
   public Color getColor() {
      if (polarBear) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   // Returns the String representation of the Bear, alternating between
   // a slash character and a backslash character, starting with a slash.
   public String toString() {
      if (count % 2 == 0) {
         return "/";
      } else {
         return "\\";
      }
   }
}