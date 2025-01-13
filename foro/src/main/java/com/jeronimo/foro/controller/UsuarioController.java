package com.jeronimo.foro.controller;

import com.jeronimo.foro.domain.usuarios.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping
    public ResponseEntity<Usuario> guardarUnUsuario(@RequestBody @Valid DatosUsuario datosUsuario, UriComponentsBuilder uriComponentsBuilder) {
        String contraseñaEncriptada = passwordEncoder.encode(datosUsuario.clave());

        Usuario usuario = new Usuario(datosUsuario);
        usuario.setClave(contraseñaEncriptada); // Asignamos la contraseña encriptada al usuario

        usuario = usuarioRepository.save(usuario);

        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(url).body(usuario);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> actualizarUsuario(@PathVariable Long id, @RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuario.actualizarUsuario(datosActualizarUsuario);
            return ResponseEntity.ok(new DatosRespuestaUsuario(usuario.getId(), usuario.getLogin(), usuario.getClave()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}