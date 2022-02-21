import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Trilha {
    private String nomeTrilha;
    private String apelido;
    private EmpresaCliente empresaCliente;
    private Ocupacao ocupacao;
    private int anoCorrente;
    private String anotacoesTrilha;
    private int nivelSatisfacao;
    static final ArrayList<Ocupacao> listaOcupacoes = new ArrayList<Ocupacao>();
    static final ArrayList<Trilha> listaTrilhasGeral = new ArrayList<Trilha>();
    private ArrayList<Modulo> listaModulos = new ArrayList<Modulo>();

    public Trilha(EmpresaCliente empresaCliente, String nomeOcupacao) {
        this.empresaCliente = empresaCliente;
        if(procuraOcupacao(nomeOcupacao)!=null){
            this.ocupacao = procuraOcupacao(nomeOcupacao);
        }else{
            Ocupacao o1 = new Ocupacao(nomeOcupacao);
            this.ocupacao = o1;
        }
        this.anoCorrente = LocalDate.now().getYear();
        this.nomeTrilha = this.ocupacao.getNomeOcupacao() + this.empresaCliente.getNomeEmpresa() + empresaCliente.getNumeroSequencialEmpresa() + this.ocupacao.getNumeroSequencialOcupacao()  + this.anoCorrente;
        this.apelido = this.ocupacao.getNomeOcupacao() + empresaCliente.getNumeroSequencialEmpresa() + this.ocupacao.getNumeroSequencialOcupacao() ;
        listaTrilhasGeral.add(this);
        this.empresaCliente.addTrilha(this);
    }

    public void setAnotacoesTrilha(String anotacoesTrilha) {
        this.anotacoesTrilha = anotacoesTrilha;
    }

    public String getAnotacoesTrilha() {
        return anotacoesTrilha;
    }

    public static Ocupacao procuraOcupacao(String ocupacaoNome) {
        for (Ocupacao a : listaOcupacoes) {
            if(a.getNomeOcupacao().equals(ocupacaoNome))
                return a;
        }
        return null;
    }

    public int getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(int nivelSatisfacao) {
        Scanner sc = new Scanner(System.in);
        boolean notaInvalida = true;
        if (nivelSatisfacao >= 1 && nivelSatisfacao <=5) {
            this.nivelSatisfacao = nivelSatisfacao;
        }else{
            while(notaInvalida){
                System.out.println("Digite uma nota de 1 a 5");
                int notaTeste = sc.nextInt();
                if (notaTeste >= 1 && notaTeste <=5) {
                    this.nivelSatisfacao = notaTeste;
                    notaInvalida = false;
                }
            }
        }
    }

    public static Trilha solicitarTrilha() {
        Scanner sc = new Scanner(System.in);
        boolean trilhaIncorreta = true;
        Trilha a = null;
        while (trilhaIncorreta) {
            System.out.println("Por favor, digite o nome de uma trilha valida");
            String trilhateste = sc.next();
            if (Modulo.procuraTrilha(trilhateste)!=null) {
                a = Modulo.procuraTrilha(trilhateste);
                trilhaIncorreta = false;
            }
        }
        return a;
    }


    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public ArrayList<Modulo> getListaModulos() {
        return listaModulos;
    }

    public static void addModulo(Trilha t, Modulo m){
        t.listaModulos.add(m);
        Modulo.atualizaTrilha(m,t);
    }

    @Override
    public String toString() {
        return nomeTrilha;
    }
}
