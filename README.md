# Like Hero To Zero - Fallstudie (IPWA02-01)

Dies ist die technische Umsetzung für die Fallstudie "Like Hero To Zero" im Rahmen des Kurses "Programmierung von industriellen Informationssystemen mit Java EE" (IPWA02-01).

Die Webanwendung bietet eine öffentliche Ansicht von CO2-Emissionsdaten und einen geschützten Backend-Bereich für Wissenschaftler:innen zur Dateneingabe.

## 🚀 Projekt-Features (User Stories)

* **MUST 1 (Öffentlich):** Als umweltpolitisch interessierte:r Bürger:in will ich den aktuellsten im Datensatz verfügbaren CO2-Ausstoß des Landes nachlesen können, über dessen Staatsbürgerschaft ich verfüge. *(Implementiert)*
* **MUST 2 (Backend):** Als registriere:r, Daten beitragende:r Wissenschaftler:in will ich die jüngsten Daten aus meiner Klimaforschung in dem Datensatz hinterlegen. *(Implementiert)*

## 🛠 Verwendeter Technologiestack

Dieser Prototyp wurde exakt nach den Vorgaben des Studienskripts (IPWA02-01) entwickelt.

* **Sprache:** Java 11
* **Framework (Backend/Web):** Java EE 8 (JSF 2.3, CDI 2.0)
* **UI-Komponenten:** PrimeFaces 11.0 (wie in Lektion 3)
* **Persistenz:** JPA 2.2 (wie in Lektion 5)
* **Persistenz-Provider:** Hibernate 5.6
* **Application Server:** WildFly 26.1.3.Final (letzte Java EE 8 kompatible Version)
* **Entwicklungs-Datenbank:** H2 (In-Memory, wird automatisch durch `import.sql` befüllt)
* **Build-Tool:** Apache Maven

## 🏁 Projekt lokal starten (mit Eclipse & WildFly)

### 1. Voraussetzungen

* Java JDK 11
* Eclipse IDE for Enterprise Java and Web Developers (Version 2022-06 oder neuer)
* Apache Maven (normalerweise in Eclipse integriert)
* **WildFly 26.1.3.Final** (letzte Java EE 8 Version! **Nicht** WildFly 27+ verwenden.)

### 2. Projekt in Eclipse importieren

1.  Eclipse starten (mit der "Java EE"-Perspektive).
2.  **File** -> **Import...**
3.  **Maven** -> **Existing Maven Projects**.
4.  **Root Directory:** Wähle den `IPWA02-01`-Ordner aus, der diese `README.md` und die `pom.xml` enthält.
5.  Klicke **Finish**.

### 3. WildFly 26 Server einrichten

1.  WildFly 26.1.3.Final [hier](https://www.wildfly.org/downloads/) herunterladen (unter "Older Releases") und entpacken.
2.  In Eclipse: **Window** -> **Show View** -> **Other...** -> **Servers**.
3.  Im "Servers"-Tab: **"No servers are available..."** anklicken.
4.  **JBoss Community** -> **WildFly 26** auswählen.
5.  **Home Directory:** Den entpackten `wildfly-26.1.3.Final`-Ordner auswählen.
6.  **Finish** klicken.

### 4. Anwendung starten

1.  Im "Servers"-Tab: **Rechtsklick** auf "WildFly 26".
2.  **Add and Remove...** auswählen.
3.  Das `like-hero-to-zero`-Projekt von "Available" nach "Configured" verschieben. **Finish** klicken.
4.  Im "Servers"-Tab: **Rechtsklick** auf "WildFly 26" -> **Start**.

Der Server startet, erstellt (dank `persistence.xml` mit `create-drop`) automatisch die H2-Datenbank-Tabellen und befüllt sie (dank `import.sql`) mit Testdaten.

### 5. Anwendung nutzen

Eclipse sollte den Browser automatisch öffnen. Falls nicht:

* **Öffentliches Frontend:** `http://localhost:8080/like-hero-to-zero/`
* **Login-Seite:** `http://localhost:8080/like-hero-to-zero/login.xhtml`
* **Test-Login (Wissenschaftler):**
    * **Benutzername:** `marie.curie`
    * **Passwort:** `radioactive`

---
*Dies ist eine Studienleistung für die IU Internationale Hochschule, erstellt von Pascal Haupt.*
