/**
 * 
 */
package com.test.city;

/**
 * @author UlyanovAV
 *
 */
public class City {
	private double latitude;
	private double longitude;
	private String name;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public City(double lan,double lon){
		this.latitude = lan;
		this.longitude = lon;
	}
	public City(String name){
	//	this.latitude = 1123d;
	//	this.longitude = 445d;
		this.name = name;
	}
	public City(){
		}
}
