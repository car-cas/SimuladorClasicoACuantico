public class MarbleSimulator {
    private double[][] matriz;
    private double[] estadoInicial;

    public MarbleSimulator(double[][] matriz,double[] estadoInicial){
        this.matriz=matriz;
        this.estadoInicial=estadoInicial;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public double[] getEstadoInicial() {
        return estadoInicial;
    }

}
