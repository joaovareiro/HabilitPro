import enums.Status;
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
                    5 - Listar trilhas de um trabalhador
                    6 - Sair""");
            op = sc.nextInt();
            switch (op){
                case 1: {
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    if(Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)),nomeModulo).getStatusModulo().equals(Status.CursoNaoIniciado)){
                        System.out.println("O modelo não pode ser avaliado pois ele ainda não começou");
                    }else if(Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)),nomeModulo).getStatusModulo().equals(Status.AvaliacaoFinalizada)){
                        System.out.println("A avaliação deste módulo já foi finalizada");
                    }else if(Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)),nomeModulo).getStatusModulo().equals(Status.EmAndamento)){
                        System.out.println("O curso ainda não está na fase de avaliação");
                    }else {
                        System.out.println("Digite a nota do modulo");
                        int nota = sc.nextInt();
                        PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(nomeAluno), Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)), nomeModulo), nota);
                    }
                        break;
                }
                case 2: {
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String cpfAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    Objects.requireNonNull(Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo)).setStatusModulo();
                    PerfilOperacional.getNotaModuloEspecifico(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)),Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)),nomeModulo));
                    break;
                }
                case 3:{
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String cpfAluno = sc.nextLine();
                    PerfilOperacional.getMediaTrabalhador(Trabalhador.procuraTrabalhador(cpfAluno));
                    break;
                }
                case 4:{
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)));
                    break;
                }
                case 5:{
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String nomeAluno = sc.nextLine();
                    PerfilOperacional.getTrilhasTrbalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(nomeAluno)));
                    break;
                }
                case 6:{
                    a = false;
                    break;
                }
            }
        }
    }
}
