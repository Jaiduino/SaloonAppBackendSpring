package com.jayesh.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;


@Entity
public class Date {

 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Id
 private int DId;
 
 @JsonDeserialize(using = LocalDateDeserializer.class)
 private LocalDate date;
 @OneToMany(mappedBy = "date")
 //@JsonIgnoreProperties({"date"})
 private List<Orders> orderlist = new ArrayList<Orders>();

 
public Date() {
}

public Date(int dId, LocalDate date) {
	this.DId = dId;
	this.date = date;
}

public int getId() {
	return DId;
}

public void setId(int id) {
	DId = id;
}

public LocalDate getDates() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public List<Orders> getOrderlist() {
	return orderlist;
}

public void setOrderlist(List<Orders> orderlist) {
	this.orderlist = orderlist;
}
 
 
}
