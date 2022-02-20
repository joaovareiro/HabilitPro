import java.util.Objects;
import java.util.Scanner;

public class MenuRH {
    public static void MenuRH(Usuario u) {
        Scanner sc = new Scanner(System.in);
        int op;
        boolean a = true;
        while (a){
            System.out.println("-------HabilitPro-------");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Listar todas as empresas do sistema
                    2 - Listar todas as trilhas de uma empresa
                    3 - Listar todos os modulos de uma trilha
                    4 - Listar todos os trabalhadores do sistema
                    5 - Listar as notas de um aluno e sua média
                    6 - Listar as anotacoes de um aluno
                    7 - Ver o log de um trabalhador
                    8 - Ver o nivel de satisfação de uma trilha
                    9 - Sair""");
            op = sc.nextInt();
            switch (op){
                case 1: {
                    PerfilAdmin.listaEmpresas();
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome da empresa");
                    sc.nextLine();
                    String nomeEmpresa = sc.nextLine();
                    if(EmpresaCliente.procuraEmpresa(nomeEmpresa) == null){
                        while (true) {
                            System.out.println("Digite o nome de uma empresa válida");
                            String empresaTeste = sc.nextLine();
                            if (EmpresaCliente.procuraEmpresa(empresaTeste) != null) {
                                PerfilAdmin.listaTrilhas(EmpresaCliente.procuraEmpresa(empresaTeste));
                                break;
                            }
                        }
                    }else{
                        PerfilAdmin.listaTrilhas(EmpresaCliente.procuraEmpresa(nomeEmpresa));
                    }
                    break;
                }
                case 3:{
                    System.out.println("Digite o nome da trilha");
                    sc.nextLine();
                    String nomeTrilha = sc.nextLine();
                    if(Modulo.procuraTrilha(nomeTrilha) == null){
                        while (true) {
                            System.out.println("Digite o nome de uma trilha válida");
                            String trilhaTeste = sc.nextLine();
                            if (Modulo.procuraTrilha(trilhaTeste) != null) {
                                PerfilAdmin.listaModulosTrilha(Objects.requireNonNull(Modulo.procuraTrilha(trilhaTeste)));
                                break;
                            }
                        }
                    }else{
                        PerfilAdmin.listaModulosTrilha(Objects.requireNonNull(Modulo.procuraTrilha(nomeTrilha)));
                    }
                    break;
                } case 4:{
                    PerfilAdmin.listaTrabalhadores();
                    break;
                }
                case 5: {
                    System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx) ");
                    sc.nextLine();
                    String cpfEntrada = sc.next();
                    if (Trabalhador.procuraTrabalhador(cpfEntrada) == null) {
                        while (true) {
                            System.out.println("Por favor, digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                                PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)));
                                break;
                            }
                        }
                    } else {
                        PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfEntrada)));
                    }
                    break;
                } case 6:{
                    System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx) ");
                    sc.nextLine();
                    String cpfEntrada = sc.next();
                    if(Trabalhador.procuraTrabalhador(cpfEntrada) == null){
                        while (true) {
                            System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null ) {
                                PerfilAdmin.logTrabalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)));
                                break;
                            }
                        }
                    }else{
                        PerfilOperacional.listaAnotacoesAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfEntrada)));
                    }
                    break;
                } case 7: {
                    System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx) ");
                    sc.nextLine();
                    String cpfEntrada = sc.next();
                    if (Trabalhador.procuraTrabalhador(cpfEntrada) == null) {
                        while (true) {
                            System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                                PerfilAdmin.logTrabalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)));
                                break;
                            }
                        }
                    } else {
                        PerfilAdmin.logTrabalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfEntrada)));
                    }
                    break;
                } case 8: {
                    System.out.println("Digite o nome da trilha");
                    sc.nextLine();
                    String nomeTrilha = sc.nextLine();
                    if(Modulo.procuraTrilha(nomeTrilha) == null){
                        while (true) {
                            System.out.println("Digite o nome de uma trilha válida");
                            String trilhaTeste = sc.nextLine();
                            if (Modulo.procuraTrilha(trilhaTeste) != null) {
                                if(Modulo.procuraTrilha(trilhaTeste).getNivelSatisfacao()>0) {
                                    System.out.println("O nível de satisfação dessa trilha é: " + Modulo.procuraTrilha(trilhaTeste).getNivelSatisfacao());
                                    break;
                                }else{
                                    System.out.println("Essa trilha não foi avaliada ainda");
                                    break;
                                }

                            }
                        }
                    }else{
                        if(Modulo.procuraTrilha(nomeTrilha).getNivelSatisfacao()>0) {
                            System.out.println("O nível de satisfação dessa trilha é: " + Modulo.procuraTrilha(nomeTrilha).getNivelSatisfacao());
                        }else{
                            System.out.println("Essa trilha não foi avaliada ainda");
                        }
                    }
                    break;
                } case 9: {
                    a = false;
                    break;
                }
            }
        }
    }



}
