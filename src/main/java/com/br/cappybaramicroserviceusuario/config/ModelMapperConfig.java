package com.br.cappybaramicroserviceusuario.config;

import com.br.cappybaramicroserviceusuario.dto.RegistroDTO;
import com.br.cappybaramicroserviceusuario.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<RegistroDTO, Usuario>() {
            @Override
            protected void configure() {
                // Ignorando o mapeamento do atributo categoriaEvento que não está no DTO
                skip(destination.getSenha());
            }
        });
        return modelMapper;    }

}

