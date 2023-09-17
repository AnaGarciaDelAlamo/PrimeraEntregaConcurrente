

//Otra forma
public class Main {
    public static void main(String[] args) {
        ProcesadorContabilidad procesador = new ProcesadorContabilidad();
        long resultadoGlobal = procesador.calcularResultadoGlobal();
    }
}

//Otro codigo

/*import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] archivos = {"informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "recursos_humanos.txt"};

        // Crear un arreglo de hilos para procesar cada archivo
        Thread[] hilos = new Thread[archivos.length];

        for (int i = 0; i < archivos.length; i++) {
            String nombreArchivo = archivos[i];
            Lanzador lanzador = new Lanzador(nombreArchivo);
            hilos[i] = new Thread(lanzador);
        }

        // Iniciar todos los hilos para procesar los archivos
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

        // Calcular el resultado global
        long resultadoGlobal = 0;
        for (String archivo : archivos) {
            String resultadoArchivo = archivo + ".res";
            try {
                String contenido = UtilidadesFicheros.leerContenido(resultadoArchivo);
                long saldoArchivo = UtilidadesFicheros.obtenerSaldoDesdeLinea(contenido);
                resultadoGlobal += saldoArchivo;
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
    }
}*/
