import enums.Perfil;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private Perfil perfilUsuario;
    static HashMap <String,String> loginSenha = new HashMap<>();

    public Usuario(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario, Perfil perfilUsuario) {
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
        this.perfilUsuario = perfilUsuario;
        loginSenha.put(this.emailUsuario,this.senhaUsuario);
    }

    public static void login(String emailEntrada, String senhaEntrada){
        Scanner sc = new Scanner(System.in);
        boolean loginInvalido = true;
        while(loginInvalido){
            System.out.printf("Digite o email:");
            String emailTeste = sc.next();
            System.out.printf("Digite a senha:");
            String senhaTeste = sc.next();
            if(loginSenha.containsKey(emailTeste) && loginSenha.containsValue(senhaTeste) && loginSenha.get(emailEntrada).equals(senhaTeste)){
                loginInvalido = false;
            }
        }
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

    public void solicitaEmail(){
        Scanner sc = new Scanner(System.in);
        boolean emailInvalido = true;
        while (emailInvalido) {
            System.out.println("Por favor, digite um email valido");
            String emailTeste = sc.next();
            if (validaEmail(emailTeste)) {
                this.senhaUsuario = emailTeste;
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

    public static String cpfBruto(String cpfFormatado){
        return cpfFormatado.replaceAll("[^0-9]", "");
    }

    public static String cpfFormatado(String cpfBruto){
        return cpfBruto.substring(0, 3) + "." + cpfBruto.substring(3, 6) + "." + cpfBruto.substring(6, 9) + "-" + cpfBruto.substring(9, 11);
    }

    //o processo de validação do CPF veio da fonte https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
    //estou usando como se fosse um método de uma biblioteca interna
    public static boolean validarCPF(String cpfValidar){
        if (cpfValidar.equals("00000000000") ||
                cpfValidar.equals("11111111111") ||
                cpfValidar.equals("22222222222") || cpfValidar.equals("33333333333") ||
                cpfValidar.equals("44444444444") || cpfValidar.equals("55555555555") ||
                cpfValidar.equals("66666666666") || cpfValidar.equals("77777777777") ||
                cpfValidar.equals("88888888888") || cpfValidar.equals("99999999999") ||
                (cpfValidar.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(cpfValidar.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpfValidar.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == cpfValidar.charAt(9)) && (dig11 == cpfValidar.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (validarCPF(cpfTeste) == true) {
                this.cpfUsuario = cpfTeste;
                cpfIncorreto = false;
            }else{
                cpfIncorreto = true;
            }
        }
    }

}
