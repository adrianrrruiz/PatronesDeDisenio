/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Builder
 * Tipo de Clase: Main()
 */
package patronbuilder;

import transferencia.datos.Estudiante;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronBuilderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estudiante est = new Estudiante.EstudianteBuilder()
                .setNombre("Gilberto Santarrosa")
                .setGenero("Masculino")
                .setEdad(49)
                .setDireccion("Santurce "
                        + "San Juan", "Puerto Rico", "Puerto Rico", "03400")
                .addContactos("Fania All Star", "555777888", "123", "Estudios",
                        "New York", "Estados Unidos"
                        , "USA", "10023")
                .addContactos("Ruben Blades", "202020", null, "Celular")
                .addTelefonos("88889999", null, "Celular")
                .addTelefonos("1010103030", null, "Estudios")
                .addProgramas("Ingenieria de Sistemas", "123456","138", "8")
                .addProgramas("Ciencia de datos", "654321","148", "2")
                .build();
        System.out.println(est);
    }

}