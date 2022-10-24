# TEMA1_PROG_ELEMENTAL_IB_2022_23v2.pdf

[TEMA1_PROG_ELEMENTAL_IB_2022_23v2_.pdf](TEMA1_PROG_ELEMENTAL_IB_2022_23v2%20pdf%20ba87bb1b6e084b15a033a07ccc652356/TEMA1_PROG_ELEMENTAL_IB_2022_23v2_.pdf)

**Programes per completar**

1.- Modifiqueu el programa 1 de manera que mostri el missatge “Hola” i “Adeu” en
dues línies consecutives.

```java
public class RunEveryProgramme {
    public static void main(String args[]){
        System.out.println("Hola");
        System.out.println("Adeu");
    }
}
```

2.- Modifiqueu el programa 2 de manera que es calculi l’àrea d’un cercle: π*r2

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        int radi;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.println("Introduiu el radi: ");
        radi = input.nextInt();
        area = Math.PI * radi * radi;
        System.out.println("L’àrea del cercle es de: " + area);
    }
}
```

3.- Modifiqueu el programa 5 de manera que faci servir la conversió de tipus explícita.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        int a, b;

        Scanner input = new Scanner(System.in);

        System.out.print("Introduiu el divisor: ");
        a = input.nextInt();

        System.out.print("Introduiu el dividend: ");
        b = input.nextInt();

        System.out.println("Quocient: " + (double) a/b + " , Residu: " + (float) a%b);
    }
}
```

4.- Modifiqueu el programa 4 de manera que en el total a pagar es tingui en compte el
16% d’IVA.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        double preu, total;
        int unitats;

        Scanner input = new Scanner(System.in);

        System.out.println("Unitats desitjades: ");
        unitats = input.nextInt();

        System.out.println("Preu unitari: ");
        preu = input.nextDouble();

        total = unitats * preu * 1.16;

        System.out.println("Total a pagar: " + total + " euros.");
    }
}
```

5.- Modifiqueu el programa 3 de manera que donats la velocitat mitjana d’un cotxe i la
distancia a recórrer es mostri el temps que trigarà a fer-la.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        double velocitat;
        double distancia;

        Scanner input = new Scanner(System.in);

        System.out.print("Velocitat mitjana (m/s): ");
        velocitat = input.nextDouble();

        System.out.print("Distància a recórrer (m): ");
        distancia = input.nextDouble();
        System.out.println("");

        System.out.println("Trigarà " + distancia/velocitat + " segons.");
    }
}
```

6.- Modifiqueu el programa 6 de manera que l’usuari introdueixi un caràcter i digui quin
és el seu codi numèric segons la codificació ASCII.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        char c;

        Scanner input = new Scanner(System.in);

        System.out.print("Introduiu un caràcter: ");
        c = input.next().charAt(0);

        System.out.println("El caràcter: " + c + " es correspon al número: " +
       (int) c);
    }
}
```

**Programes per desenvolupar**
1.- Implementeu un programa que demani l’edat i el nom de l’usuari i a continuació
mostri el missatge: “Hola Pep, tens X anys”.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        String nom = new String();
        int edat;

        Scanner input = new Scanner(System.in);

        System.out.print("Introdueix el teu nom: ");
        nom = input.nextLine();

        System.out.print("Introdueix la teva edat: ");
        edat = input.nextInt();

        System.out.println("Hola " + nom + ", tens " + edat + " anys.");
    }
}
```

2.- Implementeu un programa que calculi l’àrea, el perímetre i la longitud de la seva
diagonal d’un quadrat, donat el seu costat. (Nota: Per fer arrels quadrades feu servir la
funció (mètode) Math.sqrt(num)

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        double c;

        Scanner input = new Scanner(System.in);

        System.out.print("Longitud del costat: ");
        c = input.nextDouble();

        System.out.println("Àrea: " + c*c);
        System.out.println("Perímetre: " + c*4);
        System.out.println("Diagonal: " + Math.sqrt(2*(c*c)));
    }
}
```

3.- Implementeu un programa que permeti convertir una temperatura donada en graus
Celsius a una temperatura en graus Fahrenheit: F = 9/5(C+32).

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        double c;

        Scanner input = new Scanner(System.in);

        System.out.print("Temperatura (ºC): ");
        c = input.nextDouble();

        System.out.println("Temperatura en ºF " + 9/5*(c+32));
    }
}
```

4.- Implementeu un programa que faci la conversió de minuts a hores i minuts. L’usuari
introduirà un nombre enter de minuts i es visualitzaran el nombre de hores i minuts
corresponents.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        int min, hours;
        int min_;
        Scanner teclat = new Scanner(System.in);

        System.out.print("Introdueix quantitat de minuts: ");
        min = teclat.nextInt();
        min_ = min;

        hours = min/60;       min = min%60;

        System.out.print(min_ + " minuts equivalen a ");
        System.out.println(hours + " h i " + min + " min");

        //JOptionPane.showMessageDialog(null, hours + " h  " + min + " min  " + sec + " s  ");
    }

}
```

 **Programes opcionals**
1.- Implementeu un programa que donada una quantitat en segons, la transformi a hores,
minuts i segons.

```java
import java.util.*;
//import javax.swing.JOptionPane;

public class HandleSeconds {
    public static void main(String args[]){
        int min, hours, sec;
        int sec_;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix quantitat de segons: ");
        sec = teclat.nextInt();
        sec_ = sec;

        hours = sec/3600;   sec = sec%3600;
        min = sec/60;       sec = sec%60;

        System.out.print(sec_ + " segons equival a ");
        System.out.print(hours + " h  " + min + " min  " + sec + " s  ");

        //JOptionPane.showMessageDialog(null, hours + " h  " + min + " min  " + sec + " s  ");
        

    }
}
```

2.- Implementeu un programa que demani una quantitat en cèntims d’euro i ens faci la
descomposició en monedes d’un euro, de 50 cèntims d’euro, de 10 cèntims d’euro i d’un
cèntim d’euro.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        int cent, deu, mig, eur;
        int cent_;

        Scanner teclat = new Scanner(System.in);

        System.out.print("Introdueix quantitat de cèntims: ");
        cent = teclat.nextInt();
        cent_ = cent;

        eur = cent/100;       cent = cent%100;
        mig = cent/50;        cent = cent%50;
        deu = cent/10;        cent = cent%10;

        System.out.print(cent_ + " cèntims equivalen a ");
        System.out.println(eur + " euros, " + mig + " monedes de 50cent, " + deu + " monedes de 10cent i " + cent + " monedes de cèntims.");
    }

}
```

3.- Implementeu un programa que donat un nombre enter de quatre xifres faci les
descomposició en unitats de mil, centenes, desenes i unitats.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        int n;
        
        Scanner teclat = new Scanner(System.in);

        System.out.print("Introdueix un número: ");
        n = teclat.nextInt();
        descomposa(n);
       }

    public static void descomposa(int c){
        if(c == 0)  return;
       
        System.out.println(c%10 + " * " + (int) (10000 / Math.pow(10, (int) (Math.log10(c) + 1))));
        descomposa(c/10);
    }
}
```