/**
 * Crea métodos que permiten visualizar el mazo de cartas que se utiliza para jugar.
 * @author Gabriel González Flores - C03376
 * @version 2, 05/19/21 
 */

public class VisualizadorJuego{

    public void mostrarCartas(String[] gridDeCartas){

        for(int i = 0; i < gridDeCartas.length; i++){
            System.out.print("Carta " + (i+1) + ": " + gridDeCartas[i] + "  ");
            if((i+1) % 5 == 0){
                System.out.print("\n");
            }
        }
        System.out.println(" ");
    }

    public void mostrarJugadores(String[] arrayDeJugadores){

        for(int i = 0; i < arrayDeJugadores.length; i++){
            System.out.println("Jugador " + (i+1) + ": " + arrayDeJugadores[i] + "  ");
        }
        System.out.println(" ");
    }

    public String mostraReversoCartas(String[] gridDeCartas){

        String mazoReversoCartas = "";

        for(int i = 0; i < gridDeCartas.length; i++){

            if(gridDeCartas[i] == "XX"){
                mazoReversoCartas += "Carta " + (i+1) + ": " + gridDeCartas[i] + "  ";
            }else{
                mazoReversoCartas += "Carta " + (i+1) + ": " + "?,?" + "  ";
            }

            if((i+1) % 5 == 0){
                mazoReversoCartas += "\n";
            }
        }
        return mazoReversoCartas;
    }

    public String mostrarCartasEscogidas(String[] gridDeCartas, int cartaEscogida1, int cartaEscogida2){

        String mazoCartasEscogidas = "";
        for(int i = 0; i < gridDeCartas.length; i++){

            if(i == (cartaEscogida1-1) || i == (cartaEscogida2-1) ){
                mazoCartasEscogidas += "Carta " + (i+1) + ": " + gridDeCartas[i] + "  ";

            }else{
                if(gridDeCartas[i] == "XX"){
                    mazoCartasEscogidas += "Carta " + (i+1) + ": " + gridDeCartas[i] + "  ";
                }else{
                    mazoCartasEscogidas += "Carta " + (i+1) + ": " + "?,?" + "  ";
                }  
            }
            
            if((i+1) % 5 == 0){
                mazoCartasEscogidas += "\n";
            }
        }
        return mazoCartasEscogidas;
    }

    public String mostrarCartasEscogidas(String[] gridDeCartas, int cartaEscogida1, int cartaEscogida2, int cartaEscogida3){

        String mazoCartasEscogidas = "";
        for(int i = 0; i < gridDeCartas.length; i++){

            if(i == (cartaEscogida1-1) || i == (cartaEscogida2-1) || i == (cartaEscogida3-1)){
                mazoCartasEscogidas += "Carta " + (i+1) + ": " + gridDeCartas[i] + "  ";

            }else{
                mazoCartasEscogidas += "Carta " + (i+1) + ": " + "?,?" + "  ";
            }
            
            if((i+1) % 5 == 0){
                mazoCartasEscogidas += "\n";
            }
        }
        return mazoCartasEscogidas;
    }
}
