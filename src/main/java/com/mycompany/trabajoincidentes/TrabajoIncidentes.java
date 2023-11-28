/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajoincidentes;


import java.util.Scanner;

/**
 *
 * @author RodrigoI
 */

//CLASE PRINCIPAL DEL PROGRAMA, DESDE AQUI SE LLAMA A LA IMPRESION DEL MENU, Y SE ENCUENTRA LA PROGRAMACION DEL SWITCH Y LOS CASE PARA
//LLAMAR A CADA METODO CORRECTO SEGUN LO REQUERIDO.
//SE PUEDE INGRESAR A SUB MENU DE CLIENTE Y TENCICO Y VOLVER... MIENTRAS NO SE TIPEE 10, ESTARA DENTRO DEL WHILE Y SE REPETIRA

public class TrabajoIncidentes {

    public static void main(String[] args) {
    
        
        int opcion;
Scanner leer=new Scanner(System.in);
        Varios.menuPrincipal();
        System.out.print ("Ingrese una Opcion:");
        try{
        opcion=leer.nextInt();}
        catch(NumberFormatException er){
            System.out.println("Error, debe ingresar un numero, inicie el programa nuevamente");
            
        return;
        
        }
    while (opcion!=10)    {
        switch (opcion){
            case 1: 
                MenuTecnicos.menuTecnicos();
                break;
            case 2:
                MenuClientes.menuClientes();
                break;
            case 3:
                Incidentes.altaIncidente();
                break;
            case 4:
                Incidentes.finalizarIncidente();
                break;
            case 5:
                MenuTecnicos.ListarTecnicos();
                break;
            case 6:
                MenuClientes.listarClientes();
                break;
            case 7:
                Incidentes.listarIncAct();
                break;
            case 8:
                Incidentes.listarIncRes();
                break;
            case 9:
                Incidentes.tecnicoMasUsado();
                break;
        
        }
        System.out.println("--------------------------------------------------");    
    Varios.menuPrincipal();
    System.out.print("Ingrese una Opcion:");
    try{
    opcion=leer.nextInt();
    }
    catch (NumberFormatException er){
        System.out.println("Debe ingresar solo numeros");
        System.out.println("Reinicie el programa");
        return;
    }
    
    }


        
        
    
    
    
    
    }
        
        
        
        
    }

