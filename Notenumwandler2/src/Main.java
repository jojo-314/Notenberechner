import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {

        try {
            // SAX-Parser-Factory um Parser zu erstellen
            SAXParserFactory factory = SAXParserFactory.newInstance();

            //Parser erstellen
            SAXParser saxParser = factory.newSAXParser();

            // Eigenen Handler erstellen
            StudentSAXHandler handler = new StudentSAXHandler();

            // XML-Datei parsen
            saxParser.parse("studenten.xml", handler);

        } catch (Exception e) {
            System.out.println("Fehler");
            e.printStackTrace();
        }
    }
}
