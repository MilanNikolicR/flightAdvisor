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
@Table(name = "airport")
public class Airport {

	@Id
	@Column(name = "airport_id", nullable = false)
	int airportId;
	@Column(name = "name", nullable = false)
	String name;
	@Column(name = "city", nullable = false)
	String city;
	@Column(name = "country", nullable = false)
	String country;
	@Column(name = "iata", nullable = false)
	String iata;
	@Column(name = "icao", nullable = false)
	String icao;
	@Column(name = "latitude", nullable = false)
	long latitude;
	@Column(name = "longitude", nullable = false)
	long longitude;
	@Column(name = "altitude", nullable = false)
	long altitude;
	@Column(name = "timezone")
	int timezone;
	@Column(name = "dst")
	String dst;
	@Column(name = "tz")
	String tz;
	@Column(name = "type")
	String type;
	@Column(name = "source")
	String source;
	 
}
