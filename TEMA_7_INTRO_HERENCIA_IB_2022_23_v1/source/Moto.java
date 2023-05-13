public class Moto extends Vehicle {
    private int cilindrada;
    private final static double IMPOST = 1.2;

    // Constructor amb paràmetres
    public Moto(String marca, int motor, double preu, int cilindrada) {
        super(marca, motor, preu);

        // Validar les dades d'entrada
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("La cilindrada ha de ser un valor positiu.");
        }

        this.cilindrada = cilindrada;
    }

    // Mètode per establir la cilindrada
    public void setCilindrada(int cilindrada) {
        // Validar les dades d'entrada
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("La cilindrada ha de ser un valor positiu.");
        }

        this.cilindrada = cilindrada;
    }

    // Mètode per obtenir la cilindrada
    public int getCilindrada() {
        return cilindrada;
    }

    // Mètode per calcular el preu de la moto
    @Override
    public double calcularPreu() {
        return super.getPreu() * IMPOST;
    }

    // Mètode per mostrar les dades de la moto
    public void mostrarMoto() {
        super.mostrarVehicle();
        System.out.println(", Cilindrada: " + cilindrada);
    }

    // Override del mètode toString per mostrar les dades de la moto
    @Override
    public String toString() {
        return super.toString() + ", Cilindrada: " + cilindrada;
    }
}
