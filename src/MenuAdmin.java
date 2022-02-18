import java.util.Objects;
import java.util.Scanner;

public class MenuAdmin {
    public static void MenuAdmin(Usuario u) {
        //TODO Adicionar formas de criar contas!!!!
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        int op;
        while (a){
        System.out.println("-------HabilitPro-------");
        System.out.println("""
                    Selecione uma opcao:\s
                    1 - Cadastra uma empresa
                    2 - Cadastra uma Trilha
                    3 - Cadastra um modulo
                    4 - Cadastrar um trabalhador
                    5 - Alterar a funcao de um trabalhador""");
        op = sc.nextInt();
        switch (op){
            case 1: {
                System.out.println("Digite o CNPJ da empresa:");
                sc.nextLine();
                String cnpjEntrada = sc.nextLine();
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
                Trilha t1 = new Trilha(EmpresaCliente.procuraEmpresa(nomeEmpresa),nomeOcupacao,anotacoes);
                break;
            }
            case 3:{
                System.out.println("Digite o nome da Trilha");
                sc.nextLine();
                String nomeTrilha = sc.nextLine();
                System.out.println("Digite o nome do modulo");
                String nomeModulo = sc.nextLine();
                System.out.println("Digite as habilidades que vao ser trabalhadas nesse modulo");
                String habilidades = sc.nextLine();
                System.out.println("Digite a descricao da tarefa de avaliacao do modulo");
                String avalicao = sc.nextLine();
                System.out.println("Digite as anotações da trilha");
                String anotacoes = sc.nextLine();
                System.out.println("Digite a data de inicio do modulo (no formato dd/mm/aaaa)");
                String dataInicioModulo = sc.nextLine();
                System.out.println("Digite a data de inicio da avaliacao do modulo (no formato dd/mm/aaaa)");
                String dataInicioAvaliacao = sc.nextLine();
                System.out.println("Digite a data do fim da avaliacao do modulo(no formato dd/mm/aaaa)");
                String dataFimAvaliacao = sc.nextLine();
                Modulo m1 = new Modulo(Modulo.procuraTrilha(nomeTrilha),nomeModulo,habilidades,avalicao,nomeModulo,dataInicioModulo,dataInicioAvaliacao,dataFimAvaliacao);
                break;
            }
            case 4:{
                System.out.println("Digite o nome do Aluno");
                sc.nextLine();
                String nomeTrabalhador = sc.nextLine();
                System.out.println("Digite o cpf do trabalhador");
                String cpfTrabalhador = sc.nextLine();
                System.out.println("Digite o nome da empresa do trabalhador");
                String nomeEmpresa = sc.nextLine();
                System.out.println("Digite o nome do setor do trabalhador");
                String nomeSetor = sc.nextLine();
                System.out.println("Digite o fome da funcao exercida pelo trabalhador");
                String nomeFuncao = sc.nextLine();
                Trabalhador t1 = new Trabalhador(nomeTrabalhador,cpfTrabalhador,EmpresaCliente.procuraEmpresa(nomeEmpresa),nomeSetor,nomeFuncao);
                break;
            }
            case 5:{
                System.out.println("Digite o cpf do trabalhador");
                sc.nextLine();
                String cpfTrabalhador = sc.nextLine();
                System.out.println("Digite o nome da nova funcao do trabalhador");
                String novaFuncao = sc.nextLine();
                Objects.requireNonNull(Trabalhador.procuraTrabalhador(cpfTrabalhador)).alteraFuncao(novaFuncao);
                break;
            } case 6:{
                a = false;
                break;
            }
        }
    }
}
}


