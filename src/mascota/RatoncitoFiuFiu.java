package mascota;

public class RatoncitoFiuFiu {
    private String nombre;
    private int edad;
    private int peso;
    private byte hambre;
    private byte guarro;

    private byte salud;
    private byte energia;



    public RatoncitoFiuFiu(String nombre, int peso, byte hambre, byte guarro, byte salud, byte energia) {
        this.nombre = nombre;
        this.peso = peso;
        this.hambre = hambre;
        this.guarro = guarro;
        this.salud = salud;
        this.energia = energia;
        this.edad = 0;

    }




    public String estadisticas() {
        StringBuilder sb = new StringBuilder("RatoncitoFiuFiu");

        sb.append("peso: ").append(this.peso);
        sb.append("\nhambre: ").append(this.hambre);
        sb.append("\nguarro: ").append(this.guarro);
        sb.append("\nsalud: ").append(this.salud);
        sb.append("\nenergia: ").append(this.energia);

        return sb.toString();
    }

    public void limpiar(float esfuerzoHigienico) {
        this.guarro -= esfuerzoHigienico;
    }

    public int queTramoEdad() {
        return 0;
    }

    public boolean estasDormido() {
        return false;
    }

    public boolean estasEnfermo() {
        return false;
    }

    public boolean estasSucio() {
        return false;
    }

    public boolean estasMuerto() {
        return false;
    }

    public void envejecer(int i) {

    }

    public boolean tienesQuejas() {
        return false;
    }

    public void alimentar(float cantidadAlimento) {
        this.hambre -= cantidadAlimento;
    }

    public void curar(float cantidadMedicina) {
        this.salud += cantidadMedicina;
    }
}