package com.example.demospringbatch.repository;

import com.example.demospringbatch.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertPersona(Persona persona) {
        String sql = "INSERT INTO Persona (dni, primer_nombre, segundo_nombre) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, persona.getDni(), persona.getPrimerNombre(), persona.getSegundoNombre());
    }
}