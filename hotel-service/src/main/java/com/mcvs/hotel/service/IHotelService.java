package com.mcvs.hotel.service;

import com.mcvs.hotel.entity.Hotel;

import java.util.List;

public interface IHotelService {

    Hotel save(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
