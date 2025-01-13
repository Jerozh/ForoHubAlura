package com.jeronimo.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autor,
        String curso) {


    public DatosListadoTopicos(Topico topico) {
        this(topico.getId()
            ,topico.getTitulo()
            ,topico.getMensaje()
            ,topico.getFechaCreacion()
            ,(topico.getStatus() == true) ? "Tópico Abierto" : "Tópico Cerrado"
            ,topico.getAutor()
            ,topico.getCurso()
            );

        }
}


