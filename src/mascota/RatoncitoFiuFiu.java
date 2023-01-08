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

    private final int LIMITEEDAD = 10000;

    private boolean estaRoncando;


    private boolean comeDemasiado;

    private int felicidad;


    public RatoncitoFiuFiu(String nombre, int peso, byte hambre, byte guarro, byte salud, byte energia) {
        this.nombre = nombre;
        this.peso = peso;
        this.hambre = hambre;
        this.guarro = guarro;
        this.salud = salud;
        this.energia = energia;
        this.edad = 0;
        this.estaRoncando = false;
        this.felicidad = 100;
    }

    public String estadisticas() {
        StringBuilder sb = new StringBuilder("RatoncitoFiuFiu");

        sb.append("peso: ").append(this.peso);
        sb.append("\nhambre: ").append(this.hambre);
        sb.append("\nguarro: ").append(this.guarro);
        sb.append("\nsalud: ").append(this.salud);
        sb.append("\nenergia: ").append(this.energia);
        sb.append("\nfelicidad: ").append(this.felicidad);

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
        if (energia <= 35) {
            estaRoncando = true;
        } else if (energia > 65) {
            estaRoncando = false;

        }
        return estaRoncando;
    }

    public boolean estasFeliz() {
        return felicidad >=75;
    }

    public boolean estasEnfermo() {
        return this.salud <= 25;
    }

    public boolean estasSucio() {
        return this.guarro >= 75;

    }

    public boolean estasMuerto() {
        return (this.salud <= 0 || edad > LIMITEEDAD);

    }

    public boolean tienesHambre() {
        return this.hambre >= 70;
    }

    private void aumentarFelicidad(float cantidad){
        this.felicidad += cantidad;
        if(felicidad >= 100){
            this.felicidad = 100;
        }
        if(felicidad <=0){
            this.felicidad = 0;
        }
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        vivido += segundos;
        if (vivido > 5) {
            if (this.hambre >= 100) {
                tienesHambre();
                estasEnfermo();
                perderPeso(5);
                this.hambre = 100;
            } else {
                this.hambre++;
            }
            if (this.guarro >= 100) {
                this.guarro = 100;
            } else {
                this.guarro += 10;
            }
            if (this.salud <= 0) {

                this.salud = 0;
            } else if (this.salud <= 25) {

                this.salud -= 5;
            } else {
                this.salud -= 5;
            }
            if (this.energia <= 0) {

                this.energia = 0;
            } else {
                this.energia -= 5;
            }
            if (energia <= 35) {
                estaRoncando = true;
            } else if (energia > 65) {
                estaRoncando = false;
            }
            if (estaRoncando) {
                aumentarEnergia(5);
            }
            vivido = 0;
            if (estasEnfermo()){
                aumentarFelicidad(-1);
            }
        }
    }

    public boolean tienesQuejas() {
        return (!estasFeliz());
    }

    public void alimentar(float cantidadAlimento) {
        if (tienesHambre()) {
            aumentarSalud(cantidadAlimento);
            aumentarFelicidad(cantidadAlimento);
            comeDemasiado = false;
        } else {
            comeDemasiado = true;
            aumentarFelicidad(-cantidadAlimento);
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
        aumentarFelicidad(cantidadMedicina);
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
        if (energia <= 35) {
            estaRoncando = true;
        } else if (energia > 65) {
            estaRoncando = false;

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
            aumentarFelicidad(-cantidad);
        }
        if (peso <= 35) {
            peso = 35;
        }
    }

    public boolean jugar (float cantidadDiversion){

        if (estasEnfermo() || estasSucio() || estasDormido() || tienesHambre()){
            return false;
        }else{
            this.energia -=cantidadDiversion;
            this.hambre +=cantidadDiversion;
            this.felicidad +=cantidadDiversion;
            aumentarFelicidad(cantidadDiversion);
            return true;
        }
    }




}