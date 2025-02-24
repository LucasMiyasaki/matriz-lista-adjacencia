import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      MatrizA matriz = new MatrizA();
      ListaA lista = new ListaA();
      Scanner scanner = new Scanner(System.in);
      String filename = "MATRIZ.txt";
      int ml = 1;
      char converter = 's';

      while (ml > 0) {
         System.out.println();
         System.out.println("1. Matriz de Adjacência");
         System.out.println("2. Lista de Adjacência");
         System.out.println("0. Sair");
         System.out.print("Escolha uma opção: ");
         try {
            ml = scanner.nextInt();
         } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
            scanner.next();
         }

         if (ml == 1) {
            matriz.readFile(filename);
            matriz.verificar();

            System.out.println();
            System.out.println("Converter para Lista? [S] / [N]");
            try {
               converter = scanner.next().charAt(0);
            } catch (InputMismatchException e) {
               System.out.println("Entrada inválida");
               scanner.next();
            }
            if (converter == 's' || converter == 'S') {
               matriz.converter(lista);
               lista.verificar();
            }
         } else if (ml == 2) {
            lista.readFile(filename);
            lista.verificar();

            System.out.println();
            System.out.println("Converter para Matriz? [S] / [N]");
            try {
               converter = scanner.next().charAt(0);
            } catch (InputMismatchException e) {
               System.out.println("Entrada inválida");
               scanner.next();
            }
            if (converter == 'S' || converter == 's') {
               lista.converter(matriz);
               matriz.verificar();
            }
         }
      }
   }
}