/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 * Clase OperacionesConMatrices, se encuentra toda la libreria de operaciones 
 * para calcular Matrices de numeros complejos
 *
 */
public class MatrizCompleja {
    private Complejo[][] matriz;

    public MatrizCompleja(Complejo[][] matriz) throws Exception{
        int l = matriz[0].length;
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i].length != l) {
                throw new Exception("The rows of the matrix have to be the same length");
            }
        }
        this.matriz = matriz;
    }

    public Complejo[][] getMatriz() {
        return matriz;
    }

    public Integer tamanio() {
        return matriz.length;
    }

    /**
     * Verifies if two matrices are equal.
     * @param o The object that is going to be compered.
     * @return True or false depending if the matrices are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MatrizCompleja)) {
            return false;
        }
        MatrizCompleja m = (MatrizCompleja) o;
        if (m.getMatriz().length != matriz.length || m.getMatriz()[0].length != matriz[0].length) {
            return false;
        }
        boolean b = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!m.getMatriz()[i][j].equals(matriz[i][j])) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
        }
        return b;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 57 * hash + (int) (Double.doubleToLongBits(this.matriz.hashCode()) ^ (Double.doubleToLongBits(this.matriz.hashCode()) >>> 32));
        return hash;
    }
}