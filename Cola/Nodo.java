public class Nodo
{
    int valor;
    Nodo next;

    public Nodo(int v){
        valor=v;
        next =null;
    }

    public Nodo(Nodo n){
        valor=n.valor;
        next=n.next;
    }
}
