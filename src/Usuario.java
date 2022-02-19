import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Usuario {
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    static HashMap <String,String> loginSenha = new HashMap<>();
    static final ArrayList<Usuario> listaUsuariosGeral = new ArrayList<Usuario>();

    public Usuario(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        if(validarCPF(cpfUsuario)){
            this.cpfUsuario = cpfUsuario;
        }else{
            solicitarCPF();
        }
        if(validaEmail(emailUsuario)){
            this.emailUsuario = emailUsuario;
        }else{
            solicitaEmail();
        }
        if(validarSenha(senhaUsuario)){
            this.senhaUsuario = senhaUsuario;
        }else{
            solicitaSenha();
        }
        loginSenha.put(this.emailUsuario,this.senhaUsuario);
        listaUsuariosGeral.add(this);
    }

    public static Usuario procuraUsuario(String emailUsuario) {
        for (Usuario a : listaUsuariosGeral) {
            if(a.getEmailUsuario().equals(emailUsuario))
                return a;
        }
        return null;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public static Usuario retornaLogin(String emailEntrada, String senhaEntrada){
        Usuario a = procuraUsuario(emailEntrada);
        boolean login = false;
        if(a!=null){
            if(login(emailEntrada,senhaEntrada)){
                login = true;
        }else{
               solicitaLoginValido();
            }
        }
        return a;
    }

    public static boolean login(String emailEntrada, String senhaEntrada){
        boolean login = false;
        if(loginSenha.containsKey(emailEntrada) && loginSenha.containsValue(senhaEntrada) && loginSenha.get(emailEntrada).equals(senhaEntrada)) {
            login = true;
            Usuario a = procuraUsuario(emailEntrada);
            System.out.println("Bem-vindo " + a.getNomeUsuario());
        }
        return login;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", cpfUsuario='" + cpfUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", senhaUsuario='" + senhaUsuario + '\'' +
                '}';
    }


    public static boolean validaEmail(String emailTeste){
        boolean emailValido = false;
        String regx = "^[a-zA-Z0-9]+[@]{1}[a-z0-9]+[.]{1}[a-z]+$";
        Pattern padrao = Pattern.compile(regx);
        Matcher validador = padrao.matcher(emailTeste);
        if(validador.matches()){
            emailValido = true;
        }
        return emailValido;
    }

    public static void solicitaLoginValido(){
        Scanner sc = new Scanner(System.in);
        boolean loginInvalido = true;
        while (loginInvalido) {
            System.out.println("Por favor, digite um email valido");
            String emailTeste = sc.nextLine();
            System.out.println("Por favor, digite uma senha valida");
            String senhaTeste = sc.nextLine();
            if (login(emailTeste,senhaTeste)) {
                loginInvalido = false;
            }
        }
    }
    public void solicitaEmail(){
        Scanner sc = new Scanner(System.in);
        boolean emailInvalido = true;
        while (emailInvalido) {
            System.out.println("Por favor, digite um email valido");
            String emailTeste = sc.next();
            if (validaEmail(emailTeste)) {
                this.emailUsuario = emailTeste;
                emailInvalido = false;
            }
        }
    }

    public static boolean validarSenha(String senhaTeste){
        boolean senhaValida = false;
        String regx = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
        Pattern padrao = Pattern.compile(regx);
        Matcher validador = padrao.matcher(senhaTeste);
        if(validador.matches() && senhaTeste.length()>=8){
            senhaValida = true;
        }
        return senhaValida;
    }

    public void solicitaSenha(){
    Scanner sc = new Scanner(System.in);
    boolean senhaIncorreta = true;
        while (senhaIncorreta) {
        System.out.println("Por favor, digite uma senha valida");
        String senhaTeste = sc.next();
        if (validarSenha(senhaTeste)) {
            this.senhaUsuario = senhaTeste;
            senhaIncorreta = false;
            }
        }
    }

    public static boolean validarCPF(String emailTeste){
        boolean cpfvalido = false;
        String regx = "(\\d{3})+.+(\\d{3})+.+(\\d{3})+-+(\\d{2})";
        Pattern padrao = Pattern.compile(regx);
        Matcher validador = padrao.matcher(emailTeste);
        if(validador.matches()){
            cpfvalido = true;
        }
        return cpfvalido;
    }

    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (validarCPF(cpfTeste)) {
                this.cpfUsuario = cpfTeste;
                cpfIncorreto = false;
            }
        }
    }

}
