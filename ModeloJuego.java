/**
 * Crea métodos que permite manejar, de diversas maneras, el juego de memoria
 * con cartas de la forma (letra,número) ;Crea un mazo de cartas, un
 * mazo de premios y compara cartas para que el usuario reciba puntos según
 * su desempeño.
 * @author Gabriel González Flores - C03376
 * @version 2, 05/19/21 
 */

import javax.swing.JOptionPane;
import java.util.Random;
public class ModeloJuego{

    String[] cartasTrios;
    int posicionTrio = 0;
    JugadorJuego jugador = new JugadorJuego();

    /** 
     * Este método genera un mazo de cartas aleatorias, según su cantidad de pares y tríos.
     * @param pares dato tipo int.
     * @param trios dato tipo int.
     * @return devuelve el arreglo con las cartas generadas.  
     */
    public String[] crearCartasAleatorias(int pares, int trios){

        int numeroCartas = (2*pares)+(3*trios);

        String[] mazoDeCartas = new String[numeroCartas];
        cartasTrios = new String[trios];
        int numeroPares = 0;
        int numeroTrios = 0;
        int posicion = 0;

        while(numeroPares < pares){

            int ascii = (int)(Math.random()*(91 - 65)) + 65;
            String caracter = String.valueOf((char)ascii);
            String numeroAleatorio = Integer.toString((int)(Math.random()*(11 - 1)) + 1);
            String carta = caracter + "," + numeroAleatorio;

            mazoDeCartas[posicion] = (carta);
            posicion++;
            mazoDeCartas[posicion] = (carta);
            posicion++;
            numeroPares++;
        }

        while(numeroTrios < trios){

            int ascii = (int)(Math.random()*(91 - 65)) + 65;
            String caracter = String.valueOf((char)ascii);
            String numeroAleatorio = Integer.toString((int)(Math.random()*(11 - 1)) + 1);
            String carta = caracter + "," + numeroAleatorio;

            cartasTrios[posicionTrio] = (carta);
            posicionTrio++;

            mazoDeCartas[posicion] = (carta);
            posicion++;
            mazoDeCartas[posicion] = (carta);
            posicion++;
            mazoDeCartas[posicion] = (carta);
            posicion++;
            numeroTrios++;
        }

        return mazoDeCartas;
    }
    
    /** 
     * Este método genera un mazo de 10 premios, 5 de duplique y 5 de cuadruplique.
     * @param mazoDeCartas dato tipo int[].
     * @return devuelve el arreglo con los premios generados.  
     */
    public int[] crearCartasPremio(int[] mazoDeCartas){

        int posicion = 0;

        for(int i = 0; i < 5; i++){
            mazoDeCartas[posicion] = 2;
            posicion++;
        }

        for(int k = 5; k < mazoDeCartas.length; k++){
            mazoDeCartas[posicion] = 4;
            posicion++;
        }  
        
        return mazoDeCartas;
    }

    /** 
     * Este método baraja las cartas de tipo String.
     * @param mazoDeCartas dato tipo String[].
     * @return devuelve el arreglo barajado de las cartas generadas.  
     */
    public String[] barajarCartas(String[] mazoDeCartas){

        Random random = new Random();

        for (int i = 0; i < mazoDeCartas.length; i++){
            int posAleatoria = random.nextInt(mazoDeCartas.length);
            String temp = mazoDeCartas[i];
            mazoDeCartas[i] = mazoDeCartas[posAleatoria];
            mazoDeCartas[posAleatoria] = temp;
        }

        return mazoDeCartas;
    }

    /** 
     * Este método baraja las cartas de tipo Int.
     * @param mazoDeCartas dato tipo int[].
     * @return devuelve el arreglo barajado de los premios.  
     */
    public int[] barajarCartas(int[] mazoDeCartas){

        Random random = new Random();

        for (int i = 0; i < mazoDeCartas.length; i++){
            int posAleatoria = random.nextInt(mazoDeCartas.length);
            int temp = mazoDeCartas[i];
            mazoDeCartas[i] = mazoDeCartas[posAleatoria];
            mazoDeCartas[posAleatoria] = temp;
        }

        return mazoDeCartas;
    }

