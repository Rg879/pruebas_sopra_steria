package personas;

import java.util.*;

public class LectorPersonas {
    class PersonaOrdenada extends Persona implements Comparable{
        public PersonaOrdenada(int edad, Sexo sexo) {
            super(edad, sexo);
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        try{
            Persona [] arrayPersonas = leerPersonas();
            printPersonas(arrayPersonas);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    usar instrucción leerNumero, quizas las pruebas lo sustituyen por un mock en vez de introducir input
    public static Persona[] leerPersonas(){
//        poblamos el array de prueba
        Persona[] arrayPersonas = new Persona[50];
        Random randomGenerator = new Random(123123);
        for(int i=0; i<50;i++){
            arrayPersonas[i] = new Persona(
                    randomGenerator.nextInt(0, 113),
                    Sexo.getSexoByNumber(randomGenerator.nextInt(1, 3))
            );
        }
        return arrayPersonas;
    }

    public static void printPersonas(Persona[] arrayPersonas){
        if (arrayPersonas == null || arrayPersonas.length == 0){
            System.out.println("No hay elementos.");
        }

//        ordenamos por edad
        Persona[] ordenEdad = Arrays.copyOfRange(arrayPersonas, 0, arrayPersonas.length);
        Arrays.sort(ordenEdad, (o1, o2) -> o1.getEdad() - o2.getEdad());

//        busqueda binaria, primer elemento mayor de edad (el es mayor de edad y es el primer elemento o el anterior no lo es)
        int indexEdad=-1;
        int inicio = 0;
        int fin = ordenEdad.length -1;
        while (inicio <= fin) {
            int medio = inicio  + ((fin - inicio) / 2);
            if (ordenEdad[medio].getEdad() < 18) {
                inicio = medio + 1;
            } else if (ordenEdad[medio].getEdad() >= 18 && medio > 0 &&
                    ordenEdad[medio -1].getEdad() >= 18) {
                fin = medio - 1;
            } else if (ordenEdad[medio].getEdad() >= 18 && (medio == 0 ||
                    ordenEdad[medio -1].getEdad() < 18)) {
                indexEdad = medio;
                break;
            }
        }
        if(indexEdad == -1 ){
            System.out.println("Numero de personas mayores de edad: " + 0);
            System.out.println("Numero de personas menores de edad: " + ordenEdad.length);
        } else {
            int indice_persona_mayor = indexEdad > 0 ? indexEdad :0;
            System.out.println("Numero de personas mayores de edad: " + (ordenEdad.length - (indice_persona_mayor)));
            System.out.println("Numero de personas menores de edad: " + indice_persona_mayor);
        }

//        personas masculinas mayores de edad. 
//        En el problema no se especifica que pueden ser de sexo desconocido, no lo contemplamos
        Persona[] ordenSexo1 = Arrays.copyOfRange(ordenEdad, indexEdad, arrayPersonas.length);
        Arrays.sort(ordenSexo1, (o1, o2) -> Sexo.getValor(o1.getSexo()) - Sexo.getValor(o2.getSexo()));

//        busqueda binaria, masculino
        int indexSexo1=-1;
        inicio = 0;
        fin = ordenSexo1.length -1;
        while (inicio <= fin) {
            int medio = inicio  + ((fin - inicio) / 2);
            if (ordenSexo1[medio].getSexo() != Sexo.HOMBRE) {
                inicio = medio + 1;
            } else if (ordenSexo1[medio].getSexo() == Sexo.HOMBRE && medio > 0 &&
                    ordenSexo1[medio -1].getSexo() == Sexo.HOMBRE) {
                fin = medio - 1;
            } else if (ordenSexo1[medio].getSexo() == Sexo.HOMBRE && (medio == 0 ||
                    ordenSexo1[medio -1].getSexo() != Sexo.HOMBRE)) {
                indexSexo1 = medio;
                break;
            }
        }

        System.out.println("Numero de hombres mayores de edad: " + (indexSexo1 == -1? 0 : ordenSexo1.length - indexSexo1));

//        personas femeninas menores de edad. 
//        En el problema no se especifica que pueden ser de sexo desconocido, no lo contemplamos
        Persona[] ordenSexo2 = Arrays.copyOfRange(ordenEdad, 0, indexEdad);
        Arrays.sort(ordenSexo2, (o1, o2) -> Sexo.getValor(o2.getSexo()) - Sexo.getValor(o1.getSexo()));

//        busqueda binaria, masculino
        int indexSexo2=-1;
        inicio = 0;
        fin = ordenSexo2.length -1;
        while (inicio <= fin) {
            int medio = inicio  + ((fin - inicio) / 2);
            if (ordenSexo2[medio].getSexo() != Sexo.MUJER) {
                inicio = medio + 1;
            } else if (ordenSexo2[medio].getSexo() == Sexo.MUJER && medio > 0 &&
                    ordenSexo2[medio -1].getSexo() == Sexo.MUJER) {
                fin = medio - 1;
            } else if (ordenSexo2[medio].getSexo() == Sexo.MUJER && (medio == 0 ||
                    ordenSexo2[medio -1].getSexo() != Sexo.MUJER)) {
                indexSexo2 = medio;
                break;
            }
        }

        System.out.println("Numero de mujeres menores de edad: " + (indexSexo2 == -1? 0 : ordenSexo2.length - indexSexo2));

        System.out.println("Porcentaje de personas mayores de edad respecto a numero de personas: " +
                (ordenEdad.length - (indexEdad > 0 ? indexEdad :0)) / (double) arrayPersonas.length * 100 + "%");

        int numero_total_mujeres = (indexSexo2 == -1? 0 : ordenSexo2.length - indexSexo2) + (
                ordenSexo1.length-(indexSexo1 == -1? 0 : ordenSexo1.length - indexSexo1));

        System.out.println("Porcentaje de mujeres respecto a numero de personas: " + numero_total_mujeres / (double) arrayPersonas.length * 100 + "%");
    }
}
