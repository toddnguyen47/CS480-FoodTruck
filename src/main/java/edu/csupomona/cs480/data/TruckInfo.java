package edu.csupomona.cs480.data;
import java.util.Date;

/**
 * The basic food truck information object.
 */
public class TruckInfo {
	/** The unique truck Id */
    private String id;
    /** The unique business name */
    private String name;
    /** The business hours 0 to 6, Sun to Sat*/
//    private int startHour[] = new int[7];    
//    private int endHour[] = new int[7];
//    /** The business hours for am (true) or pm (false)*/
//    private boolean ampmS[] = new boolean[7]; 
//    private boolean ampmE[] = new boolean[7];
    /** type of food */
    private String type;
//    private int zipCode;
//    private String Location;
//    private double rating;
//    private int areaCode;
//    private int phoneNumber;
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
}
