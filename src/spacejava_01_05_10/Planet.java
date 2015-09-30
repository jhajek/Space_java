/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeremy
 */
public class Planet extends Planetoid{

    	protected int money;
	protected int fuel;
	protected int ironQuantity;
	protected int sugarQuantity;
	protected int riceQuantity;
	protected int ironDesiredQuantity;
	protected int sugarDesiredQuantity;
	protected int riceDesiredQuantity;
	protected int fuelPrice;

   // constructor
        public Planet(int xPos, int yPos, double gravityFactor, String planetoidName, int m,int f,int iq,int sq,int rq,int iqd,int sqd,int rqd,int fp){
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
        }

        int getFuel()
{
	return fuel;
}

void setFuel(int f)
{
   fuel = f;
}

int getFuelPrice()
{
	return fuelPrice;
}

void setFuelPrice(int fp)
{
	fuelPrice=fp;
}

void setFunds(int m)
{
	money = m;
}

int getFunds()
{
	return money;
}
void setIronQuantity(int iq)
{
   ironQuantity = iq;
}

void setSugarQuantity(int sq)
{
	sugarQuantity = sq;
}

int getIronQuantity()
{
	return ironQuantity;
}

int getSugarQuantity()
{
	return sugarQuantity;
}
void setRiceQuantity(int rq)
{
	riceQuantity = rq;
}

int getRiceQuantity()
{
	return riceQuantity;
}
void setIronDesiredQuantity(int idq)
{
	ironDesiredQuantity = idq;
}

int getIronDesiredQuantity()
{
	return ironDesiredQuantity;
}
void setSugarDesiredQuantity(int sdq)
{
	sugarDesiredQuantity = sdq;
}

int getSugarDesiredQuantity()
{
	return sugarDesiredQuantity;
}
void setRiceDesiredQuantity(int rdq)
{
	riceDesiredQuantity = rdq;
}

int getRiceDesiredQuantity()
{
	return riceDesiredQuantity;
}

public void Shop(Ship s)
{


	char pressedKey = '0';
	while(pressedKey != 'E' && pressedKey != 'e')
	{
	 System.out.println("\033");

	  System.out.println( "\n\t\t\tWelcome to " + this.planetoidName + "\n");
	  System.out.println("\tYou have the follwing..." + "\n");
	  System.out.printf( "\t\tIron: %d Sugar: %d RIce: %d\n", s.getIron(),s.getSugar(), s.getRice());
	  System.out.printf( "\t\tMoney: %d Fuel: %.2f Cargo Space Left: %d"  + "\n", s.getFunds(),s.getFuel(),s.getRemainingCargoSpace());
	  System.out.printf( "\n\tHere are your available actions on planet %s: +\n", this.planetoidName);



	  if (ironDesiredQuantity>ironQuantity)
	  {
            System.out.printf( "\n\t\t\t1. %s will buy Iron for: %.2f \n", this.planetoidName, (double)((ironDesiredQuantity/ironQuantity) * ironQuantity));
	  }
	  else
	  {
           System.out.println( "\t\t\t5. " + planetoidName + "will sell Iron for: " + ((ironQuantity/ironDesiredQuantity) * ironQuantity) + "\n");
	  }
	  /*System.out.println( "\n\t\t\t1. Buy Iron for: " + Iron.getBuyValue() + "\n";
	  System.out.println( "\t\t\t2. Buy Sugar for: " + Sugar.getBuyValue() + "\n";
	  System.out.println( "\t\t\t3. Buy Rice for: " + Rice.getBuyValue() + "\n";
	  System.out.println( "\t\t\t4. Buy Fuel for: " + fuelPrice + "\n";
	  System.out.println( "\t\t\t5. Sell Iron for: " + Iron.getSellValue() + "\n";
	  System.out.println( "\t\t\t6. Sell Sugar for: " + Sugar.getSellValue() + "\n";
	  System.out.println( "\t\t\t7. Sell Rice for: " + Rice.getSellValue() + "\n";
	  System.out.println( "\t\t\tU. Buy Upgrades" + "\n";
	  */
	  System.out.println( "\t\t\tE. Exit " + planetoidName);
          InputStreamReader converter = new InputStreamReader(System.in);
          BufferedReader in = new BufferedReader(converter);
            try {
                switch (Integer.parseInt(in.readLine())) {
                    case '1':
                        buyCommodity(s, "Iron");
                        break;
                    case '2':
                        //			buyCommodity(s, Sugar);
                        break;
                    case '3':
                        //		buyCommodity(s, Rice);
                        break;
                    case '4':
                        //		buyFuel(s);
                        break;
                    case '5':
                        sellCommodity(s, "Iron");
                        break;
                    case '6':
                        //	    sellCommodity(s, Sugar);
                        break;
                    case '7':
                        //	    sellCommodity(s, Rice);
                        break;
                    case 'U':
                        //		upgradeShip(s);
                        break;
                    case 'u':
                        //		upgradeShip(s);
                        break;
                    case 'E':
                        //leaving planet
                        break;
                    case 'e':
                        //leaving planet
                        break;
                    default:
                        System.out.println("Please pick one of the available options. ");
                        break;
                } // end of switch
            } catch (IOException ex) {
                Logger.getLogger(Planet.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
  }

/************************************************************************
 *buyCommodity function                                                 *
 *used to calculate purchase of any commodity available at a planet     *
 * added by Soren H.  mangled by Jeremy 05.25.08                                                                     *
 ************************************************************************/
void buyCommodity(Ship s, String c)
{

}

void sellCommodity(Ship s, String c)
{
         
}

    @Override
public String toString(){
    return xPos + " " + yPos + " " + gravityFactor + " " + planetoidName + " " + money + " " + fuel + " " + ironQuantity + " " + sugarQuantity + " " + riceQuantity + " " + ironDesiredQuantity + " " + sugarDesiredQuantity + " " + riceDesiredQuantity + " " + fuelPrice;
}

} // end of class
