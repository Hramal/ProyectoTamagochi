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

    private int sueno = this.energia;

    private boolean comeDemasiado = false;


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
        if (this.guarro <= 0)
            guarro = 0;
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
        if (energia <= 50) {
            this.energia += 5;
            return true;

        }
        if (energia >= 75) {
            return false;
        }
        return (sueno < energia);

    }

    public boolean estasFeliz() {
        return (this.salud > 80 && this.hambre < 3 && this.guarro < 25);
    }

    public boolean estasEnfermo() {
        this.salud -= 5;
        if (this.salud <= 0){
            this.salud = 0;

        }
        return (this.salud <= 25 && this.salud == 0);
    }


    public boolean estasSucio() {
        return this.guarro >= 75;
    }

    public boolean estasMuerto() {
        return this.salud == 0;

    }

    public boolean tienesHambre() {
        return this.hambre >= 7;
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        vivido += segundos;
        if (vivido > 5) {
            if (this.hambre == 10) {
                tienesHambre();
                estasEnfermo();
                perderPeso(10);
            } else {
                this.hambre++;
            }
            if (this.guarro == 100) {
                estasSucio();
            } else {
                this.guarro += 10;
            }
            if (this.salud == 0) {
                estasMuerto();
            } else if (this.salud <= 30) {
                estasEnfermo();
            } else {
                this.salud -= 5;
            }
            if (this.salud <= 0){
                this.salud = 0;
            }
            if (this.energia == 0) {
                estasDormido();
            } else {
                this.energia -= 5;
            }
            vivido = 0;
        }
    }

    public boolean tienesQuejas() {
        return (tienesHambre() || estasSucio());

    }

    public void alimentar(float cantidadAlimento) {
        if (!tienesHambre()) {
            this.hambre -= cantidadAlimento;
            comeDemasiado = true;
            estasEnfermo();

        } else {
            this.hambre -= cantidadAlimento;
            aumentarSalud(cantidadAlimento);
            ganarPeso(cantidadAlimento);
            aumentarEnergia(cantidadAlimento);
        }
        if (this.hambre <= 0) {
            this.hambre = 0;
        }
    }

    public void curar(float cantidadMedicina) {
        this.salud += cantidadMedicina;
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

    }

    private void aumentarSalud(float cantidad) {
        this.salud += cantidad;

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