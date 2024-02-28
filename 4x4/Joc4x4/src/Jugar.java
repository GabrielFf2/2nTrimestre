import java.util.Scanner;

public class Jugar {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        int turno = 0;

        System.out.println("El primer jugador jugara con las ❌ y el segundo con las ⭕");
        tablero.imprTablero();
        while (turno < 42){
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige La columna de la pieza");
            int col = scan.nextInt();
            tablero.colocarPieza(col, turno);
            if (tablero.checkFil()||tablero.checkCol()||tablero.checDiagonal()){
                tablero.imprTablero();
                System.out.println("La partida ha acabat .");
                break;
            }
            tablero.imprTablero();
            turno++;
        }
    }
}
