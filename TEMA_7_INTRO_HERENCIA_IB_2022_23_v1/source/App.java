public class App {
    public static void main(String[] args) {
        // Creació d'un array de Vehicles amb una capacitat de 10
        Vehicle[] Automobils = new Vehicle[10];

        // Assignació d'objectes Vehicle (Turisme, Suv, Moto) a l'array Automobils
        Automobils[0] = new Turisme("SEAT", 120, 250000, 5, "benzina", "gran");
        Automobils[1] = new Turisme("AUDI", 150, 300000, 5, "diesel", "mitjà");
        Automobils[2] = new Turisme("MERCEDES", 180, 400000, 7, "diesel", "gran");
        Automobils[3] = new Turisme("BMW", 160, 350000, 5, "benzina", "mitjà");
        Automobils[4] = new Suv("FORD", 130, 280000, 5, "diesel", true);
        Automobils[5] = new Suv("VOLVO", 150, 320000, 7, "diesel", false);
        Automobils[6] = new Suv("TOYOTA", 140, 300000, 5, "gasolina", true);
        Automobils[7] = new Suv("NISSAN", 120, 250000, 7, "gasolina", false);
        Automobils[8] = new Moto("HONDA", 100, 5000, 250);
        Automobils[9] = new Moto("YAMAHA", 110, 6000, 300);

        // Recorregut de l'array Automobils i mostra de cada Vehicle
        for (Vehicle vehicle : Automobils) {
            vehicle.mostrarVehicle();
            System.out.println("Preu de venda: " + vehicle.calcularPreu());
            System.out.println("------------------------------------");
        }

        System.out.println("\n\n");

        // Comprovació de si dos objectes Turisme són iguals utilitzant el mètode equals()
        Turisme turisme1 = new Turisme("Opel", 80, 17000, 5, "benzina", "gran");
        Turisme turisme2 = new Turisme("Opel", 80, 17000, 5, "benzina", "gran");

        System.out.println(turisme1.equals(turisme2)); // S'espera que retorni true
    }
}
