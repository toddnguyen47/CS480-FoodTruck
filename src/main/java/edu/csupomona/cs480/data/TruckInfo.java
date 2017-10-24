package edu.csupomona.cs480.data;

import java.util.Date;
import javax.persistence.*;

/**
 * The basic food truck information object.
 */
@Entity
public class TruckInfo {
	/** The unique truck Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /** The unique business name */
    private String name;
    /** The business hours 0 to 6, Sun to Sat*/
    private String startHour[] = new String [7];    
    private String endHour[] = new String [7];
    /** The business hours for am (true) or pm (false)*/
    private boolean ampmS[] = new boolean[7]; 
    private boolean ampmE[] = new boolean[7];
    /** type of food */
    private String type;
    private int zipCode;

    private double rating;
    private int areaCode;
    private int phoneNumber;
	private String city;
    private String address;
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


    
    
    
    
    
    
    public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private double latitude;
    private double longitude;
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

	public String[] getStartHour() {
		return startHour;
	}

	public void setStartHour(String[] startHour) {
		this.startHour = startHour;
	}

	public String[] getEndHour() {
		return endHour;
	}

	public void setEndHour(String[] endHour) {
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
