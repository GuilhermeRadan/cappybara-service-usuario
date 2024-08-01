package com.br.cappybaramicroserviceusuario.controller;

import com.br.cappybaramicroserviceusuario.dto.RegistroDTO;
import com.br.cappybaramicroserviceusuario.model.Usuario;
import com.br.cappybaramicroserviceusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @CrossOrigin("*")
    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody RegistroDTO registroDTO){
        return usuarioService.cadastrar(registroDTO);
    }


}
