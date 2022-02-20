import java.util.Scanner;

public class PerfilAdmin extends Usuario{
    public PerfilAdmin(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }

    public static Modulo criaModulos(Trilha trilha){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do modulo");
        String nomeModulo = sc.nextLine();
        System.out.println("Digite as habilidades que vao ser trabalhadas nesse modulo");
        String habilidades = sc.nextLine();
        System.out.println("Digite a descricao da tarefa de avaliacao do modulo");
        String avalicao = sc.nextLine();
        System.out.println("Digite a data de inicio do modulo (no formato dd/mm/aaaa)");
        String dataInicioModulo = sc.nextLine();
        System.out.println("Digite a data de inicio da avaliacao do modulo (no formato dd/mm/aaaa)");
        String dataInicioAvaliacao = sc.nextLine();
        System.out.println("Digite a data do fim da avaliacao do modulo(no formato dd/mm/aaaa)");
        String dataFimAvaliacao = sc.nextLine();
        Modulo m1 = new Modulo(trilha, nomeModulo, habilidades, avalicao, nomeModulo, dataInicioModulo, dataInicioAvaliacao, dataFimAvaliacao);
        return m1;
    }

    public static void listaTrilhas(EmpresaCliente ec) {
        if(ec.getListaTrilhasAssociadas().size()>0){
            for (Trilha a : ec.getListaTrilhasAssociadas()) {
                System.out.println(a.getNomeTrilha());
            }
        }else{
            System.out.println("Essa empresa não possui trilhas associadas");
        }
    }

    public static void listaEmpresas(){
        for(EmpresaCliente a : EmpresaCliente.listaEmpresas){
            System.out.println(a.toString());
        }
    }

    public static void listaModulosTrilha(Trilha t){
        if(t.getListaModulos().size()>0){
            for(Modulo a : t.getListaModulos()){
                System.out.println(a.toString());
            }
        }else{
            System.out.println("Essa trilha não possui modulos asssociados a ela");
        }
    }

    public static void listaTrabalhadores(){
        for(Trabalhador a : Trabalhador.listaTrabalhadores){
            System.out.println(a.toString());
        }
    }

    public static void logTrabalhador(Trabalhador t) {
        for(String a: t.getLogTrabalhador()){
            System.out.println(a);
        }
    }





}
