package map.View;

import java.util.Scanner;
import java.util.StringTokenizer;

import map.MAPAnalyser.MAPAnalyser;
import map.Record.Record;
public class View {
	
	private MAPAnalyser mapAnalyser;
	public View(MAPAnalyser a) {
		mapAnalyser = a;
	}
 public void commandLoop() {
	 Scanner scanner = new Scanner(System.in);
	 boolean displayMenu=true;
	    
     do {
     
         if(displayMenu) {
        	 mainMenu();
             displayMenu=false;
         }
   
 	 
 		String value1= scanner.nextLine();
 		StringTokenizer tokenizer=new StringTokenizer(value1);
 		try {
 		 int option1 =0;
 		 Integer integer=new Integer(tokenizer.nextToken());
 		 option1=integer.intValue();
         // we use a switch to carry out the choice depending on the command number
         switch(option1) {
         case 0:
         	mainMenu();
         	break;
         case 1:
        	 String personIdentificationId=tokenizer.nextToken();
        	 Record record=mapAnalyser.find(personIdentificationId);
        	 if(record==null) {
        		 System.out.println("No such records");
        	 } else {
        		 System.out.println(record.toString());
        	 }
        	 break;
         case 2: 
        	int mapValue1;
        	int mapValue2;
        	Integer integer2=new Integer(tokenizer.nextToken());
        	mapValue1=integer2.intValue();
        	Integer integer3= new Integer(tokenizer.nextToken());
        	mapValue2 = integer3.intValue();
        	 if(mapValue1<0 || mapValue1>200 || mapValue2<0 || mapValue2>200 || mapValue1>mapValue2) {
                 
                 System.out.println("***");
                 System.out.println("An error has been found in the values you entered.");
   
                 if(mapValue1<0 || mapValue1>200)
                     System.out.println("First Map Value is not >=0 and <=200. "+ "Please enter the Map Value in the Range");
   
                 if(mapValue2<0 || mapValue2>200)
                     System.out.println("Second Map value is not >=0 and <=200. "+ "Please enter the Map values in the range.");
   
                 if(mapValue1>mapValue1)
                     System.out.println("First Map value is greater than Secound Map Value. "+  "Please enter values in range (i.e map1 is less than or equal to map2.)");
             }
             else {
                 Record[] records=mapAnalyser.find(mapValue1, mapValue2);
                 for(int i=0; i<records.length; i++)
                     System.out.println(records[i].toString());
             }
        	 break;
         case 3:
        	 int minimum =mapAnalyser.lowest();
        	 int  maximum=mapAnalyser.highest();
        	 int median=mapAnalyser.median();
             
             // print the values
            System.out.println("Minimum MAP Value :  "+minimum);
            System.out.println("Maximum MAP Value : "+maximum);
            System.out.println("Median MAP Value : "+median);
        break;

        case 9:
            System.exit(0);
         break;

        default:
            System.out.println("** You typed an unrecognized command. Please see the menu.");
        break;
        	 
         }
 	 }
	  catch(Exception ex) {
         System.out.println("You typed something wrong. Please see the menu.");
     
	  }
     }  while(true);
 
	
	
	
	

    }

//START main menu
	public static void mainMenu() {
		 System.out.println("The following commands are recognised:");
         System.out.println("Display this menu                                      > 0");
         System.out.println("Display a specific subject record:                     > 1 id");
         System.out.println("Display records for all subject records within a range > 2 map1 map2");
         System.out.println("Display statistics (minimum, maximum and median)       > 3");
         System.out.println("Exit the application                                   > 9");
	}
	// EOD
}