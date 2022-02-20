import java.util.Scanner;

public class MenuInicial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpresaCliente m1 = new EmpresaCliente( "MatrizTeste",null,"00.790.711/0001-07","Porto Alegre","RS","Sul","Equipamentos Eletricos");
        EmpresaCliente f1 = new EmpresaCliente("MatrizTeste","FilialTeste","00.790.711/0002-07","Porto Alegre","RS","Sul","Equipamentos Eletricos");
        Trilha t1 = new Trilha(f1,"Programação","Trilha para aprender lógica de programação");
        Trilha t2 = new Trilha(m1,"Programação","Trilha para aprender OO");
        Modulo mod11 = new Modulo(t1,"Logica 1","Lógica de programação","Atividade do Trello","Este modulo tem como o objetivo o aprendizado de if e else","15/02/2022","17/02/2022","15/03/2022");
        Modulo mod12 = new Modulo(t1,"Logica 2","Lógica de programação","Atividade do Trello","Este modulo tem como o objetivo o aprendizado de for e while","15/02/2022","17/02/2022","15/03/2022");
        Modulo mod21 = new Modulo(t2,"Logica 1","Lógica de programação","Atividade do Trello","Este modulo tem como o objetivo o aprendizado de if e else","15/02/2022","17/02/2022","15/03/2022");
        PerfilAdmin a1 = new PerfilAdmin("Usuario Admin","111.222.333-44","admin@gmail.com","senhaadmin123");
        PerfilOperacional a2 = new PerfilOperacional("Usuario Operacional","222.333.444-55","operacional@gmail.com","senhaoperacional123");
        PerfilRH a3 = new PerfilRH("Usuario RH","333.444.555-66","rh@gmail.com","senharh123");
        Trabalhador trab1 = new Trabalhador("Rogerio","456.133.789-45",m1,"TI","Estagiario");
        Trabalhador trab2 = new Trabalhador("Claudio","411.422.780-15",f1,"TI","Junior");
        Trabalhador.atribuiTrilha(trab1,t1);
        Trabalhador.atribuiTrilha(trab2,t2);
        int op;
        System.out.println(t1.getNomeTrilha());
        MenuOperacional.MenuOperacional(a1);
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