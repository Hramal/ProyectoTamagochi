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

    private final int INFANCIA = 0;

    private final int ADULTO = 1;
    private final int VEJEZ = 2;


    private boolean comeDemasiado;


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
        if (this.guarro <= 0) {
            guarro = 0;
        }
    }

    public int queTramoEdad() {
        if (edad <= 2500) {
            return INFANCIA;
        } else if (edad < 8000) {
            return ADULTO;
        } else {
            return VEJEZ;
        }
    }

    public boolean estasDormido() {
        return (energia <= 35);
    }

    public boolean estasFeliz() {
        return (this.salud > 80 && this.hambre < 3 && this.guarro < 25);
    }

    public boolean estasEnfermo() {
        return (this.salud <= 25 || comeDemasiado);
    }

    public boolean estasSucio() {
        return this.guarro >= 75;
    }

    public boolean estasMuerto() {
        return this.salud <= 0;

    }

    public boolean tienesHambre() {
        return this.hambre >= 70;
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        vivido += segundos;
        if (vivido > 15) {
            if (this.hambre >= 100) {
                tienesHambre();
                estasEnfermo();
                perderPeso(5);
                this.hambre = 100;
            } else {
                this.hambre++;
            }
            if (this.guarro >= 100) {
                estasSucio();
                this.guarro = 100;
            } else {
                this.guarro += 10;
            }
            if (this.salud <= 0) {
                estasMuerto();
                this.salud = 0;
            } else if (this.salud <= 30) {
                estasEnfermo();
            } else {
                this.salud -= 5;
            }
            if (this.energia <= 0) {
                estasDormido();
                this.energia = 0;
            } else {
                this.energia -= 5;
            }
            vivido = 0;
        }
    }

    public boolean tienesQuejas() {
        return (!estasFeliz());
    }

    public void alimentar(float cantidadAlimento) {
        if (tienesHambre()) {
            aumentarSalud(cantidadAlimento);
            comeDemasiado = false;
        } else {
            comeDemasiado = true;
        }
        this.hambre -= cantidadAlimento;
        if (this.hambre <= 0) {
            this.hambre = 0;
        }
        if (!estasEnfermo()) {
            ganarPeso(cantidadAlimento);
        }
    }

    public void curar(float cantidadMedicina) {
        aumentarSalud(cantidadMedicina);
        aumentarEnergia(cantidadMedicina);
    }

    private void ganarPeso(float cantidad) {
        if (!estasEnfermo()) {
            this.peso += cantidad;
        }

    }

    private void aumentarEnergia(float cantidad) {
        this.energia += cantidad;
        if (this.energia >= 100) {
            this.energia = 100;
        }

    }

    private void aumentarSalud(float cantidad) {
        this.salud += cantidad;
        if (this.salud >= 100) {
            this.salud = 100;
        }
    }

    private void perderPeso(float cantidad) {
        if (tienesHambre() || estasEnfermo()) {
            this.peso -= cantidad;
        }
        if (peso <= 35) {
            peso = 35;
        }
    }
}