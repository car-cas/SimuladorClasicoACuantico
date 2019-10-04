import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;

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
    public void  programmingDrill322Test(){
        Simulador simulator = new Simulador();
        double[][] matrizDoubles = {{0,0,0,0},
                {0,0,0,2.3},
                {0,2.3,0,0},
                {2.3,0,0,0}};
        double[] estadoInicial = {6,2,5,3};
        double[] solucion = simulator.programmingDrill322(matrizDoubles, estadoInicial, 2);
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
    public void programmingDrill332Test(){
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
        Complejo[] solucion = simulator.programmingDrill332(2,matrizComplejos,estadoInicial);
        Complejo[] respuesta = new Complejo[3];
        respuesta[0]=new Complejo(-701,177);
        respuesta[1]=new Complejo(-1027,84);
        respuesta[2]=new Complejo(-484,100);
        Assert.assertArrayEquals(solucion,respuesta);
    }

}