import java.util.Arrays;
/**
 * Segundo laboratorio de CNYT: Simulador de lo clasico a lo cuantico.
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Simulador {
    private Operaciones operacion = new Operaciones();
    /**
     * Metodo programmingDrill311Y321, realiza la simulacion del programa 3.1.1 y 3.2.1 del libro.
     * Dada una matriz, un vector y unos determinados clicks determina el numero de
     * movimiento de canicas.
     * @param matriz double[][]
     * @param estadoInicial double[]
     * @param clicks int
     * @return double[]
     */
    public double[] programmingDrill311Y321(double[][]matriz,double[]estadoInicial,int clicks){
        double [] respuesta = new double[estadoInicial.length];
        while(clicks!=0) {
            for (int i = 0; i < estadoInicial.length; i++) {
                double suma = 0;
                for (int j = 0; j < estadoInicial.length; j++) {
                    suma += matriz[i][j] * estadoInicial[j];
                }
                respuesta[i] = suma;
            }
            System.arraycopy(respuesta, 0, estadoInicial, 0, estadoInicial.length);
            clicks-=1;
        }
        return respuesta;
    }

    /**
     * Metodo programmingDrill331, realiza la simulacion del programa 3.3.1 del libro.
     * Dada una matriz de complejos, un vector de complejos y unos determinados clicks
     * determina el numero de movimiento de canicas.
     * @param matriz Complejo[][]
     * @param estadoInicial Complejo[]
     * @param clicks int
     * @return Complejo[]
     */
    public Complejo[] programmingDrill331(Complejo[][]matriz,Complejo[]estadoInicial,int clicks){
        Complejo[] respuesta = new Complejo[estadoInicial.length];
        while (clicks!=0){
            for (int i = 0; i < estadoInicial.length ; i++) {
                Complejo valor = new Complejo(0,0);
                for (int j = 0; j < estadoInicial.length ; j++) {
                    valor = operacion.suma(valor,operacion.producto(matriz[i][j],estadoInicial[j]));
                }
                respuesta[i]=valor;
            }
            clicks-=1;
            estadoInicial = respuesta;
        }
        return respuesta;
    }
}
