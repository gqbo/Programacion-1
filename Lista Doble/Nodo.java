
public class Nodo
{
    Nodo prev;
    int valor;
    Nodo next;

    public Nodo(int v){
        next=null;
        prev=null;
        valor=v;
    }

    public Nodo(Nodo elem){
        next=elem.next;
        prev=elem;
        valor=elem.valor;
    }

    Nodo(int v, Nodo elem){
        next=elem.next;
        prev=elem.prev;
        valor=v;
    }

    public void addOrdered(int v){
        Nodo iter=this;
        boolean inserted=false;
        while (!inserted){
            if ((iter.next != null) && (iter.next.
                valor >= v)){
                iter.next = new Nodo(v, iter);
                iter.next.prev=iter;
                iter.next.next.prev=iter.next;
                inserted=true;
            }
            else
                iter=iter.next;
        }
    }

    public void borre(int v){
        Nodo iter=this;
        boolean borrado=false;
        while (!borrado && iter!=null){
            if (iter.next != null){
                if (iter.next.valor==v){
                    borrado=true;
                    iter.next=iter.next.next;
                    if (iter.next.next!=null){
                        iter.next.prev=iter;
                    }
                }else{
                    iter=iter.next;
                }
            }else
                borrado=true;
        }
    }

    //2,6,8,89              v=30
    // public void addOrdered(int v){
    // Nodo iter = this;
    // boolean insertado=false;
    // while ((!insertado) && (iter != null)){
    // if (v < iter.valor){ //inserta a la cabeza
    // iter.next = new Nodo(this);
    // iter.valor=v;
    // insertado=true;
    // }else{
    // if ((iter.next != null) && (v < iter.next.valor)){ //valor intermedio
    // iter.next = new Nodo(this);
    // iter.next.valor=v;
    // insertado=true;
    // }else{
    // if (iter.next != null)
    // iter=iter.next;
    // else{ //fin de la lista
    // iter.next = new Nodo(this);
    // iter.next.valor=v;
    // insertado=true;
    // }
    // }
    // }
    // }
    // }
}
