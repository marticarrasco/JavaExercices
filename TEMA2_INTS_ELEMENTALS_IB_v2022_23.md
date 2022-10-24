# TEMA2_INTS_ELEMENTALS_IB_v2022_23.pdf

[TEMA2_INTS_ELEMENTALS_IB_v2022_23.pdf](TEMA2_INTS_ELEMENTALS_IB_v2022_23%20pdf%20fd4a9c88e545456fa55658af3f7aefa0/TEMA2_INTS_ELEMENTALS_IB_v2022_23.pdf)

**Programes per completar**

1.- Modifiqueu el programa 1 i/o 2 de manera que el programa demani un nombre natural a l’usuari i es comprovi si el nombre donat és parell, senar o zero.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        // demana i emmagatzema nombres introduits al terminal
        System.out.println("Introdueix un nombre natural: "); 
        int num = input.nextInt();

        // Si el nombre no compleix amb els requisits, és negatiu (enter):
        if(num < 0)    System.out.println("ERROR - El nombre solicitat ha de ser natural.");

        // quan el nombre no és 0
        if(num != 0){
            switch(num%2){ //el residu de dividir per 2 d'un parell sempre serà 0
                case 0: System.out.println(num + " és un número parell."); break;
                default: System.out.println(num + " és un número imparell."); break;
            }
            return; // atura el programa
        }
        
        // no es compleix ninguna de les condicions anteriors
        System.out.println("El teu número és 0");
    }
}
```

 
2.- A partir del programa 1 i 2, feu un programa que llegeixi dues paraules i que n’indiqui l’ordre lexicogràfic, de manera que digui si una es major o menor que l’altra o si són iguals. Nota: Feu servir els mètodes: <string1>.equals(<string2>), <string1>.compareTo(<string2>)

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        // demana i emmagatzema cadenes introduides al terminal
        System.out.print("Introdueix una paraula: "); 
        String s1 = new String(input.nextLine());

        System.out.print("Introdueix una paraula: "); 
        String s2 = new String(input.nextLine());

        if(!s1.equals(s2)){ //si no són les mateixes paraules
            //s1.compareTo(s2) retorna un nombre positiu si s2 > s
            if(s1.compareTo(s2) > 0){
                System.out.println(s2 + " és lexicograficament major que " + s1);
            } else{
                System.out.println(s1 + " és lexicograficament major que " + s2);
            }
            return; // atura el programa
        }
        
				//només s'executa si la condició no és certa
        System.out.println("Són les mateixes paraules."); 
    }
}
```

3.- Modifiqueu el programa 3 de manera faci el canvi de moneda d’euros a dòlars i de dòlars a euros. El programa ha de demanar la quantitat a canviar i el sentit del canvi en base a una variable booleana, de manera que si aquesta variable val 1 (true) el canvi es fa d’euros a dòlars i si val 0 (false) a la inversa.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        double rate = 0.98594496; // valor d'un euro el 21/10/2022

        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix la quantitat: "); 
        int c = input.nextInt();

        System.out.println("Escull el tipus de canvi: ");
        System.out.println("0- $ a €      1- € a $");
        int b = input.nextInt();

        // fa les conversions en funció del tipus de canvi
        if(b == 1){
            System.out.println(c + "€ són " + c*rate + "$");
        }else if (b == 0){
            System.out.println(c + "$ són " + c/rate + "€");
        }else{ // si s'ha introduit un valor inesperat
            System.out.println("ERROR - Si us plau introdueix 0 o 1");
        }
    }
}
```

4.- Modifiqueu el programa 4 de manera que es calculi el producte de un total de N nombres.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        float producte = 1; // s'ha d'inicialitzar en 1 perquè sino sempre donaria 0

        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix la quantitat de nombres a multiplicar: "); 
        int c = input.nextInt();
        System.out.println("");

        for(int i=0; i < c; i++){ // es repeteix tants cops com c
            System.out.print("Introduiu un nombre real: ");
            producte = producte * input.nextFloat(); // va multiplicant els nombres introduits
        }
        
        System.out.println("El producte dels números donats és " + producte);
    }
}
```

