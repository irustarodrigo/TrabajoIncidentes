/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
/**
 *
 * @author RodrigoI
 */
@Data
@Entity
public class Tecnico implements Serializable {
    @Id    
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idTecnico;
    @Basic
    private String nomApe;
    private String dni;
    private String especialidad;
    private String telefono;
    private String contacto;
    private boolean estado;

    public Tecnico(int idTecnico, String nomApe, String dni, String especialidad, String telefono, String contacto, boolean estado) {
        this.idTecnico = idTecnico;
        this.nomApe = nomApe;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.contacto = contacto;
        this.estado = estado;
    }

    public Tecnico(String nomApe, String dni, String especialidad, String telefono, String contacto, boolean estado) {
        this.nomApe = nomApe;
        this.dni = dni;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.contacto = contacto;
        this.estado = estado;
    }

    public Tecnico() {
    }

   

   



}
