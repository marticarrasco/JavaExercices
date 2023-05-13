public class Vehicle {
    // Atributs de la classe
    private String marca;
    private int motor;
    private double preu;
    
    // Constructor per defecte
    public Vehicle() {
        // Inicialitzar els atributs amb valors per defecte
        marca = "";
        motor = 0;
        preu = 0.0;
    }

    // Constructor amb paràmetres
    public Vehicle(String marca, int motor, double preu) {
        // Validar les dades d'entrada
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no pot estar buida.");
        }
        if (motor <= 0) {
            throw new IllegalArgumentException("El motor ha de tenir una potència positiva.");
        }
        if (preu < 0.0) {
            throw new IllegalArgumentException("El preu no pot ser negatiu.");
        }
        
        // Assignar els valors als atributs
        this.marca = marca;
        this.motor = motor;
        this.preu = preu;
    }
    
    // Getters i setters per als atributs
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        // Validar les dades d'entrada
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("La marca no pot estar buida.");
        }
        
        this.marca = marca;
    }
    
    public int getMotor() {
        return motor;
    }
    
    public void setMotor(int motor) {
        // Validar les dades d'entrada
        if (motor <= 0) {
            throw new IllegalArgumentException("El motor ha de tenir una potència positiva.");
        }
        
        this.motor = motor;
    }
    
    public double getPreu() {
        return preu;
    }
    
    public void setPreu(double preu) {
        // Validar les dades d'entrada
        if (preu < 0.0) {
            throw new IllegalArgumentException("El preu no pot ser negatiu.");
        }
        
        this.preu = preu;
    }
    
    // Mètode per calcular el preu
    public double calcularPreu() {
        // El preu del vehicle és el preu base
        return preu;
    }
    
    // Mètode per mostrar les dades del vehicle
    public void mostrarVehicle() {
        System.out.println("Marca: " + marca + ", Motor: " + motor + ", Preu: " + preu);
    }
    
    // Redefinició del mètode toString de la classe Object
    @Override
    public String toString() {
        return "Marca: " + marca + ", Motor: " + motor + ", Preu: " + preu;
    }
}
