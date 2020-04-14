package com.mojdan.admin.model.user;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.mojdan.admin.model.address.Address;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private User user;

	@NotNull(message = "Firstname is required.")
	@Basic(optional = false)
	private String firstName;

	@NotNull(message = "Surname is required.")
	@Basic(optional = false)
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne
	private Address primaryAddress;

	public Seller() {
	}

}
