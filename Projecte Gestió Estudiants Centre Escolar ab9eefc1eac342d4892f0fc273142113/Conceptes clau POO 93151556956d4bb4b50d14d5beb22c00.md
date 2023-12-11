# Conceptes clau POO

# Classe

Una **classe** en POO és una plantilla o un esquema que defineix les característiques i comportaments comuns d'un conjunt d'objectes. Tècnicament, una classe en Java es pot veure com un model que descriu l'estat (atributs) i les accions (mètodes) que els objectes creats a partir d'aquesta classe podran tenir.

Per fer una analogia, podem pensar en una classe com el plànol d'una casa. Aquest plànol determina la disposició de les habitacions, portes, finestres, etc. En el món de la programació, aquests elements serien els atributs i mètodes de la classe. Així com diferents cases poden ser construïdes a partir del mateix plànol, diferents objectes (instàncies) poden ser creats a partir de la mateixa classe.

Un exemple pràctic seria una classe `Automobil`, que defineix les propietats comunes de tots els automòbils (com marca, model, color) i els comportaments (com arrencar, parar, accelerar):

```java
public class Automobil {
    // Atributs
    private String marca;
    private String model;
    private String color;

    // Constructor
    public Automobil(String marca, String model, String color) {
        this.marca = marca;
        this.model = model;
        this.color = color;
    }

    // Mètodes
    public void arrencar() {
        System.out.println("L'automòbil està arrencant.");
    }

    public void parar() {
        System.out.println("L'automòbil s'ha aturat.");
    }

    // ... més mètodes i funcionalitats
}

```

En aquest exemple, la classe `Automobil` defineix l'estructura bàsica d'un automòbil, i a partir d'aquesta es poden crear diferents objectes `Automobil` amb diferents característiques (marca, model, color) i amb la capacitat de realitzar accions com arrencar o aturar-se.

# Instància d’una classe (objecte)

Una **instància d'una classe**, també coneguda com a **objecte**, és una realització concreta d'una classe. Quan instanciem una classe, estem creant un objecte específic que té les propietats i comportaments definits en la classe, però amb valors únics per a aquestes propietats. Cada objecte té el seu propi estat independent, que es determina pels valors dels seus atributs.

Fent una altra analogia amb el plànol d'una casa: si la classe és el plànol, llavors un objecte seria una casa específica construïda segons aquest plànol. Encara que totes les cases (objectes) construïdes a partir d'aquest plànol compartiran una estructura comuna, cada una pot tenir diferents colors de pintura, tipus de mobles, etc., que les fa úniques.

Per exemple, si tenim la classe `Automobil` que hem definit abans, podem crear instàncies (objectes) d'aquesta classe:

```java
public class Main {
    public static void main(String[] args) {
        // Creant instàncies de la classe Automobil
        Automobil meuAutomobil = new Automobil("Toyota", "Corolla", "Blau");
        Automobil teuAutomobil = new Automobil("Honda", "Civic", "Vermell");

        // Utilitzant mètodes de les instàncies
        meuAutomobil.arrencar();
        teuAutomobil.parar();
    }
}

```

En aquest codi, `meuAutomobil` i `teuAutomobil` són objectes o instàncies de la classe `Automobil`. Cada un d'ells té les seves pròpies propietats (marca, model, color) que són independents entre si. Per exemple, `meuAutomobil` és un Toyota Corolla de color blau, mentre que `teuAutomobil` és un Honda Civic de color vermell. A més, cada objecte pot cridar els mètodes definits en la classe, com arrencar o parar, però aquests mètodes actuaran sobre l'estat específic de cada objecte.

# Encapsulació

L'**encapsulació** és un principi fonamental de la Programació Orientada a Objectes (POO) que consisteix en ocultar els detalls interns d'una classe i exposar només les funcionalitats necessàries a l'usuari d'aquesta classe. Això s'aconsegueix fent que els atributs d'una classe siguin privats i proporcionant mètodes públics per accedir i modificar aquests atributs, coneguts com a getters i setters. L'encapsulació ajuda a protegir l'estat intern d'un objecte i promou la modularitat i la flexibilitat en el disseny del software.

Una bona analogia seria pensar en un televisor: com a usuari, pots canviar de canal, ajustar el volum o encendre i apagar el televisor utilitzant el control remot, però no necessites saber com funcionen els circuits interns del televisor per fer-ho. De manera similar, en programació, l'encapsulació permet als usuaris interactuar amb una classe sense necessitat de conèixer o accedir directament als seus detalls interns.

