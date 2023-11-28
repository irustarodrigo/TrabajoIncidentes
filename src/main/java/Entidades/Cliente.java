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
public class Cliente implements Serializable {
@Id    
@GeneratedValue(strategy=GenerationType.AUTO)
private int idCliente;
@Basic
private String razonSocial;
private String cuit;
private String telefono;
private String contacto;
private String servicio;
private boolean estado;

    public Cliente(String razonSocial, String cuit, String telefono, String contacto, String servicio, boolean estado) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.telefono = telefono;
        this.contacto = contacto;
        this.servicio = servicio;
        this.estado = estado;
    }

    public Cliente() {
    }

   
}
