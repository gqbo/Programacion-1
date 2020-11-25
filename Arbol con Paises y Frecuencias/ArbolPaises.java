public class ArbolPaises extends ListaConContador {

    ArbolPaises rama_izq;
    ListaConContador lista;
    ArbolPaises rama_der;
    String pais;
    String nombre;
    int key;

    public ArbolPaises(String pais){ // 
        rama_izq=null;
        rama_der=null;
        this.pais = pais;
        key = pais.charAt(1);
    }

    public ArbolPaises(String pais, ListaConContador lista){ // 
        rama_izq=null;
        rama_der=null;
        this.pais = pais;
        this.lista = lista;
        key = pais.charAt(1);
    }

    public void agreguePaises(String v){ //agrega valor
        int key = v.charAt(1);
        ListaConContador lista = new ListaConContador();
        ArbolPaises arbol = this;
        if ( arbol.key < key){                          
            if (rama_der == null){
                rama_der = new ArbolPaises(v, lista);
            }else{
                rama_der.agreguePaises(v);
            }
        }else{
            if ((arbol.key > key) && (rama_izq == null)){ //v puede ir a la izquierda
                rama_izq = new ArbolPaises(v, lista);
            }else{
                if (arbol.key != key)                     //omito los duplicados
                    rama_izq.agreguePaises(v);
            }
        }
    }

    public void agregue(String nombre, String pais){
        int key = pais.charAt(1);
        ArbolPaises arbol = this;
        if (arbol.key < key){                          
            if (rama_der == null){
                System.out.println();
            }else{
                rama_der.agregue(nombre, pais);
            }
        }else{
            if ((arbol.key > key) && (rama_izq == null)){ 
                System.out.println();
            }else{
                if (arbol.key != key){
                    rama_izq.agregue(nombre, pais);
                }else{
                    arbol.lista.agregue(nombre);
                }
            }
        }
    }

    public String toString(){
        String r="";
        ArbolPaises arbol = this;
        if (rama_izq!=null){
            r+=rama_izq.toString();
        }
        if(arbol.lista == null){
            r+="";
        }else{
            r+=arbol.pais+"\n"+arbol.lista.mostrarLista()+"\n";
        }
        if (rama_der!=null){
            r+=rama_der.toString();
        }
        return r;
    }

    public int cuenteFrecuencia(String nombre){
        int frequ = 0;
        ArbolPaises arbol = this;
        if (rama_izq!=null){
            frequ+=rama_izq.cuenteFrecuencia(nombre);
        }
        
        ListaConContador iter = arbol.lista;
        while(iter!=null){
            if(iter.info.contains(nombre)){
                frequ += iter.freq;
            }
            iter = iter.next;
        }
    
        if (rama_der!=null){
            frequ+=rama_der.cuenteFrecuencia(nombre);
        }
        return frequ;
    }


    public static void main(String [] args){

        ArbolPaises arbol = new ArbolPaises("Djibouti");

        arbol.agreguePaises("CR");
        arbol.agreguePaises("USA");
        arbol.agreguePaises("Chile");
        arbol.agreguePaises("Peru");
        arbol.agreguePaises("Guatemala");
        arbol.agreguePaises("Nicaragua");
        arbol.agreguePaises("Colombia");

        arbol.agregue("Maria","Guatemala");
        arbol.agregue("Ana","Peru");
        arbol.agregue("Ana","Chile");
        arbol.agregue("Ana","Chile");
        arbol.agregue("Pedro","CR");
        arbol.agregue("Juan","Guatemala");
        arbol.agregue("Maria","CR");
        arbol.agregue("Ana","Colombia");
        arbol.agregue("Pedro","Nicaragua");
        arbol.agregue("Juan","Peru");
        arbol.agregue("Ana","Peru");
        arbol.agregue("Chepe", "CR");
        arbol.agregue("Luisa", "USA");

        String xd = arbol.toString();
        System.out.print(xd);

        int freqAna = arbol.cuenteFrecuencia("Ana");
        System.out.println("La frecuencia de Ana en todo el árbol es de: "+freqAna);

        int freqPedro = arbol.cuenteFrecuencia("Pedro");
        System.out.println("La frecuencia de Ana en todo el árbol es de: "+freqPedro);

        int freqJuan = arbol.cuenteFrecuencia("Juan");
        System.out.println("La frecuencia de Ana en todo el árbol es de: "+freqJuan);

    }
}
