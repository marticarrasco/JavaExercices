# TEMA_6_INTRO_POO_IB_2022_23_v3.pdf

[TEMA_6_INTRO_POO_IB_2022_23_v3.pdf](TEMA_6_INTRO_POO_IB_2022_23_v3%20pdf/TEMA_6_INTRO_POO_IB_2022_23_v3.pdf)

**Programes per desenvolupar**

1.- Agafant com a referència el programa fet com a exemple de la classe Estudiant, afegiu
un nou atribut: String nom, i un nou mètode: double arrodonirNota( ) que arrodoneixi la
nota d’un estudiant.

```jsx
public class Estudiant {
    // Atributs de la classe
    private int dni;
    private String nom;
    private double nota;

    // Mètodes
    // Constructor per defecte
    public Estudiant() {
        this.dni = 0;
        this.nom = "";
        this.nota = -1;
    }

    // Constructor
    public Estudiant(int dni) {
        this.dni = dni;
        this.nom = "";
        this.nota = -1;
    }

    // Consultors
    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Modificasdors
    public double getNota() {
        return nota;
    }

    public int getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public double arrodonirNota() {
        return Math.round(nota * 10.0) / 10.0;
    }

    // Entrada i sortida
    @Override
    public String toString() {
        if (nota != -1)
            return ("DNI: " + dni + " Nom: " + nom + " Nota: " + nota);
        else
            return ("DNI: " + dni + " Nom: " + nom + " Nota: NP");
    }

    public void llegir() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Escriu el dni de l'alumne: ");
        int dni = teclat.nextInt();
        System.out.println("Escriu el nom de l'alumne: ");
        String nom = teclat.next();
        System.out.println("Escriu la nota de l'alumne (-1 si es NP): ");
        double aux = teclat.nextDouble();
        if (aux >= 0 && aux <= 10)
            nota = aux;
        else
            nota = -1;
    }
}
```

**Programes opcionals**

1.- Dissenyeu i implementeu una aplicació que a partir de la classe Persona i els seus
atributs: nom (String), cognom1 (String), cognom2 (String), dni (int), edad (int), i amb
els mètodes que considereu oportuns, demani les dades de dues persones a l’usuari i les
mostri per pantalla. Feu el diagrama UML corresponent a la classe dissenyada.

