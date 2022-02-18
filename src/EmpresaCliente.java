import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmpresaCliente {
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private String nomeMatriz;
    private String nomefilialAssociada;
    private String nomeCidade;
    private String nomeEstado;
    private String regionalAssociada;
    private String segmentoEmpresa;
    private final ArrayList<Trilha> listaTrilhasAssociadas = new ArrayList<Trilha>();
    static ArrayList<EmpresaCliente> listaEmpresas = new ArrayList<>();
    private static int auxEmpresaCliente = 0;
    private int numeroSequencialEmpresa = 0;



    public EmpresaCliente(String nomeMatriz, String nomefilialAssociada, String cnpjEmpresa, String nomeCidade, String nomeEstado, String regionalAssociada, String segmentoEmpresa) {
        if(validarCNPJ(cnpjEmpresa)){
            this.cnpjEmpresa = cnpjEmpresa;
        }else{
            solicitarCNPJ();
        }
        this.nomeMatriz = nomeMatriz;
        if(isMatriz(this.cnpjEmpresa)){
            this.nomeEmpresa = this.nomeMatriz;
            this.nomefilialAssociada = null;
        }else{
            this.nomefilialAssociada = nomefilialAssociada;
            this.nomeEmpresa = this.nomefilialAssociada;
        }
        this.nomeCidade = nomeCidade;
        this.nomeEstado = nomeEstado;
        this.regionalAssociada = regionalAssociada;
        this.segmentoEmpresa = segmentoEmpresa;
        auxEmpresaCliente++;
        this.numeroSequencialEmpresa = auxEmpresaCliente;
        listaEmpresas.add(this);
    }

    public static boolean isMatriz(String cnpjTeste){
        boolean matriz = false;
        if(EmpresaCliente.cnpjBruto(cnpjTeste).substring(8, 12).equals("0001")){
            matriz = true;
        }
        return matriz;
    }

    public int getNumeroSequencialEmpresa() {
        return numeroSequencialEmpresa;
    }

    public static boolean validarCNPJ(String emailTeste){
        boolean emailValido = false;
        String regx = "(\\d{2})+.+(\\d{3})+.+(\\d{3})+/+(\\d{4})+-+(\\d{2})";
        Pattern padrao = Pattern.compile(regx);
        Matcher validador = padrao.matcher(emailTeste);
        if(validador.matches()){
            emailValido = true;
        }
        return emailValido;
    }

    public void solicitarCNPJ() {
        Scanner sc = new Scanner(System.in);
        boolean cnpjIncorreto = true;
        while (cnpjIncorreto) {
            System.out.println("Por favor, digite um CNPJ valido");
            String cnpjTeste = sc.next();
            if (validarCNPJ(cnpjTeste) == true) {
                this.cnpjEmpresa = cnpjTeste;
                cnpjIncorreto = false;
            } else {
                cnpjIncorreto = true;
            }
        }
    }

    public ArrayList<Trilha> getListaTrilhasAssociadas() {
        return listaTrilhasAssociadas;
    }

    public static String cnpjBruto(String cnpjFormatado){
        return cnpjFormatado.replaceAll("[^0-9]", "");
    }


    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public static EmpresaCliente procuraEmpresa(String nome) {
        for (EmpresaCliente a : listaEmpresas) {
            if(a.getNomeEmpresa().equals(nome))
                return a;
        }
        return null;
    }

    public void addTrilha(Trilha t){
        listaTrilhasAssociadas.add(t);
    }

    @Override
    public String toString() {
        return  nomeEmpresa + " " + cnpjEmpresa + " " +nomeCidade + " "
                + nomeEstado + " " + regionalAssociada + " " + segmentoEmpresa;
    }
}
