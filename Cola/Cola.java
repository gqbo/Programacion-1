import javax.swing.JOptionPane;

public class Cola //First In, First Out
{
    Nodo first; //primer valor
    Nodo last;  //ultimo valor

    public Cola(){
        first=last=null;
    }

    public Nodo ingresarNodo(int v){
        Nodo nodoIngresado = new Nodo(v);
        if (first==null){  //Cola vacia
            first = last = nodoIngresado;
        }else{
            if (first==last){ //solo 1
                first.next = nodoIngresado;
                last = first.next;
            }else{
                Nodo tmp = nodoIngresado;
                last.next = tmp;
                last=tmp;
            }
        }
        return nodoIngresado;
    }

    public int extraerNodo(){
        int r=first.valor;
        if (first.next==null){
            first=last=null;
        }else{
            first=first.next;
        }
        return r;
    }

    public String imprimir(){
        String r = "";
        Nodo iterador = first;
        while(iterador != null){
            r += iterador.valor + " ";
            iterador = iterador.next;
        }
        return r;
    }

    public boolean colaVacia(){
        if (first==null)
            return true;
        else
            return false;
    }

    public int cuantosQuedanAtras(Nodo nodo){
        Nodo iterador = first;
        while(iterador != null){
            if(iterador == nodo){
                first = nodo;
            }
            iterador = iterador.next;
        }
        int contador = -1;
        while(nodo != null){
            nodo = nodo.next;
            if(nodo != null){
                System.out.println(nodo.valor);
            }
            contador++;
        }
        System.out.println("Quedan " + contador + " nodos después del nodo ingresado");
        return contador;
    }

    public int cuantosQuedanAdelante(Nodo nodo){
        Nodo iterador = first;
        while(iterador != null){
            if(iterador == nodo){
                last = nodo;
            }
            iterador = iterador.next;   
        }
        int contador = 0;
        Nodo iterador2 = first;
        while(iterador2 != nodo){

            if(iterador2 != null){
                System.out.println(iterador2.valor);
            }
            iterador2 = iterador2.next;
            contador++;
        }
      
        System.out.println("Quedan " + contador + " nodos después del nodo ingresado");
        return contador;
    }
    
    public static void main (String a[]){
        //int opcion = 0;
        //int numero = 0;
        Cola cola = new Cola();
        cola.ingresarNodo(10);
        cola.ingresarNodo(20);
        Nodo nodoPregunta = cola.ingresarNodo(30);
        cola.ingresarNodo(40);
        cola.ingresarNodo(50);

        //cola.cuantosQuedanAtras(nodoPregunta);
        cola.cuantosQuedanAdelante(nodoPregunta);

        /*do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de opciones\n"
                + "1: Insertar un nodo\n" 
                + "2: Extraer un nodo\n" 
                + "3: Mostrar el contenido de la Pila\n"
                + "4: ¿Esta vacia la lista?\n" 
                + "5: Salir\n"));

            switch(opcion){
                case 1:
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero que desea anyadir"));
                    cola.ingresarNodo(numero);
                    JOptionPane.showMessageDialog(null,"Se inserto un nodo con el valor " + numero);
                break;

                case 2:
                    cola.extraerNodo();
                    JOptionPane.showMessageDialog(null,"Se extrajo un nodo");
                break;

                case 3:
                    JOptionPane.showMessageDialog(null,cola.imprimir());  
                break;

                case 4:
                    if(cola.colaVacia()){
                        JOptionPane.showMessageDialog(null,"La cola esta vacia"); 
                    }else{
                        JOptionPane.showMessageDialog(null,"La cola no esta vacia"); 
                    }  
                break;
            }
        }while(opcion != 5);
        
    }*/

}
}
