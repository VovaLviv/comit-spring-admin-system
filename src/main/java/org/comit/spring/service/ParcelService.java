package org.comit.spring.service;

import org.comit.spring.entity.Parcel;

public interface ParcelService extends GenericService<Parcel> {
	
	Parcel addParcelSenderToParcel(int parcelId, int parcelSenderId);
	
	Parcel addParcelReceiverToParcel(int parcelId, int parcelReceiverId);

}
