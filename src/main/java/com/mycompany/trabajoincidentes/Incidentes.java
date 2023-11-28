/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoincidentes;

import AccesoaDatos.IncidenteData;
import Entidades.Cliente;
import Entidades.Incidente;
import Entidades.Tecnico;
import static com.mycompany.trabajoincidentes.MenuClientes.cd;
import static com.mycompany.trabajoincidentes.MenuTecnicos.td;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author RodrigoI
 */
public class Incidentes {

public static void altaIncidente(){
    Date fechaRes = null;
    Scanner leer=new Scanner(System.in);
    Cliente incCli=new Cliente();
    Tecnico incTec=new Tecnico();
    Incidente nuevoInc=new Incidente();
    IncidenteData iData=new IncidenteData();    
    ArrayList<Cliente> listado=(ArrayList<Cliente>) cd.buscarCliente();
    System.out.println("****INGRESO DE INCIDENTES*****");
    System.out.println("****IDENTIFICACION DE CLIENTE****");
    System.out.println("----------------------------------");
    System.out.println("Ingrese CUIT del Cliente (sin guiones):");
    String cuit=leer.nextLine();
    
    Optional<Integer> idCli = listado.stream().filter(cliente -> cliente.getCuit().equals(cuit)).map(Cliente::getIdCliente).findFirst();
    if (idCli.isPresent()) {
            Integer id = idCli.get();
            int idBuscar=id.intValue();
            incCli=cd.buscarCliId(idBuscar);
            System.out.println("CLIENTE ENCONTRADO: Razon social:"+incCli.getRazonSocial());
            System.out.println("SERVICIO CONTRATADO:"+incCli.getServicio());
    
}else{
        System.out.println("Ese cliente No existe");
    }
    System.out.println("ELIJA UN TECNICO: (solo se mostraran los técnicos Activos, adecuados al servicio Contratado:");
    String servicio=incCli.getServicio();
    
    if (servicio.equals("MANTENIMIENTO SO")){ 
        final String espec1="SO";
        ArrayList<Tecnico> listadoT=(ArrayList<Tecnico>) td.buscarTecnico();
    List<Tecnico> tecnicosFiltrados = listadoT.stream()
                .filter(tecnico -> tecnico.getEspecialidad().equals(espec1) && tecnico.isEstado())
                .collect(Collectors.toList());
    tecnicosFiltrados.forEach(tecnico -> System.out.println("| ID: " + tecnico.getIdTecnico()
            + " | N.& Ape " + tecnico.getNomApe()
            + " | Especialidad: " + tecnico.getEspecialidad() ));
    }else {
        if (servicio.equals("MANTENIMIENTO SOFTWARE VS")){
        final String espec2="SOFTWARE";
         ArrayList<Tecnico> listadoT=(ArrayList<Tecnico>) td.buscarTecnico();
    List<Tecnico> tecnicosFiltrados = listadoT.stream()
                .filter(tecnico -> tecnico.getEspecialidad().equals(espec2) && tecnico.isEstado())
                .collect(Collectors.toList());
    tecnicosFiltrados.forEach(tecnico -> System.out.println(tecnico.getNomApe() + " id:" + tecnico.getIdTecnico() + " especialidad: " + tecnico.getEspecialidad() ));
        }
        else {
            if (servicio.equals("MANTENIMIENTO EQUIPOS")){
            final String espec3="HARDWARE";
             ArrayList<Tecnico> listadoT=(ArrayList<Tecnico>) td.buscarTecnico();
    List<Tecnico> tecnicosFiltrados = listadoT.stream()
                .filter(tecnico -> tecnico.getEspecialidad().equals(espec3) && tecnico.isEstado() )
                .collect(Collectors.toList());
    tecnicosFiltrados.forEach(tecnico -> System.out.println(tecnico.getNomApe() + " id:" + tecnico.getIdTecnico() + " especialidad: " + tecnico.getEspecialidad() ));
            }else {
    
    if (servicio.equals("MANTENIMIENTO CONEX Y REDES")){
        final String espec4="REDES";
         ArrayList<Tecnico> listadoT=(ArrayList<Tecnico>) td.buscarTecnico();
    List<Tecnico> tecnicosFiltrados = listadoT.stream()
                .filter(tecnico -> tecnico.getEspecialidad().equals(espec4) && tecnico.isEstado())
                .collect(Collectors.toList());
       tecnicosFiltrados.forEach(tecnico -> System.out.println(tecnico.getNomApe() + " id:" + tecnico.getIdTecnico() + " especialidad: " + tecnico.getEspecialidad() ));
    }
            }        
    
            }
            }
    
    
    System.out.println("Elija y tipee el Id del Técnico que se ocupará del incidente:");   
    int idElegido=leer.nextInt();
    leer.nextLine();
    incTec=td.buscarTecId(idElegido);
    System.out.println("Ingrese una fecha probable de resolucion del problema: dd/mm/aaaa");
    String stFechaRes=leer.nextLine();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 
    try {
        fechaRes=formatoFecha.parse(stFechaRes);
    } catch (ParseException ex) {
        System.out.println("Fecha ingresada Incorrectamente");
    }
    
    
            System.out.println("Elija una dificultad para el Incidente");
            System.out.println("1- DIFICULTAD BAJA");
            System.out.println("2- DIFICULTAD MEDIA");
            System.out.println("3- DIFICULTAD ALTA");
            System.out.println("4- EXTREMADAMENTE COMPLEJO, REQUIERE MAS HORAS");
            int opcion2=leer.nextInt();
            while (opcion2<1 || opcion2>4){
                System.out.println("Debe elegir una de las opciones propuestas");
                System.out.print("Intente nuevamente... elija opcion 1,2,3 o 4...:");
                opcion2=leer.nextInt();
            }
            String dificultad = null;
            switch (opcion2){
                case 1:
                    dificultad="BAJA";
                    break;
                case 2:
                    dificultad="MEDIA";
                    break;
                case 3:
                    dificultad="ALTA";
                    break;
                case 4:
                   dificultad ="COMPLEJA";
                    break;
         
              }
            
LocalDate fecha=LocalDate.now();
Date fechaRegistro= Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
nuevoInc.setCliente(incCli);
nuevoInc.setTecnico(incTec);
nuevoInc.setDificultad(dificultad);
nuevoInc.setFechaRegistro(fechaRegistro);
nuevoInc.setFechaEstimada(fechaRes);
nuevoInc.setEstado(true);
iData.guardarIncidente(nuevoInc);
    System.out.println("SE HA REGISTRADO EL INCIDENTE.... LA SIGUIENTE INFORMACION HA SIDO ENVIADA");
    System.out.println("AL TECNICO DE " + incTec.getEspecialidad() + "  " + incTec.getNomApe() + " a su Telefono: " + incTec.getTelefono());
    System.out.println("TAMBIEN SE HA ENVIADO UNA COPIA DE ESTE RESUMEN A : "+ incTec.getContacto());
    System.out.println("---------------------------------------------------------------");        
    System.out.println("CLIENTE QUE SE COMUNICÓ A LA MESA DE AYUDA: "+ incCli.getRazonSocial());
    System.out.println("SERVICIO CONTRATADO: " + incCli.getServicio());
    System.out.println("FECHA DE INGRESO DE INCIDENTE: "+nuevoInc.getFechaRegistro().toString());
    System.out.println("DIFICULTAD A PRIORI DEL INCIDENTE: "+ nuevoInc.getDificultad());
    System.out.println("FECHA ESTIMADA DE RESOLUCION DEL INCIDENTE: "+ nuevoInc.getFechaEstimada().toString());
    System.out.println("----------------------------------------------------------------");
    System.out.println("ESTA INFORMACION HA SIDO ENVIADA AL TELEFONO DEL CLIENTE: " +incCli.getTelefono());
    System.out.println("Y UNA COPIA AL CONTACTO: "+incCli.getContacto());
    System.out.println("PRESIONE ENTER PARA VOLVER AL MENU PRINCIPAL");
    leer.nextLine();
    leer.nextLine();
    
    
    
    
    
    
}
public static void listarIncAct(){
Scanner leer=new Scanner(System.in);
    IncidenteData iData=new IncidenteData();
ArrayList<Incidente> listadoI=(ArrayList<Incidente>) iData.buscarIncidente();
System.out.println("------------------------------------------------------------------");
    System.out.println("******** LISTADO DE INCIDENTES ACTIVOS ***************************");    
List<Incidente> incidentesActivos = listadoI.stream()
                .filter(incidente -> incidente.isEstado())
                .collect(Collectors.toList());
    incidentesActivos.forEach(incidente -> System.out.println("|ID: " + incidente.getIdIncidente() + " | Fecha Registro: " + incidente.getFechaRegistro() + " | Cliente: " + incidente.getCliente().getRazonSocial() + " | Tecnico: " + incidente.getTecnico().getNomApe() + " | Fecha estidama resolucion: " +incidente.getFechaEstimada() ));
    System.out.println("---------------------------------------------------------------");
    System.out.println("PRESIONE ENTER PARA CONTINUAR");
    leer.nextLine();
    

}
public static void finalizarIncidente(){
    IncidenteData iData=new IncidenteData();
    Incidente modInc=new Incidente();
    Scanner leer=new Scanner (System.in);
    listarIncAct();
    System.out.println("ELIJA UN INCIDENTE ACTIVO PARA MARCAR COMO RESUELTO: DEBE TIPEAR EL ID:");
    int idInc=leer.nextInt();
    modInc=iData.buscarIncId(idInc);
    modInc.setEstado(false);
    iData.modificarIncidente(modInc);
    System.out.println("EL INCIDENTE HA SIDO RESUELTO..... Presione ENTER para volver al menu Principal" );
    leer.nextLine();
    leer.nextLine();
    
    
    
    
    


}
public static void listarIncRes(){
Scanner leer=new Scanner(System.in);
    IncidenteData iData=new IncidenteData();
    System.out.println("");    
    System.out.println("------------------------------------------------------------------");
    System.out.println("******** LISTADO DE INCIDENTES RESUELTOS *************************");
ArrayList<Incidente> listadoI=(ArrayList<Incidente>) iData.buscarIncidente();
    List<Incidente> incidentesActivos = listadoI.stream()
                .filter(incidente -> !incidente.isEstado())
                .collect(Collectors.toList());
    incidentesActivos.forEach(incidente -> System.out.println("|ID: " + incidente.getIdIncidente() + " | Fecha Registro: " + incidente.getFechaRegistro() + " | Cliente: " + incidente.getCliente().getRazonSocial() + " | Tecnico: " + incidente.getTecnico().getNomApe() + " | Fecha estidama resolucion: " +incidente.getFechaEstimada() ));
    System.out.println("-------------------------------------------------------------------");
    System.out.println("PRESIONE ENTER PARA CONTINUAR");
    leer.nextLine();
    

}

public static void tecnicoMasUsado(){
Scanner leer=new Scanner (System.in);
    IncidenteData iData=new IncidenteData();
List<Incidente> listadoI=iData.buscarIncidente();
Map<Tecnico, Long> conteoIdTecnico = listadoI.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

Tecnico tecnicoMasUsado = conteoIdTecnico.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("El Tencico con mas incidentes asignados es: " + tecnicoMasUsado.getNomApe() + " De Especialidad: " +tecnicoMasUsado.getEspecialidad());
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("PRESIONE ENTER PARA VOLVER AL MENU ANTERIOR");
    leer.nextLine();
}
    
    
    







}


    