package com.projects.flightadvirosor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "route")
public class Route {
	
	@Column(name = "airline")
	String airline;
	@Id
	@Column(name = "airlineId")
	int airlineId;
	@Column(name = "sourceAirport")
	String sourceAirport;
	@Column(name = "sourceAirportId")
	int sourceAirportId;
	@Column(name = "destinationAirport")
	String destinationAirport;
	@Column(name = "destinationAirportId")
	int destinationAirportId;
	@Column(name = "codeshare")
	String codeshare;
	@Column(name = "sops")
	int sops;
	@Column(name = "equipment")
	String equipment;
	@Column(name = "price")
	long price;
}
