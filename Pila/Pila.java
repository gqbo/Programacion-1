import javax.swing.JOptionPane;
public class Pila
{
    Nodo ultimoIngresado;
    int tamanyo = 0;
    int valor;
    String Lista = "";

    public Pila(){
        ultimoIngresado = null;
        tamanyo = 0;
    }

    public boolean estaVacia(){
        return ultimoIngresado == null;
    } 

    public void push(int v){    // Ingresar un nodo
        if (estaVacia()){       // Pila vacia
            ultimoIngresado = new Nodo(v);
        }else{                  // Pila tiene al menos un valor
            Nodo tmp = new Nodo(v);
            tmp.next = ultimoIngresado;
            ultimoIngresado = tmp;
            tamanyo++;
        }
        System.out.println("Se realizó un push, el tamanyo actual es: " + tamanyo);
    }

    public int pop(){ // Elimina el ultimo valor ingresado
        int r = ultimoIngresado.valor;
        ultimoIngresado = ultimoIngresado.next;
        tamanyo--;
        System.out.println("Se realizó un pop, el tamanyo actual es: " + tamanyo);
        return r;
    }

    public int top(){ // Revisa cual es el ultimo valor ingresado
        return ultimoIngresado.valor;
    }

    public int tamanyoPila(){
        return tamanyo;
    }

    public void vaciarPila(){
        while (!estaVacia()){ // Vacia toda la pila ejectuando pops hasta que la pila este vacia
            pop();            
        }
    }

    public void mostrarValores(){
        Nodo iterador = ultimoIngresado;   
        while(iterador != null){
            Lista += iterador.valor + "\n";
            iterador = iterador.next;
        }
        //JOptionPane.showMessageDialog(null, Lista);
        System.out.println(Lista);
        Lista = "";
    }

    public int tamanyo(){
        int contador = 0;
        while(!estaVacia()){
            pop();
            contador++;
        }
        return contador;
    }

    public boolean existeX(int x, Pila pila2, Pila pila3){
        boolean existe = false;
        int valor = 0;
        int valor1 = 0;

        while(!estaVacia()){
            valor = pop();
            if(valor == x){
                existe = true;
            }
            pila2.push(valor);
        }

        while(!pila2.estaVacia()){
            valor1 = pila2.pop();
            pila3.push(valor1);
        }
        pila3.mostrarValores();
        return existe;
    }




    public static void main(String a[]){
        //int opcion = 0, nodo = 0;
        Pila pila = new Pila();
        //Pila pila2 = new Pila();
        //Pila pila3 = new Pila();
        pila.push(4);
        pila.push(5);
        pila.push(12);
        pila.push(20);
        pila.push(32);
        pila.pop();
        pila.pop();

        /*int x = 12;
        System.out.println("Ejericio D");
        System.out.println();
        if(pila.existeX(x, pila2, pila3)){
            System.out.println("Si existe " + x);
        }else{
            System.out.println("No existe " + x);
        }*/


        /*do {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                        + "1. Insertar un nodo\n"
                        + "2. Eliminar un nodo\n"
                        + "3. ¿La Pila esta vacia?\n"
                        + "4. ¿Cual es el último valor ingresado en la Pila?\n"
                        + "5. ¿Cuantos nodos tiene la pila?\n"
                        + "6. Vaciar Pila\n"
                        + "7. Mostrar contenido de la Pila\n"
                        + "8. Salir.\n\n"));
                
                switch (opcion) {
                    case 1:
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Porfavor ingresa el valor a guardar en el nodo"));
                        pila.push(nodo);
                        break;
                        
                    case 2:
                        if(!pila.estaVacia()){
                            JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor: "
                             + pila.pop());
                        }else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia.");
                        }
                        break;
                        
                    case 3:
                        if(pila.estaVacia()){
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila NO vacia");
                        }
                        break;
                        
                    case 4:
                        if(!pila.estaVacia()){
                            JOptionPane.showMessageDialog(null, "El último valor ingresado en la pila es: "
                             + pila.top());
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                        
                    case 5:
                        JOptionPane.showMessageDialog(null, "La pila contiene " + pila.tamanyoPila() + " nodos.");
                        break;
                        
                    case 6:
                        if(!pila.estaVacia()){
                            pila.vaciarPila();
                            JOptionPane.showMessageDialog(null, "Se ha vaciado la pila correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia");
                        }
                        break;
                        
                    case 7:
                        pila.mostrarValores();
                        break;
                        
                    case 8:
                        opcion = 8;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, vuelve intentar nuevamente.");
                        break;
                }
                

            } catch (NumberFormatException e) {

            }
        } while (opcion != 8);
    }*/
}
}
