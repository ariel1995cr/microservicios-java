package com.msvc.calificacion.service.impl;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.repository.CalificacionRepository;
import com.msvc.calificacion.service.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getAll() {
        return calificacionRepository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }
}
