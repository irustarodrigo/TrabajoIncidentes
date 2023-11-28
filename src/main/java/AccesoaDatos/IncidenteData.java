/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoaDatos;

import Entidades.Incidente;
import java.util.List;

/**
 *
 * @author RodrigoI
 */
//En esta clase pongo todos los metodos que comunican con la base de datos, usando la controladora de persistencia de jpa
//de los incidentes
public class IncidenteData {
    ControladoraPersistencia cPers=new ControladoraPersistencia();

public void guardarIncidente(Incidente incidente){
    cPers.guardarIncidente(incidente);
    

}
public List<Incidente> buscarIncidente(){
    
    return cPers.buscarIncidente();
    
    
}
  public Incidente buscarIncId(int id){
    return cPers.buscarIncId(id);
    
  }
   public void modificarIncidente(Incidente incidente){
      cPers.modificarIncidente(incidente);
  }
    
    


}
