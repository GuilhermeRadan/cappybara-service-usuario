package com.br.cappybaramicroserviceusuario.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.br.cappybaramicroserviceusuario.controller.UsuarioController;
import com.br.cappybaramicroserviceusuario.dto.AuthDTO;
import com.br.cappybaramicroserviceusuario.model.Usuario;
import com.br.cappybaramicroserviceusuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class AutenticacaoService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
   @Autowired
    public AutenticacaoService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findUsuarioByEmail(email);
    }

    public String obterToken(AuthDTO authDTO){

        Usuario usuario = usuarioRepository.findUsuarioByEmail(authDTO.getEmail());
        return gerarToken(usuario);
    }

    public String gerarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            return JWT.create()
                    .withIssuer("Cappybara-service-usuario")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token ! " +  exception.getMessage());
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validaTokenJWT(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret");
            return JWT.require(algorithm)
                    .withIssuer("Cappybara-service-usuario")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch(JWTVerificationException exception){

            return "Token com problema";
        }
    }


}
