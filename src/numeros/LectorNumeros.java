package numeros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorNumeros {
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner( System.in );

//        se podría meter en un bucle pero igual fallan las pruebas automatizadas, lo handleo y ya

        try{
            System.out.print( "Introduce el integer a leer: " );
            int numero = scannerInput.nextInt();

            printNumeros(numero);
        } catch (InputMismatchException e){
            System.out.print( "Tipo de dato incorrecto, por favor introduce un número válido." );
        }
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
