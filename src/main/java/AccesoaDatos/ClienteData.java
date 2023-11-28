/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoaDatos;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author RodrigoI
 */
public class ClienteData {
    ControladoraPersistencia cPers=new ControladoraPersistencia();

public void guardarCliente(Cliente cliente){
    cPers.guardarCliente(cliente);
    

}
public List<Cliente> buscarCliente(){
    
    return cPers.buscarCliente();
    
    
}
  public Cliente buscarCliId(int id){
    return cPers.buscarCliId(id);
    
  }
  public void modificarCliente(Cliente cliente){
      cPers.modificarCliente(cliente);
  }
    

}
