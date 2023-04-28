package com.msvc.usuario.external.services;

import com.msvc.usuario.entity.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "CALIFICACIONES")
public interface CalificacionService {

    @PostMapping
    public ResponseEntity<Calificacion> save(Calificacion calificacion);

    @PostMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Calificacion> update(@PathVariable String calificacionId, Calificacion calificacion);

    @DeleteMapping("/calificaciones/{calificacionId}")
    public void delete(@PathVariable String calificacionId);
}
