# TEMA_4_ARRAYS_IB_2022_23.pdf

[TEMA_4_ARRAYS_IB_2022_23.pdf](TEMA_4_ARRAYS_IB_2022_23/TEMA_4_ARRAYS_IB_2022_23.pdf)

**Programes per desenvolupar**
1.- Feu un programa a partir dels programes anteriors, ompli un vector amb les temperatures
diàries d’un mes (suposem de 30 dies) i ens informi del nombre de dies del mes que han tingut
la seva temperatura dins d’un rang establert prèviament per l’usuari.

```java
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class TemperatureChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize the vector to store temperatures
        Vector<Integer> temperatures = new Vector<>();

        System.out.print("Generate temperatures randomly? (true/false): ");
        boolean generateRandomly = sc.nextBoolean();

        if (generateRandomly) {
            // Generate temperatures randomly
            Random r = new Random();
            for (int i = 0; i < 30; i++) {
                int temp = r.nextInt(40) - 10; // generates a random temperature between -10 and 30
                temperatures.add(temp);
                System.out.println("Day " + (i + 1) + ": " + temp + "°C");
            }
        } else {
            // Fill the vector with temperatures
            for (int i = 0; i < 30; i++) {
                System.out.print("Enter temperature for day " + (i + 1) + ": ");
                int temp = sc.nextInt();
                temperatures.add(temp);
            }
        }

        // Get the temperature range from the user
        System.out.print("Enter minimum temperature: ");
        int minTemp = sc.nextInt();
        System.out.print("Enter maximum temperature: ");
        int maxTemp = sc.nextInt();

        // Count the number of days with temperatures within the range
        int count = 0;
        for (int temp : temperatures) {
            if (temp >= minTemp && temp <= maxTemp) {
                count++;
            }
        }

        // Print the result
        System.out.println("Number of days with temperatures within the range: " + count);
    }
}
```

2.- Feu un programa a partir dels programes anteriors, ompli una matriu amb les notes
trimestrals (columnes 1, 2 i 3) d’un grup de “n” alumnes d’un màxim de “NALUM” de
manera aleatòria. A la columna 0 de la matriu es demanarà una possible nota extra de cada
alumne. El programa ha de calcular la nota final de cada alumne com a resultat de la mitjana
de les notes trimestrals més la extra, i situar-la a la columna 4 de la matriu. Finalment el
programa ha de mostrar per pantalla la matriu de notes obtinguda. Opcionalment es pot
demanar a l’usuari que demani les notes concretes d’un alumne a partir del seu numero.

```java
import java.util.Scanner;

public class GradeTracker {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter number of students: ");
      int numOfStudents = sc.nextInt();
      Student[] students = new Student[numOfStudents];

      System.out.print("Generate grades randomly (yes/no)? ");
      String input = sc.next();

      boolean generateGradesRandomly = false;

      if(input.equalsIgnoreCase("yes")) {
          generateGradesRandomly = true;
      }
    
      for (int i = 0; i < numOfStudents; i++) {
          System.out.print("Enter name of student " + (i + 1) + ": ");
          String name = sc.next();
          double[] marks = new double[4];
    
          if(generateGradesRandomly) {
              marks[0] = (double) (Math.random() * 10);
              marks[1] = (double) (Math.random() * 10);
              marks[2] = (double) (Math.random() * 10);
              marks[3] = (double) (Math.random() * 10);
          } else {
              System.out.print("Enter marks for Extra: ");
              marks[0] = sc.nextInt();
              System.out.print("Enter marks for Trimestral 1: ");
              marks[1] = sc.nextInt();
              System.out.print("Enter marks for Trimestral 2: ");
              marks[2] = sc.nextInt();
              System.out.print("Enter marks for Trimestral 3: ");
              marks[3] = sc.nextInt();
          }
          
          students[i] = new Student(name, marks);
    
          System.out.println();
          
      }

      System.out.print("Show all students marks (1) or specific student grades (2)? ");
      int choice = sc.nextInt();
      if (choice == 1) {
          System.out.println("Name\t\tExtra\tTrimestral 1\tTrimestral 2\tTrimestral 3\tMean");
          System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
          
          for (Student student : students) {
            System.out.println(student.name + "\t" +"\t" + String.format("%.2f", student.marks[0]) + "\t" + String.format("%.2f", student.marks[1]) + "\t\t" + String.format("%.2f", student.marks[2]) + "\t\t" + String.format("%.2f", student.marks[3]) + "\t\t" + String.format("%.2f", student.calculateMean()));

          }
      } else if (choice == 2) {
          System.out.print("Enter name of student: ");
          String name = sc.next();
          boolean found = false;
          for (Student student : students) {
              if (student.name.equals(name)) {
                  System.out.println("Name\t\tExtra\tTrimestral 1\tTrimestral 2\tTrimestral 3\tMean");
                  System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                  System.out.println(student.name + "\t" +"\t" + String.format("%.2f", student.marks[0]) + "\t" + String.format("%.2f", student.marks[1]) + "\t\t" + String.format("%.2f", student.marks[2]) + "\t\t" + String.format("%.2f", student.marks[3]) + "\t\t" + String.format("%.2f", student.calculateMean()));

                  found = true;
                  break;
              }
          }
          if (!found) {
              System.out.println("Student not found.");
          }
      } else {
          System.out.println("Invalid choice.");
      }
      sc.close();
  }
}

class Student {
    String name;
    double[] marks = new double[4];

    Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateMean() {
      int sum = 0;
      for(int i = 1; i < marks.length-1; i++){
        sum += marks[i];
      }
      /*for (int mark : marks) {
          sum += mark;
      }
      */
      return ((sum / 3 )+ (marks[0]/10.0)) ;
    }
}
```

