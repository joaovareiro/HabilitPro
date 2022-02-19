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
                    String cpfAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    if (Trabalhador.procuraTrabalhador(cpfAluno) == null) {
                        while (true) {
                            System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                                if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfTeste), nomeModulo) == null) {
                                    while (true) {
                                        System.out.println("Digite um modulo válido");
                                        String moduloTeste = sc.nextLine();
                                        if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfTeste), moduloTeste) != null) {
                                            if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)), moduloTeste).getStatusModulo().equals(Status.CursoNaoIniciado)) {
                                                System.out.println("O modelo não pode ser avaliado pois ele ainda não começou");
                                            } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)), moduloTeste).getStatusModulo().equals(Status.AvaliacaoFinalizada)) {
                                                System.out.println("A avaliação deste módulo já foi finalizada");
                                            } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)), moduloTeste).getStatusModulo().equals(Status.EmAndamento)) {
                                                System.out.println("O curso ainda não está na fase de avaliação");
                                            } else {
                                                System.out.println("Digite a nota do modulo");
                                                int nota = sc.nextInt();
                                                PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(cpfTeste), Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfTeste)), moduloTeste), nota);
                                            }
                                            break;
                                        }
                                    }

                                }
                                break;
                            }
                        }
                        break;
                    }else if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfAluno), nomeModulo) == null) {
                        while (true) {
                            System.out.println("Digite um modulo válido");
                            String moduloTeste = sc.nextLine();
                            if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfAluno), moduloTeste) != null) {
                                if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), moduloTeste).getStatusModulo().equals(Status.CursoNaoIniciado)) {
                                    System.out.println("O modelo não pode ser avaliado pois ele ainda não começou");
                                } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), moduloTeste).getStatusModulo().equals(Status.AvaliacaoFinalizada)) {
                                    System.out.println("A avaliação deste módulo já foi finalizada");
                                } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), moduloTeste).getStatusModulo().equals(Status.EmAndamento)) {
                                    System.out.println("O curso ainda não está na fase de avaliação");
                                } else {
                                    System.out.println("Digite a nota do modulo");
                                    int nota = sc.nextInt();
                                    PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(cpfAluno), Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)), moduloTeste), nota);
                                }
                                break;
                            }
                        }
                    }else{
                        if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo).getStatusModulo().equals(Status.CursoNaoIniciado)) {
                            System.out.println("O modelo não pode ser avaliado pois ele ainda não começou");
                        } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo).getStatusModulo().equals(Status.AvaliacaoFinalizada)) {
                            System.out.println("A avaliação deste módulo já foi finalizada");
                        } else if (Modulo.procuraModulo(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo).getStatusModulo().equals(Status.EmAndamento)) {
                            System.out.println("O curso ainda não está na fase de avaliação");
                        } else {
                            System.out.println("Digite a nota do modulo");
                            int nota = sc.nextInt();
                            PerfilOperacional.avaliaModulo(Trabalhador.procuraTrabalhador(cpfAluno), Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo), nota);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                    sc.nextLine();
                    String cpfAluno = sc.nextLine();
                    System.out.println("Digite o nome do modulo");
                    String nomeModulo = sc.nextLine();
                    if (Trabalhador.procuraTrabalhador(cpfAluno) == null) {
                        while (true) {
                            System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                                if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfTeste), nomeModulo) == null) {
                                    while (true) {
                                        System.out.println("Digite um modulo válido");
                                        String moduloTeste = sc.nextLine();
                                        if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfTeste), moduloTeste) != null) {
                                            (Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfTeste)), moduloTeste)).setStatusModulo();
                                            PerfilOperacional.getNotaModuloEspecifico((Trabalhador.procuraTrabalhador(cpfTeste)),Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfTeste)),moduloTeste));
                                            break;
                                        }
                                    }
                                }else{
                                    PerfilOperacional.getNotaModuloEspecifico((Trabalhador.procuraTrabalhador(cpfTeste)),Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfTeste)),nomeModulo));
                                }
                                break;
                            }
                        }
                    }else if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfAluno), nomeModulo) == null) {
                        while (true) {
                            System.out.println("Digite um modulo válido");
                            String moduloTeste = sc.nextLine();
                            if (Modulo.procuraModulo(Trabalhador.procuraTrabalhador(cpfAluno), moduloTeste) != null) {
                                (Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)), moduloTeste)).setStatusModulo();
                                PerfilOperacional.getNotaModuloEspecifico((Trabalhador.procuraTrabalhador(cpfAluno)),Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)),moduloTeste));
                                break;
                            }
                        }
                    }else{
                        (Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)), nomeModulo)).setStatusModulo();
                        PerfilOperacional.getNotaModuloEspecifico((Trabalhador.procuraTrabalhador(cpfAluno)),Modulo.procuraModulo((Trabalhador.procuraTrabalhador(cpfAluno)),nomeModulo));

                    }
                    break;
                }
            case 3:{
                System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                sc.nextLine();
                String cpfAluno = sc.nextLine();
                if(Trabalhador.procuraTrabalhador(cpfAluno) == null) {
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                            PerfilOperacional.getMediaTrabalhador(Trabalhador.procuraTrabalhador(cpfTeste));
                            break;
                        }
                    }
                }else{
                    PerfilOperacional.getMediaTrabalhador(Trabalhador.procuraTrabalhador(cpfAluno));
                }
                break;
            }case 4:{
                System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                sc.nextLine();
                String cpfAluno = sc.nextLine();
                    if(Trabalhador.procuraTrabalhador(cpfAluno) == null) {
                        while (true) {
                            System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                            String cpfTeste = sc.nextLine();
                            if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                                PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)));
                                break;
                            }
                        }
                    }else{
                        PerfilOperacional.listaNotasMediaAluno(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)));
                    }
                break;
            }
            case 5:{
                System.out.println("Digite o cpf do aluno (no formato xxx.xxx.xxx-xx)");
                sc.nextLine();
                String cpfAluno = sc.nextLine();
                if(Trabalhador.procuraTrabalhador(cpfAluno) == null) {
                    while (true) {
                        System.out.println("Digite o cpf de um trabalhador válido (no formato xxx.xxx.xxx-xx)");
                        String cpfTeste = sc.nextLine();
                        if (Trabalhador.procuraTrabalhador(cpfTeste) != null) {
                            PerfilOperacional.getTrilhasTrbalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTeste)));
                            break;
                        }
                    }
                }else{
                    PerfilOperacional.getTrilhasTrbalhador(Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfAluno)));
                }
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
