public class MCD_Rec {
    
    public int mcd(int a, int b){
        int r = 0;
        if(b == 0){
            return a;
        }else{
            r = a%b;
            return mcd(b, r);
        }
    }

    public static void main(String [] args){
        MCD_Rec prueba = new MCD_Rec();
        int resultado = prueba.mcd(18, 12);
        System.out.println(resultado);
    }
}