5.- Modifiqueu el programa 5 de manera que a més a més hi hagi una opció per multiplicar i una altra per dividir.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        double x, y, result;
        int opc = 1;
        while(opc != 5) {
            System.out.println("++++++++MENU D'OPCIONS+++++++++"); 
            System.out.println("1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Multiplicar");
            System.out.println("4.- Dividir");
            System.out.println("5.- Sortir");

            System.out.print("Seleccioneu una opció: "); 
            Scanner teclat = new Scanner(System.in); 
            opc = teclat.nextInt();
            
            switch(opc) {
                case 1:
                    System.out.println("Primer operand: ");
                    x = teclat.nextDouble();
                    System.out.println("Segon operand: ");
                    y = teclat.nextDouble();
                    result = x + y;
                    System.out.println("El resultat de la suma es: " + result); break;

                case 2:
                    System.out.println("Primer operand: ");
                    x = teclat.nextDouble();
                    System.out.println("Segon operand: ");
                    y = teclat.nextDouble();
                    result = x - y;
                    System.out.println("El resultat de la resta es: " + result); break;

                case 3:
                    System.out.println("Primer operand: ");
                    x = teclat.nextDouble();
                    System.out.println("Segon operand: ");
                    y = teclat.nextDouble();
                    System.out.println("El resultat de la multiplicació és: " + x*y); break;

                case 4:
                    System.out.println("Primer operand: ");
                    x = teclat.nextDouble();
                    System.out.println("Segon operand: ");
                    y = teclat.nextDouble();
                    System.out.println("El resultat de la divisió és: " + x/y); break;

                case 5: System.out.println("ADEU"); break;

                default:
                    System.out.println("ERROR, OPCIÓ INCORRECTA");
                    break;
            } // fi del switch
        }//fi del while 
    }
}
```

**Programes per desenvolupar**
1.- Implementeu un programa que demani a l’usurari un nombre natural de dues xifres i faci l’arrodoniment a la desena més pròxima. Per exemple:

Unitats: 2
Desenes: 3
El numero arrodonit és: 30

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix un nombre natural de dues xifres: "); 
        int c = input.nextInt();
        System.out.println(""); // deixa una línia en blanc

        //atès que les operacions són lleugeres, és més eficient estalviar-se la variable
        System.out.println("Unitats: " + c%10);
        System.out.println("Desenes: " + c/10%10);
        
        if(c%10 >= 5){ // en el cas de que s'hagi d'arrodonir amunt (unitat >= 5)
            System.out.println("El número arrodonit és: " + (c/10%10 + 1) + "0");
        }else{ //es queda en la desena que està però les unitats són 0
            System.out.println("El número arrodonit és: " + (c/10%10) + "0");
        }

    }
}
```

2.- Implementeu un programa que calculi el sou net d’un treballador a partir del seu sou base sobre el qual s’haurà d’aplicar la taula de descompte de l’IRPF de manera progressiva i el 7% fix de pagament a la seguretat social. La taula de l’IRPF a aplicar és:

![Captura de pantalla 2022-10-21 a les 19.57.43.png](TEMA2_INTS_ELEMENTALS_IB_v2022_23%20pdf%20fd4a9c88e545456fa55658af3f7aefa0/Captura_de_pantalla_2022-10-21_a_les_19.57.43.png)

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        /*
         * fix 7%
         * 
         * 1-1000€      15%
         * 1000-2000€   18%
         * 2000-2500€   21%
         * >2500€       25%
         */

        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix el teu sou base: "); 
        Double sou = input.nextDouble(); // perquè els sous tenen decimals
        System.out.println(""); // deixa una línia en blanc

        //comprova en quina franja salarial et trobes i aplica la rebaixa social i la corresponent
        if(sou <= 1000){
            sou = sou * (1 - (0.15 + 0.07));

        }else if(sou <= 2000){
            sou = sou * (1 - (0.18 + 0.07));

        }else if(sou <= 2500){
            sou = sou * (1 - (0.21 + 0.07));

        }else{
            sou = sou * (1 - (0.25 + 0.07));
        }
        
        System.out.println("El teu sou net és: " + sou);
    }
}
```

3.- Implementeu un programa que calculi el resultat de la sèrie s(n) = 1/n, a partir del nombre n de termes demanat a l’usuari.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix un nombre de termes: "); 
        int c = input.nextInt();
        System.out.println(""); // deixa una línia en blanc

        System.out.println("El resultat és " + comput(c)); //es crida a la funció recursiva per fer el còmput
    }

    //funció recursiva que retorna resultat s(n)=1/c
    public static double comput(int c){
        if(c == 0)  return c; // cas base -> iteració acabada (n/0 és indeterminat)
        return 1.0/c + comput(c-1);
    }
}
```

