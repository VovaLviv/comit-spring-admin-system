package org.comit.spring.repository;

import org.comit.spring.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepo extends JpaRepository<Parcel, Integer> {

}
