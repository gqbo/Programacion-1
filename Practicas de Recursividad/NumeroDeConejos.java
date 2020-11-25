public class NumeroDeConejos{
    
    public int numeroConejos(int mes, int conejos, int c){

        if(c < 11){
            conejos = conejos*2;
            return numeroConejos(mes, conejos, c+1);
        }
        return conejos;
    }

    public static void main(String [] args){
        NumeroDeConejos prueba = new NumeroDeConejos();
        int resultado = prueba.numeroConejos(12,2, 0);
        System.out.println(resultado);
    }
}
