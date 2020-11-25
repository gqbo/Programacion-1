
public class Lista
{
    int valor;
    boolean ocupado;
    Lista next;

    public Lista(){
        ocupado=false;
        next = null;
    }

    public Lista(int v){
        valor=v;
        ocupado=true;
        next = null;
    }

    public Lista(Lista v){
        valor   =v.valor;
        ocupado =v.ocupado;
        next    = v.next;
    }

    public void add(int v){
        Lista iter=this;
        if (!iter.ocupado){
            iter.valor=v;
            iter.ocupado=true;
        }else{
            while (iter.next != null){
                iter=iter.next;
            }
            iter.next = new Lista (v);
        }
    }

    public void addFirst(int v){
        if (!ocupado){
            valor=v;
            ocupado=true;
        }else{
            next = new Lista(this);
            valor=v;
        }
    }

    public void addOrdered(int v){
        if (!ocupado){
            valor=v;
            ocupado=true;
        }else{ 
            if (v < this.valor){
                addFirst(v);
            }else{
                if (next==null)
                    next=new Lista(v);
                else{
                    Lista iter=this;
                    while ((iter.next != null)&&((iter.next.valor<v))&&
                    (iter.next.ocupado)){
                        iter = iter.next;
                    }
                    if (iter.next == null){
                        iter.next = new Lista(v);
                    }else{
                        if (!iter.next.ocupado){
                            iter.next.valor=v;
                            iter.next.ocupado=true;
                        }else{
                            iter.next = new Lista(iter);
                            iter.next.valor=v;
                        }
                    }

                }
            }

        }
    }

    public boolean existe(int v){
        boolean r=false;
        Lista iter = this;
        while (!r && iter.next!=null){
            if (iter.valor==v)
                r=true;
            else
                iter=iter.next;
        }
        return r;
    }

    public void borre(int v){
        Lista iter=this;
        boolean siga=true;

        while (siga){
            if (iter.valor==v){        
                if (iter.next == null){ 
                    iter.ocupado=false;
                    siga=false;
                }else{                  
                    iter.valor=iter.next.valor;
                    iter.next = iter.next.next;
                }
            }else{                    
                if (iter.next == null){
                    siga=false;
                }
                else
                    iter=iter.next;
            }
        }

    }

    public String toString(){
        String r="";
        Lista iter=this;
        boolean siga=true;
        while (siga &&(iter.ocupado==true)){
            r+=iter.valor+" ";
            if (iter.next == null)
                siga=false;
            else
                iter=iter.next;
        }
        return r;
    }

    public void valoresInferiores(int n){

        Lista iter = this;
        int contador = 0;
        boolean siga=true;

        while(siga){

            if (iter.next != null && iter.valor <= n){
                contador++;
            }
            if(iter.next == null){
                siga = false;
            }else{                 
                iter.valor=iter.next.valor;
                iter.next = iter.next.next;
            }
        }
        System.out.println("Los valores inferiores a: "+n+" es " + contador);
    }

    public void valoresPares(Lista iter){

        boolean siga=true;
        int valores;

        while(siga){

            if ((iter.next != null) && (iter.valor%2 == 0)){
                valores = iter.valor;
                System.out.println("Un valor par es: " + valores);
            }
            if(iter.next == null){
                siga = false;
            }else{                 
                iter.valor=iter.next.valor;
                iter.next = iter.next.next;
            }
        }
        System.out.println("xd prueba");
    }

    public static void main (String a[]){
        Lista lista = new Lista();      
        lista.addOrdered(58);
        lista.addOrdered(6);
        lista.addOrdered(62);
        lista.addOrdered(26);
        lista.addOrdered(60);
        lista.addOrdered(2);
        System.out.println(lista.toString());
        int x=26;
        if(lista.existe(x)){
            System.out.println("Valor "+x+" existe");
        }else
            System.out.println("Valor "+x+" NO existe");
        lista.borre(62); 

        lista.addOrdered(69);
        System.out.println("Lista sin valor a borrar= "+lista.toString());
        lista.valoresInferiores(45);
        lista.valoresPares(lista);
    }
}
