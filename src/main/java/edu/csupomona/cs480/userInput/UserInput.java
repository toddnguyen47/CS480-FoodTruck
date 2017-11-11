package edu.csupomona.cs480.userInput;

import java.util.List;

public class UserInput {
	private List<String> foodTypes;
	private String locationType;
	private String locationValue;
	private double lat;
	private double lon;
	
	/**
	 * Get what the user actually enters into the textbox.<br />
	 * For example, if the user enters "91762", locationValue will be
	 * "91762."
	 * 
	 * @return locationValue - What the user enters into the textbox
	 */
	public String getLocationValue() {
		return locationValue;
	}

	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}

	/**
	 * Get the user's selection choice of either Zip code, Address, City, or Current Location.<br />
	 * For example, if the user selects "Zip code", locationType will be "zip code."
	 * @return What the user selects as his/her location type, converted to lowercase.
	 */
	public String getLocationType() {
		return locationType.toLowerCase();
	}

	/**
	 * Sets the user's locationType (what the user selects)
	 * @param locationType - the type that the user selected, converted to lowercase
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType.toLowerCase();
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
