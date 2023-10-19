# TEMA_7_IB_ARRAYLISTS.pdf

[TEMA_7_IB_ARRAYLISTS.pdf](TEMA_7_IB_ARRAYLISTS%20pdf%203d4daacc862f4db2a627e2aa5e59ed11/TEMA_7_IB_ARRAYLISTS.pdf)

************Programes per desenvolupar************

1.- Completeu el programa ArrayList1 implementant els dos mètodes: Method1 i
Method2.

```java
import java.util.*;

public class ArrayListPractice {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mètode 1");
        System.out.println("--------");
        System.out.println();
        Method1();
        System.out.println();
        System.out.println("Mètode 2");
        System.out.println("--------");
        System.out.println();
        Method2();
    }

    public static void Method1() {
        ArrayList<Integer> nums = new ArrayList<>();

        // Afegir números a la llista
        for (int i = 10; i <= 100; i += 10) {
            nums.add(i);
        }

        // Imprimir amb bucle for normal
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        System.out.println();

        // Imprimir amb bucle for millorat
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void Method2() {
        ArrayList<String> paraules = new ArrayList<>();
        String paraula;

        // Afegir paraules a la llista
        System.out.println("Introduïu paraules. Escrigui 'fi' per acabar.");
        do {
            paraula = keyboard.next();
            if (!paraula.equals("fi")) {
                paraules.add(paraula);
            }
        } while (!paraula.equals("fi"));

        // Imprimir amb bucle for normal
        for (int i = 0; i < paraules.size(); i++) {
            System.out.println(paraules.get(i));
        }

        System.out.println();

        // Imprimir amb bucle for millorat
        for (String p : paraules) {
            System.out.println(p);
        }
    }
}
```

2.- Volem implementar un programa que permeti a un usuari introduir informació de
contacte a una llista de telèfons. La informació de contacte inclou el nom i el número de
telèfon d'una persona. El problema s'ha descompost en les dues classes següents:
Contacte i GuiaTelefonica. La classe Contacte emmagatzema informació sobre cada
contacte.

```java
import java.util.*;

public class GuiaTelefonica {
    private ArrayList<Contacte> phoneList = new ArrayList<Contacte>();

    public void getContacteInfo() {
        Scanner sc = new Scanner(System.in);
        String resposta;

        do {
            System.out.print("Introdueix el nom i cognom de l'usuari: ");
            String nom = sc.nextLine();
            System.out.print("Introdueix el telèfon de l'usuari: ");
            String telefon = sc.nextLine();

            Contacte contacte = new Contacte(nom, telefon);
            phoneList.add(contacte);

            System.out.print("Vols afegir un altre [Y o N]: ");
            resposta = sc.nextLine();
        } while (resposta.equalsIgnoreCase("Y"));
    }

    public void printContacteInfo() {
        System.out.println("-------- GUIA TELEFONICA --------");
        for (Contacte contacte : phoneList) {
            System.out.println(contacte);
        }
    }

    public static void main(String[] args) {
        GuiaTelefonica app = new GuiaTelefonica();
        app.getContacteInfo();
        app.printContacteInfo();
    }
}
```

**Programa opcional**

1.- Implementació de les classes **`Alumne`** i **`Aula`**.

```java
public class Alumne {
    private String dni;
    private String nom;
    private double nota;

    public Alumne(String dni, String nom, double nota) {
        this.dni = dni;
        this.nom = nom;
        this.nota = nota;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nom + " (" + dni + ") -----> " + nota;
    }
}
```

```java
import java.util.*;

public class Aula {
    private ArrayList<Alumne> alumnes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void afegirAlumne() {
        System.out.print("Introdueix el DNI de l'alumne: ");
        String dni = sc.nextLine();
        System.out.print("Introdueix el nom de l'alumne: ");
        String nom = sc.nextLine();
        System.out.print("Introdueix la nota de l'alumne: ");
        double nota = sc.nextDouble();
        sc.nextLine();  // per netejar el buffer

        alumnes.add(new Alumne(dni, nom, nota));
    }

    public double calcularMitjana() {
        double suma = 0.0;
        for (Alumne a : alumnes) {
            suma += a.getNota();
        }
        return suma / alumnes.size();
    }

    public void mostrarAprovatsISuspesos() {
        System.out.println("Aprovats:");
        for (Alumne a : alumnes) {
            if (a.getNota() >= 5.0) {
                System.out.println(a);
            }
        }

        System.out.println("\nSuspesos:");
        for (Alumne a : alumnes) {
            if (a.getNota() < 5.0) {
                System.out.println(a);
            }
        }
    }

    public void mostrarLlistaOrdenada() {
        alumnes.sort(Comparator.comparingDouble(Alumne::getNota));
        System.out.println("Llista ordenada:");
        for (Alumne a : alumnes) {
            System.out.println(a);
        }
    }

    public void buscarAlumnesPerNota(double notaBuscar) {
        System.out.println("Alumnes amb nota " + notaBuscar + ":");
        for (Alumne a : alumnes) {
            if (a.getNota() == notaBuscar) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {
        Aula aula = new Aula();
        System.out.print("Introdueix el nombre d'alumnes: ");
        int numAlumnes = sc.nextInt();
        sc.nextLine();  // per netejar el buffer

        for (int i = 0; i < numAlumnes; i++) {
            aula.afegirAlumne();
        }

        System.out.println("\nMitjana del grup: " + aula.calcularMitjana());
        aula.mostrarAprovatsISuspesos();
        aula.mostrarLlistaOrdenada();

        System.out.print("\nIntrodueix una nota per buscar alumnes: ");
        double notaBuscar = sc.nextDouble();
        aula.buscarAlumnesPerNota(notaBuscar);
    }
}
```
![Diagrama UML](https://github.com/marticarrasco/JavaExercices/blob/61528c57045489172612e774dbf0d039502db32c/TEMA_7_IB_ARRAYLISTS%20pdf%203d4daacc862f4db2a627e2aa5e59ed11/UML.png)
