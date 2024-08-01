package com.br.cappybaramicroserviceusuario.controller;

import com.br.cappybaramicroserviceusuario.dto.AuthDTO;
import com.br.cappybaramicroserviceusuario.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    private AuthenticationManager authenticationManager;
    private AutenticacaoService autenticacaoService;
    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager, AutenticacaoService autenticacaoService){
        this.authenticationManager = authenticationManager;
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody  AuthDTO authDTO){
        return autenticacaoService.obterToken(authDTO);
    }
    @CrossOrigin("*")
    @GetMapping("/teste")
    @ResponseStatus(HttpStatus.OK)
    public String testeAutorizacao(){

        return "Autorização feita com sucesso!";
    }


}
