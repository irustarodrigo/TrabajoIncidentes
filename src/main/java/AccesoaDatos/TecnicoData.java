/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoaDatos;

import Entidades.Tecnico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RodrigoI
 */
//En esta clase pongo todos los metodos que comunican con la base de datos, usando la controladora de persistencia de jpa
//de tecnicos
public class TecnicoData {
ControladoraPersistencia cPers=new ControladoraPersistencia();

public void guardarTecnico(Tecnico tecnico){
    cPers.guardarTecnico(tecnico);
    

}
public List<Tecnico> buscarTecnico(){
    
    return cPers.buscarTecnico();
    
    
}
  public Tecnico buscarTecId(int id){
    return cPers.buscarTecId(id);
    
  }
  public void modificarTecnico(Tecnico tecnico){
      cPers.modificarTecnico(tecnico);
  }
    
    
}
