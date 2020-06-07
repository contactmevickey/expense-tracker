package com.money.tracker.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Entity
public class Expenditure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@OneToOne(targetEntity=Account.class)	
	private Account account;
	
	@NonNull
	@OneToOne(targetEntity=User.class)
	private User user;
	
	private float amount;
	private String expenseReason;
	private String extrInfo;
	private Timestamp dateOfSpend;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	@PrePersist
	void onCreate() {
		Timestamp timeStamp = new Timestamp((new Date()).getTime());
		this.setCreatedAt(timeStamp);
		this.setUpdatedAt(timeStamp);
	}

	@PreUpdate
	void onPersist() {
		this.setUpdatedAt(new Timestamp((new Date()).getTime()));
	}

}