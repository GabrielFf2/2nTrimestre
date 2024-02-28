public class Tablero {

    private final int fila = 6;
    private final int columna = 7;
    Pieza[][] tab = new  Pieza[fila][columna];

    public Tablero(){
        inicializarTablero();
    }
    public void imprTablero (){
        for (int y = 0 ; y < this.tab.length ; y++){
            for (int x = 0 ; x < this.tab[y].length ; x++){
                System.out.print(this.tab[y][x].getPieza());
            }
            System.out.println();
        }
    }
    public void inicializarTablero (){
        for (int y = 0 ; y < this.tab.length ; y++){
            for (int x = 0 ; x < this.tab[y].length ; x++){
                this.tab[y][x]= new Pieza(y,x);
            }
        }
    }
    public void colocarPieza ( int col ,int turno){
        int row=mirarFila(col);

        if (!this.tab[row][col].isOcupada()){
            if (turno%2 == 0 ){
                this.tab[row][col].setOcupada(true);
                this.tab[row][col].setPieza("❌");
                turno++;
            }else {
                this.tab[row][col].setOcupada(true);
                this.tab[row][col].setPieza("⭕");
                turno++;
            }
        }
    }
    public int mirarFila (int columna){
        int a = 0;
        for (int x=0 ; x < tab.length ; x++){
            if (!this.tab[x][columna].isOcupada()){
                a=x;
            }
        }
        return a;
    }
    public boolean checkFil() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (esCuatroEnRaya(tab[fila][columna], tab[fila][columna + 1],
                        tab[fila][columna + 2], tab[fila][columna + 3])) {
                    return true;
                }
            }
        }
        return false;
    }
    // Método para comprobar las columnas
    public boolean checkCol() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                if (esCuatroEnRaya(tab[fila][columna], tab[fila + 1][columna],
                        tab[fila + 2][columna], tab[fila + 3][columna])) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checDiagonal() {
        // Comprobar diagonales principales (\)
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (esCuatroEnRaya(tab[fila][columna], tab[fila + 1][columna + 1],
                        tab[fila + 2][columna + 2], tab[fila + 3][columna + 3])) {
                    return true;
                }
            }
        }
        // Comprobar diagonales secundarias (/)
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 3; columna < 7; columna++) {
                if (esCuatroEnRaya(tab[fila][columna], tab[fila + 1][columna - 1],
                        tab[fila + 2][columna - 2], tab[fila + 3][columna - 3])) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean esCuatroEnRaya(Pieza a, Pieza b, Pieza c, Pieza d) {
        return a.getPieza().equals(b.getPieza()) && a.getPieza().equals(c.getPieza()) && a.getPieza().equals(d.getPieza()) && a.isOcupada() && b.isOcupada() && c.isOcupada() && d.isOcupada();
    }

    public Pieza[][] getTab() {
        return this.tab;
    }

}
