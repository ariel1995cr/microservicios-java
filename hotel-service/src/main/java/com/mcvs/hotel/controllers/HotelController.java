package com.mcvs.hotel.controllers;

import com.mcvs.hotel.entity.Hotel;
import com.mcvs.hotel.service.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.save(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> list(){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getAll());
    }

    @GetMapping("{hotelId}")
    public ResponseEntity<Hotel> findOne(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));
    }
}
