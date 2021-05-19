public class ControladorJuego {

    public static void main(String[] args){
        //Instanciar ModeloJuego y VisualizadorJuego
        ModeloJuego juego = new ModeloJuego();
        VisualizadorJuego visualizador = new VisualizadorJuego();
        //Instanciar ModeloJuego y VisualizadorJuego

        //Crear arreglo de cartas y barajar
        String[] mazoDeCartas = juego.crearCartasAleatorias(2,2);
        mazoDeCartas = juego.barajarCartas(mazoDeCartas);  
        visualizador.mostrarCartas(mazoDeCartas);
        System.out.println();
        //Crear arreglo de cartas y barajar

        //Crear cartas premio
        int[] cartasPremio = new int[10];
        cartasPremio = juego.crearCartasPremio(cartasPremio);
        cartasPremio = juego.barajarCartas(cartasPremio);
        //Crear cartas premio

        juego.escogerCartas(mazoDeCartas, cartasPremio);     
    }
    
}
