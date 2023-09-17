 //que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.
/*import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Lanzador {
    public static void main(String[] args) {
        String[] archivos = { "informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "recursosHumanos.txt" };
        //String[] archivos = args;
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
        //UtilidadesFicheros.escribirResultadosEnArchivo("ResultadoGlobal.txt", sumaGlobal);

        // Guardar resultado global
        try (PrintWriter pw = new PrintWriter(new FileWriter("ResultadoGlobal.txt"))) {
            pw.println(sumaGlobal);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ResultadoGlobal.txt");
            e.printStackTrace();
        }

        
    }
}*/

//Otra forma
class Lanzador implements Runnable {
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
}