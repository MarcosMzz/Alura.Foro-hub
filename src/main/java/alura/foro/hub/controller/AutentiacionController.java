package alura.foro.hub.controller;

import alura.foro.hub.domain.usuario.DatosAutentiacion;
import alura.foro.hub.domain.usuario.Usuario;
import alura.foro.hub.infra.security.DatosTokenJWT;
import alura.foro.hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutentiacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutentiacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());

        var autentacion = manager.authenticate(authenticationToken);

        var TokenJWT = tokenService.generarToken((Usuario) autentacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(TokenJWT));
    }
}
