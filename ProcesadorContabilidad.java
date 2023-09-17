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