Aquí tenim un exemple amb la classe `Automobil` que hem utilitzat abans, però afegint-hi encapsulació:

```java
public class Automobil {
    // Atributs privats
    private String marca;
    private String model;
    private String color;

    // Constructor
    public Automobil(String marca, String model, String color) {
        this.marca = marca;
        this.model = model;
        this.color = color;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Mètodes
    public void arrencar() {
        System.out.println("L'automòbil està arrencant.");
    }

    // ... altres mètodes
}

```

En aquest exemple, els atributs `marca`, `model` i `color` són privats, el que significa que no poden ser accedits directament des de fora de la classe. En lloc d'això, s'utilitzen mètodes públics (getters i setters) per obtenir i establir els valors d'aquests atributs. Aquesta pràctica assegura que el control sobre com s'accedeix i es modifica l'estat intern de l'objecte roman dins de la classe, ajudant a prevenir usos incorrectes i inconsistències en l'estat de l'objecte.

# Abstracció

L'**abstracció** en POO és el procés de identificar i destacar les característiques i comportaments essencials d'un concepte o entitat, tot excluint els detalls secundaris o no rellevants per a l'objectiu en qüestió. Això es realitza habitualment a través de classes abstractes o interfícies. Aquestes estructures defineixen un "tipus" d'objecte en termes generals, establint un marc que les subclasses o les classes que implementen aquestes interfícies han de seguir.

Per exemple, podem imaginar una classe abstracta `Vehicle` que encapsuli els atributs i mètodes comuns a tot tipus de vehicles, sense especificar completament com aquests mètodes funcionaran. Això permet que diferents tipus de vehicles, com cotxes, bicicletes o vaixells, puguin ser modelats com a extensions d'aquesta classe base, proporcionant les seves pròpies implementacions específiques per a aquests comportaments generals.

Aquí tenim un exemple:

```java
// Classe abstracta que defineix un vehicle en termes generals
public abstract class Vehicle {
    protected int nombreDeRodes;

    // Constructor
    public Vehicle(int nombreDeRodes) {
        this.nombreDeRodes = nombreDeRodes;
    }

    // Mètode abstracte: les subclasses hauran de proporcionar una implementació
    public abstract void arrencar();

    public abstract void parar();

    // Mètode comú a tots els vehicles
    public int getNombreDeRodes() {
        return nombreDeRodes;
    }
}

// Subclasse concreta de Vehicle
public class Cotxe extends Vehicle {
    // Constructor específic del cotxe
    public Cotxe() {
        super(4); // Els cotxes tenen generalment 4 rodes
    }

    // Implementació concreta dels mètodes abstractes
    @Override
    public void arrencar() {
        System.out.println("El cotxe està arrencant.");
    }

    @Override
    public void parar() {
        System.out.println("El cotxe s'ha aturat.");
    }

    // ... altres mètodes i comportaments específics del cotxe
}

```

En aquest cas, la classe `Vehicle` proporciona una abstracció per a tots els tipus de vehicles, definint característiques comunes com el nombre de rodes i les accions bàsiques com arrencar i parar. La classe `Cotxe` hereta d'aquesta abstracció i proporciona la implementació específica per a un cotxe. Aquest enfocament permet una major flexibilitat i reutilització del codi, ja que altres tipus de vehicles poden ser creats com a subclasses de `Vehicle`, cadascun amb les seves característiques i comportaments específics.

# Herència

L'**herència** en Programació Orientada a Objectes (POO) és un mecanisme pel qual una classe pot heretar atributs i mètodes d'una altra classe. La classe que dóna els seus atributs i mètodes s'anomena classe base o superclasse, mentre que la classe que els hereta s'anomena classe derivada o subclasse. Aquest concepte permet la reutilització del codi, facilita la mantenibilitat i fomenta l'organització jeràrquica del codi.

Per entendre la herència, podem utilitzar l'analogia d'una família. Així com els fills poden heretar característiques físiques o comportaments dels seus pares, en POO, una subclasse pot heretar les propietats i funcionalitats de la seva superclasse.

Continuant amb l'exemple del vehicle, suposem que tenim una classe `Vehicle` amb algunes propietats generals. Podem crear una subclasse `Cotxe` que hereti d'aquesta classe i afegir-li més característiques específiques:

