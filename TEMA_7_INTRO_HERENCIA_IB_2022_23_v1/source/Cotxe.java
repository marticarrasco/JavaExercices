public class Cotxe extends Vehicle {
    // Constants per als impostos i el nombre màxim de places
    private final static double IMPOST_COTXE = 1.3;
    private static final int MAX_PLACES = 7;

    protected int places;
    protected String tipus;

    // Constructor amb paràmetres
    public Cotxe(String marca, int motor, double preu, int places, String tipus) {
        // Cridar el constructor de la superclasse
        super(marca, motor, preu);

        // Validar les dades d'entrada
        if (places <= 0 || places > MAX_PLACES) {
            throw new IllegalArgumentException("El nombre de places ha de ser entre 1 i " + MAX_PLACES);
        }
        if (tipus == null || tipus.isEmpty()) {
            throw new IllegalArgumentException("El tipus de combustible no pot estar buit");
        }

        this.places = places;
        this.tipus = tipus;
    }

    // Mètodes getters i setters per les dades del cotxe
    public void setPlaces(int places) {
        // Validar les dades d'entrada
        if (places <= 0 || places > MAX_PLACES) {
            throw new IllegalArgumentException("El nombre de places ha de ser entre 1 i " + MAX_PLACES);
        }

        this.places = places;
    }

    public void setTipus(String tipus) {
        // Validar les dades d'entrada
        if (tipus == null || tipus.isEmpty()) {
            throw new IllegalArgumentException("El tipus de combustible no pot estar buit");
        }

        this.tipus = tipus;
    }

    public int getPlaces() {
        return places;
    }

    public String getTipus() {
        return tipus;
    }

    // Mètode per calcular el preu del cotxe, tenint en compte l'impost
    @Override
    public double calcularPreu() {
        return super.getPreu() * IMPOST_COTXE;
    }

    // Mètode per mostrar les dades del cotxe
    public void mostrarCotxe() {
        super.mostrarVehicle();
        System.out.println(", Places: " + places + ", Tipus de combustible: " + tipus);
    }

    // Mètode toString per mostrar les dades del cotxe
    @Override
    public String toString() {
        return super.toString() + ", Places: " + places + ", Tipus de combustible: " + tipus;
    }
}
