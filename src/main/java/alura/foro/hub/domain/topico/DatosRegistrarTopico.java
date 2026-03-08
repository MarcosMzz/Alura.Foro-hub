package alura.foro.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistrarTopico(
        @NotBlank String titulo,
        @NotBlank String nombreCurso,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fecha
) {
}
