public class Suv extends Cotxe {
    private boolean is4x4;
    private static final double SUV_4X4_FEE = 1.1;
    private static final double IMPOST = 1.4;

    // Constructor amb paràmetres
    public Suv(String marca, int motor, double preu, int places, String tipus, boolean is4x4) {
        super(marca, motor, preu, places, tipus);
        this.is4x4 = is4x4;
    }

    // Getter i setter per is4x4
    public boolean is4x4() {
        return is4x4;
    }

    public void set4x4(boolean is4x4) {
        this.is4x4 = is4x4;
    }
    
    @Override
    public double calcularPreu() {
        double preu = super.calcularPreu();
        if (is4x4) {
            preu *= SUV_4X4_FEE;
        }
        return preu * IMPOST;
    }

    // Override del mètode mostrarCotxe per mostrar si el SUV és 4x4 o no
    @Override
    public void mostrarCotxe() {
        super.mostrarCotxe();
        System.out.println(", 4x4: " + (is4x4 ? "Sí" : "No"));
    }

    // Override del mètode toString per incloure l'atribut 4x4
    @Override
    public String toString() {
        return super.toString() + ", 4x4: " + (is4x4 ? "Sí" : "No");
    }
}
