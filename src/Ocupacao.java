import java.util.ArrayList;

public class Ocupacao {
    private String nomeOcupacao;
    private static int aux = 0;
    private int numeroSequencial = 0;
    private ArrayList<Modulo> listaModulos = new ArrayList<Modulo>();

    public Ocupacao(String nomeOcupacao) {
        aux++;
        this.numeroSequencial = aux;
        this.nomeOcupacao = nomeOcupacao;
    }

    public String getNomeOcupacao() {
        return nomeOcupacao;
    }

    public int getNumeroSequencial() {
        return numeroSequencial;
    }

    public void addModulo(Modulo m){
        this.listaModulos.add(m);
    }

}
