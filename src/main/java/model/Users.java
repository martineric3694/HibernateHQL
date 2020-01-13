package model;
// Generated Nov 12, 2019 7:41:14 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "USERS", schema = "HR")
public class Users implements java.io.Serializable {

	private int userId;
	private Roles roles;
	private String email;
	private String password;
	private String name;
	private String lastName;
	private Boolean active;

	public Users() {
	}

	public Users(int userId) {
		this.userId = userId;
	}

	public Users(int userId, Roles roles, String email, String password, String name, String lastName, Boolean active) {
		this.userId = userId;
		this.roles = roles;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
	}

	@Id

	@Column(name = "USER_ID", unique = true, nullable = false, precision = 6, scale = 0)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "EMAIL", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NAME", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LAST_NAME", length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "ACTIVE", precision = 1, scale = 0)
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