4.- Implementeu un programa que comprovi si un caràcter introduït des de el teclat és numèric o no numèric i si no és numèric, si és una lletra minúscula o majúscula.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        /*
         *          codi ascii
         * LETRES: - Majús [65-90]
         *         - Minús [97-122]
         * NÚMEROS:  [48-57]
         */

        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix un caràcter: "); 
        int c = input.nextLine().charAt(0); 
        System.out.println(""); // deixa una línia en blac

        //comprova quin tipus de caràcter és
        if(c > 47 && c < 58 )   System.out.println((char) c + " és un caràcter númèric.");
        else if(c > 96 && c < 123 )   System.out.println((char) c + " és una lletra minúscula.");
        else if(c > 64 && c < 91 )   System.out.println((char) c + " és una lletra majúscula.");

    }

}
```

5.- Implementeu un programa que calculi l’àrea d’un cercle o el seu perímetre, segon l’usuari hagi entrat la paraula “area” o “perímetre”. Si l’usuari introdueix qualsevol altra paraula el programa es tancarà informant de l’error.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades

        // demana i emmagatgema dades introduides al terminal
        System.out.println("Tria entre perímetre o area"); 
        String s = new String(input.nextLine());

        //comprova si s'ha escollit l'àrea o el perímetre
        if(s.equals("area")){
            System.out.print("Radi: "); 
            double r = input.nextDouble();
            System.out.println(""); // deixa una línia en blac

            System.out.println("L'àrea és " + Math.PI*r*r);

        }else if(s.equals("perímetre")){
            System.out.print("Radi: "); 
            double r = input.nextDouble();
            System.out.println(""); // deixa una línia en blac

            System.out.println("L'àrea és " + Math.PI*2*r);

        }else{ //si la resposta no ha estat la esperada
            System.out.println("ERROR - Has d'introduir area o perímetre.");
        }               
    }
}
```

**Programes opcionals**

1.- Modifiqueu el programa 2 de l’apartat anterior de manera que la taula s’apliqui de manera progressiva i incremental.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        /*
         * fix 7%
         * 
         * f(x)=((37475+10*x)/(2499) + 0.07)
         * aquesta funció retorna el tant percent de impostos a pagar
         * el mínim són 15% + 7% i el màxim és linialment incremental
         */

        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix el teu sou base: "); 
        Double sou = input.nextDouble(); // perquè els sous tenen decimals
        System.out.println(""); // deixa una línia en blanc
        
        System.out.println("El teu sou net és: " + (sou*(1 - ((37475+10*sou)/(2499)/100 + 0.07))));
    }
}
```

1.- Implementeu un programa per resoldre una equació de segon grau, de manera que demani els tres coeficients a l’usuari i calculi totes les arrels possibles, tant reals com imaginàries.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.println("Donat ax^2 + bx + c = 0");
        System.out.print("Introdueix a: "); 
        int a = input.nextInt(); //coef a
        System.out.print("Introdueix b: "); 
        int b = input.nextInt(); //coef b
        System.out.print("Introdueix c: "); 
        int c = input.nextInt(); //coef c

        System.out.println(""); // deixa una línia en blanc
        
        int determinant = b*b - 4*a*c; //contingut de l'arrel

        if(determinant < 0){ // la solució és imaginària -- es multiplica el determinant per -1 per extreure i
            System.out.println("Les solucions són:");
            System.out.println("    -> " + (-b / (2.0*a)) + " + " + (Math.sqrt(determinant*(-1)) / (2.0*a)) + "i");
            System.out.println("    -> " + (-b / (2.0*a)) + " - " + (Math.sqrt(determinant*(-1)) / (2.0*a)) + "i");
        }else{ // solució real
            System.out.println("Les solucions són:");
            System.out.println("    -> " + ((-b + Math.sqrt(determinant)) / (2.0*a)));
            System.out.println("    -> " + ((-b - Math.sqrt(determinant)) / (2.0*a)));
        }
    }
}
```

