/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoincidentes;

import AccesoaDatos.TecnicoData;
import Entidades.Tecnico;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author RodrigoI
 */
public class MenuTecnicos {
   static TecnicoData td=new TecnicoData();
   static Scanner leer2=new Scanner(System.in);
   public static void menuTecnicos(){
        
    int opcion;
    Varios.menuOpTecnicos();
        System.out.print("Ingrese una opcion del menu tecnicos:");
        opcion=leer2.nextInt();
        System.out.println("Valor de la opcion elegida: "+opcion);
        while (opcion!=4){
            
            switch (opcion){
                case 1:
                    altaTecnico();
                    break;
                case 2:
                    bajaTecnico();
                    break;
                case 3:
                    modificaTecnico();
                    break;
                case 4:
                    opcion=4;
                    break;
            }
       Varios.menuOpTecnicos();     
       System.out.print("Ingrese una opcion del menu tecnicos:");
       opcion=leer2.nextInt(); 
        }
       
            
        
       //System.out.println("aprete 4 salgo del while");
    
    
    
    
}
   
public static void altaTecnico(){
      
    Scanner leer3=new Scanner(System.in);
    System.out.println("ALTA DE TECNICOS");
    //HAGO QUE EL USUARIO INGRESE POR CONSOLA TODOS LOS DATOS Y LOS GUARDO EN VARIABLES ACORDE
    String nomApe;
    String dni;
    String especialidad=null;
    String telefono;
    String contacto;
    boolean estado;
    System.out.print("Ingrese Nombre y Apellido: ");
    nomApe=leer3.nextLine();
    System.out.print("Ingrese el DNI: ");
    dni=leer3.nextLine();
    
    System.out.println("Elija una Especialidad de las siguientes:");
    System.out.println("1- SISTEMAS OPERATIVOS");
    System.out.println("2- SOFTWARE GENERAL");
    System.out.println("3- HARDWARE GENERAL");
    System.out.println("4- REDES");
    int opcion2=leer3.nextInt();
    while (opcion2<1 || opcion2>4){
        System.out.println("Debe elegir una de las opciones propuestas");
        System.out.print("Intente nuevamente... elija opcion 1,2,3 o 4...:");
        opcion2=leer3.nextInt();
    }
    switch (opcion2){
        case 1:
            especialidad="SO";
            break;
        case 2:
            especialidad="SOFTWARE";
            break;
        case 3:
            especialidad="HARDWARE";
            break;
        case 4:
            especialidad="REDES";
            break;
         
    }
    leer3.nextLine();
    System.out.print("Ingrese el teléfono:");
    telefono=leer3.nextLine();
    
    System.out.print("Ingrese mail u otro medio de contacto:");
    contacto=leer3.nextLine();
    
    estado=true;
    //CREO UN NUEVO OBJETO DE TIPO TECNICO Y LE PASO TODOS LOS DATOS EXCEPTO EL ID QUE SE VA A GENERAR SOLO EN LA BD
    Tecnico nuevoTec=new Tecnico(nomApe, dni, especialidad,telefono,contacto,estado);
    //UTILIZO EL METODO DE JPA (CREATE)QUE ESTA INCLUIDO EN GUARDARTECNICO()
    td.guardarTecnico(nuevoTec);
    System.out.println("TECNICO GUARDADO EN LA BASE DE DATOS CON EXITO");
   
}
 
public static void bajaTecnico(){
Scanner leer=new Scanner(System.in);
    Tecnico tecBaja=new Tecnico();
    System.out.println("BAJA LOGICA DE TECNICOS POR DNI");
    System.out.println("Ingrese el Dni:");
    String dni=leer.nextLine();
    
    //USANDO JPA FINDENTITIES TRAIGO UNA LISTA DE TODOS LOS TECNICOS
    
    ArrayList<Tecnico> listado=(ArrayList<Tecnico>) td.buscarTecnico();
    
    //USANDO STREAMS FILTRO PARA ENCONTRAR EL TECNICO CUYO DNI ES IGUAL AL QUE INGRESÓ EL USUARIO
    Optional<Integer> idTec = listado.stream().filter(tecnico -> tecnico.getDni().equals(dni)).map(Tecnico::getIdTecnico).findFirst();
    if (idTec.isPresent()) {
            Integer id = idTec.get();
            int idBuscar=id.intValue();
            tecBaja=td.buscarTecId(idBuscar);
            tecBaja.setEstado(false);
            // USANDO JPA (EDIT) CAMBIO EL CAMPO ESTADO DE TRUE A FALSE PARA INDICAR QUE ESE TECNICO SE HA DADO DE BAJA
            td.modificarTecnico(tecBaja);
            System.out.println("SE HA INACTIVADO EL TECNICO....");
           
        } else {
            System.out.println("El Dni no corresponde a ningun tecnico");
        }
   
}
public static void modificaTecnico(){
    //EN ESTE METODO, Y SIGUIENDO LA LOGICA DE LOS METODOS ANTERIORES
    //EL USUARIO INGRESA UN DNI, RECORRO LA LISTA DE TECNICOS HASTA ENCONTRAR EL TECNICO CORRECTO
    //VOY MOSTRANDO LOS DATOS Y PIDIENDO AL USUARIO QUE INGRESE LOS DATOS NUEVOS PARA CADA CASO.
    //LUEGO SE GUARDAN LOS CAMBIOS EN LA BASE DE DATOS
    
    String nomApe;
    String Mdni;
    String especialidad=null;
    String telefono;
    String contacto;
    boolean estado;
Scanner leer=new Scanner(System.in);
    Tecnico tecModi=new Tecnico();
    System.out.println("MODIFICACION DE DATOS DE TECNICO X DNI");
    System.out.println("Ingrese el Dni:");
    String dni=leer.nextLine();
     ArrayList<Tecnico> listado=(ArrayList<Tecnico>) td.buscarTecnico();
    Optional<Integer> idTec = listado.stream().filter(tecnico -> tecnico.getDni().equals(dni)).map(Tecnico::getIdTecnico).findFirst();
    if (idTec.isPresent()) {
            Integer id = idTec.get();
            int idBuscar=id.intValue();
            tecModi=td.buscarTecId(idBuscar);
            System.out.println("Nombre y Apellido actual: "+tecModi.getNomApe());
            System.out.println("Ingrese Nuevo nombre y apellido: ");
            nomApe=leer.nextLine();
            System.out.println("Dni Actual: "+tecModi.getDni());
            System.out.println("Ingrese Nuevo DNI:");
            Mdni=leer.nextLine();
            System.out.println("Especialidad Actual: "+ tecModi.getEspecialidad());
            
            System.out.println("Elija una Especialidad de las siguientes:");
            System.out.println("1- SISTEMAS OPERATIVOS");
            System.out.println("2- SOFTWARE GENERAL");
            System.out.println("3- HARDWARE GENERAL");
            System.out.println("4- REDES");
            int opcion2=leer.nextInt();
            while (opcion2<1 || opcion2>4){
                System.out.println("Debe elegir una de las opciones propuestas");
                System.out.print("Intente nuevamente... elija opcion 1,2,3 o 4...:");
                opcion2=leer.nextInt();
            }
            switch (opcion2){
                case 1:
                    especialidad="SO";
                    break;
                case 2:
                    especialidad="SOFTWARE";
                    break;
                case 3:
                    especialidad="HARDWARE";
                    break;
                case 4:
                    especialidad="REDES";
                    break;
         
              }
            
            System.out.println("Telefono Actual: "+tecModi.getTelefono());
            System.out.print("Ingrese el nuevo teléfono:");
            telefono=leer.nextLine();
            
            System.out.println("Mail u contacto alternativo Actual:"+tecModi.getContacto());
            System.out.print("Ingrese Nuevo mail u otro medio de contacto:");
            contacto=leer.nextLine();
            
            estado=tecModi.isEstado();
            if (estado==true){
                System.out.println("El estado Actual es ACTIVO, desea cambiarlo a Inactivo? ingrese SI o NO");
                String opcion=leer.nextLine().toUpperCase();
                if (opcion.equals("SI")) {
                    estado=false;
                    System.out.println("Se ha cambiado el estado a INACTIVO, lo que equivale a una Baja Logica");
                }
                else {
                    System.out.println("El estado continuará siendo ACTIVO");
                }
                
                }else {
                System.out.println("El estado Actual es INACTIVO, desea cambiarlo a ACTIVO? ingrese SI o NO");
                String opcion=leer.nextLine().toUpperCase();
                if (opcion.equals("SI")) {
                    estado=true;
                    System.out.println("Se ha cambiado el estado a ACTIVO");
                }
                else {
                    System.out.println("El estado continuará siendo INACTIVO");
                }
                
            }
          
            tecModi.setNomApe(nomApe);
            tecModi.setDni(Mdni);
            tecModi.setEspecialidad(especialidad);
            tecModi.setTelefono(telefono);
            tecModi.setContacto(contacto);
            tecModi.setEstado(estado);
            td.modificarTecnico(tecModi);
            System.out.println("CAMBIOS REALIZADOS CON EXITO");    
            }
            
            
            
}
public static void ListarTecnicos(){
    
    //ESTE METODO TRAE UNA LISTA DE TODOS LOS TECNICOS Y LUEGO MUESTRA LOS DATOS QUE QUIERO
    Scanner leer=new Scanner (System.in);
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("**** LISTADO GENERAL DE TECNICOS ****");
    System.out.println("--------------------------------------------------------------------------");
    ArrayList<Tecnico> listado=(ArrayList<Tecnico>) td.buscarTecnico();
    System.out.println(listado.stream().toString());
    listado.stream().forEach((tecs)-> System.out.println("| N.& Apellido: " + tecs.getNomApe()
    + " | DNI: " + tecs.getDni()
    + " | Espec: " + tecs.getEspecialidad()
    + " | Tel: " + tecs.getTelefono()
    + " | Cto: "+ tecs.getContacto()) );
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("PRESIONE ENTER PARA VOLVER AL MENU PRINCIPAL");
    leer.nextLine();
    
    
    
    
    


}

}

