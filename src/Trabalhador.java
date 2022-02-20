import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trabalhador {
    private String nometrabalhador;
    private String cpfTrabalhador;
    private EmpresaCliente empresaAssociada;
    private String nomeSetor;
    private String nomeFuncao;
    private LocalDate ultimaFuncao;
    private ArrayList<Trilha> listaTrilhasTrabalhador = new ArrayList<Trilha>();
    static ArrayList<Trabalhador> listaTrabalhadores = new ArrayList<Trabalhador>();
    private Map<Modulo, Integer> atribuicaoModulo = new HashMap<Modulo, Integer>();
    private Map<Modulo, String> atribuicaoAnotacao = new HashMap<Modulo, String>();
    private ArrayList<String>logTrabalhador = new ArrayList<String>();

    public Trabalhador(String nometrabalhador, String cpfTrabalhador, EmpresaCliente empresaAssociada, String nomeSetor, String nomeFuncao) {
        this.nometrabalhador = nometrabalhador;
        if(Usuario.validarCPF(cpfTrabalhador)){
            this.cpfTrabalhador = cpfTrabalhador;
        }else{
            solicitarCPF();
        }
        this.empresaAssociada = empresaAssociada;
        this.nomeSetor = nomeSetor;
        this.nomeFuncao = nomeFuncao;
        this.ultimaFuncao = LocalDate.now();
        listaTrabalhadores.add(this);
        String cargoInicial = "Foi admitido na empresa "+ this.empresaAssociada.getNomeEmpresa()+" com a função " + this.nomeFuncao + " no setor " + this.nomeSetor;
        logTrabalhador.add(cargoInicial);
    }

    public static void atribuiTrilha(Trabalhador trab, Trilha trilha){
        if(trilha.getListaModulos().size()>0){
            for(Modulo m : trilha.getListaModulos()){
                atribuiModulo(trab,m);
            }
            if(!trab.getListaTrilhasTrabalhador().contains(trilha)) {
                trab.getListaTrilhasTrabalhador().add(trilha);
                String atribuicao = "Teve a trilha " + trilha.getNomeTrilha() + " atribuida ao trabalhador";
                trab.logTrabalhador.add(atribuicao);
            }else{
                System.out.println("Essa trilha já foi atribuida ao trabalhador");
            }
        }else{
            System.out.println("Essa trilha não possui módulos, por favor atribua um módulo a ela");
        }
        }

    public ArrayList<Trilha> getListaTrilhasTrabalhador() {
        return listaTrilhasTrabalhador;
    }

    public static void atribuiModulo(Trabalhador t, Modulo m){
        t.atribuicaoModulo.put(m,null);
        t.atribuicaoAnotacao.put(m,null);
    }

    public static void setNotaModulo(Trabalhador t, Modulo m, int notaModulo) {
        t.atribuicaoModulo.put(m,notaModulo);
        String atribuicaoNota = "Tirou a nota " + notaModulo + " no modulo " + m.getNomeModulo();
        t.logTrabalhador.add(atribuicaoNota);
    }



    public static void setAnotacaoModulo(Trabalhador t, Modulo m, String anotacao){
        t.atribuicaoAnotacao.put(m,anotacao);
        String atribuicaoAnotacao = "Foi atribuido o seguinte comentário \"" + anotacao + "\" no modulo " + m.getNomeModulo();
        t.logTrabalhador.add(atribuicaoAnotacao);
    }

    public String getNometrabalhador() {
        return nometrabalhador;
    }

    public Map<Modulo, Integer> getAtribuicaoModulo() {
        return atribuicaoModulo;
    }

    public static EmpresaCliente solicitarEmpresa() {
        Scanner sc = new Scanner(System.in);
        boolean empresaIncorreta = true;
        EmpresaCliente e =null;
        while (empresaIncorreta) {
            System.out.println("Por favor, digite o nome de uma Empresa valida");
            String nomeTeste = sc.next();
            if (EmpresaCliente.procuraEmpresa(nomeTeste)!=null) {
                e = EmpresaCliente.procuraEmpresa(nomeTeste);
                empresaIncorreta = false;
            } else {
                empresaIncorreta = true;
            }
        }
        return e;
    }

    public String getCpfTrabalhador() {
        return cpfTrabalhador;
    }

    public static Trabalhador procuraTrabalhador(String cpfEntrada) {
        for (Trabalhador a : listaTrabalhadores) {
            if(a.getCpfTrabalhador().equals(cpfEntrada))
                return a;
        }
        return null;
    }

    public ArrayList<String> getLogTrabalhador() {
        return logTrabalhador;
    }

    public void alteraCargo(EmpresaCliente e, String nomeSetor, String nomeFuncao){
        if(e != this.empresaAssociada){
            String mudanca1 = "Saiu da empresa " + this.empresaAssociada.getNomeEmpresa();
            this.empresaAssociada = e;
            this.nomeSetor = nomeSetor;
            this.nomeFuncao = nomeFuncao;
            String mudanca2 = "Foi admitido na empresa "+ this.empresaAssociada.getNomeEmpresa()+" com a função " + this.nomeFuncao + " no setor " + this.nomeSetor;
            logTrabalhador.add(mudanca1);
            logTrabalhador.add(mudanca2);
        }else{
            String cargo = "Teve seu cargo alterado para " + this.nomeFuncao + " no setor " + this.nomeSetor;
            logTrabalhador.add(cargo);
        }
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

    public Map<Modulo, String> getAtribuicaoAnotacao() {
        return atribuicaoAnotacao;
    }

    @Override
    public String toString() {
        return nometrabalhador + " " + cpfTrabalhador + " " + empresaAssociada +" "+ nomeSetor + " " + nomeFuncao + " " +
                ", ultimaFuncao=" + ultimaFuncao +
                ", listaTrilhasTrabalhador=" + listaTrilhasTrabalhador;
    }
}