2.- Implementeu un programa que donat un nombre enter per l’usuari mostri quantes xifres en te.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix un nombre enter: "); 
        double c = input.nextDouble(); // si posés int si tingues més de 9 xifres peta el programa
        System.out.println(""); //deixa una linea en blanc

        // calcula quantes xifres té i ho mostra per pantalla
        System.out.println(c + " té " + (((int) Math.log10(c)) + 1) + " xifres.");
    }

}
```

4.- Implementeu un programa que donat un numero natural entre 1 i 10 mostri per pantalla la taula corresponent de multiplicar, es a dir, si l’usuari introdueix el 5, s’haurà de mostrar la taula de multiplicar del 5. En cas de que l’usuari introdueixi un nombre que no estigui inclòs entre el 1 i el 10, s’haurà de avisar amb el missatge: “Error, el nombre ha de estar entre 1 i 10”.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix el nombre entre l'1 i el 10 del qual vols veure la taula: "); 
        int c = input.nextInt(); 
        System.out.println(""); //deixa una linea en blanc
        
        if(c < 1 || c > 10){ //mostra un missatge d'error
            System.out.println("Error, el nombre ha de estar entre 1 i 10");
        } else{ //mostra la taula de c
            for(int i=0; i < 11; i++){ //i intera del 0 al 10
                System.out.println(c + " * " + i + " = " + (c*i));
            }
        }
    }
}
```

5.- Implementeu un programa que demani a l’usuari mitjançant tres enters una data en format dia-mes-any i a continuació la mostri per pantalla en format textual, per exemple:

Dia: 1
Mes : 2
Any: 2010
La data és: 1 de Febrer de 2010

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        String[] data = {"", "", ""}; // aqui s'emmagatzemaràn el dia, el mes i l'any
        // és la referència del número del mes i el número del mes
        String[] mesos = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};
        
        // demana i emmagatgema dades introduides al terminal
        System.out.print("Introdueix la data en format dia-mes-any: "); 
        String s = new String(input.nextLine());
        System.out.println(""); //deixa una linea en blanc
        
        int j = 0; // és una variable auxiliar que determina si s'està buscant el dia/mes/any
        for(int i = 0; i < s.length(); i++){ //itera per la dada introduida
            if(s.charAt(i) == '-')    j++; // si topa amb un guió vol dir que canvia el que busca
            else data[j] = data[j] + s.charAt(i); // va acumulant el que troba, separant-lo segons j
        }

        //utilitza Integer.parseInt(str) per passar de String a Int sense els 0 a la esquerra
        System.out.println("Dia: " + Integer.parseInt(data[0]));
        System.out.println("Mes: " + Integer.parseInt(data[1]));
        System.out.println("Any: " + Integer.parseInt(data[2]));
        System.out.println("La data és: " + Integer.parseInt(data[0]) + " de " + mesos[Integer.parseInt(data[1])-1] + " de " + Integer.parseInt(data[2]));
    }
}
```

6.- Donat un capital inicial c en euros, un interès anual i (expressat en %), un temps t en anys, i una indicació de si l’interès és simple o compost, calculeu en quants euros es transforma el capital inicial. L’entrada consisteix en dos nombres reals estrictament positius c i i, seguits d’un nombre enter estrictament positiu t, seguits de la paraula “simple” o la paraula “compost”. Com a resultat s’ha de donar el capital final obtingut segon sigui el cas.

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        /*
            input: c i t simple/compost
            c: capital inicial
            i: interès anual
            t: temps (anys)

            ej: 10000 10 1 simple
                5000 25 6 compost
        */

        //emmagatgema dades introduides al terminal
        double c = input.nextDouble();
        double i = input.nextDouble()/100;
        int t = input.nextInt();
        String tipus = input.nextLine();
        System.out.println(""); //deixa una linea en blanc

        if(tipus.equals(" simple")){
            System.out.println((c*(1 + i*t)));

        }else if(tipus.equals(" compost")){
            System.out.println(c * (Math.pow((1 + i*100), t)) - c);
        }
    }
}
```

7.- Feu un programa que, donat un nombre n, escrigui un “triangle de mida n”. L’entrada consisteix en un natural n i a la sortida s’escriuran n línies, de manera que la línia i contingui i asteriscos. Exemple:

![Captura de pantalla 2022-10-21 a les 19.59.25.png](TEMA2_INTS_ELEMENTALS_IB_v2022_23%20pdf%20fd4a9c88e545456fa55658af3f7aefa0/Captura_de_pantalla_2022-10-21_a_les_19.59.25.png)

```java
import java.util.*;

public class RunEveryProgramme {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); // configura un objecte que permet entrar dades
        
        //emmagatgema dades introduides al terminal
        int c = input.nextInt();
        System.out.println(""); //deixa una linea en blanc

        for(int i=1; i<c+1; i++){//i va incrementant de 1 fins a c
            for(int j=0; j<i; j++){ //mostra tants * com i
                System.out.print("*");
            }
            System.out.println(); //fa el salt de línia
        }
    }
}
```