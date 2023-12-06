package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.ParcelSender;
import org.comit.spring.service.ParcelSenderService;
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
@RequestMapping(value = "/api/parcel_senders")
public class ParcelSenderController {

	private ParcelSenderService parcelSenderService;

	public ParcelSenderController(ParcelSenderService parcelSenderService) {
		this.parcelSenderService = parcelSenderService;
	}

	@GetMapping
    public List<ParcelSender> findAll() {
        return parcelSenderService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ParcelSender> findById(@PathVariable("id") int id) {
		ParcelSender foundedParcelSender = parcelSenderService.findById(id);
        return new ResponseEntity<>(foundedParcelSender, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<ParcelSender> save(@RequestBody ParcelSender parcelSender) {
		ParcelSender parcelSenderSaved = parcelSenderService.save(parcelSender);

        return new ResponseEntity<>(parcelSenderSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<ParcelSender> updateById(@PathVariable("id") int id,
                                                   @RequestBody ParcelSender parcelSender) {
		
		ParcelSender parcelSenderUpdated = parcelSenderService.updateById(parcelSender, id);
		
		return new ResponseEntity<>(parcelSenderUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		parcelSenderService.deleteById(id);

        return new ResponseEntity<>("The parcel sender information has been deleted", HttpStatus.OK);
    }
}
