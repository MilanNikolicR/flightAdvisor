package com.projects.flightadvirosor.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "city")
@Entity
@NoArgsConstructor
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	String name;
	@Column(name = "firstname")
	String country;
	@Column(name = "description")
	String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ElementCollection
    private List<Comment> comments;
}