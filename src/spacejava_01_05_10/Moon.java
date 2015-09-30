/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jeremy
 */
public class Moon extends Planetoid{

        protected int money;
	protected int fuel;
	protected int ironQuantity;
	protected int sugarQuantity;
	protected int riceQuantity;
	protected int ironDesiredQuantity;
	protected int sugarDesiredQuantity;
	protected int riceDesiredQuantity;
	protected int fuelPrice;
        char input;

   // constructor
        public Moon(int xPos, int yPos, double gravityFactor, String planetoidName, int m,int f,int iq,int sq,int rq,int iqd,int sqd,int rqd,int fp){
         super (xPos,yPos,gravityFactor,planetoidName);
         this.money = m;
         this.fuel = f;
         this.ironQuantity = iq;
         this.sugarQuantity  = sq;
         this.riceQuantity = rq;
         this.ironDesiredQuantity = iqd;
         this.riceDesiredQuantity = rqd;
         this.sugarDesiredQuantity = sqd;
         this.fuelPrice = fp;
        } //end of class

public void Base(Ship s) throws IOException
{
      	   
            while (input == 1 || input == 2 || input == 3  || input == 4 || input == 5) {
           System.out.println("\033");
           System.out.println("Welcome to the Moon -- your home base \n\n");
	   System.out.println(":::Space News::: \n");
	   System.out.println("Planet   " + "Iron" + "\t" + "Price" + "\t" + "Sugar" + "\t" + "Price" + "\t" + "Rice" + "\t" + "Price\n");
	  // cout << "Jupiter  " <<  << "\t" << j.getIronQuantityDesired() << "\t" << j.getSugar() << "\t" << j.getSugarPrice()  << "\t" << j.getRice() << "\t" << j.getRicePrice() << endl;
	  // cout << "Earth    " << << "\t" << e.getIronQuantityDesired() << "\t" << e.getSugar() << "\t" << e.getSugarPrice()  << "\t" << e.getRice() << "\t" << e.getRicePrice() << endl;
	 //  cout << "Ganymede " << g.getIronQuantity() << "\t" << g.getIronQuantityDesired() << "\t" << g.getSugar() << "\t" << g.getSugarPrice()  << "\t" << g.getRice() << "\t" << g.getRicePrice() << endl;
	 //  cout << "Mars     " << m.getIronQuantity() << "\t" << m.getIronQuantityDesired() << "\t" << m.getSugar() << "\t" << m.getSugarPrice()  << "\t" << m.getRice() << "\t" << m.getRicePrice() << endl;
	 //  cout << "Saturn   " << S.getIronQuantity() << "\t" << S.getIronQuantityDesired() << "\t" << S.getSugar() << "\t" << S.getSugarPrice()  << "\t" << S.getRice() << "\t" << S.getRicePrice() << endl;
	 //  cout << "Neptune  " << n.getIronQuantity() << "\t" << n.getIronQuantityDesired() << "\t" << n.getSugar() << "\t" << n.getSugarPrice()  << "\t" << n.getRice() << "\t" << n.getRicePrice() << endl;
	//   cout << "Pluto    " << p.getIronQuantity() << "\t" << p.getIronQuantityDesired() << "\t" << p.getSugar() << "\t" << p.getSugarPrice()  << "\t" << p.getRice() << "\t" << p.getRicePrice() << endl;
	//   cout << "Ceres    " << c.getIronQuantity() << "\t" << c.getIronQuantityDesired() << "\t" << c.getSugar() << "\t" << c.getSugarPrice()  << "\t" << c.getRice() << "\t" << c.getRicePrice() << endl;
	   //cout << "Jupiter" << j.getIronQuantity() << "\t" << j.getIronQuantityDesiredQuantity() << "\t" << j.getSugar() << "\t" << j.getSugarPrice()  << "\t" << j.getRice() << "\t" << j.getRicePrice() << endl;
       System.out.println("\n");
	  // cout << "\nRice: " << p.getRice() << endl;
	   //cout << "\nFuel: " << p.getFuel() << endl;
	   System.out.println("1. Check Mail Box: -- Not Functional... \n");
	   System.out.println("2. Repair Ship: -- Not Functional... \n");
	   System.out.println("3. Upgrade Ship: -- Not Functional... \n");
	   System.out.println("4. Pick Up Passengers: -- Not Functional... \n");
	   System.out.println("5. Talk to people listen to space news... -- not functional... \n");
	   System.out.println("6. Leave Space Station... -- This works!\n");
	System.out.println("\n");

	   System.out.println("You have Rice - " + s.getRice() + " Iron - " + s.getIron() + " Sugar - " + s.getSugar() + "\n");
	   System.out.println("SpaceBucks - " + s.getFunds() + " Fuel - " + s.getFuel() + " Cargo Max - " + s.getCARGO_MAX() + "\n");
       System.out.println("What do you want to do?");

// read char
// http://www.overclockers.com/forums/showthread.php?t=482984
		try
		{
			input = (char)System.in.read();

		}catch(Exception exe)
		{ exe.printStackTrace(); }
            } // end of while

	   
	   s.setX(s.getX()+1);
	   s.setY(s.getY()+1);
}

} // end of class