```java
// Classe base o superclasse
public class Vehicle {
    protected int nombreDeRodes;

    public Vehicle(int nombreDeRodes) {
        this.nombreDeRodes = nombreDeRodes;
    }

    public void arrencar() {
        System.out.println("El vehicle està arrencant.");
    }

    // ... altres mètodes i propietats
}

// Classe derivada o subclasse
public class Cotxe extends Vehicle {
    private String marca;

    public Cotxe(int nombreDeRodes, String marca) {
        super(nombreDeRodes); // Crida al constructor de la superclasse
        this.marca = marca;
    }

    public void tocarBocina() {
        System.out.println("El cotxe fa beep!");
    }

    // ... altres mètodes específics del cotxe
}

```

En aquest exemple, `Cotxe` és una subclasse de `Vehicle`. Això significa que `Cotxe` hereta totes les propietats i mètodes de `Vehicle`, com `nombreDeRodes` i `arrencar()`, però també pot tenir les seves pròpies propietats i mètodes únics, com `marca` i `tocarBocina()`. Aquesta capacitat de construir noves classes a partir de classes existents simplifica el desenvolupament de software i ajuda a evitar la duplicació de codi.

# Polimorfisme

El **polimorfisme**, en la Programació Orientada a Objectes (POO), és la capacitat d'un objecte de ser tractat com a instància de múltiples classes, generalment a través de la herència. Aquest concepte permet que un objecte d'una subclasse sigui tractat com si fos un objecte de la seva superclasse, facilitant la flexibilitat i la reutilització del codi.

El polimorfisme es pot entendre millor amb una analogia musical: considera els diferents tipus d'instruments de vent. Tot i que cada instrument (com una trompeta, un saxòfon o una flauta) produeix so de manera diferent, tots poden ser tractats com a instruments de vent. En POO, això seria similar a tenir diferents subclasses que implementen de maneres distintes un mètode comú definit en una superclasse o interfície.

Un exemple en Java seria tenir una superclasse `Vehicle` i diverses subclasses com `Cotxe` i `Motocicleta`. Totes aquestes subclasses poden redefinir (sobreescriure) un mètode de la superclasse, per exemple, `arrencar()`. Això permet que, quan s'invoqui el mètode `arrencar()` en un objecte de la subclasse, s'executi la versió específica d'aquella subclasse, tot i que l'objecte sigui referenciat com a instància de la superclasse `Vehicle`.

```java
// Superclasse
public class Vehicle {
    public void arrencar() {
        System.out.println("El vehicle està arrencant de manera genèrica.");
    }
}

// Subclasse Cotxe
public class Cotxe extends Vehicle {
    @Override
    public void arrencar() {
        System.out.println("El cotxe està arrencant amb un motor d'arrancada.");
    }
}

// Subclasse Motocicleta
public class Motocicleta extends Vehicle {
    @Override
    public void arrencar() {
        System.out.println("La motocicleta està arrencant amb un pedal de kickstart.");
    }
}

// Classe de demostració
public class DemoPolimorfisme {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Cotxe();
        Vehicle vehicle2 = new Motocicleta();

        vehicle1.arrencar(); // Imprimeix: El cotxe està arrencant amb un motor d'arrancada.
        vehicle2.arrencar(); // Imprimeix: La motocicleta està arrencant amb un pedal de kickstart.
    }
}

```

En aquest exemple, tant `Cotxe` com `Motocicleta` són subclasses de `Vehicle` i ambdues redefinixen el mètode `arrencar()`. Quan s'invoqui aquest mètode en un objecte de tipus `Vehicle`, la versió que s'executarà serà la que correspon a la classe real de l'objecte, mostrant polimorfisme. Així, el polimorfisme permet tractar objectes de diverses subclasses d'una manera unificada, tot aprofitant les implementacions específiques de cada subclasse.

# Sobrecàrrega (“oveload”)

La **sobrecàrrega de mètodes** (anomenada "overload" en anglès) és una característica de la Programació Orientada a Objectes (POO) que permet definir múltiples mètodes amb el mateix nom dins d'una classe, però amb llistes de paràmetres diferents (és a dir, amb diferent nombre o tipus de paràmetres). Aquesta capacitat permet que els mètodes realitzin accions similars però amb detalls o contexts diferents.

