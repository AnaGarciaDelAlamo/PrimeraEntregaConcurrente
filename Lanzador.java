 //que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.


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



