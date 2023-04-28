package com.msvc.usuario.service.implementation;

import com.msvc.usuario.entity.Calificacion;
import com.msvc.usuario.entity.Hotel;
import com.msvc.usuario.entity.Usuario;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.external.services.HotelService;
import com.msvc.usuario.repository.IUsuarioRepository;
import com.msvc.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private HotelService hotelService;

    @Override
    public Usuario save(Usuario usuario) {
        String randomUsuarioId = UUID.randomUUID().toString();
        usuario.setUsuarioId(randomUsuarioId);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID " + usuarioId));
        Calificacion[] calificationUser = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaiones/usuarios/"+usuario.getUsuarioId(), Calificacion[].class);


        List<Calificacion> calificaciones = Arrays.stream(calificationUser).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones = calificaciones.stream().map(calificacion -> {
            System.out.println(calificacion.getHotelId());
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hoteles" + calificacion.getHotelId(), Hotel.class);
            //Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(calificacion.getHotelId());
            //logger.info("Respuesta con codigo de estado: {}", forEntity.getStatusCode());
            calificacion.setHotel(hotel);
            return calificacion;
        }).toList();

        usuario.setCalificaciones(listaCalificaciones);
        return usuario;
    }
}