Per entendre la sobrecàrrega, podem pensar en un exemple senzill de la vida real: considera un restaurant que ofereix un menú amb diferents versions del mateix plat, per exemple, una pizza. Pots demanar una pizza amb ingredients diferents (com formatge, peperoni, o vegetals), però sempre és "una pizza". De manera similar, en POO, pots tenir diferents versions d'un mètode (per exemple, `dibuixar`) que realitzi la mateixa tasca bàsica (dibuixar alguna cosa) però de maneres lleugerament diferents segons els paràmetres que li passis.

Aquí tenim un exemple en Java:

```java
public class Dibuixant {
    // Sobrecàrrega del mètode dibuixar amb diferents paràmetres

    // Dibuixa un cercle
    public void dibuixar(float radi) {
        System.out.println("Dibuixant un cercle amb radi: " + radi);
    }

    // Dibuixa un rectangle
    public void dibuixar(float amplitud, float altura) {
        System.out.println("Dibuixant un rectangle amb amplitud " + amplitud + " i altura " + altura);
    }

    // Dibuixa una línia
    public void dibuixar(float xInici, float yInici, float xFi, float yFi) {
        System.out.println("Dibuixant una línia des de (" + xInici + ", " + yInici + ") fins a (" + xFi + ", " + yFi + ")");
    }
}

// Classe per demostrar la sobrecàrrega
public class DemoSobrecarrega {
    public static void main(String[] args) {
        Dibuixant dibuixant = new Dibuixant();

        dibuixant.dibuixar(5); // Dibuixa un cercle
        dibuixant.dibuixar(4, 6); // Dibuixa un rectangle
        dibuixant.dibuixar(0, 0, 3, 3); // Dibuixa una línia
    }
}

```

En aquest exemple, la classe `Dibuixant` té tres versions diferents del mètode `dibuixar`. Cada versió accepta un conjunt diferent de paràmetres i, per tant, realitza una tasca lleugerament diferent (dibuixar un cercle, un rectangle o una línia). Quan el mètode `dibuixar` es crida, Java determina quina versió utilitzar basant-se en els paràmetres que se li passen. Aquesta flexibilitat en la definició de mètodes és un exemple clau de la sobrecàrrega de mètodes en la POO.

# Sobreescriptura (“override”)

La **sobreescriptura de mètodes** (anomenada "override" en anglès) és una característica de la Programació Orientada a Objectes (POO) que permet a una subclasse proporcionar una implementació específica d'un mètode que ja està definit en la seva superclasse. Aquest procés permet a la subclasse alterar o ampliar el comportament del mètode heretat.

Per fer una analogia, imaginem que estàs seguint una recepta heretada de la teva família per fer un pastís. La recepta original (la superclasse) ofereix els passos bàsics i ingredients. Però tu decides fer alguna modificació, com afegir un nou ingredient o canviar la manera de preparació. Això seria com "sobreescriure" la recepta original amb la teva versió personalitzada (la subclasse).

En Java, quan sobreescrius un mètode, utilitzes la mateixa signatura del mètode (el mateix nom i paràmetres) que en la superclasse, però canvies el seu cos (la implementació). Això es fa freqüentment quan treballes amb herència.

Aquí tenim un exemple:

```java
// Superclasse
public class Vehicle {
    public void mostrarSo() {
        System.out.println("El vehicle fa un so genèric.");
    }
}

// Subclasse
public class Cotxe extends Vehicle {
    @Override // Anotació per indicar que estem sobreescribint un mètode
    public void mostrarSo() {
        System.out.println("El cotxe fa un so de motor.");
    }
}

// Classe per demostrar la sobreescriptura
public class DemoSobreescriptura {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.mostrarSo(); // Imprimeix: El vehicle fa un so genèric.

        Cotxe cotxe = new Cotxe();
        cotxe.mostrarSo(); // Imprimeix: El cotxe fa un so de motor.
    }
}

```

En aquest exemple, la classe `Cotxe` sobreescriu el mètode `mostrarSo()` de la seva superclasse `Vehicle`. Així, quan es crida aquest mètode en un objecte de tipus `Cotxe`, s'utilitza la versió sobreescripta del mètode, que és específica per a la classe `Cotxe`. Això demostra com el polimorfisme i la sobreescriptura de mètodes permeten a les subclasses modificar o ampliar els comportaments heretats de les seves superclasses.