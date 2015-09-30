/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spacejava_01_05_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.*;
import java.util.Scanner;

/**
 *
 * @author jeremy
 */

public class Main {


    // http://java.about.com/od/workingwithobjects/a/accessormutator.htm
    // http://download.oracle.com/javase/1.4.2/docs/guide/util/logging/overview.html
    // http://www.abbeyworkshop.com/howto/java/readLine/index.html
    // http://www.java2s.com/Code/Java/Data-Type/UseCharacterisDigittochecktheifacharisadigit.htm
    /**
     * @param args the command line arguments
     */ static final int POSITIVE_X_LIMIT=77;
        static final int NEGATIVE_X_LIMIT=1;
        static final int POSITIVE_Y_LIMIT=19;
        static final int NEGATIVE_Y_LIMIT=1;
        static char input;
        
        private static final Logger logger = Logger.getLogger("spacejava_01_05_10.Main");
        static Scanner user_input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      
        // Example assumes these variables have been initialized
        // above, e.g. as method parameters or otherwise
       FileHandler logFile = new FileHandler("output%g.txt",true);
       logFile.setFormatter(new SimpleFormatter());
       logger.addHandler(logFile);
       logger.log(Level.INFO, "::::::::::::::::::Init Logging::::::::::::::::::");
       Random rand = new Random();      
//        final int PLANET_NAME_SIZE=9;
//        final int UNIVERSE_ARRAY_SIZE=9;
//        int moonCounter=0;
//        int number_of_planets=0;
//        int movePosition=0;

