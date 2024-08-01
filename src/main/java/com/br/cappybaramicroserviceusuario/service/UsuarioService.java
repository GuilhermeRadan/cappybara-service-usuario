package com.br.cappybaramicroserviceusuario.service;

import com.br.cappybaramicroserviceusuario.dto.RegistroDTO;
import com.br.cappybaramicroserviceusuario.exceptions.RegistroException;
import com.br.cappybaramicroserviceusuario.model.Usuario;
import com.br.cappybaramicroserviceusuario.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    private ModelMapper modelMapper;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(RegistroDTO registroDTO){
        /*Usuario usuarioExiste = usuarioRepository.findUsuarioByEmail(registroDTO.email());
        if(usuarioExiste != null){
            throw new RegistroException("Usuario já existe");
        }*/
        var passwordHash = passwordEncoder.encode(registroDTO.getSenha());
        Usuario usuario = toUsuarioEntity(registroDTO, passwordHash);

        return usuarioRepository.save(usuario);
    }


    public Usuario toUsuarioEntity(RegistroDTO registroDTO, String senha){
        Usuario usuario = modelMapper.map(registroDTO, Usuario.class);
        usuario.setSenha(senha);
        return usuario;
    }


}
