package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.OrderDetail;
import org.comit.spring.entity.Parcel;
import org.comit.spring.entity.Vehicle;
import org.comit.spring.repository.OrderDetailRepo;
import org.comit.spring.service.OrderDetailService;
import org.comit.spring.service.ParcelService;
import org.comit.spring.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	private final OrderDetailRepo orderDetailRepo;
	private final ParcelService parcelService;
	private final VehicleService vehicleService;

	

	public OrderDetailServiceImpl(OrderDetailRepo orderDetailRepo, ParcelService parcelService,
			VehicleService vehicleService) {
		this.orderDetailRepo = orderDetailRepo;
		this.parcelService = parcelService;
		this.vehicleService = vehicleService;
	}

	@Override
	public OrderDetail findById(int id) {
		return orderDetailRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRepo.findAll();
	}

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		return orderDetailRepo.save(orderDetail);
	}

	@Override
	@Transactional
	public OrderDetail updateById(OrderDetail orderDetail, int id) {
		
		OrderDetail foundedOrderDetail = findById(id);
		foundedOrderDetail.setTrackingNumber((int) orderDetail.getTrackingNumber());
		
		return foundedOrderDetail;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		OrderDetail foundedOrderDetail = findById(id);
		
		if(foundedOrderDetail != null) {
			orderDetailRepo.deleteById(id);;
		}
		
	}

	@Override
	@Transactional
	public OrderDetail addParcelToOrderDetail(int orderDetailId, int parcelId) {
		
		OrderDetail foundedOrderDetail = findById(orderDetailId);
		Parcel foundedParcel = parcelService.findById(parcelId);
		
		foundedOrderDetail.setParcel(foundedParcel);
		
		return save(foundedOrderDetail);
	}

	@Override
	@Transactional
	public OrderDetail addVehicleToOrderDetail(int orderDetailId, int vehicleId) {
		
		OrderDetail foundedOrderDetail = findById(orderDetailId);
		Vehicle foundedVehicle = vehicleService.findById(vehicleId);
		
		foundedOrderDetail.setVehicle(foundedVehicle);
		
		return save(foundedOrderDetail);
	}

}
