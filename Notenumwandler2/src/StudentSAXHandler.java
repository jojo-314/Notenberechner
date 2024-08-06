import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Default Handler mit eigenem überschreiben
public class StudentSAXHandler extends DefaultHandler {

    boolean Matrikelnummer = false;
    boolean Name = false;
    boolean Vorname = false;
    boolean Erreicht = false;
    boolean Maximal = false;

    //Student
    String matrikelnummer;
    String name;
    String vorname;

    //Note
    int erreicht;
    int maximal;

    //Akzuelles Element true markieren
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        switch (qName) {
            case "matrikelnummer":
                Matrikelnummer = true;
                break;
            case "name":
                Name = true;
                break;
            case "vorname":
                Vorname = true;
                break;
            case "erreicht":
                Erreicht = true;
                break;
            case "maximal":
                Maximal = true;
                break;
        }
    }
    //Student fertig gelesen
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if (qName.equalsIgnoreCase("student")) {
            // Ausgabe der Matr.Nr. und Namen
            System.out.println("Matrikelnummer: " + matrikelnummer);
            System.out.println("Name: " + name);
            System.out.println("Vorname: " + vorname);

            // Berechnung der Note
            double note = berechneNote(erreicht, maximal);
            System.out.println("Erreichte Note: " + note);
            //Fehlende Punkte berechnen
            double fpunkte = berechnePunkte(erreicht, maximal);
            System.out.println("Zur besseren Note fehlen: " + fpunkte+ " Punkte");
            //Markiert Ende eines Studenten
            System.out.println("* * * * * * * *");
        }
    }

    //Einlesen und Speichern der Werte
    public void characters(char ch[], int start, int length) throws SAXException {
        if (Matrikelnummer) {
            matrikelnummer = new String(ch, start, length);
            Matrikelnummer = false;
        } else if (Name) {
            name = new String(ch, start, length);
            Name = false;
        } else if (Vorname) {
            vorname = new String(ch, start, length);
            Vorname = false;
        //in int umwandeln
        } else if (Erreicht) {
            erreicht = Integer.parseInt(new String(ch, start, length));
            Erreicht = false;
        } else if (Maximal) {
            maximal = Integer.parseInt(new String(ch, start, length));
            Maximal = false;
        }
    }

    //Brechnung der Noten (Prozente aus Kursplan von Prog I entnommen)
    private double berechneNote(int erreicht, int maximal) {
        double prozent = (double) erreicht / maximal;
        if (prozent >= 0.95) {
            return 1.0;
        } else if (prozent >= 0.90) {
            return 1.3;
        } else if (prozent >= 0.85) {
            return 1.7;
        } else if (prozent >= 0.80) {
            return 2.0;
        } else if (prozent >= 0.75) {
            return 2.3;
        }else if (prozent >= 0.70) {
            return 2.7;
        }else if (prozent >= 0.65) {
            return 3.0;
        }else if (prozent >= 0.60) {
            return 3.3;
        }else if (prozent >= 0.55) {
            return 3.7;
        }else if (prozent >= 0.50) {
            return 4.0;
        }else {
            return 5.0;
        }
    }
    //Punkte bis zur besseren Note berechnen
    private double berechnePunkte(int erreicht, int maximal) {
        double prozent = (double) erreicht / maximal;
         if (prozent>=0.95) {
            return 0.0;
        }else if (prozent>=0.5){
            double exact = ((((prozent * 100)%5)-5)*(-1))* maximal/100;
            //Punkte runden
            double rounded = Math.round(exact * 100.0) / 100.0;
        return rounded;
        }else{
            double exact = (0.5-prozent)* maximal;
            double rounded = Math.round(exact * 100.0) / 100.0;
            return rounded;
        }
    }
}

