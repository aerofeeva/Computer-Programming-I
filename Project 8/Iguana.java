import java.util.*;
import java.awt.*;

public class Iguana extends Critter {
   private Random r;
   private int count;
   private String display;
   
   public Iguana() {
      r = new Random();
      count = 0;
      display = "<->";
   }
   
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else {
         int n = r.nextInt(2);
         if (n % 2 == 0) {
            display = "<L>";
            return Action.LEFT;
         } else {
            display = "<R>";
            return Action.RIGHT;
         }
      }
   }
   
   public Color getColor() {
      if (count % 2 == 0) {
         return Color.BLUE;
      } else {
         return Color.RED;
      }
   }
   
   public String toString() {
      return display;
   }
}