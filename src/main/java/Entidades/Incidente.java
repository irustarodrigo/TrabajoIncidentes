/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author RodrigoI
 */
@Data
@Entity
public class Incidente implements Serializable {
@Id    
@GeneratedValue(strategy=GenerationType.AUTO)    
private int idIncidente;

@ManyToOne
@JoinColumn(name = "idCliente")
private Cliente cliente;


@ManyToOne
@JoinColumn(name = "idTecnico")
private Tecnico tecnico;

@Basic
private String dificultad;
@Temporal(TemporalType.DATE)
private Date fechaRegistro;
@Temporal(TemporalType.DATE)
private Date fechaEstimada;
@Basic
private boolean estado;    

    public Incidente(int idIncidente, Cliente cliente, Tecnico tecnico, String dificultad, Date fechaRegistro, Date fechaEstimada, boolean estado) {
        this.idIncidente = idIncidente;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.dificultad = dificultad;
        this.fechaRegistro = fechaRegistro;
        this.fechaEstimada = fechaEstimada;
        this.estado = estado;
    }

    public Incidente() {
    }


   
}
