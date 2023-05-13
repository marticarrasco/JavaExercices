public class Turisme extends Cotxe {
    private String size;
    private static final int MAX_PLACES = 7;
    private static final double IMPOST = 1.25;

    // Constructor amb paràmetres
    public Turisme(String marca, int motor, double preu, int places, String tipus, String size) {
        super(marca, motor, preu, places, tipus);
        setSize(size);
    }

    // Setter per a size que comprova si el valor és vàlid
    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("El tamany no pot estar buit");
        }
        this.size = size;
    }

    // Getter per a size
    public String getSize() {
        return size;
    }

    // Override de mostrarCotxe per a mostrar el tamany en lloc del tipus de combustible
    @Override
    public void mostrarCotxe() {
        super.mostrarCotxe();
        System.out.println(", Tamany: " + size);
    }

    // Override de toString per a incloure el tamany
    @Override
    public String toString() {
        return super.toString() + ", Tamany: " + size;
    }

    // Override de calcularPreu per a afegir una tarifa addicional per a vehicles amb més de 7 places
    @Override
    public double calcularPreu() {
        double preu = super.calcularPreu();
        if (getPlaces() > MAX_PLACES) {
            preu *= 1.1;
        }
        return preu * IMPOST;
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Turisme other = (Turisme) obj;
    return getMarca().equals(other.getMarca()) &&
           getMotor() == other.getMotor() &&
           Double.compare(getPreu(), other.getPreu()) == 0 &&
           getPlaces() == other.getPlaces() &&
           getTipus().equals(other.getTipus()) &&
           getSize().equals(other.getSize());
    }
}
