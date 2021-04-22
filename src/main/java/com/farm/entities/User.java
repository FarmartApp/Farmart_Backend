
package com.farm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.farm.settings.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "users")
@ApiModel(description = "All details about the users. ")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(nullable = false, length = 100)
	@NotEmpty(message = "First name cannot be empty")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String firstName;

	@Column(nullable = true)
	private String lastName;

	@Column(nullable = true)
	private String district;

	@Column(nullable = true)
	private String address;

	@Column(nullable = true)
	private String username;

	@Column(unique = true, nullable = false, length = 255)
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email")
	private String email;

	@Column(nullable = false, columnDefinition = "LONGTEXT")
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8, message = "Password should have atleast 8 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(columnDefinition = "LONGTEXT")
	@JsonIgnore
	private String token;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;
	@Column(name = "is_mobile_verified", nullable = false)
	private boolean isMobileVerified;

	@Column(unique = true, nullable = false, length = 100)
	@NotEmpty(message = "Contact primary cannot be empty")
	private String contactPrimary;

	@Column(nullable = true)
	private String contactSecondary;

	@Column(nullable = true)
	private String avatar;
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "created_at")
	@CreationTimestamp
	@JsonIgnore
	private Calendar createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonIgnore
	private Calendar updatedAt;

	@Column(name = "deleted_at")
	@JsonIgnore
	private Calendar deletedAt;
	

	

	// ******************JOIN TABLE*************************//



	


	

	/**
	 * 
	 */
	public User() {
		super();
	}

	// ************GETTERS AND SETTERS***************//


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public boolean isMobileVerified() {
		return isMobileVerified;
	}

	public void setMobileVerified(boolean mobileVerified) {
		isMobileVerified = mobileVerified;
	}

	public String getContactPrimary() {
		return contactPrimary;
	}

	public void setContactPrimary(String contactPrimary) {
		this.contactPrimary = contactPrimary;
	}

	public String getContactSecondary() {
		return contactSecondary;
	}

	public void setContactSecondary(String contactSecondary) {
		this.contactSecondary = contactSecondary;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Calendar getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Calendar deletedAt) {
		this.deletedAt = deletedAt;
	}
	//*************************************constructor***********************************//

	public User(Integer id, @NotEmpty(message = "First name cannot be empty") @Size(min = 2, message = "Name should have atleast 2 characters") String firstName, String lastName, String district, String address, String username, @NotEmpty(message = "Email cannot be empty") @Email(message = "Invalid email") String email, @NotEmpty(message = "Password cannot be empty") @Size(min = 8, message = "Password should have atleast 8 characters") String password, String token, boolean isActive, boolean isMobileVerified, @NotEmpty(message = "Contact primary cannot be empty") String contactPrimary, String contactSecondary, String avatar, String description, Calendar createdAt, Calendar updatedAt, Calendar deletedAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.district = district;
		this.address = address;
		this.username = username;
		this.email = email;
		this.password = password;
		this.token = token;
		this.isActive = isActive;
		this.isMobileVerified = isMobileVerified;
		this.contactPrimary = contactPrimary;
		this.contactSecondary = contactSecondary;
		this.avatar = avatar;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
}
