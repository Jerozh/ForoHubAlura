package com.jeronimo.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        boolean status,

        String autor,

        String curso


) {
}
