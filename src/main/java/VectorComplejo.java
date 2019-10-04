public class VectorComplejo {
    Complejo[] vector;

    /**
     * The constructor of a new complex vector.
     * @param vector The complex vector.
     */
    public VectorComplejo(Complejo[] vector) {
        this.vector = vector;
    }

    /**
     * Obtains the complex vector.
     * @return The complex vector.
     */
    public Complejo[] getVector() {
        return vector;
    }

    /**
     * Compares if 2 complex vectors are equal.
     * @param o The object that will be compared.
     * @return True or false depending if the complex vectors are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complejo)) {
            return false;
        }
        VectorComplejo v = (VectorComplejo) o;
        if(v.getVector().length != vector.length) {
            return false;
        }
        boolean b = false;
        for(int i = 0; i < v.getVector().length; i++) {
            if(!v.getVector()[i].equals(vector[i])) {
                b = false;
                break;
            } else {
                b = true;
            }
        }
        return b;
    }

}
