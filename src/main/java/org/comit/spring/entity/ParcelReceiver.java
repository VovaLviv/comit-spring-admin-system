package org.comit.spring.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parcel_Receivers")
public class ParcelReceiver {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parcel_receiver_id")
	private Integer parcelReceiverId;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String adress;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;
	
	@OneToMany(mappedBy = "percelReceiver", cascade = CascadeType.ALL)
	private List<Parcel> parcels;
	
	public ParcelReceiver() {
		
	}
	
	public ParcelReceiver(String fullName, String city, String adress, 
			String postalCode, String cellPhone) {
		this.fullName = fullName;
		this.city = city;
		this.adress = adress;
		this.postalCode = postalCode;
		this.cellPhone = cellPhone;
	}

	public int getParcelReceiverId() {
		return parcelReceiverId;
	}

	public void setParcelReceiverId(int parcelReceiverId) {
		this.parcelReceiverId = parcelReceiverId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	

}
