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

        try {
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
                    // 7. Procesar cada incidencia
                    String[] datos = linea.split("\\|");
                    String id = datos[0];
                    String descripcion = datos[1];
                    String prioridad = datos[2];
                    // 8. Clasificar prioridad
                    if (prioridad.contains("ALTA")) {
                        altas ++;
                        // 9. Escribir incidencias ALTA
                        reporteAltas.println(linea);
                        // 9.1 Imprimir incidencias ALTAS para el reporte
                        reporte.println(id + " | " + descripcion);
                    } else if (prioridad.contains("MEDIA")) {
                        medias++;
                    } else {
                        bajas++;
                    }

                    total++;
                }
                // 10. Generar resumen
                reporte.println("REPORTE DE INCIDENCIAS\n" +
                    "======================\n" +
                    "\nArchivo procesado: " + path.getFileName() +
                    "\n\nTotal de incidencias: " + total +
                    "\n\nPrioridad alta: " + altas +
                    "\nPrioridad media: " + medias +
                    "\nPrioridad baja: " + bajas);

                System.out.println("\n\nINCIDENCIAS DE ALTA PRIORIDAD\n" + reporteAltas);


            }
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
