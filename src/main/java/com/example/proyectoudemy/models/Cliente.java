package com.example.proyectoudemy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// implementar seriallizable es importante porque se trabaja con serelizacioones , el proceso de convertir un objeto en secuencia de bytes
// para alamacenarlo a la memoria(BBDD) Es recomendable
@Entity
@Table(name = "cliente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    // Para que se guarde en la BBDD como una fecha
    @Temporal(TemporalType.DATE)
    private Date createAt;

}