    /** 
     * Este método "elimina las cartas" definiendo la carta usada como: "XX".
     * @param mazoDeCartas dato tipo String[].
     * @param cartaParaEliminar dato tipo int.
     * @return devuelve el arreglo eliminando la carta usada.  
     */
    public String[] eliminarCartas(String[] mazoDeCartas, int cartaParaEliminar){
        
        mazoDeCartas[cartaParaEliminar-1] = "XX";
        return mazoDeCartas;
    }

    /** 
     * Este método elimina las cartas creando un mazo nuevo con un tamaño menor
     * y copiando todos los valores en este mazo nuevo sin la carta a eliminar.
     * @param mazoDeCartas dato tipo String[].
     * @param mazoDeCartas dato tipo mazoNuevo[].
     * @param cartaParaEliminar dato tipo int.
     * @return devuelve el arreglo eliminando la carta usada.  
     */
    public String[] eliminarCartas(String[] mazoDeCartas, String[] mazoNuevo, int cartaParaEliminar){
        
        for(int i = 0; i < mazoNuevo.length; i++){
            if(i < (cartaParaEliminar-1)){
                mazoNuevo[i] = mazoDeCartas[i];
            }
            if(i >= (cartaParaEliminar-1)){
                mazoNuevo[i] = mazoDeCartas[i+1];
            }
        }
        return mazoNuevo;
    }

    /** 
     * Este método elimina las cartas de premio creando un mazo nuevo con un tamaño menor
     * y copiando todos los valores en este mazo nuevo sin la carta a eliminar.
     * @param mazoDeCartas dato tipo int[].
     * @param mazoNuevo dato tipo int[].
     * @param cartaParaEliminar dato tipo int.
     * @return devuelve el arreglo eliminando la carta de premio usada.  
     */
    public int[] eliminarCartas(int[] mazoDePremios, int[] mazoNuevo, int cartaParaEliminar){
        
        for(int i = 0; i < mazoNuevo.length; i++){
            if(i < (cartaParaEliminar-1)){
                mazoNuevo[i] = mazoDePremios[i];
            }
            if(i >= (cartaParaEliminar-1)){
                mazoNuevo[i] = mazoDePremios[i+1];
            }
        }
        return mazoNuevo;
    } 

    /** 
     * Este método crea un mazo nuevo eliminando el par de cartas escogidas por el usuario y verifica si existe 
     * una tercera carta igual según su letra y número.
     * @param mazoDeCartas dato tipo int[].
     * @param numeroCartaX dato tipo int.
     * @param numeroCartaY dato tipo int.
     * @param terceraCarta dato tipo String.
     * @return devuelve una variable booleana que define si existe una tercera carta.  
     */
    public boolean buscarCartaTrio(String[] mazoDeCartas, int numeroCartaX, int numeroCartaY, String terceraCarta){
        boolean existe = false;
        ModeloJuego juego = new ModeloJuego();

        String[] mazoNuevo = new String[mazoDeCartas.length - 1];
        mazoDeCartas = juego.eliminarCartas(mazoDeCartas, mazoNuevo, numeroCartaX);
        String[] mazoNuevo2 = new String[mazoDeCartas.length - 1];
        mazoDeCartas = juego.eliminarCartas(mazoDeCartas, mazoNuevo2, numeroCartaY-1);

        for(int i = 0; i < mazoDeCartas.length; i++){

            if(mazoDeCartas[i] == terceraCarta){
                existe = true;
            }
        }
        return existe;
    }
    
