
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


@Entity
@Table(name = "transports")
@ApiModel(description = "All details about the agricultural products ")
public class Transport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer id;






	@Column(nullable =false,name ="vehicle_model")
	@NotEmpty(message = "vehicle Type cannot be empty")
	private String VehicleModel;

	@Column(nullable =false,name ="vehicle_no")
	@NotEmpty(message = "Product Type cannot be empty")
	private String VehicleNo;



	@Column(name ="weight",nullable =true)
	private Double Weight;
	@Column(name ="amount",nullable =true)
	private Integer Amount;

	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;




	@Column(nullable = true)
	private String image;



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





	// *****************Getters Setters*************************//

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleModel() {
		return VehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		VehicleModel = vehicleModel;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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


	//*************************Constructors*************************************//


	public Transport(Integer id, @NotEmpty(message = "vehicle Type cannot be empty") String vehicleModel, @NotEmpty(message = "Product Type cannot be empty") String vehicleNo, Double weight, Integer amount, User user, String image, Calendar createdAt, Calendar updatedAt, Calendar deletedAt) {
		this.id = id;
		VehicleModel = vehicleModel;
		VehicleNo = vehicleNo;
		Weight = weight;
		Amount = amount;
		this.user = user;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Transport(){
		super();
	}

}
