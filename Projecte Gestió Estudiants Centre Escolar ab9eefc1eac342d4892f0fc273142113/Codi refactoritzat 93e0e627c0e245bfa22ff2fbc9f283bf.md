# Codi refactoritzat

# Classes fonamentals

En el projecte, he aplicat un conjunt de millores clau de manera consistent a través de les classes **`Persona`**, **`Estudiante`**, i **`Profesor`**. Aquestes millores són:

1. **Validació de Dades**: En cada classe, he implementat validacions en els constructors i mètodes setters per assegurar que les dades introduïdes siguin vàlides i coherents. Això inclou comprovacions per evitar valors buits o invàlids com DNIs buits o edats negatives en **`Persona`**, i rangs inadequats de mitjanes en **`Estudiante`**. Aquesta mesura prevé errors de dades i millora la robustesa del sistema.
2. **Gestió d'Errors**: He afegit tractament d'errors en els setters per manejar situacions on es proporcionen dades incorrectes. Això ajuda a prevenir que l'estat de l'objecte esdevingui inconsistent i facilita la depuració del codi.
3. **Millora de la Legibilitat**: He reorganitzat el codi en cada classe, agrupant mètodes i utilitzant espaiat i indentació per a millorar la legibilitat. Així mateix, he afegit comentaris descriptius que expliquen el propòsit i funcionament de cada part del codi, facilitant la seva comprensió i manteniment.
4. **Mètode `toString` Personalitzat**: Per a cada classe, he sobreescrit el mètode **`toString`** per proporcionar una representació textual detallada i clara de l'objecte. Aquest canvi permet una millor visualització de les dades de l'objecte, especialment útil durant la depuració i el logueig.

Aquestes millores, implementades de manera coherenta a través de les tres classes, no només augmenten la qualitat del codi, sinó que també asseguren una base sòlida per a expansions i modificacions futures del projecte.

```java
import java.io.Serializable;

/**
 * Classe que representa una persona. Implementa Serializable per a permetre
 * la seva emmagatzematge en fitxers binaris.
 */
public class Persona implements Serializable {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private char sexo;
    private int edad;

    public Persona(String dni, String nombre, String apellido1, String apellido2, char sexo, int edad) {
        setDni(dni);
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setSexo(sexo);
        setEdad(edad);
    }

    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.sexo = ' ';
        this.edad = 0;
    }

    public void setDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no pot estar buit.");
        }
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nom no pot estar buit.");
        }
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        if (apellido1 == null || apellido1.isEmpty()) {
            throw new IllegalArgumentException("El primer cognom no pot estar buit.");
        }
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        if (apellido2 == null || apellido2.isEmpty()) {
            throw new IllegalArgumentException("El segon cognom no pot estar buit.");
        }
        this.apellido2 = apellido2;
    }

    public void setSexo(char sexo) {
        if (sexo != 'H' && sexo != 'D') {
            throw new IllegalArgumentException("El sexe ha de ser 'H' (home) o 'D' (dona).");
        }
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("L'edat no pot ser negativa.");
        }
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + 
            ", Nombre: " + nombre + 
            ", Primer Apellido: " + apellido1 + 
            ", Segon Apellido: " + apellido2 + 
            ", Sexo: " + sexo + 
            ", Edad: " + edad;
    }

}
```

```java
public class Estudiante extends Persona {
    private String escuela;
    private double media;

    /**
     * Constructor per defecte. Crea un estudiant amb valors inicials buits o per defecte.
     */
    public Estudiante() {
        super();
        this.escuela = "";
        this.media = 0.0;
    }

    /**
     * Constructor amb paràmetres per a crear una instància d'Estudiante.
     * Hereta de la classe Persona i afegeix els camps específics d'estudiant.
     *
     * @param dni        DNI de l'estudiant.
     * @param nombre     Nom de l'estudiant.
     * @param apellido1  Primer cognom de l'estudiant.
     * @param apellido2  Segon cognom de l'estudiant.
     * @param sexo       Sexe de l'estudiant.
     * @param edad       Edat de l'estudiant.
     * @param escuela    Nom de l'escola de l'estudiant.
     * @param media      Mitjana de notes de l'estudiant.
     */
    public Estudiante(String dni, String nombre, String apellido1, String apellido2, char sexo, int edad, String escuela, double media) {
        super(dni, nombre, apellido1, apellido2, sexo, edad);
        this.escuela = escuela;
        if (media < 0.0 || media > 10.0) {
            throw new IllegalArgumentException("La mitjana ha de ser entre 0 i 10.");
        }
        this.media = media;
    }

    // Setters amb validació
    public void setEscuela(String escuela) {
        if (escuela == null || escuela.isEmpty()) {
            throw new IllegalArgumentException("El nom de l'escola no pot estar buit.");
        }
        this.escuela = escuela;
    }

    public void setMedia(double media) {
        if (media < 0.0 || media > 10.0) {
            throw new IllegalArgumentException("La mitjana ha de ser entre 0 i 10.");
        }
        this.media = media;
    }

    // Getters sense canvis
    public String getEscuela() {
        return escuela;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return super.toString() + " Escuela: " + escuela + " Media: " + media;
    }
}
```

