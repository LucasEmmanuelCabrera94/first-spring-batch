package com.example.demospringbatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Builder
@SuppressWarnings("restriction")
@XmlRootElement(name = "persona")
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String dni;


    public Persona(Long id, String primerNombre, String segundoNombre, String dni) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.dni = dni;
    }

    public Persona() {
    }
    @XmlElement
    public String getPrimerNombre() {
        return primerNombre;
    }

    @XmlElement
    public String getSegundoNombre() {
        return segundoNombre;
    }

    @XmlElement
    public String getDni() {
        return dni;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlElement
    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    @Override
    public String toString() {
        return "Persona{" +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
