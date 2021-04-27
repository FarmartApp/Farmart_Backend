
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
@Table(name = "products")
@ApiModel(description = "All details about the agricultural products ")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(nullable = false, length = 100)
	@NotEmpty(message = "product name cannot be empty")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;



	@Column(nullable = false)
	private String location;





	@Column( nullable = false,name ="price")
	@NotEmpty(message = "Price cannot be empty")
	private Double Price;

	@Column(nullable =false,name ="product_type")
	@NotEmpty(message = "Product Type cannot be empty")
	private String ProductType;



	@Column(name = "is_sold", nullable = true)
	private boolean isSold;
	@Column(name = "is_delivery_available", nullable = true)
	private boolean isDeliveryAvailable;

	@Column(name ="weight",nullable =true)
	private Double Weight;
	@Column(name ="amount",nullable =true)
	private Integer Amount;




	@Column(nullable = true)
	private String image;
	


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

	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	

	

	// *****************Getters Setters*************************//


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Double getPrice() {
		return Price;
	}

	public String getProductType() {
		return ProductType;
	}

	public boolean isSold() {
		return isSold;
	}

	public boolean isDeliveryAvailable() {
		return isDeliveryAvailable;
	}

	public Double getWeight() {
		return Weight;
	}

	public Integer getAmount() {
		return Amount;
	}

	public String getImage() {
		return image;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public Calendar getDeletedAt() {
		return deletedAt;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public void setSold(boolean sold) {
		isSold = sold;
	}

	public void setDeliveryAvailable(boolean deliveryAvailable) {
		isDeliveryAvailable = deliveryAvailable;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDeletedAt(Calendar deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//*************************Constructors*************************************//


	public Product(Integer id, @NotEmpty(message = "product name cannot be empty") @Size(min = 2, message = "Name should have atleast 2 characters") String name, String location, @NotEmpty(message = "Price cannot be empty") Double price, @NotEmpty(message = "Product Type cannot be empty") String productType, boolean isSold, boolean isDeliveryAvailable, Double weight, Integer amount, String image, Calendar createdAt, Calendar updatedAt, Calendar deletedAt, User user) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		Price = price;
		ProductType = productType;
		this.isSold = isSold;
		this.isDeliveryAvailable = isDeliveryAvailable;
		Weight = weight;
		Amount = amount;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.user = user;

	}

}
