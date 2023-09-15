// que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Lanzador {
    public static void main(String[] args) {
        String[] archivos = { "informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "recursosHumanos.txt" };

        // Crear hilos para procesar cada archivo
        Thread[] threads = new Thread[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            threads[i] = new Thread(new ProcesadorContabilidad(archivos[i]));
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar a que termine el hilo");
                e.printStackTrace();
            }
        }

        // Sumar todas las sumas de departamentos
        long sumaGlobal = UtilidadesFicheros.obtenerSumaTransacciones(archivos);

        // Guardar resultado global
        try (PrintWriter pw = new PrintWriter(new FileWriter("ResultadoGlobal.txt"))) {
            pw.println(sumaGlobal);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ResultadoGlobal.txt");
            e.printStackTrace();
        }
    }
}