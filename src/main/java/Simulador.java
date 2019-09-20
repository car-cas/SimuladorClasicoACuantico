import java.util.Arrays;
/**
 * Segundo laboratorio de CNYT: Simulador de lo clasico a lo cuantico.
 *
 * @author Carlos Andres Castaneda Lozano
 */
public class Simulador {
    /**
     * Metodo programmingDrill311, realiza la simulacion del programa 3.1.1 y 3.2.1 del libro.
     * Dada una matriz, un vector y unos determinados clicks determina el numero de
     * movimiento de canicas.
     * @param matriz [][]
     * @param estadoInicial []
     * @param clicks int
     * @return
     */
    public double[] programmingDrill311Y321 (double[][]matriz,double[]estadoInicial, int clicks){
        double [] respuesta = new double[estadoInicial.length];
        for (int i = 0; i < clicks ; i++) {
            respuesta = multiplicacionMatrizVector(matriz,estadoInicial);
        }
        return respuesta;
    }
    /**
     * Metodo multplicacionMatrizVector, calcula la multiplicacion
     * de una matriz por un vector.
     * @param matriz double[][]
     * @param estadoInicial double []
     * @return
     */
    public double[] multiplicacionMatrizVector(double[][]matriz,double[]estadoInicial){
        double [] respuesta = new double[estadoInicial.length];
        for (int i = 0; i < estadoInicial.length ; i++) {
            for (int j =0 ; j< estadoInicial.length;j++){
                double suma = 0;
                for (int k = 0; k < estadoInicial.length ; k++) {
                    suma += matriz[i][k] * estadoInicial[k];
                }
                respuesta[i] = suma;
            }
        }
        return respuesta;
    }
    public static void main(String[] args){
        Simulador marbleSimulator = new Simulador();
        double[][] matriz = new double[4][4];
        matriz[0][0]=0;
        matriz[0][1]=0;
        matriz[0][2]=0;
        matriz[0][3]=0;
        matriz[1][0]=0;
        matriz[1][1]=0;
        matriz[1][2]=0;
        matriz[1][3]=1;
        matriz[2][0]=0;
        matriz[2][1]=1;
        matriz[2][2]=0;
        matriz[2][3]=0;
        matriz[3][0]=1;
        matriz[3][1]=0;
        matriz[3][2]=0;
        matriz[3][3]=0;
        double[][] matriz2 = new double [4][4];
        matriz2[0][0]=0;
        matriz2[0][1]=0;
        matriz2[0][2]=0;
        matriz2[0][3]=0;
        matriz2[1][0]=0;
        matriz2[1][1]=0;
        matriz2[1][2]=0;
        matriz2[1][3]=2.3;
        matriz2[2][0]=0;
        matriz2[2][1]=2.3;
        matriz2[2][2]=0;
        matriz2[2][3]=0;
        matriz2[3][0]=2.3;
        matriz2[3][1]=0;
        matriz2[3][2]=0;
        matriz2[3][3]=0;
        double[] estadoinicial = new double[4];
        estadoinicial[0]=6;
        estadoinicial[1]=2;
        estadoinicial[2]=5;
        estadoinicial[3]=3;
        int clicks = 1;
        System.out.println("Programming Drill 3.1.1 : "+Arrays.toString(marbleSimulator.programmingDrill311Y321(matriz, estadoinicial,clicks)));
        System.out.println("Programming Drill 3.2.1 : "+Arrays.toString(marbleSimulator.programmingDrill311Y321(matriz2, estadoinicial,clicks)));

    }
}
