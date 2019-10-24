import java.text.DecimalFormat;

/**
 *
 * @author Carlos Andres Castaneda Lozano
 *
 * Clase Complejo, crea un numero complejo que consta de un numero
 * real y un numero imaginario.
 *
 */
public class Complejo {
    private double numeroA;
    private double numeroB;

    public Complejo(double numeroA,double numeroB){
        this.numeroA = numeroA;
        this.numeroB = numeroB;
    }

    public double getNumeroA(){
        return numeroA;
    }

    public double getNumeroB(){
        return numeroB;
    }

    @Override
    public String toString() {
        String simbolo = "";
        if(numeroB >= 0){
            simbolo="+";
        }
        return numeroA + " " + simbolo + " " + numeroB + 'i';
    }

    /**
     *
     * Metodo suma, calcula el modulo de un numero complejo
     *
     * @return Complejo
     */
    public double modulo(){
        double respuesta = Math.sqrt(Math.pow(numeroA,2) + Math.pow(numeroB,2));
        return respuesta;

    }

    /**
     *
     * Metodo conjugado, calcula el conjugado de un numero complejo
     *
     * @param x Complejo
     * @return Complejo
     */
    public  Complejo conjugado(){
        return new Complejo(numeroA,numeroB*-1);
    }

    public String getnumeroComplejo() {
        DecimalFormat df = new DecimalFormat("#.##");
        if(numeroB < 0) {
            return df.format(numeroA) + " - " + df.format(numeroB * -1) + "i";
        } else {
            return df.format(numeroA) + " + " + df.format(numeroB) + "i";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Complejo number = (Complejo) obj;
        return this.numeroA == number.getNumeroA() && this.numeroB == number.getNumeroB();
    }

    @Override
    public int hashCode(){
        int hash=3;
        hash = 57 * hash + (int) (Double.doubleToLongBits(this.numeroA) ^ (Double.doubleToLongBits(this.numeroA) >>> 32));
        hash = 57 * hash + (int) (Double.doubleToLongBits(this.numeroB) ^ (Double.doubleToLongBits(this.numeroB) >>> 32));
        return hash;
    }


}