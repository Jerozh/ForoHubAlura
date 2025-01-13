package com.jeronimo.foro.domain.usuarios;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String clave;



    public Usuario(@Valid DatosUsuario datosUsuario) {
        this.login = datosUsuario.login();
        this.clave = datosUsuario.clave();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));

    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    public void actualizarUsuario(DatosActualizarUsuario datosActualizarUsuario) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String claveEncriptada =passwordEncoder.encode(datosActualizarUsuario.clave());
        this.login = datosActualizarUsuario.login();
        this.clave = claveEncriptada;
    }

    public Usuario() {

    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
