import java.util.Scanner;

public class MenuAdmin {
    public static void MenuAdmin(Usuario u) {
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        int op;
        while (a){
        System.out.println("-------HabilitPro-------");
        System.out.println("""
                    Selecione uma opcao:\s
                    1 - Cadastrar uma empresa
                    2 - Cadastrar uma trilha
                    3 - Cadastrar um modulo
                    4 - Cadastrar uma nova conta
                    5 - Cadastrar um trabalhador
                    6 - Alterar o cargo de um trablhador
                    7 - Associar uma trilha a um trbalhador
                    8 - Sair""");
        op = sc.nextInt();
        switch (op){
            case 1: {
                System.out.println("Digite o CNPJ da empresa (no formato XX.XXX.XXX/XXXX-XX):");
                sc.nextLine();
                String cnpjEntrada = sc.nextLine();
                if(!EmpresaCliente.validarCNPJ(cnpjEntrada))
                while (true) {
                    System.out.println("Digite o nome de um cnpj válido (no formato XX.XXX.XXX/XXXX-XX)");
                    String cnpjTeste = sc.nextLine();
                    if (EmpresaCliente.validarCNPJ(cnpjTeste)) {
                        cnpjEntrada = cnpjTeste;
                        break;
                    }
                }
                System.out.println("Digite o nome da Matriz:");
                String nomeMatriz = sc.nextLine();
                System.out.println("Digite o nome da Cidade:");
                String nomeCidade = sc.nextLine();
                System.out.println("Digite o nome do Estado:");
                String nomeEstado = sc.nextLine();
                System.out.println("Digite o nome da regional associada:");
                String nomeRegionalAsssociada = sc.nextLine();
                System.out.println("Digite o nome do segmento da empresa");
                String nomeSegmentoEmpresa = sc.nextLine();
                if(!EmpresaCliente.isMatriz(cnpjEntrada)){
                    System.out.println("Digite o nome da Filial:");
                    String nomeFilial = sc.nextLine();
                    EmpresaCliente e1 = new EmpresaCliente(nomeMatriz,nomeFilial,cnpjEntrada,nomeCidade,nomeEstado,nomeRegionalAsssociada,nomeSegmentoEmpresa);
                }else{
                    EmpresaCliente e1 = new EmpresaCliente(nomeMatriz,null,cnpjEntrada,nomeCidade,nomeEstado,nomeRegionalAsssociada,nomeSegmentoEmpresa);
                }
                break;
            }
            case 2:{
                System.out.println("Digite o nome da empresa cliente:");
                sc.nextLine();
                String nomeEmpresa = sc.nextLine();
                System.out.println("Digite o nome da ocupação");
                String nomeOcupacao= sc.nextLine();
                System.out.println("Digite as anotações da trilha");
                String anotacoes = sc.nextLine();
                if(EmpresaCliente.procuraEmpresa(nomeEmpresa)!=null){
                    Trilha t1 = new Trilha(EmpresaCliente.procuraEmpresa(nomeEmpresa),nomeOcupacao,anotacoes);
                    EmpresaCliente.procuraEmpresa(nomeEmpresa).addTrilha(t1);
                    System.out.println("A trilha " + t1.getNomeTrilha() + " foi criada com sucesso!");
                    System.out.println("A trilha deve possuir pelo menos um módulo");
                    while (true){
                        Modulo novo = PerfilAdmin.criaModulos(t1);
                        System.out.println("""
                                       Gostaria de adicionar mais um módulo a essa trilha?\s
                                        1 - Sim
                                        2 - Não""");
                        int op1 = sc.nextInt();
                        if(op1 == 2){
                            break;
                        }
                    }
                }else{
                    EmpresaCliente emp1 = Trabalhador.solicitarEmpresa();
                    Trilha t1 = new Trilha(emp1,nomeOcupacao,anotacoes);
                    emp1.addTrilha(t1);
                    System.out.println("A trilha " + t1.getNomeTrilha() + " foi criada com sucesso!");
                    System.out.println("A trilha deve possuir pelo menos um módulo");
                    while (true){
                        Modulo novo = PerfilAdmin.criaModulos(t1);
                        System.out.println("""
                                       Gostaria de adicionar mais um módulo a essa trilha?\s
                                        1 - Sim
                                        2 - Não""");
                        int op1 = sc.nextInt();
                        if(op1 == 2){
                            break;
                        }
                    }
                }
                break;
            }
            case 3:{
                System.out.println("Digite o nome da Trilha");
                sc.nextLine();
                String nomeTrilha = sc.nextLine();
                if(Modulo.procuraTrilha(nomeTrilha)!=null) {
                    Modulo m1 = PerfilAdmin.criaModulos(Modulo.procuraTrilha(nomeTrilha));
                    System.out.println("O modulo " + m1.getNomeModulo() + " foi criado com sucesso!");
                }else{
                    boolean repeticao = true;
                    while(repeticao){
                            Modulo m1 = PerfilAdmin.criaModulos(Trilha.solicitarTrilha());
                            System.out.println("O modulo " + m1.getNomeModulo() + " foi criado com sucesso!");
                            repeticao = false;
                            }
                        }
                break;
            }
            case 4:{
                System.out.println("Digite o nome do usuario");
                sc.nextLine();
                String nomeUsuario = sc.nextLine();
                System.out.println("Digite o cpf do usuario");
                String cpfUsuario = sc.nextLine();
                System.out.println("Digite o email do usuario");
                String emailUsuario = sc.nextLine();
                System.out.println("Digite a senha do usuario (ela deve ter mais que 8 caracteres e pelo menos um número)");
                String senhaUsuario = sc.nextLine();
                System.out.println("""
                    Escolha o tipo de conta que voce quer criar:\s
                    1 - Conta Admin
                    2 - Conta Operacional
                    3 - Conta RH""");
                int op1 = sc.nextInt();
                switch (op1){
                    case 1:{
                        PerfilAdmin pa1 = new PerfilAdmin(nomeUsuario,cpfUsuario,emailUsuario,senhaUsuario);
                        break;
                    }
                    case 2:{
                        PerfilOperacional po1 = new PerfilOperacional(nomeUsuario,cpfUsuario,emailUsuario,senhaUsuario);
                        break;
                    }
                    case 3:{
                        PerfilRH prh1 = new PerfilRH(nomeUsuario,cpfUsuario,emailUsuario,senhaUsuario);
                        break;
                    }
                }
                break;
            }
            case 5:{
                System.out.println("Digite o nome do Aluno");
                sc.nextLine();
                String nomeTrabalhador = sc.nextLine();
                System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx)");
                String cpfTrabalhador = sc.nextLine();
                System.out.println("Digite o nome da empresa do trabalhador");
                String nomeEmpresa = sc.nextLine();
                System.out.println("Digite o nome do setor do trabalhador");
                String nomeSetor = sc.nextLine();
                System.out.println("Digite o nome da funcao exercida pelo trabalhador");
                String nomeFuncao = sc.nextLine();
                if(EmpresaCliente.procuraEmpresa(nomeEmpresa)==null) {
                    while (true) {
                        System.out.println("Digite o nome de uma empresa válida");
                        String nomeTeste = sc.nextLine();
                        if (EmpresaCliente.procuraEmpresa(nomeTeste) != null) {
                            Trabalhador t1 = new Trabalhador(nomeTrabalhador, cpfTrabalhador, EmpresaCliente.procuraEmpresa(nomeTeste), nomeSetor, nomeFuncao);
                            break;
                        }
                    }
                }else {
                    Trabalhador t1 = new Trabalhador(nomeTrabalhador, cpfTrabalhador, EmpresaCliente.procuraEmpresa(nomeEmpresa), nomeSetor, nomeFuncao);

                }
                break;
            }
            case 6: {
                System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx)");
                sc.nextLine();
                String cpfTrabalhador = sc.nextLine();
                System.out.println("Digite o nome da empresa");
                String novaEmpresa = sc.nextLine();
                System.out.println("Digite a nova funcao do trabalhador");
                String novaFuncao = sc.nextLine();
                System.out.println("Digite o novo setor do trabalhador");
                String novoSetor = sc.nextLine();
                if (Trabalhador.procuraTrabalhador(cpfTrabalhador) == null && EmpresaCliente.procuraEmpresa(novaEmpresa) == null) {
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        System.out.println("Digite o nome de uma empresa válida");
                        String empresaTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null && EmpresaCliente.procuraEmpresa(empresaTeste) != null) {
                            Trabalhador.procuraTrabalhador(cpfTeste).alteraCargo(EmpresaCliente.procuraEmpresa(empresaTeste), novoSetor, novaFuncao);
                            break;
                        }
                    }
                }else if(Trabalhador.procuraTrabalhador(cpfTrabalhador) == null){
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null ) {
                            Trabalhador.procuraTrabalhador(cpfTeste).alteraCargo(EmpresaCliente.procuraEmpresa(novaEmpresa), novoSetor, novaFuncao);
                            break;
                        }
                    }
                }else if(EmpresaCliente.procuraEmpresa(novaEmpresa) == null){
                    while (true) {
                        System.out.println("Digite o nome de uma empresa válida");
                        String empresaTeste = sc.nextLine();
                        if (EmpresaCliente.procuraEmpresa(empresaTeste) != null) {
                            Trabalhador.procuraTrabalhador(cpfTrabalhador).alteraCargo(EmpresaCliente.procuraEmpresa(empresaTeste), novoSetor, novaFuncao);
                            break;
                        }
                    }
                }else{
                    Trabalhador.procuraTrabalhador(cpfTrabalhador).alteraCargo(EmpresaCliente.procuraEmpresa(novaEmpresa), novoSetor, novaFuncao);
                }
                break;
            }case 7:{
                System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx)");
                sc.nextLine();
                String cpfTrabalhador = sc.nextLine();
                System.out.println("Digite o nome da trilha que vai ser associada ao trabalhador");
                String novaTrilha = sc.nextLine();
                if(Trabalhador.procuraTrabalhador(cpfTrabalhador)==null && Modulo.procuraTrilha(novaTrilha)==null){
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                            cpfTrabalhador = cpfTeste;
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("Digite o nome de uma trilha válida");
                        String trilha = sc.nextLine();
                        if (Modulo.procuraTrilha(trilha) != null) {
                            Trabalhador.atribuiTrilha(Trabalhador.procuraTrabalhador(cpfTrabalhador),Modulo.procuraTrilha(trilha));
                            break;
                        }
                    }

                }else if(Trabalhador.procuraTrabalhador(cpfTrabalhador)==null){
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                            Trabalhador.atribuiTrilha(Trabalhador.procuraTrabalhador(cpfTeste),Modulo.procuraTrilha(novaTrilha));
                            break;
                        }
                    }
                }else if(Modulo.procuraTrilha(novaTrilha)==null){
                    while (true) {
                        System.out.println("Digite o nome de uma trilha válida");
                        String trilha = sc.nextLine();
                        if (Modulo.procuraTrilha(trilha) != null) {
                            Trabalhador.atribuiTrilha(Trabalhador.procuraTrabalhador(cpfTrabalhador),Modulo.procuraTrilha(trilha));
                            break;
                        }
                    }
                }else{
                    Trabalhador.atribuiTrilha(Trabalhador.procuraTrabalhador(cpfTrabalhador),Modulo.procuraTrilha(novaTrilha));
                }
                break;
            } case 8:{
                a = false;
                break;
            }
        }
    }
}
}


