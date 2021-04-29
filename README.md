Si implementi la funzione customPrint della classe Solution

~~~~
    /**
     * Allows the columns projection of the input data
     * Formally like: "select colums from data"
     * @param data well-formed csv with comma as separator and \n as end of line (also  the last row ends with \n)
     * @param columns the columns to extract
     * @return a new csv (with the same format) but that contains only the colums specified (with the specified order)
     */
    public String customPrint(String data, String[] columns) {}
~~~~

Dove data è una stringa contenente un csv ben formato (non ci sono colonne mancanti). La prima riga del csv contiene gli header (titoli) delle colonne
L'array columns in input rappresenta invece l'array delle colonne di cui si vuole fare la proiezione.
In output si vuole ottenere un csv (come stringa).


Esempio
~~~~
LastName,FirstName,Age,Job
Mazzucchelli,Enrico,30,Developer
Devil,Andrea,52,Bella domanda

~~~~

Facendo la seguente richiesta
```java
Solution solution = new Solution();
String output = solution.customPrint(test, new String[]{"FirstName","Age"});
```

Si ottiene come output:

~~~~
FirstName,Age
Enrico,30
Andrea,52

~~~~


Eccezioni:
Il metodo generera:
- IllegalArgumentException se l'array di columns è nullo o vuoto
- IllegalArgumentException se l'array di columns contiene stringhe di colonne non presenti nel csv. Il testo di quest'ultima eccezione deve essere: "Missing columns: " + invalidColumnsCount

