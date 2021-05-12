
package com.farm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import  com.farm.entities.User;


@Entity
@Table(name = "histories")
@ApiModel(description = "All details about the sold product")
public class History implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer id;


	@Column( nullable = false,name ="sold_price")
	@NotEmpty(message = "Price cannot be empty")
	private Double SoldPrice;













	@Column(name = "created_at")
	@CreationTimestamp

	private Calendar createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonIgnore
	private Calendar updatedAt;

	@Column(name = "deleted_at")
	@JsonIgnore
	private Calendar deletedAt;

	@ManyToOne()
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private User buyer;

	@ManyToOne()
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private User seller;



	// *****************Getters Setters*************************//

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public Double getSoldPrice() {
		return SoldPrice;
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

	public User getBuyer() {
		return buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSoldPrice(Double soldPrice) {
		SoldPrice = soldPrice;
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

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
//*************************Constructors*************************************//


	public History(Integer id, @NotEmpty(message = "Price cannot be empty") Double soldPrice, Calendar createdAt, Calendar updatedAt, Calendar deletedAt, User buyer, User seller) {
		this.id = id;
		SoldPrice = soldPrice;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.buyer = buyer;
		this.seller = seller;
	}

	public History(){
		super();
	}

}
