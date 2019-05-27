package map.Record;

public class Record {
	private String id;
	private int sbp;
	private int dbp;
	private int map;
	private String category;
	
	
	// Creating Constructor
	public Record (String ID, int SBP,int DBP,int MAP,String Category) {
		id=ID;
		sbp=SBP;
		dbp=DBP;
		map=MAP;
		category=Category;
	}
	
	
	
	// implement  getter for all attribute
	
	public String getId() {
		return id;
	}
	public int getSbp() {
		return sbp;
	}
	public int getDbp() {
		return dbp;
	}
	public int getMap() {
		return map;
	}
	public String getCategory() {
		return category;
	}
	
	// Implement toString Method
	public String toString() {
        String string="<"+id+","+sbp+","+dbp+","+map+","+category+">";
        return string;
    }
	
}
