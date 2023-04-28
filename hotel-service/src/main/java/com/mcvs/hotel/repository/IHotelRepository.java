package com.mcvs.hotel.repository;

import com.mcvs.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepository extends JpaRepository<Hotel, String> {
}
