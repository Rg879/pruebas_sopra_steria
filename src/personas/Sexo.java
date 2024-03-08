package personas;

public enum Sexo{
    HOMBRE, MUJER, NO_DEFINIDO;

    public static Sexo getSexoByNumber(int numero){
        return switch (numero) {
            case 2 -> HOMBRE;
            case 1 -> MUJER;
            default -> NO_DEFINIDO;
        };
    }

    public static int getValor(Sexo sexo){
        return switch (sexo) {
            case HOMBRE -> 2;
            case MUJER -> 1;
            default -> 0;
        };
    }
}
