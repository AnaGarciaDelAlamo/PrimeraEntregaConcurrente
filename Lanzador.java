 //que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.


/*class Lanzador implements Runnable {
    private Transaccion transaccion;
    private long cantidad;

    public Lanzador(Transaccion transaccion, long cantidad) {
        this.transaccion = transaccion;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        transaccion.realizarTransaccion(cantidad);
        System.out.println("Hilo " + Thread.currentThread().getId() + " suma " + cantidad);
    }
}*/

//otra forma
import java.io.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    public static void main(String[] args) {
        String[] archivos = { "informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "recursos_humanos.txt" };

        // Crear transacciones aleatorias y escribirlas en los archivos de los departamentos
        for (String archivo : archivos) {
            generarTransacciones(archivo, 100); // Cambia 100 al número deseado de transacciones
        }

        // Crea un ExecutorService con un número fijo de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(archivos.length);

        // Ejecuta un ProcesadorContabilidad para cada archivo
        for (String archivo : archivos) {
            executorService.submit(new ProcesadorContabilidad(archivo));
        }

        // Apaga el ExecutorService una vez que todos los hilos terminen
        executorService.shutdown();
        try {
            // Espera hasta que todos los hilos hayan terminado
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                // Si no terminan en 1 hora, se maneja desde aquí
                System.err.println("No se han completado todos los hilos en 1 hora.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Suma todas las sumas de departamentos
        long sumaGlobal = UtilidadesFicheros.obtenerSumaTransacciones(archivos);

        // Guarda el resultado global
        try (PrintWriter pw = new PrintWriter(new FileWriter("Resultado_global.txt"))) {
            pw.println(sumaGlobal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generarTransacciones(String archivo, int numTransacciones) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            Random random = new Random();
            for (int i = 0; i < numTransacciones; i++) {
                long transaccion = random.nextInt(1000); 
                pw.println(transaccion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



