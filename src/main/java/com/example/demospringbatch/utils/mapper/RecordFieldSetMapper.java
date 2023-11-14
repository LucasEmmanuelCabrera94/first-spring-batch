package com.example.demospringbatch.utils.mapper;

import com.example.demospringbatch.model.Persona;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.context.properties.bind.BindException;

public class RecordFieldSetMapper implements FieldSetMapper<Persona> {

    public Persona mapFieldSet(FieldSet fieldSet) throws BindException {
        Persona persona = new Persona();

        persona.setID(fieldSet.readLong("id"));
        persona.setPrimerNombre(fieldSet.readString("primerNombre"));
        persona.setSegundoNombre(fieldSet.readString("segundoNombre"));
        persona.setDni(fieldSet.readString("dni"));
        return persona;
    }
}
