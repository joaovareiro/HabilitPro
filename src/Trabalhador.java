import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Trabalhador {
    private String nometrabalhador;
    private String cpfTrabalhador;
    private EmpresaCliente empresaAssociada;
    private String nomeSetor;
    private String nomeFuncao;
    private LocalDate ultimaFuncao;
    private ArrayList<Trilha> listaTrilhasTrabalhador = new ArrayList<Trilha>();
    private ArrayList<Modulo> listaTrilhas = new ArrayList<Modulo>(); //TODO extrair notas dos modulos dessa lista
    static ArrayList<Trabalhador> listaTrabalhadores = new ArrayList<Trabalhador>();
    private HashMap<Modulo, Integer> atribuicaoModulo = new HashMap<Modulo, Integer>();
    //validar com os metodos de usuario

    public Trabalhador(String nometrabalhador, String cpfTrabalhador, String empresaAssociada, String nomeSetor, String nomeFuncao) {
        this.nometrabalhador = nometrabalhador;
        if(Usuario.validarCPF(cpfTrabalhador)){
            this.cpfTrabalhador = cpfTrabalhador;
        }else{
            solicitarCPF();
        }
        if(EmpresaCliente.procuraEmpresa(empresaAssociada)!=null){
            this.empresaAssociada = EmpresaCliente.procuraEmpresa(empresaAssociada);
        }else{
            solicitarEmpresa();
        }

        this.nomeSetor = nomeSetor;
        this.nomeFuncao = nomeFuncao;
        this.ultimaFuncao = LocalDate.now();
        listaTrabalhadores.add(this);
    }

    public void atribuiModulo(Modulo m){
        atribuicaoModulo.put(m,null);
    }

    public void atribuiNota(Modulo m, int nota){
        atribuicaoModulo.put(m,nota);
    }

    private void solicitarEmpresa() {
        Scanner sc = new Scanner(System.in);
        boolean empresaIncorreta = true;
        while (empresaIncorreta) {
            System.out.println("Por favor, digite o nome de uma Empresa valida");
            String nomeTeste = sc.next();
            if (EmpresaCliente.procuraEmpresa(nomeTeste)!=null) {
                this.empresaAssociada = EmpresaCliente.procuraEmpresa(nomeTeste);
                empresaIncorreta = false;
            } else {
                empresaIncorreta = true;
            }
        }
    }

    public void alteraSetor(String novoSetor){
        this.nomeSetor = novoSetor;
    }

    public void alteraFuncao(String novaFuncao){
        this.nomeFuncao = novaFuncao;
        this.ultimaFuncao = LocalDate.now();
    }

    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (Usuario.validarCPF(cpfTeste) == true) {
                this.cpfTrabalhador = cpfTeste;
                cpfIncorreto = false;
            } else {
                cpfIncorreto = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Trabalhador{" +
                "nometrabalhador='" + nometrabalhador + '\'' +
                ", cpfTrabalhador='" + cpfTrabalhador + '\'' +
                ", empresaAssociada=" + empresaAssociada +
                ", nomeSetor='" + nomeSetor + '\'' +
                ", nomeFuncao='" + nomeFuncao + '\'' +
                ", ultimaFuncao=" + ultimaFuncao +
                ", listaTrilhasTrabalhador=" + listaTrilhasTrabalhador +
                ", listaTrilhas=" + listaTrilhas +
                '}';
    }
}
