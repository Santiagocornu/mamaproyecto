package com.proyectoMama.proyectoMama.entities.Person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Person")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id_person;

    @Getter @Setter private String nombre_person;
    @Getter @Setter private String apellido_person;
    @Getter @Setter private String telefono_person;

    public Person(String nombre_person, String apellido_person, String telefono_person) {
        this.nombre_person = nombre_person;
        this.apellido_person = apellido_person;
        this.telefono_person = telefono_person;
    }
}
