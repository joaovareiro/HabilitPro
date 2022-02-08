import java.time.LocalDate;
import java.util.ArrayList;

public class Trabalhador {
    private String nometrabalhador;
    private String cpfTrabalhador;
    private EmpresaCliente empresaAssociada;
    private String nomeSetor;
    private String nomeFuncao;
    private LocalDate ultimaFuncao;
    private ArrayList<Trilha> listaTrilhasTrabalhador = new ArrayList<Trilha>();
    private ArrayList<Modulo> listaTrilhas = new ArrayList<Modulo>(); //TODO extrair notas dos modulos dessa lista
}
