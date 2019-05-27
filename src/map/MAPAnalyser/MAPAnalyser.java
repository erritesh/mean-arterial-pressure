package map.MAPAnalyser;

import java.util.Arrays;
import map.Record.Record;

public class MAPAnalyser {
	 private Record[] data;
	 private int nrecords;
	 
	// Both loadFromTables() and sortById() are to be invoked from the constructor for the MAPAnalyser class
	
	public MAPAnalyser() {
		loadFromTables();
         sortById();
    }
	
	// variable for the array of records
   
    
    private void loadFromTables() {
	
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
	
	
	
	
	
	 try {
		 data=new Record[personIdentifier.length];
	
	
	for(int i=0;i<=data.length;i++) {
		float map;
		 map=(float) (1.0/3.0*systolicBloodPressure[i]+2.0/3.0*diastolicBloodPressure[i]);
		// Cast Float value -> int
		 
		int mapValue= (int) map;
		// Calculate category
		String category = classify(mapValue);
		
		// data set from recorded values
		data[i]=new  Record(personIdentifier[i], systolicBloodPressure[i], diastolicBloodPressure[i], mapValue, category);
	} }catch(Exception e) {    
		   System.out.println("Total Record Found : "+e.getMessage());
	}
	 
    }

    private void sortById() {
        
        for(int i=0; i<data.length-1; i++) {
        
            int minPosition=i;
      
            for(int j=i+1; j<data.length; j++) {
          
                String string1=data[j].getId(), string2=data[minPosition].getId();
        
                int compare=string1.compareTo(string2);
                if(compare<0)            
                    minPosition=j;
        
            }
      
            if(minPosition!=i) {
          
                Record record=data[i];
        
                data[i]=data[minPosition];
        
                data[minPosition]=record;
        
            }
      
        }
    }
    
    public static String classify(int mapVal) {
		if(mapVal>70 && mapVal<100)
		{
			return "Normal";
		}
		else if(mapVal>50 && mapVal<70)
		{
			return "Low";
		}
		else if(mapVal>100 && mapVal<120)
		{
			return "High";
		}
		return "None";
	}
    // Find Maximum value
    public int highest() { 

        int maxValue=0;
    
        for(int i=0; i<data.length; i++) {

            int mapValue=data[i].getMap();
        
            if(mapValue>maxValue)
            	maxValue=mapValue;
        
        }
    
        return maxValue;
    
    }
    // Find minimum value
    
    public int lowest() {
        int minValue=1000;
        
        for(int i=0; i<data.length; i++) {
        	
            int map=data[i].getMap();
            
            if(map<minValue)
            	
            	minValue=map;
        
        }
    
        return minValue;
    
    }
    // TO USE FOR find the Median Value
	public  int median() {
		 int[] mapVal=new int[data.length];
		 for(int i=0; i<data.length; i++)
			 mapVal[i]=data[i].getMap();
		 Arrays.sort(mapVal);
		 int medianVal=0;
	        int mapLen=mapVal.length;
	    
	        if(mapLen%2==1)
	        	medianVal=mapVal[mapLen/2];
	        else
	        	medianVal=(mapVal[mapLen/2]+mapVal[mapLen/2]-1)/2;
	    
		return medianVal;
	      
	      
	}
	
	public Record find(String id) {
	      
        Record record=null;
        int left=0;
        int right=data.length-1;
        while(left<=right) {
            int middle=(left+right)/2;
            
            String string1=data[middle].getId(), string2=id;
            int compare=string1.compareTo(string2);
            if(compare<0)
                left=middle+1;
            else if(compare>0)
                right=middle-1;
            else {
          
                record=data[middle];
                break;
        
            }
      
        }
    
        return record;
    
    }
    public Record[] find(int map1, int map2) {
        int i;
        int j;
        int count=0;
    
        for(i=0; i<data.length; i++)
            if(data[i].getMap()>=map1 && data[i].getMap()<=map2)
                count++;
        Record[] records=new Record[count];
        i=0;
        j=0;
        while(i<data.length && j<count) {
            if(data[i].getMap()>=map1 && data[i].getMap()<=map2) {
                records[j]=data[i];
                j++; 
            }
      
            i++; 
        }
        return records; 
    }
}
