import java.time.LocalDate;
import java.util.ArrayList;

public class Trilha {
    private String nomeTrilha; //reler especificao
    private String apelido;
    private EmpresaCliente empresaCliente;
    private String ocupacao;
    private ArrayList<Modulo> listaModulos = new ArrayList<Modulo>();
    private int anoCorrente;
    private String anotacoesTrilha;
    private static int aux = 0;
    private int numeroSequencial = 0;

    public Trilha(EmpresaCliente empresaCliente, String ocupacao, String anotacoesTrilha) {
        aux++;
        this.empresaCliente = empresaCliente;
        this.ocupacao = ocupacao;
        this.anoCorrente = LocalDate.now().getYear();
        this.anotacoesTrilha = anotacoesTrilha;
        this.numeroSequencial = aux;
        this.nomeTrilha = this.ocupacao + this.empresaCliente.getNomeEmpresa() + this.numeroSequencial + this.anoCorrente ;
        this.apelido = this.ocupacao + this.numeroSequencial;
    }

    public void addModulo(Modulo m){
        this.listaModulos.add(m);
    }
}
