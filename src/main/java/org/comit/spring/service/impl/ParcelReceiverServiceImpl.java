package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.ParcelReceiver;
import org.comit.spring.repository.ParcelReceiverRepo;
import org.comit.spring.service.ParcelReceiverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParcelReceiverServiceImpl implements ParcelReceiverService {
	
	private ParcelReceiverRepo parcelReceiverRepo;
	
	public ParcelReceiverServiceImpl(ParcelReceiverRepo parcelReceiverRepo) {
		this.parcelReceiverRepo = parcelReceiverRepo;
	}

	@Override
	public ParcelReceiver findById(int id) {
		return parcelReceiverRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<ParcelReceiver> findAll() {
		return parcelReceiverRepo.findAll();
	}

	@Override
	public ParcelReceiver save(ParcelReceiver parcelReceiver) {
		return parcelReceiverRepo.save(parcelReceiver);
	}

	@Override
	@Transactional
	public ParcelReceiver updateById(ParcelReceiver parcelReceiver, int id) {

		ParcelReceiver foundedParcelReceiver = findById(id);
		foundedParcelReceiver.setFullName(parcelReceiver.getFullName());
		foundedParcelReceiver.setCity(parcelReceiver.getCity());
		foundedParcelReceiver.setAdress(parcelReceiver.getAdress());
		foundedParcelReceiver.setPostalCode(parcelReceiver.getPostalCode());
		foundedParcelReceiver.setCellPhone(parcelReceiver.getCellPhone());
		
		return foundedParcelReceiver;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		ParcelReceiver foundedParcelReceiver = findById(id);
		
		if(foundedParcelReceiver != null) {
			parcelReceiverRepo.deleteById(id);;
		}
		
	}

}
