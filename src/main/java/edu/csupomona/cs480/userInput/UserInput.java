package edu.csupomona.cs480.userInput;

import java.util.List;

public class UserInput {
	private List<String> foodTypes;
	private String locationType;
	private String locationValue;
	private double lat;
	private double lon;

	public String getLocationValue() {
		return locationValue;
	}

	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public List<String> getFoodTypes() {
		return foodTypes;
	}

	public void setFoodTypes(List<String> foodTypes) {
		this.foodTypes = foodTypes;
	}

   public double getLat() {
      return lat;
   }

   public void setLat(double lat) {
      this.lat = lat;
   }

   public double getLon() {
      return lon;
   }

   public void setLon(double lon) {
      this.lon = lon;
   }
}
