import enums.Regional;
import enums.Segmento;

import java.util.Scanner;

public class MenuInicial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        while (true){
            System.out.println("-------HabilitPro-------");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Fazer login
                    2 - Sair do sistema""");
            op = sc.nextInt();
            if(op==1){
                boolean loginInvalido = true;
                while(loginInvalido){
                    System.out.println("Digite o email:");
                    String email = sc.next();
                    System.out.println("Digite a senha:");
                    String senha = sc.next();
                    Usuario u = Usuario.retornaLogin(email,senha);
                    if(u instanceof PerfilAdmin){
                        MenuAdmin.MenuAdmin(u);
                        loginInvalido = false;
                    }else if(u instanceof PerfilOperacional){
                        MenuOperacional.MenuOperacional( u);
                        loginInvalido = false;
                    }else if(u instanceof PerfilRH){
                        MenuRH.MenuRH(u);
                        loginInvalido = false;
                    }if(u == null){
                        System.out.println("O email digitado não foi encontrado na base de dados, por favor tente novamente");
                    }
                }
            }else{
                System.exit(0);
            }
        }
    }
}