/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoaDatos;

import Entidades.Cliente;
import Entidades.Incidente;
import Entidades.Tecnico;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RodrigoI
 */

//en esta clase, se agrupan todos los metodos que comunican las entidades con los metodos create, edit, (Destroy no uso) Find...

public class ControladoraPersistencia {
    ClienteJpaController cliJpa=new ClienteJpaController();
    TecnicoJpaController tecJpa=new TecnicoJpaController();
    IncidenteJpaController incJpa=new IncidenteJpaController();

   public void guardarTecnico(Tecnico tecnico) {
       tecJpa.create(tecnico);
    }
    public List<Tecnico> buscarTecnico(){
       
       return tecJpa.findTecnicoEntities();
       
    }
    public Tecnico buscarTecId(int id){
        return tecJpa.findTecnico(id);
    
    }
    
    public void modificarTecnico(Tecnico tecnico){
        try {
            tecJpa.edit(tecnico);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarCliente(Cliente cliente) {
       cliJpa.create(cliente);
    }
    public List<Cliente> buscarCliente(){
       
       return cliJpa.findClienteEntities();
       
    }
    public Cliente buscarCliId(int id){
        return cliJpa.findCliente(id);
    
    }
    
    public void modificarCliente(Cliente cliente){
        try {
            cliJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public void guardarIncidente(Incidente incidente){
    incJpa.create(incidente);
    
    

}
public List<Incidente> buscarIncidente(){
    
    return incJpa.findIncidenteEntities();
    
    
}
  public Incidente buscarIncId(int id){
    return incJpa.findIncidente(id);
    
  }
  public void modificarIncidente(Incidente incidente){
        try {
            incJpa.edit(incidente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
}
