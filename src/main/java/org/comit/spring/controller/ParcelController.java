package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.Parcel;
import org.comit.spring.service.ParcelService;
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
@RequestMapping(value = "/api/parcels")
public class ParcelController {
	
	private ParcelService parcelService;
	
	public ParcelController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}
	
	@GetMapping
    public List<Parcel> findAll() {
        return parcelService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Parcel> findById(@PathVariable("id") int id) {
		Parcel foundedParcel = parcelService.findById(id);
        return new ResponseEntity<>(foundedParcel, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Parcel> save(@RequestBody Parcel parcel) {
		Parcel foundedParcel = parcelService.save(parcel);

        return new ResponseEntity<>(foundedParcel, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Parcel> updateById(@PathVariable("id") int id,
                                             @RequestBody Parcel parcel) {
		
		Parcel foundedParcel = parcelService.updateById(parcel, id);
		
		return new ResponseEntity<>(foundedParcel, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		parcelService.deleteById(id);

        return new ResponseEntity<>("The parcel information has been deleted", HttpStatus.OK);
    }
	
	@PostMapping(value = "{parcel_id}/parcel_sender/{parcel_sender_id}/add")
    public ResponseEntity<Parcel> addParcelSenderToParcel(@PathVariable("parcel_id") int parcelId,
                                                          @PathVariable("parcel_sender_id") int parcelSenderId){
        Parcel parcel = parcelService.addParcelSenderToParcel(parcelId, parcelSenderId);
        return new ResponseEntity<>(parcel, HttpStatus.OK);
    }
	
	@PostMapping(value = "{parcel_id}/parcel_receiver/{parcel_receiver_id}/add")
    public ResponseEntity<Parcel> addParcelReceiverToParcel(@PathVariable("parcel_id") int parcelId,
                                                            @PathVariable("parcel_receiver_id") int parcelReceiverId){
        Parcel parcel = parcelService.addParcelReceiverToParcel(parcelId, parcelReceiverId);
        return new ResponseEntity<>(parcel, HttpStatus.OK);
    }

}
