/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package probar;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yaqui
 */
public class Probar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int exit = 1;
        while (exit == 1) {
            int cont = 1;
            System.out.println("______________________________________");
            System.out.println(" B U S C A N D O   E L   T E S O R O");
            System.out.println("______________________________________");
            System.out.println("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Inicia el juego........");
            int filas = 7, filaus;
            int columnas = 7, colus;
            boolean bandera = true;

            String[][] tab = tablero(filas, columnas);
            while (cont <= 5) {
                  System.out.println("Intento " + cont);
                for (int i = 0; i < columnas; i++) {
                    System.out.print("  "+i);
                }
                System.out.println(" ");
              
                //imprime la matriz
                for (int i = 0; i < filas; i++) {
                    System.out.print(i);
                    
                   for (int j = 0; j < columnas; j++) {
                        System.out.print("[" + tab[i][j] + "]");
                    }
                    System.out.println();
                }

                System.out.println("Ingrese la fila: ");
                filaus = sc.nextInt();
                System.out.println("Ingrese la columnas: ");
                colus = sc.nextInt();
                if (filaus > 7) {
                    System.out.println("Error fuera del rango");
                } else if (colus > 7) {
                    System.out.println("Error fuera del rango");
                } else if (filaus < 0) {
                    System.out.println("Error fuera del rango");
                } else if (colus < 0) {
                    System.out.println("Error fuera del rango");
                }
                //cont++;

                while (filaus > 7 || colus > 7 || filaus < 0 || colus < 0);
                if (tab[filaus][colus] == "$") {
                    System.out.println("Felicidades " + nombre + " encontraste el tesoro ($)");
                    cont += 6;
                    bandera = false;
                } else if (tab[filaus][colus] == "X") {
                    System.out.println("Ya eligio esta posicion, repita");
                } else {
                    System.out.println("Siga intentando ");
                }
                tab[filaus][colus] = "X";

                cont++;

            }
            System.out.println("...Desea jugar otra vez.." + nombre);
            System.out.println("(1) para seguir y (0) salir");
            exit = sc.nextInt();
        }

    }

    public static String[][] tablero(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = " ";
            }
        }
        matriz = tesoro(matriz);
        return matriz;
    }

    public static String[][] tesoro(String[][] escoteso) {
        for (int i = 0; i < 1; i++) {
            Random tesoro = new Random();
            int pos_i;
            int pos_j;
            do {
                int max = escoteso.length - 1;
                pos_i = tesoro.nextInt(max);
                pos_j = tesoro.nextInt(max);

            } while (escoteso[pos_i][pos_j].equals("$"));
            escoteso[pos_i][pos_j] = "$";
        }
        return escoteso;
    }
}
