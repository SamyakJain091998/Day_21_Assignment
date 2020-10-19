package com.InvoiceService.assignment;

public class Rides {

	private double time;
	private double distance;
	private String type;

	public Rides() {

	}

	public Rides(double time, double distance, String type) {
		this.time = time;
		this.distance = distance;
		this.type = type;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Rides [time=" + time + ", distance=" + distance + ", type=" + type + "]";
	}

}
