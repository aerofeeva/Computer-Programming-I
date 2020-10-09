import java.util.*;
import java.awt.*;
public class Ferret extends Critter {
   private Random r;
   private int display;
   
   public Ferret() {
      r = new Random();
      display = 0;
   }
   
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         display = 5;
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         if (display > 0) {
            display--;
         }
         return Action.HOP;
      }
      else {
         if (display > 0) {
            display--;
         }
         int n = r.nextInt(2);
         if (n % 2 == 0) {
            return Action.LEFT;
         } else {
            return Action.RIGHT;
         }
      }
   }
   
   public Color getColor() {
      if (display == 0) {
         return Color.BLUE;
      } else {
         return Color.RED;
      }
   }
   
   public String toString() {
      return "I=" + display;
   }
}