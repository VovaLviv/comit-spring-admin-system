package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.ParcelReceiver;
import org.comit.spring.service.ParcelReceiverService;
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
@RequestMapping(value = "/api/parcel_receivers")
public class ParcelReceiverController {

	private final ParcelReceiverService parcelRecieverService;

	public ParcelReceiverController(ParcelReceiverService parcelRecieverService) {
		this.parcelRecieverService = parcelRecieverService;
	}

	@GetMapping
    public List<ParcelReceiver> findAll() {
        return parcelRecieverService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ParcelReceiver> findById(@PathVariable("id") int id) {
		ParcelReceiver foundedParcelReceiver = parcelRecieverService.findById(id);
        return new ResponseEntity<>(foundedParcelReceiver, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<ParcelReceiver> save(@RequestBody ParcelReceiver parcelReceiver) {
		ParcelReceiver parcelReceiverSaved = parcelRecieverService.save(parcelReceiver);

        return new ResponseEntity<>(parcelReceiverSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<ParcelReceiver> updateById(@PathVariable("id") int id,
                                                     @RequestBody ParcelReceiver parcelReceiver) {
		
		ParcelReceiver parcelReceiverUpdated = parcelRecieverService.updateById(parcelReceiver, id);
		
		return new ResponseEntity<>(parcelReceiverUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		parcelRecieverService.deleteById(id);

        return new ResponseEntity<>("The parcel reciever information has been deleted", HttpStatus.OK);
    }
}
