package edu.csupomona.cs480.data;

import edu.csupomona.cs480.data.GoogleGeoBounds;
import edu.csupomona.cs480.data.GoogleGeoLatLng;

public class GoogleGeoGeometry {
    public GoogleGeoBounds getBounds() {
		return bounds;
	}
	public void setBounds(GoogleGeoBounds bounds) {
		this.bounds = bounds;
	}
	public GoogleGeoLatLng getLocation() {
		return location;
	}
	public void setLocation(GoogleGeoLatLng location) {
		this.location = location;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public GoogleGeoBounds getViewport() {
		return viewport;
	}
	public void setViewport(GoogleGeoBounds viewport) {
		this.viewport = viewport;
	}
	public GoogleGeoGeometry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoogleGeoGeometry(GoogleGeoBounds bounds, GoogleGeoLatLng location, String location_type,
			GoogleGeoBounds viewport) {
		super();
		this.bounds = bounds;
		this.location = location;
		this.location_type = location_type;
		this.viewport = viewport;
	}
	private GoogleGeoBounds bounds;
    private GoogleGeoLatLng location;
    private String location_type;
    private GoogleGeoBounds viewport;
}
