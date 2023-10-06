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
import java.util.*;

public class Alumne {
    private String dni;
    private double nota;

    public Alumne(String dni, double nota) {
        this.dni = dni;
        this.nota = nota;
    }

    public String getDni() {
        return dni;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nota: " + nota;
    }
}
```

```java
public class Aula {
    private ArrayList<Alumne> alumnes = new ArrayList<>();

    public void afegirAlumne(Alumne alumne) {
        alumnes.add(alumne);
    }

    public void mostrarAprovats() {
        for (Alumne alumne : alumnes) {
            if (alumne.getNota() >= 5) {
                System.out.println(alumne);
            }
        }
    }

    public void mostrarSuspesos() {
        for (Alumne alumne : alumnes) {
            if (alumne.getNota() < 5) {
                System.out.println(alumne);
            }
        }
    }

    public void mostrarLlistaOrdenada() {
        ArrayList<Alumne> llistaOrdenada = new ArrayList<>(alumnes);
    
        for (int i = 0; i < llistaOrdenada.size() - 1; i++) {
            for (int j = i + 1; j < llistaOrdenada.size(); j++) {
                if (llistaOrdenada.get(i).getNota() > llistaOrdenada.get(j).getNota()) {
                    Alumne temp = llistaOrdenada.get(i);
                    llistaOrdenada.set(i, llistaOrdenada.get(j));
                    llistaOrdenada.set(j, temp);
                }
            }
        }

        for (Alumne alumne : llistaOrdenada) {
            System.out.println(alumne);
        }
    }
}
```