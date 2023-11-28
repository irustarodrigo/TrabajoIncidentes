/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoincidentes;

import AccesoaDatos.ClienteData;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author RodrigoI
 */
public class MenuClientes {
 static ClienteData cd = new ClienteData();

    
public static void menuClientes(){
    Scanner leer=new Scanner(System.in);
    int opcion;
    System.out.println("");
    System.out.println("");
    Varios.menuOpClientes();
        System.out.print("Ingrese una opcion:");
        opcion=leer.nextInt();
        while (opcion!=4){
            switch (opcion){
                case 1:
                    altaCliente();
                    break;
                case 2:
                    bajaCliente();
                    break;
                case 3:
                    modificaCliente();
                    break;
                    
            }
            
            
       Varios.menuOpClientes();     
       System.out.print("Ingrese una opcion del menu clientes:");
       opcion=leer.nextInt(); 
            
        }
    
    
    
    
    
}
public static void altaCliente(){
      
    Scanner leer3=new Scanner(System.in);
    System.out.println("");
    System.out.println("----------------------------------------------");
    System.out.println("*********ALTA DE Clientes*********************");
  
    String razonSocial;
    String cuit;
    String telefono;
    String contacto;
    String servicio=null;
    boolean estado;
            
    System.out.print("Ingrese Razon Social: ");
    razonSocial=leer3.nextLine();
    System.out.print("Ingrese el CUIT: ");
    cuit=leer3.nextLine();
    
    System.out.print("Ingrese el teléfono:");
    telefono=leer3.nextLine();
    
    System.out.print("Ingrese mail u otro medio de contacto:");
    contacto=leer3.nextLine();
    
    
    System.out.println("Elija uno servicio contratado:");
    System.out.println("1- MANTENIMIENTO DE SISTEMAS VS");
    System.out.println("2- MANTENIMIENTO DE SOFTWARE VS");
    System.out.println("3- MANTENIMIENTO DE EQUIPOS");
    System.out.println("4- MANTENIMIENTO DE CONEXIONES Y REDES");
    int opcion2=leer3.nextInt();
    while (opcion2<1 || opcion2>4){
        System.out.println("Debe elegir una de las opciones propuestas");
        System.out.print("Intente nuevamente... elija opcion 1,2,3 o 4...:");
        opcion2=leer3.nextInt();
    }
    switch (opcion2){
        case 1:
            servicio="MANTENIMIENTO SO";
            break;
        case 2:
            servicio="MANTENIMIENTO SOFTWARE VS";
            break;
        case 3:
            servicio="MANTENIMIENTO EQUIPOS";
            break;
        case 4:
            servicio="MANTENIMIENTO CONEX Y REDES";
            break;
         
    }
   
    estado=true;
    Cliente nuevoCli=new Cliente(razonSocial, cuit,telefono,contacto,servicio,estado);
    cd.guardarCliente(nuevoCli);
    System.out.println("--------------------------------------------------");
    System.out.println("CLIENTE GUARDADO EN LA BASE DE DATOS CON EXITO");
    System.out.println("--------------------------------------------------");
    System.out.println("PRESIONE ENTER PARA VOLVER AL MENU ANTERIOR");
    leer3.nextLine();
    leer3.nextLine();
     
   
}
 
public static void bajaCliente(){
Scanner leer=new Scanner(System.in);
    Cliente cliBaja=new Cliente();
    System.out.println("");
    System.out.println("---------------------------------------------------");
    System.out.println("*******BAJA LOGICA DE CLIENTES POR CUIT************");
    System.out.println("");
    System.out.println("Ingrese el CUIT (sin guiones):");
    String cuit=leer.nextLine();
     ArrayList<Cliente> listado=(ArrayList<Cliente>) cd.buscarCliente();
    Optional<Integer> idCli = listado.stream().filter(cliente -> cliente.getCuit().equals(cuit)).map(Cliente::getIdCliente).findFirst();
    if (idCli.isPresent()) {
            Integer id = idCli.get();
            int idBuscar=id.intValue();
            cliBaja=cd.buscarCliId(idBuscar);
            cliBaja.setEstado(false);
            cd.modificarCliente(cliBaja);
            System.out.println("CLIENTE: " +cliBaja.getRazonSocial() + " DADO DE BAJA CON EXITO (baja logica)");
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("El CUIT no corresponde a ningun Cliente");
        }
        System.out.println("PRESIONE ENTER PARA VOLVER AL MENU ANTERIOR");
        leer.nextLine();
}
public static void modificaCliente(){
    String razonSocial;
    String Mcuit;
    String servicio=null;
    String telefono;
    String contacto;
    boolean estado;
Scanner leer=new Scanner(System.in);
    Cliente cliModi=new Cliente();
    System.out.println("");
    System.out.println("--------------------------------------------------------");
    System.out.println("*******MODIFICACION DE DATOS DE CLIENTE X CUIT**********");
    System.out.println("");
    System.out.println("Ingrese el CUIT (sin guiones):");
    String cuit=leer.nextLine();
    ArrayList<Cliente> listado=(ArrayList<Cliente>) cd.buscarCliente();
    Optional<Integer> idCli = listado.stream().filter(cliente -> cliente.getCuit().equals(cuit)).map(Cliente::getIdCliente).findFirst();
    if (idCli.isPresent()) {
            Integer id = idCli.get();
            int idBuscar=id.intValue();
            cliModi=cd.buscarCliId(idBuscar);
            System.out.println("Razon Social Actual: "+cliModi.getRazonSocial());
            System.out.println("Ingrese Nueva Razon social: ");
            razonSocial=leer.nextLine();
            System.out.println("CUIT Actual: "+cliModi.getCuit());
            System.out.println("Ingrese Nuevo CUIT (sin guiones):");
            Mcuit=leer.nextLine();
            
            System.out.println("Telefono Actual: "+cliModi.getTelefono());
            System.out.print("Ingrese el nuevo teléfono:");
            telefono=leer.nextLine();
            
            System.out.println("Mail u contacto alternativo Actual:"+cliModi.getContacto());
            System.out.print("Ingrese Nuevo mail u otro medio de contacto:");
            contacto=leer.nextLine();
                        
            System.out.println("Servicio Actual contratado: "+ cliModi.getServicio());
            
            System.out.println("Elija una Servicio de los siguientes:");
            System.out.println("1- MANTENIMIENTO DE SISTEMAS VS");
            System.out.println("2- MANTENIMIENTO DE SOFTWARE VS");
            System.out.println("3- MANTENIMIENTO DE EQUIPOS");
            System.out.println("4- MANTENIMIENTO DE CONEXIONES Y REDES");
            int opcion2=leer.nextInt();
            while (opcion2<1 || opcion2>4){
                System.out.println("Debe elegir una de las opciones propuestas");
                System.out.print("Intente nuevamente... elija opcion 1,2,3 o 4...:");
                opcion2=leer.nextInt();
                leer.nextLine();
            }
            switch (opcion2){
                case 1:
                    servicio="MANTENIMIENTO SO";
                    break;
                case 2:
                    servicio="MANTENIMIENTO SOFTWARE VS";
                    break;
                case 3:
                    servicio="MANTENIMIENTO EQUIPOS";
                    break;
                case 4:
                    servicio="MANTENIMIENTO CONEX Y REDES";
                    break;
            }
                      
            estado=cliModi.isEstado();
            if (estado==true){
                System.out.println("");
                System.out.println("El estado Actual es ACTIVO, desea cambiarlo a Inactivo? ingrese SI o NO");
                leer.nextLine();
                String opcion=leer.nextLine().toUpperCase();
                if (opcion.equals("SI")) {
                    estado=false;
                    System.out.println("Se ha cambiado el estado a INACTIVO, lo que equivale a una Baja Logica");
                    System.out.println("-----------------------------------------------------------------------");
                }
                else {
                    System.out.println("El estado continuará siendo ACTIVO");
                    System.out.println("------------------------------------------------------------------------");
                }
                
                }else {
                System.out.println("El estado Actual es INACTIVO, desea cambiarlo a ACTIVO? ingrese SI o NO");
                leer.nextLine();
                String opcion=leer.nextLine().toUpperCase();
                if (opcion.equals("SI")) {
                    estado=true;
                    System.out.println("Se ha cambiado el estado a ACTIVO");
                    System.out.println("----------------------------------------------------------------------");
                }
                else {
                    System.out.println("El estado continuará siendo INACTIVO");
                    System.out.println("----------------------------------------------------------------------");
                }
                
            }
          
            cliModi.setRazonSocial(razonSocial);
            cliModi.setCuit(Mcuit);
            cliModi.setTelefono(telefono);
            cliModi.setContacto(contacto);
            cliModi.setServicio(servicio);
            cliModi.setEstado(estado);
            cd.modificarCliente(cliModi);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("CAMBIOS GUARDADOS EXITOSAMENTE");    
            System.out.println("----------------------------------------------------------------------");
            System.out.println("PRESION ENTER PARA VOLVER AL MENU ANTERIOR");
            leer.nextLine();
            }
            
            
            
}
public static void listarClientes(){
    Scanner leer=new Scanner(System.in);
ArrayList<Cliente> listado=(ArrayList<Cliente>) cd.buscarCliente();
    System.out.println(listado.stream().toString());
    System.out.println("");
    System.out.println("----------------------------------------------------");
    System.out.println("****** LISTADO GENERAL DE CLIENTES *****************");
    System.out.println("----------------------------------------------------");
    listado.stream().forEach((clis)-> System.out.println("| Razon Social: "+ clis.getRazonSocial()
            + " | CUIT: " + clis.getCuit()
            + " | Servicio Contratado: " + clis.getServicio()
            + " | Teléfono: " + clis.getTelefono()
            + " | Contacto: " + clis.getContacto()));
    System.out.println("-----------------------------------------------------");
    System.out.println("PRESIONES ENTER PARA VOLVER AL MENU ANTERIOR");
    leer.nextLine();
}
}
