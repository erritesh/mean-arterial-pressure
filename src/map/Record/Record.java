package map.Record;

public class Record {
	private String id;
	private int sbp;
	private int dbp;
	private int map;
	private String category;
	
	// implement setter and getter for all attribute
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSbp() {
		return sbp;
	}
	public void setSbp(int sbp) {
		this.sbp = sbp;
	}
	public int getDbp() {
		return dbp;
	}
	public void setDbp(int dbp) {
		this.dbp = dbp;
	}
	public int getMap() {
		return map;
	}
	public void setMap(int map) {
		this.map = map;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", sbp=" + sbp + ", dbp=" + dbp + ", map=" + map + ", category=" + category
				+ ", getId()=" + getId() + ", getSbp()=" + getSbp() + ", getDbp()=" + getDbp() + ", getMap()="
				+ getMap() + ", getCategory()=" + getCategory() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}	
}
