/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Abstract Factory
 * Implementación para el Service de Articulos tipo Restfull
 */
package af.familiarest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import model.User;
import servicios.IServiciosArticulos;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author Fabrizio Bolaño
 */
public class ImplementacionRestArticulos implements IServiciosArticulos {
    //private static final String[] ARTICULOS = new String[]{"Disco Duro", "Teclados", "Mouse"};

    @Override
    public String[] getArticulos() {
        System.out.println("Tipo de Servicio: Restful");
        return getArticulosRest();
    }

    private String[] getArticulosRest() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.escuelajs.co/api/v1/products"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Deserializar la respuesta JSON en una lista de objetos Producto
                ObjectMapper objectMapper = new ObjectMapper();
                List<Product> productos = objectMapper.readValue(response.body(), new TypeReference<List<Product>>() {});

                // Extraer los nombres de los productos
                List<String> titles = productos.stream()
                        .map(Product::getTitle)
                        .collect(Collectors.toList());

                //Pasar titles a un array de String
                String[] titlesArray = titles.toArray(new String[0]);

                return titlesArray;
            } else {
                System.out.println("Failed to fetch data. HTTP error code: " + response.statusCode());
                return null;
            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }



}