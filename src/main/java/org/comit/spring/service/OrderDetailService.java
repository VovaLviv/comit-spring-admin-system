package org.comit.spring.service;

import org.comit.spring.entity.OrderDetail;

public interface OrderDetailService extends GenericService<OrderDetail> {
	
    OrderDetail addParcelToOrderDetail(int orderDetailId, int parcelId);
	
    OrderDetail addVehicleToOrderDetail(int orderDetailId, int vehicleId);

}
