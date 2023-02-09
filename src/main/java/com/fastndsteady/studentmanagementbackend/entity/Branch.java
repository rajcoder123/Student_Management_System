package com.fastndsteady.studentmanagementbackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("branches")
public class Branch {
	@Id
	private String id;
	private String name;
	private String hod;
	private Integer seats;
	private Integer filledSeats;
	private Integer faculties;
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(String id, String name, String hod, Integer seats, Integer filledSeats, Integer faculties) {
		super();
		this.id = id;
		this.name = name;
		this.hod = hod;
		this.seats = seats;
		this.filledSeats = filledSeats;
		this.faculties = faculties;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", hod=" + hod + ", seats=" + seats + ", filledSeats="
				+ filledSeats + ", faculties=" + faculties + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Integer getFilledSeats() {
		return filledSeats;
	}
	public void setFilledSeats(Integer filledSeats) {
		this.filledSeats = filledSeats;
	}
	public Integer getFaculties() {
		return faculties;
	}
	public void setFaculties(Integer faculties) {
		this.faculties = faculties;
	}
}
