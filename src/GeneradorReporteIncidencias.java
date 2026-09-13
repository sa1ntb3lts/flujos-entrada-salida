import java.io.*;
import java.nio.file.*;

public class GeneradorReporteIncidencias {

    public static void main(String[] args) {

        // 1. Validar argumentos

        // 2. Crear Path del archivo de entrada
        Path path = Path.of("mesa-ayuda/entrada", "incidencias.txt");
        // 3. Comprobar existencia
        System.out.println("El archivo existe?: " + Files.exists(path));
        // 4. Mostrar información del archivo
        System.out.println("Es archivo: " + Files.isRegularFile(path));
        System.out.println("Se puede leer: " + Files.isReadable(path));
        // 5. Crear directorio de salida
        Path directorio = Files.createDirectories(Path.of("mesa-ayuda/salida/reportes"));
        // 6. Crear Paths para los archivos de salida



        int total = 0;
        int altas = 0;
        int medias = 0;
        int bajas = 0;

        try (
            BufferedReader lector = Files.newBufferedReader(/* completar */);
            PrintWriter reporte = new PrintWriter(Files.newBufferedWriter(/* completar */));
            PrintWriter reporteAltas = new PrintWriter(Files.newBufferedWriter(/* completar */))
        ) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                // 7. Procesar cada incidencia
                // 8. Clasificar prioridad
                // 9. Escribir incidencias ALTA
            }

            // 10. Generar resumen

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
