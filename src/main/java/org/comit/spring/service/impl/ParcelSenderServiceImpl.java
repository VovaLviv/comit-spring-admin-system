package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.ParcelSender;
import org.comit.spring.repository.ParcelSenderRepo;
import org.comit.spring.service.ParcelSenderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParcelSenderServiceImpl implements ParcelSenderService {

    private ParcelSenderRepo parcelSenderRepo;
	
	public ParcelSenderServiceImpl(ParcelSenderRepo parcelSenderRepo) {
		this.parcelSenderRepo = parcelSenderRepo;
	}

	@Override
	public ParcelSender findById(int id) {
		return parcelSenderRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<ParcelSender> findAll() {
		return parcelSenderRepo.findAll();
	}

	@Override
	public ParcelSender save(ParcelSender parcelSender) {
		return parcelSenderRepo.save(parcelSender);
	}

	@Override
	@Transactional
	public ParcelSender updateById(ParcelSender parcelSender, int id) {

		ParcelSender foundedParcelSender = findById(id);
		foundedParcelSender.setFullName(parcelSender.getFullName());
		foundedParcelSender.setCity(parcelSender.getCity());
		foundedParcelSender.setAdress(parcelSender.getAdress());
		foundedParcelSender.setPostalCode(parcelSender.getPostalCode());
		foundedParcelSender.setCellPhone(parcelSender.getCellPhone());
		
		return foundedParcelSender;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		ParcelSender foundedParcelSender = findById(id);
		
		if(foundedParcelSender != null) {
			parcelSenderRepo.deleteById(id);;
		}
		
	}

}
