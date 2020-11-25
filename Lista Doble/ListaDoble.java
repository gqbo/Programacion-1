public class ListaDoble
{
    Nodo first;  //apuntador al primer nodo
    Nodo last;   //apuntador al ultimo nodo

    public ListaDoble(){
        first=last=null;
    }

    public void append(int v){ //agrega al final
        if (first==null){
            first=last=new Nodo(v);
        }else{
            Nodo tmp=last;
            if (first==last){
                last=new Nodo(v);
                first.next=last;
                last.prev=tmp;
            }else{
                last.next=new Nodo(v);
                last=last.next;
                last.prev=tmp;
            }
        }
    }

    public boolean existe(int v){
        boolean r = false;
        Nodo iterador = first;

        while (iterador!=null){
            if(iterador.valor == v){
                r = true;
            }
            iterador=iterador.next;
        }
        return r;
    }

    public void addOrdered(int v){ //agrega en orden
        if (first==null){ // Para agregar el primer 
            first=last=new Nodo(v);
        }else{
            if (first==last){ // Para agregar un segundo valor

                if(first.valor < v){
                    last = new Nodo(v);
                }else{
                    first = new Nodo(v);
                }
                last.prev = first;
                first.next = last;
                
            }else{ // Para agregar 3 o mas valores
                if (first.valor > v){
                    Nodo tmp=first; 
                    first = new Nodo (v,first); // Clonar al inicio de la lista
                    tmp.prev=first;
                }else{
                    if (last.valor <= v){
                        Nodo tmp=last;
                        last.next=new Nodo(v);
                        last=last.next;
                        last.prev=tmp;
                    }
                    else
                        first.addOrdered(v);
                }
            }
        }
    }

    public void borre(int v){
        if (first!=null){ //lista no vacia
            if ((first == last) && (first.valor==v)){//solo 1
                first = last = null;
            }else{
                if (first.valor==v){
                    first = first.next;
                    first.prev=null;
                }else{
                    if (last.valor==v){
                        last = last.prev;
                        last.next=null;
                    }else{
                        first.borre (v);
                    }
                }
            }
        }
    }
    
    //QUIZ
    public void valoresPares(){

        String pares = "";
        Nodo iterador = first;

        while (iterador!=null){
            if(iterador.valor%2 == 0){
                pares += iterador.valor + " ";
            }
            iterador=iterador.next;
        }
        System.out.println(pares);
    }

    public void valoresMayores(int valorParametro){

        String mayores = "";
        Nodo iterador = first;

        while (iterador!=null){
            if(iterador.valor > valorParametro){
                mayores += iterador.valor + " ";
            }
            iterador=iterador.next;
        }
        System.out.println(mayores);

    }

    public void muestreLista(){
        Nodo it=first;
        while (it!=null){
            System.out.println(it.valor);
            it=it.next;
        }
    }

    public void muestreListaInvertida(){
        Nodo it=last;
        while (it!=null){
            System.out.println(it.valor);
            it=it.prev;
        }
    }

    public Nodo direccion(int v){ // 1) METODO PARA EL QUIZ 

        Nodo r;
        if(existe(v)){
            r = first;
        }else{
            r = null;
        }
        Nodo iterador = first;
        while(iterador != null){
            if(iterador.valor == v){
                r = iterador;
            }
            iterador = iterador.next;
        } 
        return r;
    }

    public String valoresAlrededor(int numeroDeValores, int valor){

        String r = "";
        int z = 0;
        int y = 0;
        Nodo iterador = first;

        while(iterador != null){
            if(iterador.valor == valor){
                while(z < numeroDeValores){
                    r += iterador.prev.valor + " ";
                    if(iterador.prev.prev != null){
                        iterador.prev = iterador.prev.prev;
                    }
                    z++;
                }
            }
            iterador = iterador.next;
        }

        Nodo iterador2 = first;

        r += "* ";

        while(iterador2 != null){

            if(iterador2.valor == valor){
                while(y < numeroDeValores){
                    r += iterador2.next.valor + " ";
                    if(iterador2.next.next != null){
                        iterador2.next = iterador2.next.next;
                    }
                    y++;
                }
            }
            iterador2 = iterador2.next;
        }
        return r;
    }
    // QUIZ

    public static void main (String args[]){
        ListaDoble lista=new ListaDoble();
    
        lista.addOrdered(11);
        lista.addOrdered(17);
        lista.addOrdered(45);
        lista.addOrdered(50);
        lista.addOrdered(62);
        lista.addOrdered(83);
        lista.addOrdered(90);

        System.out.println("Lista normal");
        lista.muestreLista();
        System.out.println("");

        /*System.out.println("Lista normal");
        lista.muestreLista();
        System.out.println("");
        System.out.println("Lista invertida");
        lista.muestreListaInvertida();
        System.out.println("");
        System.out.println("Valores pares de la lista");
        lista.valoresPares();
        System.out.println("");
        System.out.println("Valores mayores al valor 32");
        lista.valoresMayores(32);
        System.out.println("");*/

        System.out.println("Ejercicio 1 ");
        System.out.print("La direccion del nodo es: " + lista.direccion(17));
        System.out.println();

        System.out.println();
        System.out.println("Ejercicio 2 ");
        System.out.print(lista.valoresAlrededor(2, 50));
        System.out.println();


    }
}
