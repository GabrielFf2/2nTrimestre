import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        boolean win = false;

        while (!win){
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige posicion de la pieza");
            int row = scan.nextInt();
            int col = scan.nextInt();
            tablero.colocarPieza(row,col);
            if (tablero.checkFil()||tablero.checkCol()||tablero.checDiagonal()||tablero.checDiagonalInversa()){
                tablero.imprTablero();
                System.out.println("La partida ha acabat .");
                break;
            }
            tablero.imprTablero();

        }



    }
}