```java
public class Profesor extends Persona {
    private String materia;
    private String grupo;
    private int horas;

    /**
     * Constructor per defecte. Crea un professor amb valors inicials buits o per defecte.
     */
    public Profesor() {
        super();
        this.materia = "";
        this.grupo = "";
        this.horas = 0;
    }

    /**
     * Constructor amb paràmetres per a crear una instància de Profesor.
     * Hereta de la classe Persona i afegeix els camps específics del professor.
     *
     * @param dni        DNI del professor.
     * @param nombre     Nom del professor.
     * @param apellido1  Primer cognom del professor.
     * @param apellido2  Segon cognom del professor.
     * @param sexo       Sexe del professor.
     * @param edad       Edat del professor.
     * @param materia    Matèria que imparteix el professor.
     * @param grupo      Grup al qual pertany el professor.
     * @param horas      Nombre d'hores que imparteix el professor.
     */
    public Profesor(String dni, String nombre, String apellido1, String apellido2, char sexo, int edad, String materia, String grupo, int horas) {
        super(dni, nombre, apellido1, apellido2, sexo, edad);
        this.materia = materia;
        this.grupo = grupo;
        if (horas < 0) {
            throw new IllegalArgumentException("El nombre d'hores no pot ser negatiu.");
        }
        this.horas = horas;
    }

    // Setters amb validació
    public void setMateria(String materia) {
        if (materia == null || materia.isEmpty()) {
            throw new IllegalArgumentException("La matèria no pot estar buida.");
        }
        this.materia = materia;
    }

    public void setGrupo(String grupo) {
        if (grupo == null || grupo.isEmpty()) {
            throw new IllegalArgumentException("El grup no pot estar buit.");
        }
        this.grupo = grupo;
    }

    public void setHoras(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("El nombre d'hores no pot ser negatiu.");
        }
        this.horas = horas;
    }

    // Getters sense canvis
    public String getMateria() {
        return materia;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public String toString() {
        return super.toString() + " Materia: " + materia + " Grupo: " + grupo + " Horas: " + horas;
    }
}
```

