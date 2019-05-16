package map.Main;

import java.util.Scanner;

import map.MAPAnalyser.MAPAnalyser;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String personIdentifier[] = new String[10];
		personIdentifier[0]="A001";
		personIdentifier[1]="A002";
		personIdentifier[2]="A003";
		personIdentifier[3]="A004";
		personIdentifier[4]="A005";
		personIdentifier[5]="A006";
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
    	System.out.print("1. Display the record for a specified person. \n");
    	System.out.print("2. Display records for all persons with MAP values within a specified range. \n");
    	System.out.print("3. Display the minimum, maximum and median MAP values. \n");
    	System.out.print("0. Exit the application \n");
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
    	        			System.out.println("Index : " + getindex);
    	        			System.out.println("Person identifier Report: "+personIdentifier[getindex]);
    	        			if (getindex >= 0) {
    	        				MAPAnalyser.mapResults(systolicBloodPressure, diastolicBloodPressure,getindex);
    	        			}
    	        		} else {
    	        			System.out.println("This is invalid input ! \n");
    	        		}
    	        		System.out.print("Finished Report");
    	                break; 
    	                
    	            case '2':
    	            	System.out.print("Work in progress");
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