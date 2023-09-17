//que procesará un archivo, sumará las transacciones y almacenará el resultado en el archivo correspondiente.
/*import java.io.*;

public class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

     @Override
    public void run() {
        long sumaDepartamento = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                long transaccion = Long.parseLong(linea);
                sumaDepartamento += transaccion;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error en el archivo " + archivo);
            e.printStackTrace();
        }

        // Guardar resultado en el archivo correspondiente
        String resultadoArchivo = archivo + ".res";
        try (PrintWriter pw = new PrintWriter(new FileWriter(resultadoArchivo))) {
            pw.println(sumaDepartamento);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + resultadoArchivo);
            e.printStackTrace();
        }
    }

    /*@Override
    public void run() {
        long sumaDepartamento = UtilidadesFicheros.sumarTransaccionesEnArchivo(archivo);
        UtilidadesFicheros.escribirResultadosEnArchivo(archivo, sumaDepartamento);
    }
}*/

//Otra forma

import java.io.IOException;

class ProcesadorContabilidad {
 public long calcularResultadoGlobal() {
    String[] departamentos = {"informatica", "gerencia", "contabilidad", "comercio", "recursos_humanos"};
    int numHilos = 5; // Número de hilos

    for (String departamento : departamentos) {
        Transaccion transaccion = new Transaccion();

        // Crear un arreglo de hilos
        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < numHilos; i++) {
            final long cantidad = i * 100; // Cantidad a sumar en cada hilo
            Lanzador lanzador = new Lanzador(transaccion, cantidad);
            hilos[i] = new Thread(lanzador);
        }

        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        try {
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Guardar el resultado en un archivo
        String resultadoArchivo = departamento + ".txt.res";
        try {
            String resultadoDepartamento = "Saldo final para el departamento " + departamento + ": " + transaccion.getSaldo();
            UtilidadesFicheros.escribirResultadoEnArchivo(resultadoArchivo, resultadoDepartamento);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calcular el resultado global
    long resultadoGlobal = 0;
    for (String departamento : departamentos) {
        String resultadoArchivo = departamento + ".txt.res";
        try {
            String contenido = UtilidadesFicheros.leerContenido(resultadoArchivo);
            long saldoDepartamento = UtilidadesFicheros.obtenerSaldoDesdeLinea(contenido);
            resultadoGlobal += saldoDepartamento;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guardar el resultado global en un archivo
    try {
        String resultadoGlobalTexto = "Saldo total de la empresa: " + resultadoGlobal;
        UtilidadesFicheros.escribirResultadoEnArchivo("Resultado_global.txt", resultadoGlobalTexto);
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Procesamiento completado. Saldo total de la empresa: " + resultadoGlobal);
    return resultadoGlobal;
}
}