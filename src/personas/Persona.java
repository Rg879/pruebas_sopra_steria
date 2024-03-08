package personas;

public class Persona {

    private int edad;
    private Sexo sexo;

    public Persona(int edad, Sexo sexo) {
        this.edad=edad;
        this.sexo=sexo;
    }

    public int getEdad() { return edad; }

    public Sexo getSexo() { return sexo; }

    public void setEdad(int edad) { this.edad = edad; }

    public void setSexo(Sexo sexo) { this.sexo = sexo; }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", sexo=" + sexo +
                '}';
    }
}
