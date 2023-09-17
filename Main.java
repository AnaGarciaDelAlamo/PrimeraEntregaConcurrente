/*public class Main {
    public static void main(String[] args) {
        Lanzador.main(args);
    }
}*/

//Otra forma
public class Main {
    public static void main(String[] args) {
        ProcesadorContabilidad procesador = new ProcesadorContabilidad();
        long resultadoGlobal = procesador.calcularResultadoGlobal();
    }
}