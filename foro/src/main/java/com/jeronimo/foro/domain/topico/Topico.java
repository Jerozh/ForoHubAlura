package com.jeronimo.foro.domain.topico;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Table(name="topicos")
@Entity(name="topico")
@EqualsAndHashCode(of = "id")
public class Topico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private boolean status;
    private String autor;
    private String curso;



    public Topico(DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
    }

    public boolean getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }



    public Topico() {
    }

    public void actualizarTopico(DatosActualizarTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.status = datos.status();
    }
}



