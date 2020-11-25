// Este programa debe estar dentro de una carpeta!!!!
// En caso de no estar en una carpeta, el archivo se guardará en C:\Users\*nombre del usuario*\*Carpeta del IDE*
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Archivos implements Serializable{ //Serializable sirve para los archivos

    Scanner entradaArchivo;
    String todosLosDatos = "";
    String [] separarDatos = new String[8];
    File datosPersonas;

    public void guardarArchivo(String nombreArchivo){ //Metodo para crear el archivo con los datos de las personas

        try{
            BufferedWriter personas = new BufferedWriter(new FileWriter(nombreArchivo)); //Crea el archivo Personas.dat en el folder del proyecto
            JOptionPane.showMessageDialog(null,"Separe cada dato con un renglon");

            String datos1 = JOptionPane.showInputDialog("Cedula - Nombre - Apellido - diaNac - mesNac - anyoNac - sexo(1=hombre, 2=mujer) - numTel");
            personas.write(datos1); //Escribir los datos en el archivo
            personas.write("\n");

            String datos2 = JOptionPane.showInputDialog("Cedula - Nombre - Apellido - diaNac - mesNac - anyoNac - sexo(1=hombre, 2=mujer) - numTel");
            personas.write(datos2); //Escribir los datos en el archivo
            personas.write("\n");

            String datos3 = JOptionPane.showInputDialog("Cedula - Nombre - Apellido - diaNac - mesNac - anyoNac - sexo(1=hombre, 2=mujer) - numTel");
            personas.write(datos3); //Escribir los datos en el archivo
            personas.write("\n");

            String datos4 = JOptionPane.showInputDialog("Cedula - Nombre - Apellido - diaNac - mesNac - anyoNac - sexo(1=hombre, 2=mujer) - numTel");
            personas.write(datos4); //Escribir los datos en el archivo

            personas.close(); //"Guardar" el archivo
        }
        catch(IOException e){
            System.out.println("Ha ocurrido un error al crear el archivo");
        }
    }

    public void opciones(String nombreArchivo){

        System.out.println("Escoja la opcion de su gusto: "+"\n"+
        "1 = Mostrar todos los datos en el archivo"+"\n"+
        "2 = Mostrar datos de personas mayores a una fecha de naciemiento dada"+"\n"+
        "3 = Mostrar datos de personas de un sexo"); //Dependiendo de la opcion se ejecutan las diferentes instrucciones
        Scanner opcionesUsuario = new Scanner(System.in);
        int opciones = opcionesUsuario.nextInt();
        System.out.println();

        if(opciones == 1){ //Imprime todos los datos en el archivo
            System.out.println("Todos los datos en el archivo son los siguientes: ");
            try{
                datosPersonas = new File(nombreArchivo);
                entradaArchivo = new Scanner(datosPersonas);

                while(entradaArchivo.hasNextLine()){
                    todosLosDatos = entradaArchivo.nextLine();
                    System.out.println(todosLosDatos);
                }
            }
            catch(IOException e){
                System.out.println("Ha ocurrido un error al buscar el archivo");
                System.exit(0);
            }     
            System.out.println();
        }      

        if(opciones == 2){ //Mostrar solo las personas mayores a una fecha de nacimiento dada

            System.out.println("Introduzca el dia de nacimiento base");

            Scanner scannerDia = new Scanner(System.in);
            int dia = scannerDia.nextInt();
            System.out.println();

            System.out.println("Introduzca el mes de nacimiento base");

            Scanner scannerMes = new Scanner(System.in);
            int mes = scannerMes.nextInt();
            System.out.println();
                
            System.out.println("Introduzca el anyo de nacimiento base");

            Scanner scannerAnyo = new Scanner(System.in);
            int anyo = scannerAnyo.nextInt();
            System.out.println();

            try{
                datosPersonas = new File(nombreArchivo);
                entradaArchivo = new Scanner(datosPersonas);

                System.out.println("Los datos de las personas mayores a la fecha de nacimiento dada son: ");

                while(entradaArchivo.hasNextLine()){
                    todosLosDatos = entradaArchivo.nextLine();
                    separarDatos = todosLosDatos.split("-");
                    int anyoDatos = Integer.parseInt(separarDatos[5]);
                    int mesDatos = Integer.parseInt(separarDatos[4]);
                    int diaDatos = Integer.parseInt(separarDatos[3]);
                    if((anyoDatos<anyo)|| (mesDatos < mes && anyoDatos == anyo) || (diaDatos < dia && mesDatos == mes && anyoDatos == anyo)){
                        System.out.println(Arrays.toString(separarDatos));
                    }
                }
                System.out.println();
            }
            catch(IOException e){
                    System.out.println("Ha ocurrido un error al buscar el archivo");
                    System.exit(0);
            }
        }

        if(opciones == 3){ // Mostrar solo las personas de un sexo en especifico
            
            System.out.println("Introduzca un sexo. 1 = Hombre, 2 = Mujer");

            Scanner scannerSexo = new Scanner(System.in);
            int sexo = scannerSexo.nextInt();
            System.out.println();

            try{
                datosPersonas = new File(nombreArchivo);
                entradaArchivo = new Scanner(datosPersonas);

                System.out.println("Los datos de las personas de sexo: "+sexo);

                while(entradaArchivo.hasNextLine()){
                    todosLosDatos = entradaArchivo.nextLine();
                    separarDatos = todosLosDatos.split("-");
                    int sexoDatos = Integer.parseInt(separarDatos[6]);
                    
                    if(sexoDatos == sexo){
                        System.out.println(Arrays.toString(separarDatos));
                    }
                }
                System.out.println();
            }
            catch(IOException e){
                    System.out.println("Ha ocurrido un error al buscar el archivo");
                    System.exit(0);
            }
        }
    }


    public static void main(String [] args){

        Archivos archivo = new Archivos();
        Scanner entradaArchivo;
        File datosPersonas;

        String archivoParametro = JOptionPane.showInputDialog("Introduzca como desea que se llame el archivo a crear");
        System.out.println();

        archivo.guardarArchivo(archivoParametro); //Se crea el archivo

        try{
            System.out.println("Introduzca el nombre del archivo"); //Se escanea el nombre del archivo
            entradaArchivo = new Scanner(System.in);
            String nombreArchivo = entradaArchivo.nextLine();
            datosPersonas = new File(nombreArchivo);
            entradaArchivo = new Scanner(datosPersonas);
            System.out.println();
        }
        catch(IOException e){
            System.out.println("Ha ocurrido un error al buscar el archivo");
            System.out.println();

            int intentoArchivo = 1;

            if(intentoArchivo == 1){
                System.out.println("Desea intentar de nuevo? 1 = Si, 2 = No");
                Scanner intento = new Scanner(System.in);
                int otroIntento = intento.nextInt();

                if(otroIntento == 1){

                    try{
                        System.out.println("Introduzca el nombre del archivo"); //Se escanea el nombre del archivo
                        entradaArchivo = new Scanner(System.in);
                        String nombreArchivo = entradaArchivo.nextLine();
                        datosPersonas = new File(nombreArchivo);
                        entradaArchivo = new Scanner(datosPersonas);
                    }
                    catch(IOException a){
                        System.out.println("Ha ocurrido un error al buscar el archivo");
                    }
                    System.out.println();

                }else{
                    System.exit(0);
                }
             }
        }

        archivo.opciones(archivoParametro);

        int numeroDeOpcion = 1;

        while(numeroDeOpcion == 1){ //Repetir opciones

            System.out.println("Desea consultar otra opcion? 1 = Si, 2 = No");
            Scanner otraOpcion = new Scanner(System.in);
            int numero = otraOpcion.nextInt();
            System.out.println();

            if(numero == 1){
                archivo.opciones(archivoParametro);
            }else{
                System.exit(0);
            }


        }
        
    }
}