    /** 
     * Este método maneja todos los casos de emparejamiento de cartas, según su letra, su número y ambos, define los puntos obtenidos
     * de cada jugador y todos sus datos, como el nombre, las indicaciones que da por jugada y si acertó o no.
     * @param mazoDeCartas dato tipo String[].
     * @param mazoDePremios dato tipo int[].
     */
    public void escogerCartas(String[] mazoDeCartas, int[] mazoDePremios){

        boolean puedeSeguirJugando = true;

        VisualizadorJuego visualizador = new VisualizadorJuego();
        ModeloJuego juego = new ModeloJuego(); 

        int numeroJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores participarán en el juego?"));
        JugadorJuego[] jugadores = new JugadorJuego[numeroJugadores];

        for(int i = 0; i < jugadores.length; i++){
            JugadorJuego jugador = new JugadorJuego();
            String nombre = JOptionPane.showInputDialog("Escriba el nombre del Jugador " + (i+1));
            jugador.setNombre(nombre);
            jugadores[i] = jugador;
        }

        JOptionPane.showMessageDialog(null, "Comienza el juego el jugador: " + jugadores[0].getNombre());

        do{

            for(int i = 0; i < jugadores.length; i++){

                int puntosGanados = 0;

                String metodo = JOptionPane.showInputDialog(null,"¿Por cuál método gustaría comparar las cartas?\n"
                + "1: Comparar según la letra\n" 
                + "2: Comparar según el número\n"
                + "3: Comparar según la letra y el número", "Jugador " + (i+1) + ": " + jugadores[i].getNombre(), JOptionPane.INFORMATION_MESSAGE);

                switch(metodo){
                    case "1":
                        String cartasEscogidas1 = JOptionPane.showInputDialog(visualizador.mostraReversoCartas(mazoDeCartas) + "\n" 
                        + "Escoja los números de las cartas que desea comparar con una coma en medio (Ej: 2,4)" + "\n" + "Si en la carta aparece XX significa que fue eliminada del mazo y no puede ser seleccionada");

                        String numeroCarta1 = Character.toString(cartasEscogidas1.charAt(0));
                        String numeroCarta2 = Character.toString(cartasEscogidas1.charAt(2));

                        String carta1 = mazoDeCartas[(Integer.parseInt(numeroCarta1))-1];
                        String carta2 = mazoDeCartas[(Integer.parseInt(numeroCarta2))-1];

                        JOptionPane.showMessageDialog(null, visualizador.mostrarCartasEscogidas(mazoDeCartas, Integer.parseInt(numeroCarta1), Integer.parseInt(numeroCarta2)) + "\n" 
                        + "Las cartas escogidas son: " + carta1 + " y " + carta2);

                        jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                        + "Indicaciones dadas: " + "Carta " + numeroCarta1 + " (" + carta1 + ")" + " -" + " Carta " + numeroCarta2 + " (" + carta2 + ")" + "\n");
                        
                        if(carta1.charAt(0) == carta2.charAt(0)){
                            puntosGanados = Character.getNumericValue(carta1.charAt(2)) + Character.getNumericValue(carta2.charAt(2));
                            JOptionPane.showMessageDialog(null, "Como ambas cartas comparten la letra " + "'"+carta1.charAt(0)+"'" + " los puntos ganados son: " + puntosGanados);
                            
                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCarta1));
                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCarta2));

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                            + "Indicaciones dadas: " + "Carta " + numeroCarta1 + " (" + carta1 + ")" + " -" + " Carta " + numeroCarta2 + " (" + carta2 + ")" + "\n");
                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            JOptionPane.showMessageDialog(null, "Los puntos totales del jugador " + jugadores[i].getNombre() + " son: " + jugadores[i].getPuntosTotales());
                        }
                        else{

                            JOptionPane.showMessageDialog(null, "Las cartas: " + carta1 + " y " + carta2 + " no son iguales en su letra, por lo tanto no gana puntos.");

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "No acertó el par de cartas " + "\n");
                            JOptionPane.showMessageDialog(null, "Los puntos totales del jugador " + jugadores[i].getNombre() + " son: " + jugadores[i].getPuntosTotales());

                        }   
                    break;

                    case "2":
                        String cartasEscogidasA = JOptionPane.showInputDialog(visualizador.mostraReversoCartas(mazoDeCartas) + "\n" 
                        + "Escoja los números de las cartas que desea comparar con una coma en medio (Ej: 2,4)" + "\n" + "Si en la carta aparece XX significa que fue eliminada del mazo y no puede ser seleccionada");

                        String numeroCartaA = Character.toString(cartasEscogidasA.charAt(0));
                        String numeroCartaB = Character.toString(cartasEscogidasA.charAt(2));

                        String cartaA = mazoDeCartas[(Integer.parseInt(numeroCartaA))-1];
                        String cartaB = mazoDeCartas[(Integer.parseInt(numeroCartaB))-1];

                        JOptionPane.showMessageDialog(null, visualizador.mostrarCartasEscogidas(mazoDeCartas, Integer.parseInt(numeroCartaA), Integer.parseInt(numeroCartaB)) + "\n" 
                        + "Las cartas escogidas son: " + cartaA + " y " + cartaB);

                        jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                        + "Indicaciones dadas: " + "Carta " + numeroCartaA + " (" + cartaA + ")" + " -" + " Carta " + numeroCartaB + " (" + cartaB + ")" + "\n");

                        if(cartaA.charAt(2) == cartaB.charAt(2)){
                            puntosGanados = Character.getNumericValue(cartaA.charAt(2)) + Character.getNumericValue(cartaB.charAt(2));
                            JOptionPane.showMessageDialog(null,"Como ambas cartas comparten el número " + "'"+cartaA.charAt(2)+"'" + " los puntos ganados son: " + puntosGanados);
                            
                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCartaA));
                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCartaB));

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                            + "Indicaciones dadas: " + "Carta " + numeroCartaA + " (" + cartaA + ")" + " -" + " Carta " + numeroCartaB + " (" + cartaB + ")" + "\n");
                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            JOptionPane.showMessageDialog(null, "Los puntos totales del jugador " + jugadores[i].getNombre() + " son: " + jugadores[i].getPuntosTotales());
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Las cartas: " + cartaA + " y " + cartaB + " no son iguales en su número, por lo tanto no gana puntos.");

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "No acertó el par de cartas " + "\n");

                            JOptionPane.showMessageDialog(null, "Los puntos totales del jugador " + jugadores[i].getNombre() + " son: " + jugadores[i].getPuntosTotales());
                        }   
                    break;

                    case "3":

                        String cartasEscogidasX = JOptionPane.showInputDialog(visualizador.mostraReversoCartas(mazoDeCartas) + "\n" 
                        + "Escoja los números de las cartas que desea comparar con una coma en medio (Ej: 2,4)" + "\n" + "Si en la carta aparece XX significa que fue eliminada del mazo y no puede ser seleccionada");

                        String numeroCartaX = Character.toString(cartasEscogidasX.charAt(0));
                        String numeroCartaY = Character.toString(cartasEscogidasX.charAt(2));

                        String cartaX = mazoDeCartas[(Integer.parseInt(numeroCartaX))-1];
                        String cartaY = mazoDeCartas[(Integer.parseInt(numeroCartaY))-1];

                        JOptionPane.showMessageDialog(null, visualizador.mostrarCartasEscogidas(mazoDeCartas, Integer.parseInt(numeroCartaX), Integer.parseInt(numeroCartaY)) + "\n" 
                        + "Las cartas escogidas son: " + cartaX + " y " + cartaY);

                        jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                        + "Indicaciones dadas: " + "Carta " + numeroCartaX + " (" + cartaX + ")" + " -" + " Carta " + numeroCartaY + " (" + cartaY + ")" + "\n");

                        if(cartaX.charAt(0) == cartaY.charAt(0) && cartaX.charAt(2) == cartaY.charAt(2)){
                            puntosGanados = Character.getNumericValue(cartaX.charAt(2)) + Character.getNumericValue(cartaY.charAt(2));
                            JOptionPane.showMessageDialog(null,"Como ambas cartas comparten la letra " + "'"+cartaX.charAt(0)+"'" + " y el número " + "'"+cartaX.charAt(2)+"'" + " los puntos ganados son: " + puntosGanados); 

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "\n" + "Nombre: " + jugadores[i].getNombre() + "\n" 
                            + "Indicaciones dadas: " + "Carta " + numeroCartaX + " (" + cartaX + ")" + " -" + " Carta " + numeroCartaY + " (" + cartaY + ")" + "\n");
                            jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el par de cartas " + "\n");

                            if(buscarCartaTrio(mazoDeCartas, Integer.parseInt(numeroCartaX), Integer.parseInt(numeroCartaY), cartaX)){

                                String numeroCarta = JOptionPane.showInputDialog(visualizador.mostrarCartasEscogidas(mazoDeCartas, Integer.parseInt(numeroCartaX), Integer.parseInt(numeroCartaY)) + "\n" 
                                + "Existe una tercera carta igual a " + cartaX + ". Escoja el número de carta donde se ubica: ");

                                String terceraCarta = mazoDeCartas[(Integer.parseInt(numeroCarta))-1];

                                JOptionPane.showMessageDialog(null, visualizador.mostrarCartasEscogidas(mazoDeCartas, Integer.parseInt(numeroCartaX), Integer.parseInt(numeroCartaY), Integer.parseInt(numeroCarta)) + "\n" 
                                + "Las carta escogida es: " + terceraCarta);

                                jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Pudo escoger tercera carta, indicaciones: " + "Carta " + numeroCarta + " (" + terceraCarta + ") " + "\n");

                                if(cartaX.charAt(0) == terceraCarta.charAt(0) && cartaX.charAt(2) == terceraCarta.charAt(2)){

                                    puntosGanados += Character.getNumericValue(terceraCarta.charAt(2));

                                    if(mazoDePremios[0] == 4){
                                        JOptionPane.showMessageDialog(null,"Como logró identificar el trío de cartas iguales se le cuadriplicará su puntaje" + "\n" + "Puntos obtenidos: " + (puntosGanados *= mazoDePremios[0]));
                                    }else{
                                        if(mazoDePremios[0] == 2){
                                            JOptionPane.showMessageDialog(null,"Como logró identificar el trío de cartas iguales se le duplicará su puntaje" + "\n" + "Puntos obtenidos: " + (puntosGanados *= mazoDePremios[0]));  
                                        }else{
                                            if(mazoDePremios[0] == 0){
                                                JOptionPane.showMessageDialog(null,"Logró identificar el trío de cartas iguales, pero no quedan cartas de premio" + "\n" + "Puntos obtenidos: " + (puntosGanados));
                                            }
                                        }              
                                    }

                                    if(mazoDePremios[0] == 0){

                                        jugadores[i].setPuntosGanados(puntosGanados);
                                        jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                                        jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos con la tercera carta: " + jugadores[i].getPuntosGanados() + "\n" 
                                        + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el trio de cartas, pero no quedan cartas de premio" + "\n");
                                        jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "Puntos obtenidos con la tercera carta: " + jugadores[i].getPuntosGanados() + "\n" 
                                        + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el trio de cartas, perno no quedan cartas de premio" + "\n");
                                    }else{

                                        jugadores[i].setPuntosGanados(puntosGanados);
                                        jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                                        jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos con la tercera carta: " + jugadores[i].getPuntosGanados() + "\n" 
                                        + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el trio de cartas, por lo tanto recibio una carta de premio que modifica sus puntos" + "\n");
                                        jugadores[i].setInfoJugadasGanadas(jugadores[i].getInfoJugadasGanadas() + "Puntos obtenidos con la tercera carta: " + jugadores[i].getPuntosGanados() + "\n" 
                                        + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "Acertó el trio de cartas, por lo tanto recibio una carta de premio que modifica sus puntos" + "\n");
                                    }

                                    int[] mazoNuevo = new int[mazoDePremios.length-1];
                                    if(mazoNuevo.length == 0){
                                        mazoDePremios[0] = 0;
                                    }else{
                                        mazoDePremios = juego.eliminarCartas(mazoDePremios, mazoNuevo, 1);
                                    }
                                    
                                    mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCarta));

                                }else{
                                    JOptionPane.showMessageDialog(null,"Como no logró identificar el trío de cartas iguales su puntaje se mantendrá igual" + "\n" + "Puntos obtenidos: " + puntosGanados);

                                    jugadores[i].setPuntosGanados(puntosGanados);
                                    jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                                    jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Pudo escoger tercera carta, indicaciones: " + "Carta " + numeroCarta + " (" + terceraCarta + ") ");
                                    jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                                    + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "No acertó el trio de cartas, por lo tanto sus puntos se mantienen" + "\n");
                                }
                            }

                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCartaX));
                            mazoDeCartas = juego.eliminarCartas(mazoDeCartas, Integer.parseInt(numeroCartaY));
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Las cartas: " + cartaX + " y " + cartaY + " no son iguales en su letra y número, por lo tanto no gana puntos.");

                            jugadores[i].setPuntosGanados(puntosGanados);
                            jugadores[i].setPuntosTotales(puntosGanados += jugadores[i].getPuntosTotales());
                            jugadores[i].setInfoJugadas(jugadores[i].getInfoJugadas() + "Puntos obtenidos: " + jugadores[i].getPuntosGanados() + "\n" 
                            + "Puntos totales: " + jugadores[i].getPuntosTotales() + "\n" + "No acertó el par de cartas " + "\n");
                        }
                    break;
                }
            }
        }while(puedeSeguirJugando == true);
    }
}  