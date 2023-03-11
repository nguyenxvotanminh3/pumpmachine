package com.nguyenminh.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tablepump" )
public class Pump {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="humidlevel")
	private int humidlevel;
	@Column(name="latitude")
	private double latitude;
	@Column(name="longitude")
	private double longitude;
	@Column(name="aiwatering")
	private String aiwatering;
	@Column(name="autowatering")
	private String autowatering;
	@Column(name="manualwatering")
	private String manualwatering;
	
	
	public Pump () {
	
	}


	public Pump(int humidlevel, double latitude, double longitude, String aiwatering, String autowatering,
			String manualwatering) {
		super();
		this.humidlevel = humidlevel;
		this.latitude = latitude;
		this.longitude = longitude;
		this.aiwatering = aiwatering;
		this.autowatering = autowatering;
		this.manualwatering = manualwatering;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getHumidlevel() {
		return humidlevel;
	}


	public void setHumidlevel(int humidlevel) {
		this.humidlevel = humidlevel;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getAiwatering() {
		return aiwatering;
	}


	public void setAiwatering(String aiwatering) {
		this.aiwatering = aiwatering;
	}


	public String getAutowatering() {
		return autowatering;
	}


	public void setAutowatering(String autowatering) {
		this.autowatering = autowatering;
	}


	public String getManualwatering() {
		return manualwatering;
	}


	public void setManualwatering(String manualwatering) {
		this.manualwatering = manualwatering;
	}


	@Override
	public String toString() {
		return "Pump [id=" + id + ", humidlevel=" + humidlevel + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", aiwatering=" + aiwatering + ", autowatering=" + autowatering + ", manualwatering=" + manualwatering
				+ "]";
	}

	
	
	
}

