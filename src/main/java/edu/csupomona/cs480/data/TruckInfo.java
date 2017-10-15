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
    private int startHour[] = new int[7];    
    private int endHour[] = new int[7];
    /** The business hours for am (true) or pm (false)*/
    private boolean ampmS[] = new boolean[7]; 
    private boolean ampmE[] = new boolean[7];
    /** type of food */
    private String type;
    private int zipCode;
    private String Location;
    private double rating;
    private int areaCode;
    private int phoneNumber;
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

	public int[] getStartHour() {
		return startHour;
	}

	public void setStartHour(int[] startHour) {
		this.startHour = startHour;
	}

	public int[] getEndHour() {
		return endHour;
	}

	public void setEndHour(int[] endHour) {
		this.endHour = endHour;
	}

	public boolean[] getAmpmS() {
		return ampmS;
	}

	public void setAmpmS(boolean[] ampmS) {
		this.ampmS = ampmS;
	}

	public boolean[] getAmpmE() {
		return ampmE;
	}

	public void setAmpmE(boolean[] ampmE) {
		this.ampmE = ampmE;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
