package com.money.tracker.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name="account_id")
	private Account account;
	
    @OneToMany(mappedBy = "user")
    private List<Investment> investments;
	
	private String name;
	private String email;
	private String profession;
	private float incomePerMonth;
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