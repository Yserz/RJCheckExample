/*
 * Copyright (C) 2013 Michael Koppen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fhb.rjcheckexample.entity;

import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This entity represents an account.
 *
 * @author Michael Koppen <michael.koppen@googlemail.com>
 */
@Entity
@Cacheable(false)
@NamedQueries({
	@NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username")
})
public class Account extends BaseEntity {

	@Id
	private String email;
	@NotNull
	@Size(min = 1, max = 255)
	@Column(unique = true)
	private String username;
	@NotNull
	@Size(min = 1, max = 255)
	private String lastName;
	@NotNull
	@Size(min = 1, max = 255)
	private String firstName;

	public Account() {
	}

	public Account(String email, String username, String lName, String fName) {
		this.email = email;
		this.username = username;
		this.lastName = lName;
		this.firstName = fName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + Objects.hashCode(this.email);
		hash = 89 * hash + Objects.hashCode(this.username);
		hash = 89 * hash + Objects.hashCode(this.lastName);
		hash = 89 * hash + Objects.hashCode(this.firstName);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Account other = (Account) obj;
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		return true;
	}
}
