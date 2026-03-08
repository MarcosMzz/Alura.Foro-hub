package alura.foro.hub.controller;


import alura.foro.hub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity resgitrarTopico(@RequestBody @Valid DatosRegistrarTopico datos, UriComponentsBuilder uriP){
        var topico = new Topico(datos);

        repository.save(topico);

        var uri = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion){

        var page =repository.findAllByActivoTrue(paginacion).map(DatosListaTopico::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            topico.actualizarInformacion(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }

}
