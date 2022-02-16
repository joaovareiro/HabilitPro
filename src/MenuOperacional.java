import java.util.Scanner;

public class MenuOperacional {
    public static void MenuOperacional(Usuario u){
        Scanner sc = new Scanner(System.in);
        int op;
        while (true){
            System.out.println("-------HabilitPro-------");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Avaliar um módulo de um aluno
                    2 - Ver a nota de um aluno
                    3 - Ver a media de um aluno
                    4 - Ver todas as notas de um aluno
                    """);
            op = sc.nextInt();
            switch (op){
                case 1: {
                    while(true){
                        System.out.println("Digite o nome do aluno");
                        String nomeAluno = sc.nextLine();
                        if(Trabalhador.procuraTrabalhador(nomeAluno)!=null){
                            System.out.println("Digite o nome do modulo");
                            String nomeModulo = sc.nextLine();
                            if(Modulo.procuraModulo(Trabalhador.procuraTrabalhador(nomeAluno),nomeAluno)!=null){
                                System.out.println("Digite a nota do modulo");
                                int nota = sc.nextInt();
                                PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(nomeAluno),Modulo.procuraModulo(Trabalhador.procuraTrabalhador(nomeAluno),nomeAluno),nota);
                                break;
                            }
                        }
                    }
                }
                case 2: {
                    System.out.println("Digite o nome do aluno");
                    String nomeAluno = sc.nextLine();
                    if(Trabalhador.procuraTrabalhador(nomeAluno)!=null){
                        System.out.println("Digite o nome do modulo");
                        String nomeModulo = sc.nextLine();
                        if(Modulo.procuraModulo(Trabalhador.procuraTrabalhador(nomeAluno),nomeAluno)!=null){
                            PerfilOperacional.getNotaModuloEspecifico(Trabalhador.procuraTrabalhador(nomeAluno),Modulo.procuraModulo(Trabalhador.procuraTrabalhador(nomeAluno),nomeAluno));
                        }
                    }
                }
                case 3:{
                    System.out.println("Digite o nome do aluno");
                    String nomeAluno = sc.nextLine();
                    if(Trabalhador.procuraTrabalhador(nomeAluno)!=null){
                        PerfilOperacional.getMediaTrabalhador(Trabalhador.procuraTrabalhador(nomeAluno));
                    }
                }
                case 4:{
                    System.out.println("Digite o nome do aluno");
                    String nomeAluno = sc.nextLine();
                    if(Trabalhador.procuraTrabalhador(nomeAluno)!=null){
                        PerfilOperacional.listaNotasAluno(Trabalhador.procuraTrabalhador(nomeAluno));
                    }
                }
            }
        }
    }
}
