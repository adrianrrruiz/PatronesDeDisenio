/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Abstract Factory
 * Implementación para el Web Service de Articulos
 */
package af.familiaws;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import servicios.IServiciosArticulos;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ImplementacionWSArticulos implements IServiciosArticulos {
    //private static final String[] ARTICULOS = new String[]{"Disco Duro", "Teclados", "Mouse"};

    @Override
    public String[] getArticulos() {
        System.out.println("Tipo de Servicio: WebServices");
        return getArticulosSOAP();

    }

    public String[] getArticulosSOAP() {
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear el cuerpo de la petición SOAP
            String requestBody = """
                    <?xml version="1.0" encoding="utf-8"?>
                    <soap12:Envelope xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
                      <soap12:Body>
                        <ListOfCountryNamesByName xmlns="http://www.oorsprong.org/websamples.countryinfo">
                        </ListOfCountryNamesByName>
                      </soap12:Body>
                    </soap12:Envelope>
                    """;

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso"))
                    .header("Content-Type", "application/soap+xml; charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado de la respuesta
            if (response.statusCode() == 200) {
                // Parsear la respuesta XML para extraer los nombres de los países
                List<String> countryNames = parseSOAPResponse(response.body());
                return countryNames.toArray(new String[0]);
            } else {
                System.out.println("Failed to fetch data. HTTP error code: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para parsear la respuesta SOAP y extraer los nombres de los países
    private static List<String> parseSOAPResponse(String response) throws Exception {
        List<String> countryNames = new ArrayList<>();

        // Crear un DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parsear la respuesta XML
        Document document = builder.parse(new InputSource(new StringReader(response)));

        // Extraer los elementos
        NodeList nodeList = document.getElementsByTagName("m:tCountryCodeAndName");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element countryElement = (Element) nodeList.item(i);
            NodeList nameList = countryElement.getElementsByTagName("m:sName");
            if (nameList.getLength() > 0) {
                countryNames.add(nameList.item(0).getTextContent());
            }
        }

        return countryNames;
    }

}
