package alura.foro.hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String nombreCurso;

    private String mensaje;

    private LocalDateTime fecha;

    private boolean activo;

    public Topico(DatosRegistrarTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.fecha = datos.fecha();
        this.nombreCurso = datos.nombreCurso();
        this.mensaje = datos.mensaje();
        this.activo = true;
    }
}
