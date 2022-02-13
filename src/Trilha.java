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
    private static ArrayList<Ocupacao> listaOcupacoes = new ArrayList<Ocupacao>();
    static final ArrayList<Trilha> listaTrilhasGeral = new ArrayList<Trilha>();
    private int nivelSatisfacao;

    public Trilha(EmpresaCliente empresaCliente, String nomeOcupacao, String anotacoesTrilha) {
        this.empresaCliente = empresaCliente;
        if(procuraOcupacao(nomeOcupacao)!=null){
            this.ocupacao = procuraOcupacao(nomeOcupacao);
        }else{
            Ocupacao o1 = new Ocupacao(nomeOcupacao);
            this.ocupacao = o1;
        }
        this.anoCorrente = LocalDate.now().getYear();
        this.anotacoesTrilha = anotacoesTrilha;
        this.nomeTrilha = this.ocupacao.getNomeOcupacao() + this.empresaCliente.getNomeEmpresa() + this.ocupacao.getNumeroSequencial() + this.anoCorrente;
        this.apelido = this.ocupacao.getNomeOcupacao() + this.ocupacao.getNumeroSequencial();
        listaTrilhasGeral.add(this);
    }

    public static Ocupacao procuraOcupacao(String ocupacaoNome) {
        for (Ocupacao a : listaOcupacoes) {
            if(a.getNomeOcupacao().equals(ocupacaoNome))
                return a;
        }
        return null;
    }


    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public String getApelido() {
        return apelido;
    }

    public int getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(int nivelSatisfacao) {
        Scanner sc = new Scanner(System.in);
        boolean notaInvalida = true;
        while(notaInvalida){
            System.out.println("Digite uma nota de 1 a 5");
            int notaTeste = sc.nextInt();
            if (notaTeste >= 1 && notaTeste <=5) {
                this.nivelSatisfacao = nivelSatisfacao;
                notaInvalida = false;
            } else {
                notaInvalida = true;
            }
        }
    }

}
