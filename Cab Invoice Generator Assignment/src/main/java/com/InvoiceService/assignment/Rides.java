package com.InvoiceService.assignment;

public class Rides {

	private double time;
	private double distance;

	public Rides() {

	}

	public Rides(double time, double distance) {
		this.time = time;
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Rides [time=" + time + ", distance=" + distance + "]";
	}

}
