package edu.csupomona.cs480.data;

public class GoogleGeoLatLng {
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public GoogleGeoLatLng() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoogleGeoLatLng(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	private String lat;
    private String lng;
}
