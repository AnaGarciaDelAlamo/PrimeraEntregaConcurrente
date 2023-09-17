//con métodos útiles para el procesamiento de archivos, incluyendo uno para obtener la suma de las transacciones de un conjunto de archivos.

/*import java.io.*;

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
                System.out.println("Error en el archivo " + archivo);
                e.printStackTrace();
            }
        }
        return sumaTotal;
    }

    /*public static long sumarTransaccionesEnArchivo(String archivo) {
        long suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                long transaccion = Long.parseLong(linea);
                suma += transaccion;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en el archivo " + archivo);
            e.printStackTrace();
        }
        return suma;
    }

    public static void escribirResultadosEnArchivo(String archivo, long suma) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo + ".res"))) {
            bw.write(Long.toString(suma));
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + archivo);
            e.printStackTrace();
        }
    } 
}*/

//Otra forma

import java.io.BufferedReader;
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
}

