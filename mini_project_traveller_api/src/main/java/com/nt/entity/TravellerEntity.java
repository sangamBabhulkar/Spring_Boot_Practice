package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Column(name = "Rest_Traveller")
public class TravellerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String country;
	
	private long mobileno;
	private LocalDate dob;
	
	@Column(length = 30)
	private String currentLocation;
	
	@Column(length = 30)
	private String leadingTo;
	
	
	
	
	@CreationTimestamp
	private LocalDateTime registeredOn;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedOn;
	
	@Column(length = 30)
	private String createdBy;
	
	public Integer getTid
	
	
}
