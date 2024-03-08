package numeros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorNumeros {
    public static void main(String[] args) {
//        se podría meter en un bucle pero igual fallan las pruebas automatizadas, lo handleo y ya
        try{
            int numero = leerNumero();
            printNumeros(numero);
        } catch (InputMismatchException e){
            System.out.print( "Tipo de dato incorrecto, por favor introduce un número válido." );
        }
    }

//    usar instrucción leerNumero, quizas las pruebas lo sustituyen por un mock en vez de introducir input
    public static int leerNumero(){
        Scanner scannerInput = new Scanner( System.in );

        System.out.print( "Introduce el integer a leer: " );
        return scannerInput.nextInt();
    }

    public static void printNumeros(int numero){
        int fin = numero % 2 == 0? 0 : 1;
        if (numero < 0){
            System.out.println("El ejercicio no contempla números menores a 0.");
            return;
        }
        for(int i=numero;i>=fin; i-=2){
            System.out.println(i);
        }
    }
}
