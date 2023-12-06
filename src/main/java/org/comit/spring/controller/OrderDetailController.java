package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.OrderDetail;
import org.comit.spring.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order_details")
public class OrderDetailController {

	private final OrderDetailService orderDetailService;
	
	public OrderDetailController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	@GetMapping
    public List<OrderDetail> findAll() {
        return orderDetailService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<OrderDetail> findById(@PathVariable("id") int id) {
		OrderDetail foundedOrderDetail = orderDetailService.findById(id);
        return new ResponseEntity<>(foundedOrderDetail, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail orderDetail) {
		OrderDetail OrderDetailSaved = orderDetailService.save(orderDetail);

        return new ResponseEntity<>(OrderDetailSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateById(@PathVariable("id") int id,
                                                  @RequestBody OrderDetail orderDetail) {
		
		OrderDetail orderDetailUpdated = orderDetailService.updateById(orderDetail, id);
		
		return new ResponseEntity<>(orderDetailUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		orderDetailService.deleteById(id);

        return new ResponseEntity<>("The order detail information has been deleted", HttpStatus.OK);
    }
	
	@PostMapping(value = "{order_detail_id}/parcel/{parcel_id}/add")
    public ResponseEntity<OrderDetail> addParcelToOrderDetail(@PathVariable("order_detail_id") int orderDetailId,
                                                              @PathVariable("parcel_id") int parcelId){
        OrderDetail orderDetail = orderDetailService.addParcelToOrderDetail(orderDetailId, parcelId);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
	
	@PostMapping(value = "{order_detail_id}/vehicle/{vehicle_id}/add")
    public ResponseEntity<OrderDetail> addVehicleToOrderDetail(@PathVariable("order_detail_id") int orderDetailId,
                                                               @PathVariable("vehicle_id") int vehicleId){
		OrderDetail orderDetail = orderDetailService.addVehicleToOrderDetail(orderDetailId, vehicleId);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
}