   Planet jupiter = new Planet(36,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.5,"Juptier",2000,6000,100,100,100,100,200,10,100);
   Planet earth = new Planet (12,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Earth",25000,10000,1000,1000,1000,1200,50,100,100);
   Planet mars = new Planet (3,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Mars",7000,0,0,100,100,0,500,0,100);
   Moon ganymede = new Moon((jupiter.getX()+0),(jupiter.getY()+2),1.0,"Ganymede",5000,4000,0,500,0,0,500,0,100);
   Moon moon = new Moon(earth.getX()+0,earth.getY()+2,1.0,"Moon",0,0,0,0,0,0,0,0,0);
   Planet saturn = new Planet (24,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Saturn",2000 ,6000,100,100,100,150,80,1,200);
   Planet neptune = new Planet (48,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Neptune",2000,6000,100,500,100,150,100,100,200);
   Planet pluto = new Planet (60,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Pluto",2000,1000,100,0,100,1000,0,500,200);
   Planet ceres = new Planet (72,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),1.0,"Ceres",1000,5000,1000,0,0,100,0,0,200);
   Planetoid sun  = new Planetoid(75,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),2.5,"Sun");
   Planetoid beltegeuse = new Planetoid (18,(rand.nextInt(POSITIVE_Y_LIMIT - NEGATIVE_Y_LIMIT + 1) + NEGATIVE_Y_LIMIT),10,"Beltegeuse");

   Ship s = new Ship(moon.getX(),moon.getY(),"Enterprise",512.25,100,200,300,400,5000);


//***********************************************************************************
// Create planet objects
// structure is as follows:
// xPos,yPos,planetName,fuel,money,sugarQuantity,riceQuantity,ironQuantity,ironDesiredQuantity,sugarDesiredQuantity,riceDesiredQuantity,fuelPrice
// int xPos, int yPos, char* name, int m, int f, int iq, int sq, int rq, int idq, int sdq, int rdq, int fp
//**********************************************************************************
   while (input !='8')
   {

  //  Object[] passingObjects = {s,jupiter,earth,mars,ganymede,moon,saturn,neptune,pluto,ceres,sun,beltegeuse};

   checkIfAtPlanet(s,jupiter,earth,mars,ganymede,moon,saturn,neptune,pluto,ceres,sun,beltegeuse);

   //checkIfAtPlanet(passingObjects);
   if (Character.isLetter(input))
   {
	   input = '0';
   }
  
   //randomEvent();
   //marketFlux();	   
   // gotoX = getXCoord();
   // gotoY = getYCoord();
   drawMap(s.getX(),s.getY(),jupiter.getX(),jupiter.getY(),earth.getX(),earth.getY(),mars.getX(),mars.getY(),ganymede.getX(),ganymede.getY(),moon.getX(),moon.getY(),saturn.getX(),saturn.getY(),neptune.getX(),neptune.getY(),pluto.getX(),pluto.getY(),ceres.getX(),ceres.getY(),sun.getX(),sun.getY(),beltegeuse.getX(),beltegeuse.getY());
   //drawHUD(moon.getX(),moon.getY(),s);
   input = drawHUD(moon.getX(),moon.getY(),s);
// old way to do Logging
// logger.fine("The value of input: " + input);
// logger.fine("You moved to: " + s.getX() + ", " + s.getY());
// New way to log
   logger.log(Level.FINE, "The value of input: {0}", input);
   logger.log(Level.FINE, "You moved to: {0}, {1}", new Object[]{s.getX(), s.getY()});


   // travel(input,s);
   //moveMoon(moon);
   // Supposed to clear the screen but not what I am looking for...
   //   Runtime.getRuntime().exec("cls");
   System.out.println("\033");
   } // end of while

    } //end of main class

private static void checkIfAtPlanet(Ship s, Planet jupiter, Planet earth, Planet mars, Moon ganymede, Moon moon, Planet saturn, Planet neptune, Planet pluto, Planet ceres, Planetoid sun, Planetoid beltegeuse) throws IOException {
//private static void checkIfAtPlanet(Object[])
      Unit[] pojo = {s,jupiter,earth,mars,ganymede,moon,saturn,neptune,pluto,ceres,sun,beltegeuse};
//***
      for (Unit p:pojo)
      {
          if (p instanceof Planet)
          {  System.out.println("planet\n"); }
          if (s.getX()==p.getX() && s.getY()==p.getY() && p instanceof Planet)
          {
               ((Planet)p).Shop(s);
               s.setX(s.getX()+1);
           }
      }

  
} // end of method

//********************************************************************************************
// void checkIfAtMoonMenu()
// This method is used to start the game at your home base of the moon
// This can be changed.
//********************************************************************************************

private static char checkIfAtMoonMenu(Ship s, Planet jupiter, Planet earth, Planet mars, Moon ganymede, Moon moon, Planet saturn, Planet neptune, Planet pluto, Planet ceres, Planetoid sun, Planetoid beltegeuse) {
   



	   System.out.println("\033");
           System.out.println("Welcome to the" + moon.getPlanetoidName() + " your home base ");
	   System.out.println(":::Space News::: ");
	   System.out.println("Planet   " + "Iron" + "\t" + "Price" + "\t" + "Sugar" + "\t" + "Price" + "\t" + "Rice" + "\t" + "Price");
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

//http://download.oracle.com/javase/6/docs/api/java/util/Scanner.html
       // casting string to char http://www.computing.net/answers/programming/java-castingconverting-string-to-char/1893.html
    // turnary operator http://www.devdaily.com/java/edu/pj/pj010018/

       input = ( user_input.hasNext() ) ? user_input.next().charAt(0) : 0;
//
//            if (user_input.hasNext())
//            {
//            input = user_input.next().charAt(0);
//            }
//            else
//            {
//            input = '0';
//            }

return input;
} // end of checkIfAtMoon
//***********************************************************************************
// void drawMap()
// This is a simple function to draw out the physical map of the universe
// This function receives all the planet objects passed in so it can map them as well
// your ship position
//**********************************************************************************
private static void drawMap(int x, int y, int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6, int x7, int y7, int x8, int y8, int x9, int y9, int x10, int y10) {

  char[][] grid = new char[][]{{'0','-','+','-','+','-','+','-','+','-','1','-','+','-','+','-','+','-','+','-','2','-','+','-','+','-','+','-','+','-','3','-','+','-','+','-','+','-','+','-','4','-','+','-','+','-','+','-','+','-','5','-','+','-','+','-','+','-','+','-','6','-','+','-','+','-','+','-','+','-','7','-','+','-','+','-','+','-','+','-'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'1',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','1'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},{'-',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-'},{'0','-','+','-','+','-','+','-','+','-','1','-','+','-','+','-','+','-','+','-','2','-','+','-','+','-','+','-','+','-','3','-','+','-','+','-','+','-','+','-','4','-','+','-','+','-','+','-','+','-','5','-','+','-','+','-','+','-','+','-','6','-','+','-','+','-','+','-','+','-','7','-','+','-','+','-','+','-','+','-'}};

  grid[y][x]= 'x';
  grid[y0][x0]= 'J';
  grid[y1][x1] = 'E';
  grid[y2][x2]= 'M';
  grid[y3][x3]= 'g';
  grid[y4][x4]= 'm';
  grid[y5][x5]= 'S';
  grid[y6][x6]= 'N';
  grid[y7][x7]= 'P';
  grid[y8][x8]= 'C';
  grid[y9][x9] = 's';
  grid[y10][x10] = 'B';

  // watch out!!! I had the bounds backwards and since c++ doesn't check the prog
  // complied but then crashed when I tried to assign a value.
  // also the subscripts need to be int - so cast the ints!!! or else crash city
  // cout << ex;
  // cout << array[3][81];

    for (int i = 0; i <= 20; i++){
        for (int j = 0; j < 79; j++){
              System.out.print ( grid[i][j] );
            }
        System.out.print ( "\n" );
}
    }
//***********************************************************************************
// char drawHUD()  
// This is a simple function to draw out the text description of where you are
// 
//**********************************************************************************
private static char drawHUD(int mx, int my, Ship s) {

  String asciiPosX;
  String asciiPosY;
  char eight='8';
  char input='0';

   System.out.println("The Moon, your home base is located at: " + mx + ", " + my + " - You are located at: " + s.getX() + ", " + s.getY());
   System.out.println("\nStatus - Fuel: " + s.getFuel() + " Spacebucks: " + s.getFunds());
   System.out.println("Cargo Hold: Rice: " + s.getRice() + " IRON: " + s.getIron() + " SUGAR: " + s.getSugar());
   
   System.out.println("Where do you want to move? (XX YY -- Q Q is quit) ");
   Scanner sc = new Scanner(System.in);


   //BufferedReader yin = new BufferedReader(new InputStreamReader(System.in));
      //  read the username from the command-line; need to use try/catch with the
      //  readLine() method
   // http://www.devdaily.com/java/edu/pj/pj010005/
   //http://download.oracle.com/javase/6/docs/api/java/util/Scanner.html
            asciiPosX = sc.next();
            asciiPosY = sc.next();
              
      
 // http://download.oracle.com/javase/1.4.2/docs/api/java/lang/String.html
//   if (asciiPos.contains(","))
//   {
//   stringX=asciiPos.substring(0,asciiPos.charAt(asciiPos.indexOf(","))+1);
//   stringY=asciiPos.substring((asciiPos.charAt(asciiPos.indexOf(","))+1),asciiPos.length());
//   }
//   else
//   {
//
//   }

    logger.log(Level.FINE, "asciiPosX: {0} asciiPosY: {1}", new Object[]{asciiPosX, asciiPosY});

   if (asciiPosX.equalsIgnoreCase("Q"))
   {
   input=eight;
   }
   else
   {
    parseMovement(asciiPosX,asciiPosY,s);
       // Input is coming in a format of XX,YY a five char string
	   // it is beingsplit assuming that the input is two chars comma and two more
	   //  each value is being assigned to the x,y value - which is strange because I think
	   //  the x,y value is opposite anyway. =P

  // s.setX(atoi(stringX.c_str()));  // must cast the string into an integer so that you can repostion your ship
   //s.setY(atoi(stringY.c_str()));  // ditto
   }
   return input;
} // end of method

    
    private static void travel(char input, Ship s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
  



private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
//***********************************************************************************
// int parseStringX()
// This is a simple function to parse and return the coodinates you want to goto
//
//
//**********************************************************************************
    private static void parseMovement(String stringX, String stringY, Ship s) {

   int x;
   int y;
   double hypot=0.0;

   x = Integer.parseInt(stringX);
   y = Integer.parseInt(stringY);

   if (x == 0)
   {
	s.setX(s.getX());
   }

   if (y == 0)
   {
	s.setY(s.getY());
   }


   if (x <= POSITIVE_X_LIMIT && x >= NEGATIVE_X_LIMIT && y <= POSITIVE_Y_LIMIT && y >= NEGATIVE_Y_LIMIT)
  {
  // calculate data for hypotenuese (sp?) and get units for fuel subtraction
  // http://download.oracle.com/javase/1.4.2/docs/api/java/lang/Math.html
   double xc = x-s.getX();
   double yc = y-s.getY();
   // http://download.oracle.com/javase/6/docs/api/java/lang/Math.html#pow(double, double)

   double xcsq = Math.pow(xc,2);
   double yxsq = Math.pow(yc,2);

   hypot = Math.abs(Math.sqrt(xcsq+yxsq));
   logger.log(Level.FINE, "Hypot: ", new Object[]{hypot});

// error checking for input
//	outfile.open("errorLog.txt", ios::app);
//	outfile  << "The time is: " << asctime(localtm) << " " << "Hypotenoose: " << hypot << endl;
//    outfile.close();
// ------
	  s.setX(x);  //
	  s.setY(y);

	  s.setFuel(s.getFuel()-hypot);
  }



} // end of method

} // end of class
