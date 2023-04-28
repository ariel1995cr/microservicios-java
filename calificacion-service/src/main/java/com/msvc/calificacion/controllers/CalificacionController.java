package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.service.impl.CalificacionServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionServiceImpl calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> save(@RequestBody Calificacion calificacion)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.save(calificacion));
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> listAll()
    {
        return ResponseEntity.ok(calificacionService.getAll());
    }

    @GetMapping("usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listCalificacionesPorUsuarioId(@PathVariable String usuarioId)
    {
        return ResponseEntity.ok(calificacionService.getCalificacionesByUsuarioId(usuarioId));
    }

    @GetMapping("usuarios/{hotelId}")
    public ResponseEntity<List<Calificacion>> listCalificacionesPorHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(calificacionService.getCalificacionesByHotelId(hotelId));
    }


}
