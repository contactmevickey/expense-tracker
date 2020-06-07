package com.money.tracker.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Entity
public class InvestmentCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
    @OneToMany(mappedBy = "investmentCategory")
    private List<Investment> investments;
	
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