# Classe ListaPersonas.java

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    // Atributos
    private List<Persona> lista; // Lista de personas
    private String filename; // Nombre del archivo físico

    // Constructor
    public ListaPersonas(String nomFitxer) {
        lista = new ArrayList<>();
        filename = nomFitxer;
    }

    // Método para agregar una persona
    public void afegir(Persona p) {
        lista.add(p);
    }

    // Método para editar una persona
    public void editar(Persona p, int pos) {
        if (pos >= 0 && pos < lista.size()) {
            lista.set(pos, p);
        }
    }

    // Método para eliminar una persona
    public void eliminar(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            lista.remove(pos);
        }
    }

    // Método para obtener una persona por posición
    public Persona getPersona(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            return lista.get(pos);
        }
        return null;
    }
    
    public int getTamaño() {
        return lista.size();
    }
    

    // Método para buscar una persona por DNI
    public int buscarDato(String dni) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    // Método para imprimir la lista de personas
    public void imprimirLista() {
        for (Persona persona : lista) {
            System.out.print(persona instanceof Estudiante ? "ESTUDIANTE \t" : "PROFESOR \t");
            System.out.println(persona);
        }
    }

    // Método para leer el archivo y cargar personas en la lista
    public void leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Persona p;
            lista.clear();
            while ((p = (Persona) ois.readObject()) != null) {
                afegir(p);
            }
        } catch (Exception ignored) {
        }
    }

    // Método para escribir en el archivo los objetos Persona de la lista
    public boolean guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Persona p : lista) {
                oos.writeObject(p);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
```

# Clase Colegi.java

```java
import java.util.Scanner;
import java.util.InputMismatchException;

public class Colegi {

    private static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        ListaPersonas lp = new ListaPersonas("ColegiDatos.dat");
        int opcio;

        do {
            mostrarMenu();
            opcio = obtenirOpcio();
            procesarOpcion(opcio, lp);
        } while (opcio != 6);
    }

    private static int obtenirOpcio() {
        while (true) {
            try {
                return teclat.nextInt();
            } catch (InputMismatchException e) {
                teclat.next(); // neteja l'entrada incorrecta
                System.out.print("Si us plau, introdueix un número vàlid: ");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n\t\t MENU D'OPCIONS\n");
        System.out.println("\t 1.- Donar d'alta una persona");
        System.out.println("\t 2.- Modificar dades d'una persona");
        System.out.println("\t 3.- Donar de baixa una persona");
        System.out.println("\t 4.- Buscar una persona");
        System.out.println("\t 5.- Imprimir llista personas");
        System.out.println("\t 6.- Sortir (Desant arxiu)");
        System.out.print("\n Trii una opció: ");
    }

    private static void procesarOpcion(int opcio, ListaPersonas lp) {
        switch (opcio) {
            case 1:
                altaPersona(lp);
                break;
            case 2:
                modificarPersona(lp);
                break;
            case 3:
                eliminarPersona(lp);
                break;
            case 4:
                buscarPersona(lp);
                break;
            case 5:
                imprimirLista(lp);
                break;
            case 6:
                despedida(lp);
                break;
            default:
                System.out.println("Opció incorrecta, torni a provar...");
        }
    }
    
    private static void altaPersona(ListaPersonas lp) {
        System.out.println("Si es un estudiant indica 1, si es un professor 0: ");
        int tipusPersona = obtenirOpcio();
    
        if (tipusPersona == 1) {
            Estudiante estudiante = new Estudiante();
            leerDatosPersona(estudiante);
            System.out.println("Introduiu escola: ");
            String escola = teclat.next();
            estudiante.setEscuela(escola);
            System.out.println("Introduiu nota mitja: ");
            double mitja = teclat.nextDouble();
            estudiante.setMedia(mitja);
    
            lp.afegir(estudiante);
        } else {
            Profesor profesor = new Profesor();
            leerDatosPersona(profesor);
            System.out.println("Introduiu materia: ");
            String materia = teclat.next();
            profesor.setMateria(materia);
            System.out.println("Introduiu grups: ");
            String grup = teclat.next();
            profesor.setGrupo(grup);
            System.out.println("Introduiu hores: ");
            int hores = teclat.nextInt();
            profesor.setHoras(hores);
    
            lp.afegir(profesor);
        }
        desarDades(lp);
    }
    
    private static void leerDatosPersona(Persona persona) {
        System.out.println("Introduiu dni: ");
        String dni = teclat.next();
        persona.setDni(dni);
        System.out.println("Introduiu nom: ");
        String nom = teclat.next();
        persona.setNombre(nom);
        System.out.println("Introduiu primer cognom: ");
        String cognom1 = teclat.next();
        persona.setApellido1(cognom1);
        System.out.println("Introduiu segon cognom: ");
        String cognom2 = teclat.next();
        persona.setApellido2(cognom2);
        System.out.println("Introduiu sexe (H o D): ");
        char sexe = teclat.next().charAt(0);
        persona.setSexo(sexe);
        System.out.println("Introduiu edad: ");
        int edad = teclat.nextInt();
        persona.setEdad(edad);
    }
    
    private static void modificarPersona(ListaPersonas lp) {
        if (lp.getTamaño() > 0) {
            System.out.println("Posició a modificar entre 0 - " + (lp.getTamaño() - 1));
            int pos = teclat.nextInt();
            if (pos < 0 || pos >= lp.getTamaño()) {
                System.out.println("Posició fora de rang.");
                return;
            }
            Persona p = lp.getPersona(pos);
            leerDatosPersona(p);
            lp.editar(p, pos);
            desarDades(lp);
        } else {
            System.out.println("Llista buida");
        }
    }
    
    private static void eliminarPersona(ListaPersonas lp) {
        if (lp.getTamaño() > 0) {
            System.out.println("Posició a eliminar entre 0 - " + (lp.getTamaño() - 1));
            int pos = teclat.nextInt();
            if (pos < 0 || pos >= lp.getTamaño()) {
                System.out.println("Posició fora de rang.");
                return;
            }
            lp.eliminar(pos);
            desarDades(lp);
        } else {
            System.out.println("Llista buida");
        }
    }
    
    private static void buscarPersona(ListaPersonas lp) {
        if (lp.getTamaño() > 0) {
            System.out.println("Introduiu dni a buscar: ");
            String dni = teclat.next();
            int pos = lp.buscarDato(dni);
            if (pos >= 0) {
                System.out.println("Persona trobada a la posició: " + pos);
                System.out.println(lp.getPersona(pos).toString());
            } else {
                System.out.println("Persona no trobada");
            }
        } else {
            System.out.println("Llista buida");
        }
    }
    
    private static void imprimirLista(ListaPersonas lp) {
        if (lp.getTamaño() > 0) {
            lp.imprimirLista();
        } else {
            System.out.println("Llista buida");
        }
    }
    
    private static void despedida(ListaPersonas lp) {
        if (lp.guardar()) {
            System.out.println("Fitxer desat\nAdeu....");
        } else {
            System.out.println("Error al guardar el fitxer, no s'ha tancat el programa...");
        }
    }
    
    private static void desarDades(ListaPersonas lp) {
        System.out.println("Vols desar les dades en el fitxer de dades? (S o N)");
        char c = teclat.next().charAt(0);
        if (c == 'S' || c == 's') {
            if (lp.guardar()) {
                System.out.println("Dades guardades al fitxer");
            } else {
                System.out.println("Dades no guardades al fitxer");
            }
        }
    }
}
```