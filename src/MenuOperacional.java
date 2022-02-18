import java.util.Objects;
import java.util.Scanner;

public class MenuOperacional {
    public static void MenuOperacional(Usuario u){
        Scanner sc = new Scanner(System.in);
        int op;
        boolean a = true;
        while (a){
            System.out.println("-------HabilitPro-------");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Avaliar um módulo de um aluno
                    2 - Ver a nota de um aluno
                    3 - Ver a media de um aluno
                    4 - Ver todas as notas de um aluno e a sua média
                    5 - Sair""");
            op = sc.nextInt();
            switch (op){
                case 1: {
                    System.out.println("Digite o cpf do aluno");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    System.out.println("Digite a nota do modulo");
                    int nota = sc.nextInt();
                    PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(nomeAluno),Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)),nomeModulo),nota);
                    break;
                }
                case 2: {
                    System.out.println("Digite o cpf do aluno");
                    sc.nextLine();
                    String cpfAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    PerfilOperacional.getNotaModuloEspecifico(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)),Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)),nomeModulo));
                    break;
                }
                case 3:{
                    System.out.println("Digite o cpf do aluno");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    PerfilOperacional.getMediaTrabalhador(Trabalhador.procuraTrabalhador(nomeAluno));
                    break;
                }
                case 4:{
                    System.out.println("Digite o cpf do aluno");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)));
                    break;
                }
                case 5:{
                    a = false;
                    break;
                }
            }
        }
    }
}
