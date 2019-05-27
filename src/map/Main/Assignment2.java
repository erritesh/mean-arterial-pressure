package map.Main;

import map.MAPAnalyser.MAPAnalyser;
import map.View.View;

public class Assignment2 {

	public static void main(String[] args) {
		
		
        MAPAnalyser mapAnalyser=new MAPAnalyser();
      
        View view=new View(mapAnalyser);
		view.commandLoop();
		
	}
}
