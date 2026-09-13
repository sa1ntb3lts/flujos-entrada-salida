import java.io.*;
import java.nio.file.*;

public class GeneradorReporteIncidencias {

    public static void main(String[] args) {

        // 1. Validar argumentos
        if (args.length == 0) {
            System.out.println("ERROR! Debes proporcionar un argumento que contenga el path y el archivo de entrada.");
            return;
        }
        // 2. Crear Path del archivo de entrada
        Path path = Path.of(args[0]);
        // 3. Comprobar existencia
        System.out.println("El archivo existe?: " + Files.exists(path));
        if (!Files.exists(path)) {
            return;
        }
        // 4. Mostrar información del archivo
        System.out.println("Es archivo: " + Files.isRegularFile(path));
        System.out.println("Se puede leer: " + Files.isReadable(path));
        System.out.println("Tamaño: " + Files.size(path) + " bytes");
        System.out.println("Última modificación: " + Files.getLastModifiedTime(path));
        // 5. Crear directorio de salida
        Path directorioReportes = Files.createDirectories(Path.of("mesa-ayuda/salida/reportes"));
        // 6. Crear Paths para los archivos de salida
        Path pathReporte = Path.of("mesa-ayuda/salida/reportes", "reporte-incidencias.txt");
        Path pathAltas = Path.of("mesa-ayuda/salida/reportes", "incidencias-altas.txt");


        int total = 0;
        int altas = 0;
        int medias = 0;
        int bajas = 0;

        try (
            BufferedReader lector = Files.newBufferedReader(path);
            PrintWriter reporte = new PrintWriter(Files.newBufferedWriter(pathReporte));
            PrintWriter reporteAltas = new PrintWriter(Files.newBufferedWriter(pathAltas))
        ) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                // 8. Clasificar prioridad
                // 9. Escribir incidencias ALTA
            }

            // 10. Generar resumen

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
