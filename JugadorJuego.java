public class JugadorJuego {

    String nombre;
    int puntosGanados;
    int puntosTotales;
    int cartaVoltear1;
    int cartaVoltear2;
    boolean acerto;
    String infoJugadas;
    String infoJugadasGanadas;

    public JugadorJuego(){
        nombre = "";
        cartaVoltear1 = 0;
        cartaVoltear2 = 0;
        puntosGanados = 0;
        puntosTotales = 0;
        acerto = false;
        infoJugadas = ""; 
        infoJugadasGanadas = "";
    }

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public void setCartaVoltear1(int carta){
        this.cartaVoltear1 = carta;
    }

    public void setCartaVoltear2(int carta){
        this.cartaVoltear2 = carta;
    }

    public void setPuntosGanados(int puntos){
        this.puntosGanados = puntos;
    }

    public void setPuntosTotales(int puntos){
        this.puntosTotales = puntos;
    }

    public void setAcerto(boolean acerto){
        this.acerto = acerto;
    }

    public void setInfoJugadas(String infoJugadas){
        this.infoJugadas = infoJugadas;
    }

    public void setInfoJugadasGanadas(String infoJugadasGanadas){
        this.infoJugadasGanadas = infoJugadasGanadas;

    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCartaVoltear1(){
        return this.cartaVoltear1;
    }

    public int getPuntosGanados(){
        return this.puntosGanados;
    }

    public int getPuntosTotales(){
        return this.puntosTotales;
    }

    public boolean getAcerto(){
        return this.acerto;
    }

    public String getInfoJugadas(){
        return this.infoJugadas;
    }

    public String getInfoJugadasGanadas(){
        return this.infoJugadasGanadas;
    }
}
