// Anastasia Erofeeva
// 04/14/16
// CSE 142
// TA: Rajenil Rana
// Assignment #3 (Part 1)
//
// This program will draw a house and a moon. 

import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(300,300);
      p.setBackground(Color.BLUE);
      Graphics g = p.getGraphics();
      drawHouse(g);
      drawRoof(g);
      drawWindow(g);
      drawMoon(g);
   }
    
   // Takes a Graphics object as a parameter and draws the bottom 
   // of the house.      
   public static void drawHouse(Graphics g) {
      g.setColor(Color.GRAY);
      g.fillRect(50, 150, 200, 150);
      g.setColor(Color.WHITE);
      g.fillRect(50, 150, 200, 10);
      g.setColor(Color.BLACK);
      g.drawRect(50, 150, 200, 150);  
   }
   
   // Takes a Graphics object as a parameter and draws the roof 
   // of the house. 
   public static void drawRoof(Graphics g) {
      g.setColor(Color.BLACK);
      Polygon poly = new Polygon();
      poly.addPoint(150, 40);
      poly.addPoint(50, 150);
      poly.addPoint(250, 150);
      g.fillPolygon(poly);
   }
   
   // Takes a Graphics object as a parameter and draws the window 
   // of the house.
   public static void drawWindow(Graphics g) {
      g.setColor(Color.WHITE);
      g.fillRect(115, 190, 70, 70);
      g.setColor(Color.BLACK);
      g.drawRect(115, 190, 70, 70);
      g.setColor(Color.YELLOW);
      g.fillRect(125, 200, 50, 50);
      g.setColor(Color.BLACK);
      g.drawRect(125, 200, 50, 50);
      g.drawLine(125, 225, 175, 225);
      g.drawLine(150, 200, 150, 250);
   }
   
   // Takes a Graphics object as a parameter and draws the moon.
   public static void drawMoon(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillOval(240, 30, 30, 30);
   }
}
      
