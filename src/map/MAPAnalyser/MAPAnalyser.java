package map.MAPAnalyser;

public class MAPAnalyser {
	public static void mapResults(int[] sbp, int[] dbp,int index) {
		float[] map = new float[10];
		for(int i=0; i< sbp.length;i++)
		{
			map[i]=(float) (1.0/3.0*sbp[i]+2/3.0*dbp[i]);
		}
		validateMap(map[index]);
		System.out.println("Systolic Blood Pressure (in mmHg) : "+sbp[index]);
		System.out.println("Diastolic Blood Pressure (in mmHg) : "+dbp[index]);
		System.out.println("Mean Arterial Pressure : "+map[index]);
		System.out.println("Cateogry :"+ validateMap(map[index]));
	}
	
	public static void mapResult(int[] sbp, int[] dbp,int minIndex,int maxIndex) {
		float[] map = new float[10];
		for(int i=0; i< sbp.length;i++)
		{
			map[i]=(float) (1.0/3.0*sbp[i]+2/3.0*dbp[i]);
		}
		validateMap(map[minIndex]);
		while(minIndex <= maxIndex)
		{
			System.out.println("Systolic Blood Pressure (in mmHg) : "+sbp[minIndex]);
			System.out.println("Diastolic Blood Pressure (in mmHg): "+dbp[minIndex]);
			System.out.println("Mean Arterial Pressure: "+map[minIndex]);
			System.out.println("Cateogry :"+ validateMap(map[minIndex]));
			System.out.println("=====================================");
			minIndex++;
		}
	}
	
	public static boolean checkIfExist(String[] myStringArray, String stringToLocate) {
		for (String element : myStringArray) {
			if (element.equals(stringToLocate)) {
				return true;
			}
		}
		return false;
	}
	
	public static String validateMap(float mapVal) {
		if(mapVal>70 && mapVal<100)
		{
			return "Ideal";
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
	
	//  find index function start
	public static int findIndex(String[] findString, String item) {
		for (int i = 0; i < findString.length; i++) {
			if (item.equals(findString[i]))
				return i;
		}
		return -1;
	}
	// EOC
	
	// checking value exits or not in Array
	public static boolean checkIfExists(String[] myStringArray, String stringToLocate) {
		for (String element : myStringArray) {
			if (element.equals(stringToLocate)) {
				return true;
			}
		}
		return false;
	}
	// EOC
}
