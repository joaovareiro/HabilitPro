import java.util.ArrayList;

public class Ocupacao {
    private String nomeOcupacao;
    private static int auxOcupacao = 0;
    private int numeroSequencialOcupacao = 0;
    private ArrayList<Modulo> listaModulos = new ArrayList<Modulo>();

    public Ocupacao(String nomeOcupacao) {
        auxOcupacao++;
        this.numeroSequencialOcupacao = auxOcupacao;
        this.nomeOcupacao = nomeOcupacao;
    }

    public String getNomeOcupacao() {
        return nomeOcupacao;
    }

    public int getNumeroSequencialOcupacao() {
        return numeroSequencialOcupacao;
    }

    public void addModulo(Modulo m){
        this.listaModulos.add(m);
    }

}
