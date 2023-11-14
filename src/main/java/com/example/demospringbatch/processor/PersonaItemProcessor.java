package com.example.demospringbatch.processor;

import com.example.demospringbatch.model.Persona;
import com.example.demospringbatch.repository.PersonaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonaItemProcessor  implements ItemProcessor<Persona, Persona> {

    //para tener logs
    private static final Logger LOG = LoggerFactory.getLogger(PersonaItemProcessor.class);

    @Autowired
    private PersonaDao personaDao;


    @Override
    public Persona process(Persona item) throws Exception {
        //esto lo hago solo para ver un cambio, todo en mayuscula
        Long id = item.getID();
        String primerNombre = item.getPrimerNombre().toUpperCase();
        String segundoNombre = item.getSegundoNombre().toUpperCase();
        String dni = item.getDni();


        Persona persona = Persona.builder()
                .id(id)
                .primerNombre(primerNombre)
                .segundoNombre(segundoNombre)
                .dni(dni)
                .build();


        LOG.info("Convirtiendo ("+item+") a ("+persona+")");

        personaDao.insertPersona(persona);

        return persona;
    }
}
