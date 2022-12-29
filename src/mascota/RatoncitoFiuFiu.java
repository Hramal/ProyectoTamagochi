package mascota;

public class RatoncitoFiuFiu {
    private String nombre;
    private int edad;
    private int peso;
    private byte hambre;
    private byte guarro;

    private byte salud;
    private byte energia;

    private int vivido;


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
    public boolean estasFeliz(){
        return (this.salud > 80 && this.hambre < 3 && this.guarro < 25);
    }

    public boolean estasEnfermo() {
        return (this.salud <= 25 && this.salud < 1);

    }

    public boolean estasSucio() {
        return this.guarro >= 75;
    }

    public boolean estasMuerto() {
        return this.salud == 0;

    }

    public boolean tienesHambre(){
        return this.hambre >7;
    }

    public void envejecer(int segundos) {
        this.edad = edad + segundos;
        vivido += segundos;
        if (vivido >= 1000) {
            this.hambre = (byte) (hambre + (byte) (vivido * 0.001));
            if (this.hambre > 10) {
                this.hambre = 10;
                tienesHambre();
                estasEnfermo();
            }
            this.salud = (byte) (salud - (byte) (vivido * 0.01));
            if (this.salud <= 25) {
                estasEnfermo();
            }
            if (this.salud <= 0) {
                this.salud = 0;
                estasMuerto();
            }
            this.guarro = (byte) (guarro + (byte) (vivido * 0.01));
            if (this.guarro > 100) {
                this.guarro = 100;
                estasSucio();
            }
            if (this.energia == 0) {
                estasDormido();
            } else {
                this.energia = (byte) (energia - (byte) (vivido * 0.01));

            }
            vivido = 0;
        }

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