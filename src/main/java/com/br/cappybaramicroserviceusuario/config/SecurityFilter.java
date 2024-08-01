package com.br.cappybaramicroserviceusuario.config;

import com.br.cappybaramicroserviceusuario.model.Usuario;
import com.br.cappybaramicroserviceusuario.repository.UsuarioRepository;
import com.br.cappybaramicroserviceusuario.service.AutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private AutenticacaoService autenticacaoService;
    private UsuarioRepository usuarioRepository;
    @Autowired
    public SecurityFilter(AutenticacaoService autenticacaoService, UsuarioRepository usuarioRepository){
        this.autenticacaoService = autenticacaoService;
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extraiTokenHeader(request);
        if (token != null){
            String login = autenticacaoService.validaTokenJWT(token);
            Usuario usuario = usuarioRepository.findUsuarioByEmail(login);

            var autentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autentication);
        }
        filterChain.doFilter(request, response);
    }

    public String extraiTokenHeader(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null){
            return null;
        }
        if(!authHeader.split(" ")[0].equals("Bearer")){
            return  null;
        }
        return authHeader.split(" ")[1];
    }
}
