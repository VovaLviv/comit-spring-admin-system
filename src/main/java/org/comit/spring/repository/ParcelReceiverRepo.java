package org.comit.spring.repository;


import org.comit.spring.entity.ParcelReceiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelReceiverRepo extends JpaRepository<ParcelReceiver, Integer> {

}
