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
                    6 - Sair""");
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
                    PerfilAdmin.listaTrilhas(EmpresaCliente.procuraEmpresa(nomeEmpresa));
                    break;
                }
                case 3:{
                    System.out.println("Digite o nome da trilha");
                    sc.nextLine();
                    String nomeTrilha = sc.nextLine();
                    PerfilAdmin.listaModulosTrilha(Objects.requireNonNull(Modulo.procuraTrilha(nomeTrilha)));
                    break;
                }
                case 4:{
                    PerfilAdmin.listaTrabalhadores();
                    break;
                }
                case 5:{
                    System.out.println("Digite o cpf do trabalhador (no formato xxx.xxx.xxx-xx) ");
                    sc.nextLine();
                    String cpfEntrada = sc.next();
                    PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfEntrada)));
                    break;
                } case 6:{
                    a = false;
                    break;
                }
            }
        }
    }



}
