/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Abstract Factory
 * Implementación para el Service de Empleados tipo Restfull
 */
package af.familiarest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import servicios.IServiciosEmpleados;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ImplementacionRestEmpleados implements IServiciosEmpleados {
    //private static final String[] EMPLEADOS = new String[]{"Juan Guillermo", "David", "Luis Fernando"};

    @Override
    public String[] getEmpleados() {
        System.out.println("Tipo de Servicio: Restful");
        return getEmpleadosRest();
    }

    private String[] getEmpleadosRest() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.escuelajs.co/api/v1/users"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Deserializar la respuesta JSON en una lista de objetos User
                ObjectMapper objectMapper = new ObjectMapper();
                List<User> users = objectMapper.readValue(response.body(), new TypeReference<List<User>>() {});

                // Extraer los nombres de los usuarios
                List<String> names = users.stream()
                        .map(User::getName)
                        .collect(Collectors.toList());

                //Pasar name a un array de String
                String[] namesArray = names.toArray(new String[0]);

                return namesArray;
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