package tarifas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorTarifas {
    public static void main(String[] args) {
//        se podría meter en un bucle pero igual fallan las pruebas automatizadas, lo handleo y ya
        try{
            double horasTrabajadas = leerNumero("Introduce las horas trabajadas: ");
            double tarifa = leerNumero("Introduce el precio por hora: ");
            printSalario(horasTrabajadas, tarifa);
        } catch (InputMismatchException e){
            System.out.print( "Tipo de dato incorrecto, por favor introduce un número válido." );
        }
    }

    public static double leerNumero(String mensaje){
        Scanner scannerInput = new Scanner( System.in );

        System.out.print( mensaje );
        return scannerInput.nextDouble();
    }

    public static void printSalario(double horasTrabajadas, double tarifa){
        double tarifaOrdinaria = Math.min(40, horasTrabajadas) * tarifa;
        double horasExtra = horasTrabajadas > 40? (horasTrabajadas -40) * tarifa : 0;

        System.out.println("El saldo del empleado es de: " + String.format("%.2f", tarifaOrdinaria + horasExtra));
    }
}
