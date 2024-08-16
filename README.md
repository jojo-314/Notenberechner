Notenberechner

Dieses Projekt ist eine Anwendung zur Analyse von Studentendaten, die über eine XML-Datei eingelesen werden. 
Es berechnet die Noten der Studierenden basierend auf ihren Klausurergebnissen. Außerdem gibt es die fehlenden Punkte zur Besseren Note an.

Verwendung

Es wird eine XML Datei benötigt, die das Programm verarbeiten soll. Um die Datei zu ändern, einfach den Namen der Datei in der Main austauschen.
Also im Beispiel "studenten.xml".

 // XML-Datei parsen
            saxParser.parse("studenten.xml", handler);

XML Datei muss folgenden Aufbau haben:

 <studenten>
     <student>
         <matrikelnummer>abc123456</matrikelnummer>
         <name>Mustermann</name>
         <vorname>Max</vorname>
         <erreicht>98</erreicht>
         <maximal>100</maximal>
     </student>
   ...
 </studenten>

Wobei "<studenten>" alle Einträge von "<student>" umfasst.
Die Matrikelnummer, sowie Vor- und Nachname kann ein beliebiger String sein.
Erreicht und maximal müssen integer sein.

Code der Main Methode und SAXHandler sind zu finden bei:
    Notenumwandler/Notenumwandler2/src/

Autor:
Johanna Meißner
