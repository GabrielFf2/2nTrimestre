public class Tablero {
    Pieza[][] tab = new  Pieza[3][3];

    public Tablero(){
        inicializarTablero();
    }
    public void imprTablero (){
        for (int y = this.tab.length-1 ; y >= 0 ; y--){
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
    int turno = 1;

    public void colocarPieza (int row , int col){
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
    public boolean checkFil(){
        boolean result = false;
        for (int y =0 ; y < this.tab.length ;y++){
            for (int x =y+1 ; x < this.tab.length ;x++){
                if (this.tab[y][0].getPieza().equals(this.tab[y][x].getPieza()) && this.tab[y][x].getPieza().equals(this.tab[y][x-1].getPieza()) && this.tab[y][x-1].ocupada && this.tab[y][x].ocupada){
                    result = true;
                }else {
                    result = false;
                }
            }
            if (result){
                return result;
            }
        }
        return result;
    }

    public boolean checkCol(){
        boolean result = false;
        for (int y =0 ; y < this.tab.length ;y++){
            for (int x =y+1 ; x < this.tab.length ;x++){
                if (this.tab[0][y].getPieza().equals(this.tab[x][y].getPieza()) && this.tab[x][y].getPieza().equals(this.tab[x-1][y].getPieza()) && this.tab[y][x-1].ocupada && this.tab[y][x].ocupada){
                    result = true;
                }else {
                    result = false;
                }
            }
            if (result){
                return result;
            }
        }
        return result;
    }

    public boolean checDiagonal(){
        boolean result = false;
        for (int y = 1 ; y < this.tab.length ;y++){
            if (this.tab[0][0].getPieza().equals(this.tab[y][y].getPieza()) && this.tab[y-1][y-1].getPieza().equals(this.tab[y][y].getPieza()) && this.tab[y][y].ocupada && this.tab[0][0].ocupada){
                result = true;
            }else {
                result = false;
            }
        }
        return result;
    }

    public boolean checDiagonalInversa(){
        boolean result = false;
        for (int y = this.tab.length-1 ; y > 0 ; y--){
            for (int x = 0 ; x < this.tab.length-1 ; x++){
                if (this.tab[2][0].getPieza().equals(this.tab[y-1][x+1].getPieza()) && this.tab[y][x].getPieza().equals(this.tab[y-1][x+1].getPieza()) && this.tab[2][0].ocupada && this.tab[y-1][x+1].ocupada){
                    result = true;
                }
            }
        }

        return result;
    }



    public Pieza[][] getTab() {
        return this.tab;
    }

}