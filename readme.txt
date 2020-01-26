Guten Tag Herr Gehri

In diesem Dokument möchte ich Ihnen noch einige Informationen teilen, damit Sie sich in unserem Projekt besser zurecht finden.

Damit das Projekt grundsätzlich funktioniert, bitte ich Sie das SQL-Script, welches Sie im Ordner sql finden, auszuführen.

Damit die DB funktioniert, muss XAMPP gestartet werden.

Falls es ein Problem mit dem MySQL connector gibt, können Sie folgende Schritte im Projekt ausführen:

Rechtsklick auf Libraries -> Add JAR/Folder -> Navigieren Sie in unser Bankomat Projekt -> mysql-connector-java-8.0.18 -> mysql-connector-java-8.0.18 ->
Wählen Sie "mysql-connector-java-8.0.18.jar" aus. Danach sollte es funktionieren.

Wenn Sie eine Karte entsperren möchten, können Sie in der Tabelle "kartegesperrt" den Eintrag für die Karte löschen.

Wenn Sie ein Bankkonto entsperren möchten, können Sie in der Tabelle "bank" das Feld gesperrt auf 0 setzen.

Wenn Sie in der Geldkassette Noten nachfüllen möchten, können Sie in der Tabelle "geldkassette" die Anzahl erhöhen.

