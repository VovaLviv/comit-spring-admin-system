package org.comit.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parcels")
public class Parcel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parcel_id")
	private Integer parcelId;
	
	@Column(name = "parcel_type", nullable = false)
	private String parcelType;
	
	@Column(name = "parcel_number", nullable = false)
	private String parcelNumber;
	
	@Column(nullable = false)
	private Double weight;
	
	@Column(name = "delivery_fees", nullable = false)
	private Double deliveryFees;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parcel_sender_id", referencedColumnName = "parcel_sender_id")
	private ParcelSender parcelSender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parcel_receiver_id", referencedColumnName = "parcel_receiver_id")
	private ParcelReceiver percelReceiver;
	
	@OneToOne(mappedBy = "parcel")
	private OrderDetail orderDetail;
	
	public Parcel() {
		
	}
	
	public Parcel(String parcelType, String parcelNumber, double weight) {
		this.parcelType = parcelType;
		this.parcelNumber = parcelNumber;
		this.weight = weight;
	}

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public String getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDeliveryFees() {
		return deliveryFees;
	}
	
	public void setDeliveryFees(double weight) {
		
		if (weight <= 0.5 && weight > 0) {
			this.deliveryFees = 10.2;
		} else if (weight > 0.5 && weight < 1.2) {
			this.deliveryFees = 15.2;
	    } else if (weight > 1.2 && weight < 2.0) {
	    	this.deliveryFees = 18.0;
	    } else if (weight > 2.0 && weight < 5.0) {
	    	this.deliveryFees = 25.0;
	    } else if (weight > 5.0) {
	    	this.deliveryFees = 35.0;
	    }
   }

	public ParcelSender getParcelSender() {
		return parcelSender;
	}

	public void setParcelSender(ParcelSender parcelSender) {
		this.parcelSender = parcelSender;
	}

	public ParcelReceiver getPercelReceiver() {
		return percelReceiver;
	}

	public void setPercelReceiver(ParcelReceiver percelReceiver) {
		this.percelReceiver = percelReceiver;
	}
	
	
}
