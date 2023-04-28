package com.mcvs.hotel.service.impl;

import com.mcvs.hotel.entity.Hotel;
import com.mcvs.hotel.exceptions.ResourceNotFoundException;
import com.mcvs.hotel.repository.IHotelRepository;
import com.mcvs.hotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
       String hotelId = UUID.randomUUID().toString();
       hotel.setId(hotelId);
       return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
       return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con el id" + id));
    }
}
