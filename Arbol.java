
public class Arbol
{
    Arbol rama_izq;
    int valor;
    Arbol rama_der;

    public Arbol(int v){
        rama_izq=null;
        valor=v;
        rama_der=null;
    }

    public void add(int v){ //agrega valor
        if (valor < v){                             // valor entrante va a la derecha
            if (rama_der == null){
                rama_der = new Arbol(v);
            }else{
                rama_der.add(v);
            }
        }else{
            if ((valor > v) && (rama_izq == null)){ //v puede ir a la izquierda
                rama_izq = new Arbol(v);
            }else{
                if (valor != v)                     //omito los duplicados
                    rama_izq.add(v);
            }
        }
    }

    public boolean existe(int v){
        boolean r=false;  //valor no existe
        if (valor==v) //se encontro el valor buscado
            r=true;
        else{
            if (valor < v){ //deberia estar en rama derecha
                if (rama_der!=null)
                    return rama_der. existe(v);
            }else{
                if (rama_izq!=null)//deberia estar en rama izquierda
                    return rama_izq. existe(v);
            }
        }
        return r;
    }

    public String deIPD(){
        String r="";
        if (rama_izq!=null){
            r+=rama_izq.deIPD();
        }
        r+=valor+" ";
        if (rama_der!=null){
            r+=rama_der.deIPD();
        }
        return r;
    }

    public String deDPI(){
        String r="";
        if (rama_der!=null){
            r+=rama_der.deDPI();
        }
        r+=valor+" ";
        if (rama_izq!=null){
            r+=rama_izq.deDPI();
        }
        return r;
    }

    public String dePDI(){
        String r="";
        r+=valor+" ";
        if (rama_der!=null){
            r+=rama_der.dePDI();
        }

        if (rama_izq!=null){
            r+=rama_izq.dePDI();
        }
        return r;
    }

    public int dePeso(){
        int r=1;
        if (rama_der!=null){
            r+=rama_der.dePeso();
        }
        if (rama_izq!=null){
            r+=rama_izq.dePeso();
        }
        return r;
    }

    public String muestre(String t){
        String r="";
        if (rama_der!=null){
            r+=rama_der.muestre(t+"\t");
        }
        r+=t+valor+"\n";
        if (rama_izq!=null){
            r+=rama_izq.muestre(t+"\t");
        }
        return r;
    }

    public int cuenteHojas(){
        int c=0;
        if ((rama_izq == null) && (rama_der == null))
            c=1;
        else{
            if (rama_izq!=null)
                c+=rama_izq.cuenteHojas();
            if (rama_der!=null)
                c+=rama_der.cuenteHojas();
        }

        return c;
    }

    public int deAltura(){
        int r=1;                //nodo hoja
        int alt_izq=0;
        int alt_der=0;
        if (rama_izq!=rama_der){//nodo intermedio
            if (rama_izq!=null)
                alt_izq+=rama_izq.deAltura();
            if (rama_der!=null)
                alt_der+=rama_der.deAltura();
            if (alt_izq > alt_der)
                r+=alt_izq;
            else
                r+=alt_der;
        }
        return r;
    }

    public int deAnchura(){
        int r=0;
        int v[]=new int[deAltura()];
        for (int i=0;i<v.length;i++){
            v[i]=0;
        }
        cuente(v, 0);
        r=0;
        for (int i=1;i<v.length;i++){
            if (v[i]>v[r])
                r=i;
        }
        return v[r];
    }

    public int deMayorMenores() { //valor inmediatamente anterior
        int r=valor;
        if (rama_der!=null)
            r=rama_der.deMayorMenores();
        return r;
    }

    public int deMenorMayores() { //valor inmediatamente anterior
        int r=valor;
        if (rama_izq!=null)
            r=rama_izq.deMenorMayores();
        return r;
    }

    public void cuente(int v[], int i){
        v[i]++;
        if (rama_izq!=null)
            rama_izq.cuente(v,i+1);
        if (rama_der!=null)
            rama_der.cuente(v,i+1);
    }

    public Arbol borre(int v){
        Arbol r=this;
        if (v==valor){ //valor esta en esta raiz
            if (rama_izq==rama_der) // solo había un Nodo
                r=null; //arbol queda en nulo
            else{
                if (rama_der==null) {//valor reemplazante viene de rama izquierda
                    valor=rama_izq.deMayorMenores();
                    rama_izq=rama_izq.borre(v);
                }else{
                    if (rama_izq==null) {//valor reemplazante viene de rama izquierda
                        valor=rama_der.deMenorMayores();
                        rama_der=rama_der.borre(v);
                    }else{
                        if (rama_izq.dePeso() > rama_der.dePeso()){ //valor reemplazante viene de rama izq
                            valor = rama_izq.deMayorMenores();
                            rama_izq.borre(valor);
                        }else{
                            valor =rama_der.deMenorMayores();
                            rama_der.borre(valor);
                        }
                    }
                }
            }
        }else{
            if (v > valor){
                if (rama_der!=null)
                    rama_der=rama_der.borre(v);
            }else{
                if (rama_izq!=null)
                    rama_izq=rama_izq.borre(v);
            }
        }
        return r;
    }

    public static void main (String a[]){
        Arbol arbol=new Arbol(67);
        arbol.add(23);
        arbol.add(56);
        arbol.add(75);
        arbol.add(90);
        arbol.add(100);
        arbol.add(80);
        arbol.add(40);
        arbol.add(70);
        arbol.add(73);
        arbol.add(70);
        arbol.add(60);
        arbol.add(69);
        arbol.add(73);
        System.out.println(arbol.dePDI());//deja un espacio
        System.out.println("peso = "+arbol.dePeso());
        System.out.println(arbol.muestre("\t"));//deja un espacio
        int x=45;
        if (arbol.existe(x))
            System.out.println("valor "+x+" existe");
        else
            System.out.println("valor "+x+" NO existe");
        System.out.println("Cant hojas ="+arbol. cuenteHojas());
        System.out.println("altura = "+arbol.deAltura());
        System.out.println("anchura = "+arbol.deAnchura());
        System.out.println("mayor de menores = "+
            arbol.rama_izq.deMayorMenores());
        System.out.println("menor de mayores = "+
            arbol.rama_der.deMenorMayores());
        Arbol nuevo=arbol.borre(90);
        System.out.println(nuevo.muestre("\t"));//deja un espacio
    }
}
