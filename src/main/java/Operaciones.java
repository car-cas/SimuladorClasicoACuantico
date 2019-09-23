/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 * Clase Operaciones, se encuentra toda la libreria de operaciones
 * para calcular numeros complejos
 *
 */
public class Operaciones {

    /**
     *
     * Metodo suma, calcula la suma de dos numeros complejos
     *
     * @param x Complejo
     * @param y Complejo
     * @return Complejo
     */
    public  Complejo suma(Complejo x,Complejo y){
        double respuesta = x.getNumeroA() + y.getNumeroA();
        double respuestaDos = x.getNumeroB() + y.getNumeroB();
        return new Complejo(respuesta,respuestaDos);
    }
    /**
     *
     * Metodo Producto, calcula el producto de dos numeros complejos
     *
     * @param x Complejo
     * @param y Complejo
     * @return Complejo
     */
    public Complejo producto(Complejo x,Complejo y){
        double respuesta = (x.getNumeroA() * y.getNumeroA())-(x.getNumeroB() * y.getNumeroB());
        double respuestaDos = (x.getNumeroA() * y.getNumeroB())+(x.getNumeroB()* y.getNumeroA());
        return new Complejo(respuesta,respuestaDos);
    }

}
