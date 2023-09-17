 //que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.

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

//Otro codigo
/*class Lanzador implements Runnable {
    private String nombreArchivo;
    private long cantidad;

    public Lanzador(String nombreArchivo, long cantidad) {
        this.nombreArchivo = nombreArchivo;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        ProcesadorContabilidad procesador = new ProcesadorContabilidad();
        long resultado = procesador.calcularResultadoGlobal(nombreArchivo);
        System.out.println("Hilo " + Thread.currentThread().getId() + " procesó el archivo " + nombreArchivo + " con resultado " + resultado);
        // Agregar el resultado a una variable compartida o realizar cualquier otra operación necesaria
    }
}*/



