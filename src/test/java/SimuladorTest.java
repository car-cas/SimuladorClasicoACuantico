import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 * Unit test
 *
 */
public class SimuladorTest{

    @Test
    public void  programmingDrill311Test(){
        Simulador simulator = new Simulador();
        double[][] matrizBool = {{0,0,0,0},
                                 {0,0,0,1},
                                 {0,1,0,0},
                                 {1,0,0,0}};
        double[] estadoInicial = {6,2,5,3};
        double[] solucion = simulator.programmingDrill311Y321(matrizBool, estadoInicial, 2);
        double[] respuesta = {0,6,3,0};
        for(int i=0;i<respuesta.length;i++){
            assertTrue(respuesta[i]==solucion[i]);
        }
    }

    @Test
    public void  programmingDrill321Test(){
        Simulador simulator = new Simulador();
        double[][] matrizDoubles = {{0,0,0,0},
                                    {0,0,0,2.3},
                                    {0,2.3,0,0},
                                    {2.3,0,0,0}};
        double[] estadoInicial = {6,2,5,3};
        double[] solucion = simulator.programmingDrill311Y321(matrizDoubles, estadoInicial, 2);
        double[] respuesta = {0,31.739999999999995,15.869999999999997,0};
        for(int i=0;i<respuesta.length;i++){
            assertTrue(respuesta[i]==solucion[i]);
        }
    }

    @Test
    public void programmingDrill331Test(){
        Simulador simulator = new Simulador();
        Complejo[][] matrizComplejos = new Complejo[3][3];
        matrizComplejos[0][0] = new Complejo(2,4);
        matrizComplejos[0][1] = new Complejo(1,3);
        matrizComplejos[0][2] = new Complejo(5,0);
        matrizComplejos[1][0] = new Complejo(3,2);
        matrizComplejos[1][1] = new Complejo(1,2);
        matrizComplejos[1][2] = new Complejo(7,12);
        matrizComplejos[2][0] = new Complejo(2,2);
        matrizComplejos[2][1] = new Complejo(1,1);
        matrizComplejos[2][2] = new Complejo(2,4);
        Complejo[] estadoInicial = new Complejo[3];
        estadoInicial[0]=new Complejo(1,3);
        estadoInicial[1]=new Complejo(2,5);
        estadoInicial[2]=new Complejo(3,6);
        Complejo[] solucion = simulator.programmingDrill331(matrizComplejos,estadoInicial,2);
        Complejo[] respuesta = new Complejo[3];
        respuesta[0]=new Complejo(-701,177);
        respuesta[1]=new Complejo(-1027,84);
        respuesta[2]=new Complejo(-484,100);
        Assert.assertArrayEquals(solucion,respuesta);
    }

