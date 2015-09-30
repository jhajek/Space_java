/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;

/**
 *
 * @author jeremy
 */
public class Planetoid extends Unit{

     protected double gravityFactor;
    protected String planetoidName;

      public Planetoid(int xPos, int yPos,double gravityFactor, String planetoidName) {
        super(xPos, yPos);
        this.gravityFactor = gravityFactor;
        this.planetoidName = planetoidName;
    }

          public void setGravityFactor(double gf) {
        this.gravityFactor=gf;
    }
         public double getGravityFactor() {
    return gravityFactor;
   }

         public void setPlanetoidName(String planetoidName) {
             this.planetoidName = planetoidName;
         }

         public String getPlanetoidName() {
             return planetoidName;
         }
          @Override
    public String toString() {

     return  " Gravity Factor: " + gravityFactor + " \n";
    }


}
