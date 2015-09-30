/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;

/**
 *
 * @author jeremy
 */
public class Unit {

     // the Unit class has three fields
    protected int xPos;
    protected int yPos;
   

    //  constructor
    public Unit(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    
    public void setX(int x) {
        this.xPos = x;
    }

    public void setY(int y) {
        this.yPos = y;
    }


   public int getX() {
    return xPos;
       }
      public int getY() {
    return yPos;
   }

   
    @Override
    public String toString() {

     return "xPos: " + xPos + " yPos: " + yPos + " \n";
    }
} // end of class
