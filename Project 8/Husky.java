// Anastasia Erofeeva
// 05/29/16
// CSE 142
// TA: Rajneil Rana
// Assignment #8 (Husky)
//
// This defines a class of critters known as "Husky".
// Huskies infect if an enemy critter is in front of them. 
// Huskies hop if an enemy critter is behind them.
// Huskies turn right if an enemy critter is to the right of them.
// Huskies turn left if a wall, another Husky, or an empty space is to the left of them.

import java.awt.*;

public class Husky extends Critter {
   private int count;
   
   // Constructs a Husky critter.
   public Husky() {
      count = 0;
   }
   
   // Takes a CritterInfo info and uses it to identify which move the
   // Husky should make. Returns infect in an enemy is in front, otherwise 
   // returns hop if an enemy is behind the Husky, otherwise returns turn
   // right if an enemy is to the right of the Husky, otherwise returns 
   // turn left. 
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getBack() == Neighbor.OTHER) {
         return Action.HOP;
      } else if (info.getRight() == Neighbor.OTHER) {
         return Action.RIGHT;
      } else {
         return Action.LEFT;
      }    
   }
   
   // Returns the color of the Husky, which alternates between yellow
   // and magenta. 
   public Color getColor() {
      if (count % 2 == 0) {
         return Color.YELLOW;
      } else {
         return Color.MAGENTA;
      }
   }
   
   // Returns the String representation of the Husky, which alternates
   // between "U" and "W". 
   public String toString() {
      if (count % 2 == 0) {
         return "U";
      } else {
         return "W";
      }
   }
}