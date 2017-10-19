package edu.csupomona.cs480.data;

import edu.csupomona.cs480.data.GoogleGeoAdressComponent;
import edu.csupomona.cs480.data.GoogleGeoGeometry;

public class GoogleGeoResult {
	
    private GoogleGeoAdressComponent [] address_components;
	private String formatted_address;
    private GoogleGeoGeometry geometry;
    private Boolean partial_match;
    private String place_id;
    private String [] types;
    
    
	public GoogleGeoResult(GoogleGeoAdressComponent[] address_components, String formatted_address,
			GoogleGeoGeometry geometry, Boolean partial_match, String place_id, String[] types) {
		super();
		this.address_components = address_components;
		this.formatted_address = formatted_address;
		this.geometry = geometry;
		this.partial_match = partial_match;
		this.place_id = place_id;
		this.types = types;
	}
	public GoogleGeoResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public GoogleGeoAdressComponent[] getAddress_components() {
		return address_components;
	}
	public void setAddress_components(GoogleGeoAdressComponent[] address_components) {
		this.address_components = address_components;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public GoogleGeoGeometry getGeometry() {
		return geometry;
	}
	public void setGeometry(GoogleGeoGeometry geometry) {
		this.geometry = geometry;
	}
	public Boolean getPartial_match() {
		return partial_match;
	}
	public void setPartial_match(Boolean partial_match) {
		this.partial_match = partial_match;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}



}