    @Test
    public void programmingDrill322Y332Test() throws Exception {
        int slits = 2;
        int targets = 5;
        Map<String, Complejo> p = new HashMap<>();
        p.put("0 1", new Complejo(1.0/Math.sqrt(2), 0));
        p.put("0 2", new Complejo(1.0/Math.sqrt(2), 0));
        p.put("1 3", new Complejo(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
        p.put("1 4", new Complejo(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("1 5", new Complejo(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("2 5", new Complejo(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
        p.put("2 6", new Complejo(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("2 7", new Complejo(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        MatrizCompleja expectedMatrix = new MatrizCompleja(new Complejo[8][8]);
        expectedMatrix.getMatriz()[0][0] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][1] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][2] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[0][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][0] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][1] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][2] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[1][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][0] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][1] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][2] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[2][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[3][0] = new Complejo(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
        expectedMatrix.getMatriz()[3][1] = new Complejo(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[3][2] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[3][3] = new Complejo(1, 0);
        expectedMatrix.getMatriz()[3][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[3][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[3][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[3][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[4][0] = new Complejo(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatriz()[4][1] = new Complejo(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[4][2] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[4][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[4][4] = new Complejo(1, 0);
        expectedMatrix.getMatriz()[4][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[4][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[4][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[5][0] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[5][1] = new Complejo(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[5][2] = new Complejo(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[5][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[5][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[5][5] = new Complejo(1, 0);
        expectedMatrix.getMatriz()[5][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[5][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[6][0] = new Complejo(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatriz()[6][1] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[6][2] = new Complejo(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[6][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[6][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[6][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[6][6] = new Complejo(1, 0);
        expectedMatrix.getMatriz()[6][7] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][0] = new Complejo(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatriz()[7][1] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][2] = new Complejo(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatriz()[7][3] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][4] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][5] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][6] = new Complejo(0, 0);
        expectedMatrix.getMatriz()[7][7] = new Complejo(1, 0);
        MatrizCompleja actualMatrix = (MatrizCompleja) Simulador.programmingDrill322Y332(slits, targets, p).get(0);
        VectorComplejo expectedVector = new VectorComplejo(new Complejo[8]);
        expectedVector.getVector()[0] = new Complejo(0,0);
        expectedVector.getVector()[1] = new Complejo(0,0);
        expectedVector.getVector()[2] = new Complejo(0,0);
        expectedVector.getVector()[3] = new Complejo(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
        expectedVector.getVector()[4] = new Complejo(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedVector.getVector()[5] = new Complejo(0,0);
        expectedVector.getVector()[6] = new Complejo(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedVector.getVector()[7] = new Complejo(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        VectorComplejo actualVector = (VectorComplejo) Simulador.programmingDrill322Y332(slits, targets, p).get(1);
        Assert.assertEquals(expectedMatrix, actualMatrix);
    }

    @Test
    public void probabilidadTest() {
        VectorComplejo state = new VectorComplejo(new Complejo[4]);
        state.getVector()[0] = new Complejo(-3,-1);
        state.getVector()[1] = new Complejo(0,-2);
        state.getVector()[2] = new Complejo(0,1);
        state.getVector()[3] = new Complejo(2,0);
        int position = 2;
        Double expected = 0.052624;
        Double actual = Simulador.probabilidad(state, position);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void transicionTest()throws Exception{
        VectorComplejo startState = new VectorComplejo(new Complejo[2]);
        startState.getVector()[0] = new Complejo(Math.sqrt(2) / 2, 0);
        startState.getVector()[1] = new Complejo(0, Math.sqrt(2) / 2);
        VectorComplejo endState = new VectorComplejo(new Complejo[2]);
        endState.getVector()[0] = new Complejo(0,Math.sqrt(2) / 2);
        endState.getVector()[1] = new Complejo(-Math.sqrt(2) / 2, 0);
        Complejo expected = new Complejo(0, -1.0000000000000002);
        Complejo actual = Simulador.transicion(startState, endState);
        assertEquals(expected, actual);
    }

    @Test
    public void valorMediaTest() throws Exception {
        VectorComplejo ket = new VectorComplejo(new Complejo[2]);
        ket.getVector()[0] = new Complejo(Math.sqrt(2) / 2, 0);
        ket.getVector()[1] = new Complejo(0, Math.sqrt(2) / 2);
        MatrizCompleja observable = new MatrizCompleja(new Complejo[2][2]);
        observable.getMatriz()[0][0] = new Complejo(1, 0);
        observable.getMatriz()[0][1] = new Complejo(0, -1);
        observable.getMatriz()[1][0] = new Complejo(0, 1);
        observable.getMatriz()[1][1] = new Complejo(2, 0);
        Complejo expected = new Complejo(2.5000000000000004, 0);
        Complejo actual = Simulador.valorMedia(ket, observable);
        assertEquals(expected, actual);
    }

    @Test
    public void varianzaTest() throws Exception {
        VectorComplejo ket = new VectorComplejo(new Complejo[2]);
        ket.getVector()[0] = new Complejo(Math.sqrt(2) / 2, 0);
        ket.getVector()[1] = new Complejo(0, Math.sqrt(2) / 2);
        MatrizCompleja observable = new MatrizCompleja(new Complejo[2][2]);
        observable.getMatriz()[0][0] = new Complejo(1, 0);
        observable.getMatriz()[0][1] = new Complejo(0, -1);
        observable.getMatriz()[1][0] = new Complejo(0, 1);
        observable.getMatriz()[1][1] = new Complejo(2, 0);
        Complejo expected = new Complejo(0.25, 0);
        Complejo actual = Simulador.varianza(ket, observable);
        assertEquals(expected, actual);
    }
    /**
    @Test
    public void dynamicsTest() throws Exception {
        VectorComplejo initialState = new VectorComplejo(new Complejo[2]);
        initialState.getVector()[0] = new Complejo(1, 0);
        initialState.getVector()[1] = new Complejo(0, 0);
        MatrizCompleja[] matrixArray = new MatrizCompleja[4];
        MatrizCompleja m1 = new MatrizCompleja(new Complejo[2][2]);
        m1.getMatriz()[0][0] = new Complejo(0, 0);
        m1.getMatriz()[0][1] = new Complejo(1 / Math.sqrt(2), 0);
        m1.getMatriz()[1][0] = new Complejo(1 / Math.sqrt(2), 0);
        m1.getMatriz()[1][1] = new Complejo(0, 0);
        MatrizCompleja m2 = new MatrizCompleja(new Complejo[2][2]);
        m2.getMatriz()[0][0] = new Complejo(0, 1 / Math.sqrt(2));
        m2.getMatriz()[0][1] = new Complejo(0, 0);
        m2.getMatriz()[1][0] = new Complejo(0, 0);
        m2.getMatriz()[1][1] = new Complejo(1 / Math.sqrt(2), 0);
        MatrizCompleja m3 = new MatrizCompleja(new Complejo[2][2]);
        m3.getMatriz()[0][0] = new Complejo(1 / Math.sqrt(2), 0);
        m3.getMatriz()[0][1] = new Complejo(0, 0);
        m3.getMatriz()[1][0] = new Complejo(0, 0);
        m3.getMatriz()[1][1] = new Complejo(0, 1 / Math.sqrt(2));
        MatrizCompleja m4 = new MatrizCompleja(new Complejo[2][2]);
        m4.getMatriz()[0][0] = new Complejo(0, 0);
        m4.getMatriz()[0][1] = new Complejo(1 / Math.sqrt(2), 0);
        m4.getMatriz()[1][0] = new Complejo(-1 / Math.sqrt(2), 0);
        m4.getMatriz()[1][1] = new Complejo(0, 0);
        matrixArray[0] = m1;
        matrixArray[1] = m2;
        matrixArray[2] = m3;
        matrixArray[3] = m4;
        VectorComplejo expected = new VectorComplejo(new Complejo[4]);
        expected.getVector()[0] = new Complejo(0, 0);
        expected.getVector()[1] = new Complejo(0.24999, 0);
        VectorComplejo actual = Simulador.dinamica(matrixArray, initialState);
        assertEquals(expected, actual);
    }
    **/
}