**Programes opcionals** 
1.- Fer un programa que:
a) Llegeixi una seqüència de “n” valors numèrics reals d’un màxim de MAX i
els emmagatzemi en un vector.
b) Mostri per pantalla quin és el valor mínim, així com la posició que n’ocupa en
el vector. Si apareix repetit el valor mínim es mostrarà el de menor índex dels
valors mínims.

```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int maxSize = 10; // Maximum size of the vector, set by the programmer
    double[] vector = new double[maxSize];
    int size = 0; // Current size of the vector
    
    System.out.println("Enter real values (up to " + maxSize + "). Type 'stop' to stop:");
    size = fillVector(vector, maxSize, sc); // demana les dades a l'usuari
    
    int minIndex = getMinIndex(vector, size); //troba la posició del valor mínim
    double minValue = vector[minIndex]; //busca el valor mínim en base a la seva posició
    
		//mostra aquests valors
    System.out.println("Minimum value: " + minValue);
    System.out.println("Vector index: " + minIndex);
  }
  
  public static int fillVector(double[] vector, int maxSize, Scanner sc) {
    int size = 0;
    while (sc.hasNextDouble() && size < maxSize) { //mentre hi hagi espai per dades
      double value = sc.nextDouble();

      vector[size] = value;
      size++;
    }
    return size;
  }
  
  public static int getMinIndex(double[] vector, int size) {
    int minIndex = -1;
    double minValue = Double.MAX_VALUE;
    for (int i = 0; i < size; i++) { //itera el vector en busca de l'index més petit
      if (vector[i] < minValue) {
        minValue = vector[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}
```

2. Calculeu la matriu transposada d’una matriu. Una matriu transposada d’una donada, és
el resultat de canviar en la matriu original el valor de les files pel de les columnes.
Es definirà una funció amb el prototipus:
public static void transposada(double m[][], double mt[][]);
Aquesta funció rebrà la matriu original introduïda pel teclat m, i ha de calcular la seva
transposada mt. El programa principal ha de mostrar per pantalla la matriu original i la
seva transposada.

```java
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int rows = readRows(sc); // demana files
    int columns = readColumns(sc); // demana columnes
    
    boolean randVals = useRandomValues(); // demana si es volen generar dades o introduirles
    double[][] matrix = readMatrix(sc, rows, columns, randVals); // genera/demana dades

    System.out.println("Original matrix:"); //mostra la matriu original
    printMatrix(matrix, rows, columns);

    double[][] transposedMatrix = transposeMatrix(matrix, rows, columns); //genera la matriu trasposada
    System.out.println("Transposed matrix:"); //mostra la matriu trasposada
    printMatrix(transposedMatrix, columns, rows);
  }
  
  public static int readRows(Scanner sc) {
    System.out.print("Enter the number of rows: ");
    return sc.nextInt();
  }
  
  public static int readColumns(Scanner sc) {
    System.out.print("Enter the number of columns: ");
    return sc.nextInt();
  }
  
  public static double[][] readMatrix(Scanner sc, int rows, int columns, boolean useRandomValues) {
    double[][] matrix = new double[rows][columns];
    if (useRandomValues) {
      matrix = generateMatrix(rows, columns);
    } else {
      System.out.println("Enter the matrix elements:"); // va demanant dades per a la matriu
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          matrix[i][j] = sc.nextDouble();
        }
      }
    }
    return matrix;
  }
  
  public static double[][] transposeMatrix(double[][] matrix, int rows, int columns) {
    double[][] transposedMatrix = new double[columns][rows];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        transposedMatrix[j][i] = matrix[i][j]; // les files passen a ser les columnes i viceversa
      }
    }
    return transposedMatrix;
  }
  

	// mostra la matriu en format taula
  public static void printMatrix(double[][] matrix, int rows, int columns) {
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(decimalFormat.format(matrix[i][j]) + " ");
      }
      System.out.println();
    }
  }

	//demana si es volen usar valors aleatoris
  public static boolean useRandomValues() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Use random values for the matrix? (y/n) ");
    String input = sc.next();
    return input.equals("y");
  }
	
	// afegeix nombres aleatoris a la matriu
  public static double[][] generateMatrix(int rows, int columns) {
    Random random = new Random();
    double[][] matrix = new double[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = random.nextDouble() * 100;
      }
    }
    
    return matrix;
  }
}
```
