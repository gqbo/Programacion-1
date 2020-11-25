public class ListaConContador {
    String info;       
    boolean ocupado;
    ListaConContador next;
    int key;
    int freq = 0;         

    public ListaConContador(){   
        ocupado = false;  
        next = null;    
    }

    public ListaConContador(String v){
        info = v;
        freq = 1;
        ocupado = true; 
        next = null; 
    }

    public ListaConContador(ListaConContador v){
        info = v.info;
        ocupado = v.ocupado;
        next = v.next;
        freq = v.freq;
    }

    public boolean revisarNombre(String v){
        boolean siHay = false;
        ListaConContador iter2 = this;

        if(iter2.ocupado){
            while(iter2 != null){
                if(iter2.info.contains(v)){
                    iter2.freq++;
                    siHay = true;
                }
                iter2=iter2.next;
            }
        }

        return siHay;
    }

    public void agregue(String v){

        ListaConContador iter=this;

        if(revisarNombre(v)){
            
        }else{
            if (!iter.ocupado) {
                iter.info = v;
                iter.freq = 1;
                iter.ocupado = true;
            }else{       
                while (iter.next != null){
                    iter=iter.next;
                }
                iter.next = new ListaConContador(v);
            }          
        }  
    }

    public String mostrarLista(){
        String r = "";
        ListaConContador iter = this;
        while(iter!=null){
            r += "Nombre: "+iter.info+" -- "+"Frecuencia: " + iter.freq+"\n";
            iter = iter.next;
        }
        return r;
    }
}
