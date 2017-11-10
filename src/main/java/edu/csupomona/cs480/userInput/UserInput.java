package edu.csupomona.cs480.userInput;

import java.util.List;

public class UserInput {
	private List<String> foodTypes;
	private String locationType;
	private String locationValue;

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
}
