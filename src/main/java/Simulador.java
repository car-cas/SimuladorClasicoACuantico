import java.util.ArrayList;
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
    private static VectorComplejo accionMatrizSobreVector(MatrizCompleja matriz, VectorComplejo vector){
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

    /**
     * Metodo probabilidad, calcular la probabilidad de encontrar una
     * particual en una posicion en particular.
     * @param estado VectorComplejo
     * @param posicion int
     * @return double
     */
    public static double probabilidad(VectorComplejo estado, int posicion) {
        Double n = 0.0;
        for(int i = 0; i < estado.getVector().length;i++) {
            n += Math.pow(estado.getVector()[i].modulo(), 2);
        }
        Double norm = Math.sqrt(n);
        Double prob = Math.pow(estado.getVector()[posicion].modulo(),2) / Math.pow(norm, 2);
        return prob;
    }

    /**
     * Metodo transicion, Calcula la probabilidad de transicion de un estado a otro.
     * @param estadoInicial VectorComplejo
     * @param estadoFinal VectorComplejo
     * @return Complejo
     */
    public static Complejo transicion(VectorComplejo estadoInicial, VectorComplejo estadoFinal){
        VectorComplejo bra = estadoFinal.conjugado();
        Complejo ans = productoInterno(estadoFinal, estadoInicial);
        return ans;
    }

    /**
     * Metodo productoInterno, calcula el producto interno de 2 vectores dados.
     * @param v1 VectorComplejo
     * @param v2 VectorComplejo
     * @return Complejo
     */
    public static Complejo productoInterno(VectorComplejo v1, VectorComplejo v2){
        Complejo r = new Complejo(0,0);
        for (int i = 0; i < v1.getVector().length;i++) {
            r = Operaciones.suma(r, Operaciones.producto(v1.conjugado().getVector()[i], v2.getVector()[i]));
        }
        return r;
    }

    /**
     * Metodo valorMedia, Calcula la media entre una matriz un vector de numeros complejos.
     * @param ket VectorComplejo
     * @param observable MatrizCompleja
     * @return Complejo
     */
    public static Complejo valorMedia(VectorComplejo ket, MatrizCompleja observable){
        VectorComplejo omegaKet = accionMatrizSobreVector(observable, ket);
        Complejo ans = productoInterno(omegaKet, ket);
        return ans;
    }

    /**
     * Metodo varianza, calcula la varianza entre un vector y una matriz de numeros complejos.
     * @param ket VectorComplejo
     * @param observable MatriComplejo
     * @return Complejo
     * @throws Exception
     */
    public static Complejo varianza(VectorComplejo ket, MatrizCompleja observable) throws Exception {
        Complejo mean = valorMedia(ket, observable);
        MatrizCompleja m = new MatrizCompleja(new Complejo[2][2]);
        m.getMatriz()[0][0] = mean;
        m.getMatriz()[0][1] = new Complejo(0, 0);
        m.getMatriz()[1][0] = new Complejo(0, 0);
        m.getMatriz()[1][1] = mean;
        MatrizCompleja subtraction = adicionDeMatrices(observable, m.inversa());
        MatrizCompleja temp = matrizMultiplicacion(subtraction, subtraction);
        VectorComplejo act = accionMatrizSobreVector(temp, ket);
        Complejo ans = productoInterno(ket, act);
        return ans;

    }

    /**
     * Metodo matrizMultiplicacion, multiplica dos matrices de complejos
     * @param m1 MatrizCompleja
     * @param m2 MatrizCompleja
     * @return MatrizCompleja
     */
    private static MatrizCompleja matrizMultiplicacion(MatrizCompleja m1, MatrizCompleja m2) {
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
     * Metodo adicionDeMatrices, calcula la suma de dos matrices de numeros complejos
     * @param m1 MatrizCompleja
     * @param m2 MatrizCompleja
     * @return MatrizCompleja
     */
    public static MatrizCompleja adicionDeMatrices(MatrizCompleja m1, MatrizCompleja m2) {
        MatrizCompleja r = crearMatriz(m1.getMatriz().length, m1.getMatriz()[0].length);
        for (int i = 0; i < m1.getMatriz().length; i++) {
            for (int j = 0 ; j < m1.getMatriz()[0].length; j++) {
                r.getMatriz()[i][j] = Operaciones.suma(m1.getMatriz()[i][j], m2.getMatriz()[i][j]);
            }
        }
        return r;
    }

    /**
     * Metodo dinamica, calcula el estado final a partir de un estado inicial.
     * @param m
     * @param estadoInicial
     * @return VectorComplejo
     */
    public static VectorComplejo dinamica(MatrizCompleja[] m, VectorComplejo estadoInicial){
        VectorComplejo ans = accionMatrizSobreVector(m[0], estadoInicial);
        for (int i = 1; i < m.length; i++) {
            ans = accionMatrizSobreVector(m[1], ans);
        }
        return ans;
    }

}
