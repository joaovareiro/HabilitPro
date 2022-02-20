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
    public static ArrayList<String> listaRegionais = new ArrayList<String>();
    public static ArrayList<String> listaSegmentos = new ArrayList<String>();

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
        if(validaRegional(regionalAssociada)) {
            this.regionalAssociada = regionalAssociada;
        }else{
            solicitarRegional();
        }
        if(validaSegmento(segmentoEmpresa)) {
            this.segmentoEmpresa = segmentoEmpresa;
        }else{
            solicitarSegmento();
        }
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

    public static void regional() {
        listaRegionais.add("Alto Uruguai Catarinense");
        listaRegionais.add("Alto Vale do Itajaí");
        listaRegionais.add("Centro-Norte");
        listaRegionais.add("Centro-Oeste");
        listaRegionais.add("Extremo Oeste");
        listaRegionais.add("Foz do Rio Itajaí");
        listaRegionais.add("Litoral Sul");
        listaRegionais.add("Norte-Nordeste");
        listaRegionais.add("Oeste");
        listaRegionais.add("Planalto Norte");
        listaRegionais.add("Serra Catarinense");
        listaRegionais.add("Sudeste");
        listaRegionais.add("Sul");
        listaRegionais.add("Vale do Itajaí");
        listaRegionais.add("Vale do Itajaí Mirim");
        listaRegionais.add("Vale do Itapocu");
    }

    public boolean validaRegional(String entrada){
        boolean valido = false;
        for (String a : EmpresaCliente.listaRegionais) {
            if(a.equals(entrada)) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public void solicitarRegional(){
        Scanner sc = new Scanner(System.in);
        boolean regionalInvalida = true;
        while (regionalInvalida) {
            System.out.println("Por favor, digite uma regional valida");
            String regionalTeste = sc.next();
            if (validaRegional(regionalTeste)) {
                this.regionalAssociada= regionalTeste;
                regionalInvalida = false;
            }
        }
    }

    public static void segmento() {
        listaSegmentos.add("Alimentos e Bebidas");
        listaSegmentos.add("Celulose e Papel");
        listaSegmentos.add("Construção");
        listaSegmentos.add("Equipamentos elétricos");
        listaSegmentos.add("Fármacos e Equipamentos de Saúde");
        listaSegmentos.add("Fumo");
        listaSegmentos.add("Indústria Autotiva");
        listaSegmentos.add("Indústria Cerâmica");
        listaSegmentos.add("Indústria Diversa");
        listaSegmentos.add("Indústria Extrativa");
        listaSegmentos.add("Indústria Gráfica");
        listaSegmentos.add("Madeira e Móveis");
        listaSegmentos.add("Máquinas e equipamentos");
        listaSegmentos.add("Metalmecânica e Metalurgia");
        listaSegmentos.add("Óleo,Gás e Eletricidade");
        listaSegmentos.add("Produtos Quḿicos e Plásticos");
        listaSegmentos.add("Saneamento básico");
        listaSegmentos.add("TIC");
        listaSegmentos.add("Textil, Confecção, Couro e Calçados");

    }

    public boolean validaSegmento(String entrada){
        boolean valido = false;
        for (String a : EmpresaCliente.listaSegmentos) {
            if(a.equals(entrada)) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public void solicitarSegmento(){
        Scanner sc = new Scanner(System.in);
        boolean segmentoInvalido = true;
        while (segmentoInvalido) {
            System.out.println("Por favor, digite um segmento valido");
            String segmentoTeste = sc.next();
            if (validaSegmento(segmentoTeste)) {
                this.segmentoEmpresa= segmentoTeste;
                segmentoInvalido = false;
            }
        }
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
            System.out.println("Por favor, digite um CNPJ valido (no formato XX.XXX.XXX/XXXX-XX)");
            String cnpjTeste = sc.next();
            if (validarCNPJ(cnpjTeste)) {
                this.cnpjEmpresa = cnpjTeste;
                cnpjIncorreto = false;
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
