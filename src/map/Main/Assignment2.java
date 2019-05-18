package map.Main;

import java.util.Scanner;

import map.MAPAnalyser.MAPAnalyser;
import map.View.View;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String personIdentifier[] = new String[10];
		personIdentifier[0]="A001";
		personIdentifier[1]="A002";
		personIdentifier[2]="A003"; //
		personIdentifier[3]="A004";
		personIdentifier[4]="A005";
		personIdentifier[5]="A006";//
		personIdentifier[6]="A007";
		personIdentifier[7]="A008";
		personIdentifier[8]="A009";
		personIdentifier[9]="A010";
		
		/**
		 * 70-90 : Low
		 * 90-120 : Ideal
		 * 120-140 : Pre-High
		 * 140-190 : High 
		 * Ref: http://www.bloodpressureuk.org/BloodPressureandyou/Thebasics/Bloodpressurechart
		 */
		
		int systolicBloodPressure[]=new int[10];
		systolicBloodPressure[0]=95;
		systolicBloodPressure[1]=110;
		systolicBloodPressure[2]=98;
		systolicBloodPressure[3]=132;
		systolicBloodPressure[4]=77;
		systolicBloodPressure[5]=87;
		systolicBloodPressure[6]=145;
		systolicBloodPressure[7]=122;
		systolicBloodPressure[8]=110;
		systolicBloodPressure[9]=122;
		
		/**
		 * 40-60 : Low 
		 * 60-80 : Ideal
		 * 80-90 : Pre-High 
		 * 90-100 : High
		 * Ref: http://www.bloodpressureuk.org/BloodPressureandyou/Thebasics/Bloodpressurechart
		 */
		
		int diastolicBloodPressure[]=new int [10];
		diastolicBloodPressure[0]=74;
		diastolicBloodPressure[1]=70;
		diastolicBloodPressure[2]=78;
		diastolicBloodPressure[3]=86;
		diastolicBloodPressure[4]=56;
		diastolicBloodPressure[5]=58;
		diastolicBloodPressure[6]=96;
		diastolicBloodPressure[7]=86;
		diastolicBloodPressure[8]=76;
		diastolicBloodPressure[9]=85;
		
		
		char option;
		Scanner scanner = new Scanner(System.in);
    	View.mainMenu();
    	    while(true) {
    	    	option = scanner.next().charAt(0);
    	        switch(option) {
    	            case '1':
    	            	System.out.print("Please Enter Person Identifier \n");
    	            	String stringToLocate = scanner.next();
    	            	boolean found = MAPAnalyser.checkIfExists(personIdentifier, stringToLocate);
    	        		if (found) {
    	        			int getindex = MAPAnalyser.findIndex(personIdentifier, stringToLocate);
    	        			System.out.println("This is valid input ! \n");
    	        			System.out.println("Report");
    	        			System.out.println("S.No : " + getindex);
    	        			System.out.println("Person identifier Report: "+personIdentifier[getindex]);
    	        			if (getindex >= 0) {
    	        				MAPAnalyser.mapResults(systolicBloodPressure, diastolicBloodPressure,getindex);
    	        			}
    	        		} else {
    	        			System.out.println("This is invalid input ! \n");
    	        		}
    	        		System.out.print(" Report Finished ! \n");
    	        		System.out.println("Press 1 : For Main Menu");
    	        		System.out.println("Press 0 : For Exit Application \n");
    	        		int option2 = scanner.nextInt();
    	        		switch(option2) {
    	        		case 1:
    	        			if(option2==1) {
    	        				View.mainMenu();
    	        			} 
    	        		break;
    	        		case 0:
    	        			return;
    	        		}
    	        		
    	                break; 
    	            case '2':
    	            	System.out.println("Please Enter Person Identifier's Range \n");
    	            	System.out.print("Please enter FROM person identifier: \n");
    	        		String minStringToLocate = scanner.next();
    	        		System.out.print("Please enter TO person identifier: \n");
    	        		String maxStringToLocate = scanner.next();
    	        		try{
    	        			if(maxStringToLocate.compareTo(minStringToLocate)<=0)
    	        			{
    	        				throw new Exception("Invalid entry, please enter correct value");
    	        			}
    	        		}
    	        		catch(Exception ex)
    	        		{
    	        			System.out.println("Invalid Entry! Please enter the values again");
    	        			return;
    	        		}
    	        		if (MAPAnalyser.checkIfExist(personIdentifier, minStringToLocate) && MAPAnalyser.checkIfExist(personIdentifier, maxStringToLocate)) {
    	        			int minIndex = MAPAnalyser.findIndex(personIdentifier, minStringToLocate);
    	        			int maxIndex = MAPAnalyser.findIndex(personIdentifier, maxStringToLocate);
    	        			System.out.println("This is valid input ! \n");
    	        			//System.out.println("Identified : " + getindex);
    	        			if (minIndex >= 0 && maxIndex >0) {
    	        				MAPAnalyser.mapResult(systolicBloodPressure, diastolicBloodPressure,minIndex,maxIndex);
    	        			}
    	        		} else {
    	        			System.out.println("This is invalid input ! \n");
    	        		}
    	        		System.out.print(" Report Finished ! \n");
    	        		System.out.println("Press 1 : For Main Menu");
    	        		System.out.println("Press 0 : For Exit Application \n");
    	        		int option3 = scanner.nextInt();
    	        		switch(option3) {
    	        		case 1:
    	        			if(option3==1) {
    	        				View.mainMenu();
    	        			} 
    	        		break;
    	        		case 0:
    	        			return;
    	        		
    	        		}
    	        		
    	                break;
    	            case '3':
    	            	System.out.print("Work in progress");
    	                break;
    	            case '4':
    	                return;
    	            default: 
    	                System.out.println("Invalid Input!");
    	                break;
    	        
    	    }
    	}	
		
		
	}


}
