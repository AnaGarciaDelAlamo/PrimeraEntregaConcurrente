//con métodos útiles para el procesamiento de archivos, incluyendo uno para obtener la suma de las transacciones de un conjunto de archivos.


/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class UtilidadesFicheros {
    public static String leerContenido(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }

    public static void escribirResultadoEnArchivo(String nombreArchivo, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
        }
    }

    public static long obtenerSaldoDesdeLinea(String linea) {
        String[] partes = linea.split(":");
        if (partes.length == 2) {
            try {
                return Long.parseLong(partes[1].trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0; // Valor predeterminado en caso de error
    }
}*/

//Otra forma
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UtilidadesFicheros {
    public static long obtenerSumaTransacciones(String[] archivos) {
        long sumaTotal = 0;
        for (String archivo : archivos) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    long transaccion = Long.parseLong(linea);
                    sumaTotal += transaccion;
                }
            } catch (IOException | NumberFormatException e) {
                // Manejar excepciones de lectura y formato aquí
                e.printStackTrace();
            }
        }
        return sumaTotal;
    }

    public static void procesarArchivosConcurrentemente(String[] archivos) {
        ExecutorService executorService = Executors.newFixedThreadPool(archivos.length);

        // Procesar cada archivo en un hilo separado
        for (String archivo : archivos) {
            executorService.submit(() -> procesarArchivo(archivo));
        }

        executorService.shutdown();
    }

    private static void procesarArchivo(String archivo) {
        long sumaTotal = obtenerSumaTransacciones(new String[]{archivo});

        // Guardar el resultado en un archivo de resultados
        String resultadoArchivo = archivo + ".res";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoArchivo))) {
            bw.write(String.valueOf(sumaTotal));
        } catch (IOException e) {
            // Manejar excepciones de escritura aquí
            e.printStackTrace();
        }
    }
}