```jsx
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Person {
    private String name;
    private String surname1;
    private String surname2;
    private int dniNumber;
    private char dniLetter;
    private LocalDate birthDate;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    private String nationality;
    private String profession;
    private String[] languages;

    public Person(String name, String surname1, String surname2, int dniNumber, LocalDate birthDate, String gender, String phoneNumber, String email, String address, String city, String country, String nationality, String profession, String[] languages) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.dniNumber = dniNumber;
        this.dniLetter = calculateDniLetter(dniNumber);
        this.birthDate = birthDate;
        this.age = calculateAge();
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.nationality = nationality;
        this.profession = profession;
        this.languages = languages;
    }

    public Person(String name, String surname1, String surname2, int dniNumber, char dniLetter, int age) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.dniNumber = dniNumber;
        this.dniLetter = dniLetter;
        this.age = age;
        this.birthDate = LocalDate.now().minusYears(age);
    }
    
    public Person(String name, String surname1, String surname2, int dniNumber, char dniLetter, int age, String gender, String phoneNumber, String email, String address, String city, String country, String nationality, String profession, String[] languages) {
        this(name, surname1, surname2, dniNumber, dniLetter, age);
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.nationality = nationality;
        this.profession = profession;
        this.languages = languages;
    }

    public void readData(){
        public static Person createPersonFromInput() {
            Scanner scanner = new Scanner(System.in);
        
            System.out.print("Name: ");
            String name = scanner.nextLine();
        
            System.out.print("First surname: ");
            String surname1 = scanner.nextLine();
        
            System.out.print("Second surname: ");
            String surname2 = scanner.nextLine();
        
            System.out.print("DNI number: ");
            int dniNumber = scanner.nextInt();
        
            System.out.print("Birth year: ");
            int birthYear = scanner.nextInt();
        
            System.out.print("Birth month (number): ");
            int birthMonth = scanner.nextInt();
        
            System.out.print("Birth day: ");
            int birthDay = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
        
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
        
            System.out.print("Phone number: ");
            String phoneNumber = scanner.nextLine();
        
            System.out.print("Email: ");
            String email = scanner.nextLine();
        
            System.out.print("Address: ");
            String address = scanner.nextLine();
        
            System.out.print("City: ");
            String city = scanner.nextLine();
        
            System.out.print("Country: ");
            String country = scanner.nextLine();
        
            System.out.print("Nationality: ");
            String nationality = scanner.nextLine();
        
            System.out.print("Profession: ");
            String profession = scanner.nextLine();
        
            System.out.print("Languages (comma-separated): ");
            String languagesString = scanner.nextLine();
            String[] languages = languagesString.split(",");
    }
    

    public String getName() {
        return this.name;
    }

    public String getSurname1() {
        return this.surname1;
    }

    public String getSurname2() {
        return this.surname2;
    }

    public int getDniNumber() {
        return this.dniNumber;
    }

    public char getDniLetter() {
        return this.dniLetter;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getProfession() {
        return this.profession;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public void setDniNumber(int dniNumber) {
        this.dniNumber = dniNumber;
        this.dniLetter = calculateDniLetter(dniNumber);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.age = calculateAge();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    private char calculateDniLetter(int dniNumber) {
        String dniLetterTable = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniLetterIndex = dniNumber % 23;
        return dniLetterTable.charAt(dniLetterIndex);
    }

    private int calculateAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public String toString() {
        return String.format("%s %s %s (DNI: %d-%c, age: %d)%n%s%n%s, %s, %s%n%s, %s, %s%nNationality: %s%nProfession: %s%nLanguages: %s",
                             this.name, this.surname1, this.surname2, this.dniNumber, this.dniLetter, this.age,
                             this.gender,
                             this.phoneNumber, this.email, this.address, this.city, this.country,
                             this.nationality, this.profession, String.join(", ", this.languages));
    }

    public void readData() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Name: ");
        String name = scanner.nextLine();
    
        System.out.print("First surname: ");
        String surname1 = scanner.nextLine();
    
        System.out.print("Second surname: ");
        String surname2 = scanner.nextLine();
    
        System.out.print("DNI number: ");
        int dniNumber = scanner.nextInt();
    
        System.out.print("Birth year: ");
        int birthYear = scanner.nextInt();
    
        System.out.print("Birth month (number): ");
        int birthMonth = scanner.nextInt();
    
        System.out.print("Birth day: ");
        int birthDay = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
    
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
    
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
    
        System.out.print("Email: ");
        String email = scanner.nextLine();
    
        System.out.print("Address: ");
        String address = scanner.nextLine();
    
        System.out.print("City: ");
        String city = scanner.nextLine();
    
        System.out.print("Country: ");
        String country = scanner.nextLine();
    
        System.out.print("Nationality: ");
        String nationality = scanner.nextLine();
    
        System.out.print("Profession: ");
        String profession = scanner.nextLine();
    
        System.out.print("Languages (comma-separated): ");
        String languagesString = scanner.nextLine();
        String[] languages = languagesString.split(",");
    
        // set the instance variables
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.dniNumber = dniNumber;
        this.dniLetter = calculateDniLetter(dniNumber);
        this.birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        this.age = calculateAge();
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.nationality = nationality;
        this.profession = profession;
        this.languages = languages;
    }
    
}
```

You can then call this method on a Person object to ask the user for input and set the corresponding attributes. For example:

```jsx
Person person = new Person("", "", "", 0, LocalDate.now(), "", "", "", "", "", "", "", "", new String[0]);
person.readData();
System.out.println(person.toString());
```
