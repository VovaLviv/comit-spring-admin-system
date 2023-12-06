package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Parcel;
import org.comit.spring.entity.ParcelSender;
import org.comit.spring.entity.ParcelReceiver;
import org.comit.spring.repository.ParcelRepo;
import org.comit.spring.service.ParcelReceiverService;
import org.comit.spring.service.ParcelSenderService;
import org.comit.spring.service.ParcelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepo parcelRepo;
    private final ParcelSenderService parcelSenderService;
    private final ParcelReceiverService parcelReceiverService;

	public ParcelServiceImpl(ParcelRepo parcelRepo, ParcelSenderService parcelSenderService,
			ParcelReceiverService parcelReceiverService) {
		this.parcelRepo = parcelRepo;
		this.parcelSenderService = parcelSenderService;
		this.parcelReceiverService = parcelReceiverService;
	}


	@Override
	public Parcel findById(int id) {
		return parcelRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}


	@Override
	public List<Parcel> findAll() {
		return parcelRepo.findAll();
	}

	@Override
	public Parcel save(Parcel parcel) {
		
		parcel.setDeliveryFees(parcel.getWeight());
		
        return parcelRepo.save(parcel);
	}

	@Override
	@Transactional
	public Parcel updateById(Parcel parcel, int id) {
		
		Parcel foundedParcel = findById(id);
		foundedParcel.setParcelType(parcel.getParcelType());
		foundedParcel.setParcelNumber(parcel.getParcelNumber());
		foundedParcel.setWeight(parcel.getWeight());
		foundedParcel.setDeliveryFees(parcel.getWeight());
		
		return foundedParcel;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		Parcel foundedParcel = findById(id);
		
		if(foundedParcel != null) {
			parcelRepo.deleteById(id);;
		}
		
	}

	@Override
	@Transactional
	public Parcel addParcelSenderToParcel(int parcelId, int parcelSenderId) {
		
		Parcel foundedParcel = findById(parcelId);
		ParcelSender foundedParcelSender = parcelSenderService.findById(parcelSenderId);
		
		foundedParcel.setParcelSender(foundedParcelSender);
		
		return save(foundedParcel);
	}


	@Override
	@Transactional
	public Parcel addParcelReceiverToParcel(int parcelId, int parcelReceiverId) {
		
		Parcel foundedParcel = findById(parcelId);
		ParcelReceiver foundedParcelReceiver = parcelReceiverService.findById(parcelReceiverId);
		
		foundedParcel.setPercelReceiver(foundedParcelReceiver);
		
		return save(foundedParcel);
	}
}


