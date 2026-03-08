package alura.foro.hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        String titulo,
        String nombreCurso,
        String mensaje
) {
}
