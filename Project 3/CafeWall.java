// Anastasia Erofeeva
// 04/14/16
// CSE 142
// TA: Rajneil Rana
// Assignment #3 (Part 2)
//
// This program will draw rows and grids of black and white 
// boxes to create the Cafe Wall illusion. The black boxes will
// have blue Xs. The rows within each grid will be separated 
// by the mortar and each second row may be offset a certain 
// distance from the first row.

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
   
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      drawRow(g, 0, 0, 4, 20);
      drawRow(g, 50, 70, 5, 30);
      drawGrid(g, 10, 150, 4, 25, 0);
      drawGrid(g, 250, 200, 3, 25, 10);
      drawGrid(g, 425, 180, 5, 20, 10);
      drawGrid(g, 400, 20, 2, 35, 35);
   }
   
   // Takes a Graphics object, an (x,y) position, the number of pairs of 
   // boxes, and the size of each box as parameters. Uses these parameters
   // to draw a row of black and white boxes.
   public static void drawRow(Graphics g, int x, int y, int pairs, int size) {
      for (int i = 0; i < pairs; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x + (2 * size * i), y, size, size);
         
         g.setColor(Color.BLUE);
         g.drawLine(x + (2 * size * i), y, x + (2 * size * i) + size, y + size);
         g.drawLine(x + (2 * size * i), y + size, x + (2 * size * i) + size, y);
         
         g.setColor(Color.WHITE);
         g.fillRect(x + (2 * size * i) + size, y, size, size);
      }
   } 
   
   // Takes a Graphics object, an (x,y) position, the number of pairs of 
   // boxes, the size of each box, and the offset distance as parameters.
   // Uses these parameters to draw a grid of a series of pairs of rows, 
   // where the second row may be offset a certain distance relative to the
   // first. 
   public static void drawGrid(Graphics g, int x, int y, int pairs, int size, int offset) {
      for (int i = 0; i < pairs * 2; i++) {
         drawRow(g, x + (offset * (i % 2)), y + (size * i) + (MORTAR * i), pairs, size);
      }
   }
}