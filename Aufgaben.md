# Java 8 Workshop -- Aufgaben

Code: <https://github.com/andrena/java8-workshop>

## Functional Interfaces und Lambdas

### Supplier

#### 1. `SupplierFrage`

```java
if (logger.isLoggable(Level.INFO)) {
	logger.info(ermittleKomplizierteNachricht());
}
```

Im obigen Beispiel wird `ermittleKomplizierteNachricht()` nur dann aufgerufen, wenn `Level.INFO` geloggt werden soll. Wie kann man das gleiche erreichen, ohne ein `if`-Statement zu verwenden?

*Tipp:* Schau dir die `info`-Methoden der Klasse `java.util.logging.Logger` an.

#### 2. `SupplierUebung`

Schreibe eine Log-Methode, die wie folgt aufgerufen wird:

```java
logIf(() -> x > 0, Level.INFO, () -> "X was > 0: " + x);
```
- Die Bedingung wird nur aufgerufen, wenn der LogLevel an ist
- Die Nachricht wird nur erstellt, wenn die Bedingung erfüllt ist

### Consumer

#### 1. `ConsumerUebung`

Schreibe eine statische Methode mit folgender Signatur, die den vom `Supplier` gelieferten Wert an den `Consumer` weitergibt und rufe sie auf.

```java
<T> void consume(Supplier<T> supplier, Consumer<T> consumer)
```

#### 2. `ConsumerBonusFrage`

Warum ist die oben genannte Signatur zu restriktiv? Was wäre besser?

#### 3. `ConsumerBonusAufgabe`

Erzeuge eine Liste von Personen und gebe sie auf die Konsole aus ohne eine Schleife zu verwenden.

### Predicates

#### 1. `PredicatesUebung`

Implementiere eine statische Methode mit folgender Signatur, die alle Elemente aus einer `Collection` entfernt, die einem `Predicate` entsprechen und rufe sie auf.

```java
<T> void removeIf(Collection<T> collection, Predicate<T> predicate)
```

*Tipp:* Verwende `Collection#iterator`.

#### 2. `PredicatesBonusFrage`

Warum ist die oben genannte Signatur zu restriktiv? Was wäre besser?


#### 3. `PredicatesBonusAufgabe`

Schreibe eine statische Methode mit folgender Signatur, die den vom `Supplier` gelieferten Wert an den `Consumer` weitergibt, wenn das `Predicate` erfüllt ist, und rufe sie auf.

```java
<T> void consumeIf(Supplier<T> supplier, Predicate<T> predicate, Consumer<T> consumer)
```

### Functions

#### 1. `FunctionsUebung`

Implementiere eine statische Methode mit folgender Signatur, die alle Elemente, die einem `Predicate` entsprechen, aus einer `List` mit dem Wert ersetzt, den die `Function` zurückgibt und rufe sie auf.

```java
<T> void replaceIf(List<T> list, Predicate<T> predicate, Function<T, T> function)
```

*Tipp:* Verwende `List#listIterator` und `ListIterator#set`.

#### 2. `FunctionsBonusFrage`

Warum ist die oben genannte Signatur zu restriktiv? Was wäre besser?


#### 3. `FunctionsBonusAufgabe`

Schreibe eine statische Methode mit folgender Signatur, die den vom `Supplier` gelieferten Wert über die `Function` an den `Consumer` weitergibt, wenn das `Predicate` erfüllt ist, und rufe sie auf.

```java
<A,B> void convertAndConsumeIf(Supplier<A> supplier, Predicate<A> predicate, Function<A,B> function, Consumer<B> consumer)
```


## Streams

### 1. Filter/Map-Aufgaben

Bearbeite die Klasse `StreamAufgabe1`. Beginne jeweils mit einem `Stream<Person>`, der über die Methode `newPersonenStream()` erzeugt werden kann.
Jeder Test in der Klasse ist rot und soll durch Anwendung der richtigen `Stream`-Methoden grün gemacht werden.

1. Gibt es eine Person, die den Nachnamen "Maier" hat?
1. Wie viele Personen gibt es mit Nachnahmen "Maier"?
1. Bestimme die Anzahl verschiedener Vornamen (ohne Dubletten).
1. Gibt es Personen mit Nachnahmen mit mehr als 8 Zeichen?
1. Ermittle Statistiken über die Länge der Nachnamen (Minimum, Maximum, Durchschnitt).

### 2. Collector-Aufgaben

Bearbeite die Klasse `StreamAufgabe2`. Beginne jeweils mit einem `Stream<Person>`, der über die Methode `newPersonenStream()` erzeugt werden kann.

1. Erstelle eine sortierte Liste, die alle verschiedenen Vornamen der Personen mit Nachnamen "Maier" enthält.
1. Genauso wie die vorherige Aufgabe, nur dass jetzt das Ergebnis eine `LinkedList` sein soll.
1. Erstelle einen `String`, der kommasepariert alle verschiedenen Vornamen der Personen mit Nachnamen "Maier" enthält. (z.B. "Egon, Hans, Walter")
1. Erstelle eine `Map`, die als Keys die Nachnamen enthält und als Value eine Liste mit den entsprechenden Personen: `Map<String, List<Person>>`
1. Erstelle eine List mit einem String je Nachname der Form "Müller: Egon, Hans, Walter", d.h. jeder Nachname enthält einen Eintrag in der List und in dem String sind alle verschiedenen Vornamen sortiert und kommasepariert aufgelistet. (Tipp: Erstelle zunächste dieselbe Map, wie in der Aufgabe zuvor)


## Optional

Bearbeite die Klasse `OptionalAufgabe` ohne ein einziges `if`-Statement zu verwenden.

1. Finde die erste Person mit dem Nachnamen "Müller" in einem `Stream<Person>`.
1. Verwende einen Default-Wert für die Person, wenn keine gefunden wurde.
1. Gib die Person aus, sofern sie gefunden wurde.
1. Gib die Person aus, sofern sie gefunden wurde und den Vornamen "Daniel" hat.
1. Lese den Nachnamen der Person aus, falls sie gefunden wurde. Ansonsten verwende "Maier" als Nachnamen.
1. Erzeuge selbst ein befülltes `Optional<Person>`.
1. Erzeuge selbst ein leeres `Optional<Person>`.
1. Wirf eine `IllegalArgumentException`, wenn ein `Optional<Person>` leer ist.

<!--BREAK-->

## DateTime-API

1. Ermittle die Anzahl der Personen, die an einem Freitag den 13. geboren sind.
1. Ermittle den Wochentag des 1. April 2014.
1. Ermittle das Alter in Jahren, Monaten und Tagen einer Person, die am 12. März 1976 geboren ist. Tipp: Verwende die Klasse `Period`.
1. Gib alle Zeitzonen sortiert aus. Siehe `ZoneId.getAvailableZoneIds`, verwende die `Stream`-API.
1. Gruppiere die Personen nach Geburtsjahr und ermittle das Jahr mit den meisten Geburten.

---
(C) Copyright 2014 andrena objects ag
