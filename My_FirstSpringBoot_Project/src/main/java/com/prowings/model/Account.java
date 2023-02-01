package com.prowings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	@Id
	Integer accountNo;
	@Column
	String ifseCode;
	@Column
	String branch;
	@Column
	String accountHolderName;

}
