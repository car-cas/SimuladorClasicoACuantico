import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Segundo laboratorio de CNYT: Simulador de lo clasico a lo cuantico.
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Simulador {
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
                    valor = Operaciones.suma(valor,Operaciones.producto(matriz[i][j],estadoInicial[j]));
                }
                respuesta[i]=valor;
            }
            System.arraycopy(respuesta, 0, estadoInicial, 0, estadoInicial.length);
            clicks-=1;

        }
        return respuesta;
    }
    /**
     * Metodo programmingDrill322Y332, replica el sistema de La doble rendija, el cual
     * consiste en calcular la matriz de probabilidades del experimento segun la cantidad
     * de rendijas y el numero de objetivos igresados por el usuario.
     * @param slits int
     * @param targets int
     * @param p Map
     * @return ArrayList<Object>
     */
    public static ArrayList<Object> programmingDrill322Y332(int slits, int targets, Map p){
        MatrizCompleja matriz = crearMatriz(slits+targets+1, slits+targets+1);
        for(int i = 0; i < slits+targets+1; i++) {
            for(int j = 0; j < slits+targets+1; j++) {
                if(p.containsKey(Integer.toString(i) + " " + Integer.toString(j))) {
                    matriz.getMatriz()[j][i] = (Complejo) p.get(Integer.toString(i) + " " + Integer.toString(j));
                } else {
                    matriz.getMatriz()[j][i] = new Complejo(0,0);
                }
            }
        }
        for (int i = 0; i < slits+1; i++) {
            matriz.getMatriz()[i][i] = new Complejo(0,0);
        }
        for (int i = slits + 1; i < slits+targets+1;i++) {
            matriz.getMatriz()[i][i] = new Complejo(1,0);
        }
        VectorComplejo vector = new VectorComplejo(new Complejo[slits+targets+1]);
        vector.getVector()[0] = new Complejo(1, 0);
        for (int i = 1; i < vector.getVector().length;i++) {
            vector.getVector()[i] = new Complejo(0,0);
        }
        ArrayList<Object> r = new ArrayList<Object>();
        r.add(mutiplicacionMatrices(matriz,matriz));
        r.add(accionMatrizSobreVector(mutiplicacionMatrices(matriz,matriz), vector));
        return r;
    }

    /**
     * Metodo accionMatrizSobreVector, calcula la accion de una matriz sobre
     * un vector
     * @param matriz MatrizCompleja
     * @param vector VectorComplejo
     * @return Complejo[]
     */
    private static Object accionMatrizSobreVector(MatrizCompleja matriz, VectorComplejo vector){
        VectorComplejo r = new VectorComplejo(new Complejo[vector.getVector().length]);
        Complejo s = new Complejo(0,0);
        for (int i = 0; i < vector.getVector().length; i++) {
            for (int j = 0; j < matriz.getMatriz()[0].length; j++) {
                s = Operaciones.suma(s, Operaciones.producto(matriz.getMatriz()[i][j], vector.getVector()[j]));
            }
            r.getVector()[i] = s;
            s = new Complejo(0,0);
        }
        return r;
    }

    /**
     *  Metodo multiplicacionMatrices, multiplica dos matrices de complejos
     * @param m1 MatrizCompleja
     * @param m2 MatrizCompleja
     * @return MatrizCompleja
     */
    private static MatrizCompleja mutiplicacionMatrices(MatrizCompleja m1, MatrizCompleja m2){
        MatrizCompleja r = crearMatriz(m1.getMatriz().length, m1.getMatriz()[0].length);
        Complejo s = new Complejo(0,0);
        for (int m = 0; m < m1.getMatriz().length; m++) {
            for (int n = 0; n < m1.getMatriz()[0].length; n++) {
                for (int i = 0; i < m1.getMatriz().length; i++) {
                    s = Operaciones.suma(s, Operaciones.producto(m1.getMatriz()[m][i], m2.getMatriz()[i][n]));
                }
                r.getMatriz()[m][n] = s;
                s = new Complejo(0,0);
            }
        }
        return r;
    }

    /**
     * Metodo CrearMatriz, crea una matriz de numeros complejos
     * @param i int
     * @param j int
     * @return MatrizCompleja
     */
    private static MatrizCompleja crearMatriz(int i, int j) {
        MatrizCompleja r =null;
        try {
            r = new MatrizCompleja(new Complejo[i][j]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
