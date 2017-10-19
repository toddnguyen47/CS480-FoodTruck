package edu.csupomona.cs480.data;

import edu.csupomona.cs480.data.GoogleGeoLatLng;

public class GoogleGeoBounds {
	
	public GoogleGeoBounds() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoogleGeoBounds(GoogleGeoLatLng northeast, GoogleGeoLatLng southwest) {
		super();
		this.northeast = northeast;
		this.southwest = southwest;
	}
	private GoogleGeoLatLng northeast;
    private GoogleGeoLatLng southwest;
    
	public GoogleGeoLatLng getNortheast() {
		return northeast;
	}
	public void setNortheast(GoogleGeoLatLng northeast) {
		this.northeast = northeast;
	}
	public GoogleGeoLatLng getSouthwest() {
		return southwest;
	}
	public void setSouthwest(GoogleGeoLatLng southwest) {
		this.southwest = southwest;
	}

}
