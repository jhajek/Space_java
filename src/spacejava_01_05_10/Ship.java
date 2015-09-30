/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;

/**
 *
 * @author jeremy
 */
public class Ship extends Unit {

    	protected String shipName;
	protected double fuel;
	protected int money;
        protected int iron;
	protected int sugar;
	protected int rice;
        protected int CARGO_MAX;

            //  constructor
    public Ship(int xPos, int yPos, String shipName, double fuel, int money, int iron, int sugar, int rice, int CARGO_MAX) {
        super(xPos,yPos);
        this.shipName = shipName;
        this.fuel = fuel;
        this.money = money;
        this.iron = iron;
        this.rice = rice;
        this.sugar = sugar;
        this.CARGO_MAX = CARGO_MAX;
    }

public void setShipName(String shipName) {
  this.shipName=shipName;
}

public void setFuel(double f){
   this.fuel = f;
}

public void setFunds(int m){
	this.money = m;
}

public double getFuel(){
	return fuel;
}

public int getFunds(){
	return money;
}

public void setIron(int i){
   this.iron = i;
}

public void setSugar(int s){
	this.sugar = s;
}

public int getIron(){
	return iron;
}

public int getSugar(){
	return sugar;
}
public void setRice(int r){
	rice = r;
}

public int getRice(){
	return rice;
}
public void setCARGO_MAX(int c){
	CARGO_MAX = c;
}

public int getCARGO_MAX(){
	return CARGO_MAX;
}

public int getRemainingCargoSpace() {
      return (this.CARGO_MAX-(this.iron+this.sugar+this.rice));
}

    @Override
public String toString()
{
 return "Stats: " + xPos + " " + yPos + " " + shipName + " " + fuel + " " + money + " " + iron + " " + sugar + " " + rice + " " + CARGO_MAX   ;
}

} // end of class
