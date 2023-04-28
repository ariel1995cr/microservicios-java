package com.msvc.calificacion.service;

import com.msvc.calificacion.entities.Calificacion;

import java.util.List;

public interface ICalificacionService {
    Calificacion save(Calificacion calificacion);

    List<Calificacion> getAll();

    List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionesByHotelId(String hotelId);
}
