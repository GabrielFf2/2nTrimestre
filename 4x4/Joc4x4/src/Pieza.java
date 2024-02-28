public class Pieza {

    String pieza ;
    boolean ocupada ;
    int row ;
    int col;

    public Pieza (int row , int col){
        this.pieza = "⬜";
        this.ocupada = false;
    }
    public String getPieza() {
        return pieza;
    }
    public void setPieza(String pieza) {
        this.pieza = pieza;
    }
    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
