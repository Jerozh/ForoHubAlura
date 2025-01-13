package com.jeronimo.foro.domain.usuarios;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarUsuario(
        @NotBlank
        String login,
       @NotBlank
        String clave
) {
}
