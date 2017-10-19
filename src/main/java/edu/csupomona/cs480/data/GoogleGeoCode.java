package edu.csupomona.cs480.data;

import edu.csupomona.cs480.data.GoogleGeoResult;
public class GoogleGeoCode {
    public GoogleGeoCode(String status, GoogleGeoResult[] results, Boolean exclude_from_slo, String error_message) {
		super();
		this.status = status;
		this.results = results;
		this.exclude_from_slo = exclude_from_slo;
		this.error_message = error_message;
	}
	private String status;
    private GoogleGeoResult [] results;
    private Boolean exclude_from_slo;
    private String error_message;
	public GoogleGeoCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public GoogleGeoResult[] getResults() {
		return results;
	}
	public void setResults(GoogleGeoResult[] results) {
		this.results = results;
	}
	public Boolean getExclude_from_slo() {
		return exclude_from_slo;
	}
	public void setExclude_from_slo(Boolean exclude_from_slo) {
		this.exclude_from_slo = exclude_from_slo;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
}
