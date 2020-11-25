import java.util.ArrayList;

import javax.swing.JOptionPane;
public class MDArrayList{

    public static void main(String [] args){

        ArrayList<String> cadenas = new ArrayList<String>(); //Se crea una lista llamada cadenas

        String frase, respuesta;
        do{
            frase = JOptionPane.showInputDialog("Ingresa la frase"); //Se pide la frase
            cadenas.add(frase); //Agregar la frase a la lista cadena
            respuesta = JOptionPane.showInputDialog("Desea ingresar otra frase? ( SI / NO )");
            respuesta = respuesta.toUpperCase();

        }while(respuesta.equals("SI"));

        System.out.println("Frases originales");

        for(int i = 0; i<cadenas.size(); i++){ //.size es para el tamanyo de la lista dinamica
            System.out.println(cadenas.get(i)); //.get para obtener el contenido
        }
        System.out.println("");



        //Utilizando el metodo .set
        cadenas.set(0,"LA PRIMERA LA CAMBIE");

        System.out.println("Frases modificadas");

        for(int i = 0; i<cadenas.size(); i++){ //.size es para el tamanyo de la lista dinamica
            System.out.println(cadenas.get(i)); //.get para obtener el contenido
        }
        System.out.println("");

        //Utilizando el metodo .remove
        cadenas.remove(0);

        System.out.println("Frases modificadas y borrando la primera frase");

        for(int i = 0; i<cadenas.size(); i++){ //.size es para el tamanyo de la lista dinamica
            System.out.println(cadenas.get(i)); //.get para obtener el contenido
        }
        System.out.println("");
    }

}