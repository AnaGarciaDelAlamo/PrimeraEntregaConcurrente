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

