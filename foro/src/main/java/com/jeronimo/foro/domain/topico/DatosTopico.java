package com.jeronimo.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosTopico(

        @NotBlank
         String titulo,
        @NotBlank
         String mensaje,
        @NotNull
        boolean status,
        @NotBlank
         String autor,
        @NotBlank
         String curso
         ) {
}
