Realizado por Carlos Andrés Castañeda Lozano

# Programa simulación de lo clásico a lo cuántico

En este programa resolvere los retos de programación del libro **Quantum-Computing for Computer Scientists** los cuales corresponden al **Capitulo 3**.

## Programming drill 3.1.1

Este programa replica el sistema de **Las canicas**, el cual consiste en dada cierta cantidad de canicas en un orden ya establecido, reorganizarlas mediante una matriz booleana y un vector con el numero de canicas en cada posición, ademas tendremos un numero de **clicks** el cual nos determinará el numero de movimientos del sistema.

* Para que el usuario pueda disponer de este programa, tiene que ingresar una **matriz booleana** , un **vector con la cantidad de canicas** y el numero de **clicks** que el usuario desea.
 
## Programming drill 3.2.1

Este programa al igual que el anterior replica el sistema de **Las canicas**, pero a diferencia del anterior, cambia la matriz booleana por una **matriz de fraccionarios**.

* Para que el usuario pueda disponer de este programa, tiene que ingresar una **matriz de fraccionarios** , un **vector con la cantidad de canicas** y el numero de **clicks** que el usuario desea.

## Programming drill 3.2.2

## Programming drill 3.3.1

Este programa al igual que el programa **3.1.1** y **3.2.1** replica el siste de **Las canicas**, pero a diferencia de los dos anteriores, se cambia la matriz por una **matriz y vector complejo**.

* Para que el usuario pueda disponer de este programa, tiene que ingresar una **matriz complaja** , un **vector complejo** y el numero de **clicks** que el usuario desea.

## Programming drill 3.3.2

# Pruebas unitarias

* Se crearon 5 pruebas unitarias, una por cada programa realizado. Estas pruebas se encuentran en **SimuladorTest**.
* **Ejemplo**:
```
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
```
* Para cada una de las pruebas se implementó JUnit y Maven.
* Se creó un metodo "**equals**" y **hashCode** la cual verifica si los resultados de las pruebas corresponden al resultado esperado.


## Ejecución de las pruebas

**Compiling**
```
$ mvn clean compile
```
**Packing**
```
$ mvn package
```
**Running the tests**
```
$ mvn test
```
## Captura
![](src/site/resources/captura.png)

# License
This project is under the Apache license - see [LICENSE](LICENSE.txt) for more details.
