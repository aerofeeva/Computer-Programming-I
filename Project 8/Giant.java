// Anastasia Erofeeva
// 05/29/16
// CSE 142
// TA: Rajneil Rana
// Assignment #8 (Giant)
//
// This defines a class of critters known as "Giant".
// Giants infect if an enemy critter is in front of them. 
// Giants hop if the space in front of them is empty.
// Giants turn right if a wall or another Bear is in front of them. 

import java.awt.*;

public class Giant extends Critter {
   private int count;
   
   // Constructs a Giant critter. 
   public Giant() {
      count = 0;
   }
   
   // Takes a CritterInfo info and uses it to identify which move the 
   // Giant should make. Returns infect if the enemy is in front, otherwise
   // returns hop if possible, otherwise returns turn right. 
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
   
   // Returns the color of the Giant, which is gray.
   public Color getColor() {
      return Color.GRAY;
   }
   
   // Returns the String representation of the Giant, "fee" for 6 moves,
   // then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves,
   // then repeats. 
   public String toString() {
      int change = count / 6;
      if (change % 4 == 0) {
         return "fee";
      } else if (change % 4 == 1) {
         return "fie";
      } else if (change % 4 == 2) {
         return "foe";
      } else {
         return "fum";
      }
   }
}