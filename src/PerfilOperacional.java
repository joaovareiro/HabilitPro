import java.util.Map;
import java.util.Scanner;

public class PerfilOperacional extends Usuario{
    public PerfilOperacional(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }
    //avalia (set nota) e emite relatorios(get values do hashmap fazendo uma media geral e tambem lista o conjunto (nome modulo e nota))

    public static void avaliaModulo(Trabalhador t, Modulo m, int notaModulo) {
        Scanner sc = new Scanner(System.in);
        boolean notaInvalida = true;
        if (notaModulo >= 1 && notaModulo <=5) {
            Trabalhador.setNotaModulo(t,m,notaModulo);
        }else{
            while(notaInvalida){
                System.out.println("Digite uma nota de 1 a 5");
                int notaTeste = sc.nextInt();
                if (notaTeste >= 1 && notaTeste <=5) {
                    Trabalhador.setNotaModulo(t,m,notaModulo);
                    notaInvalida = false;
                }
            }
        }
    }

    public static void getNotaModuloEspecifico(Trabalhador t, Modulo m){
        System.out.println("A nota do módulo procurado é: " + t.getAtribuicaoModulo().get(m));
    }

    public static void getMediaTrabalhador(Trabalhador t){
        double soma = 0;
        double div = 0;
        for(int a : t.getAtribuicaoModulo().values()){
            soma+=a;
            div++;
        }
        System.out.println("A media do aluno " + t.getNometrabalhador() +" é " + soma/div);
    }

    public static void listaNotasMediaAluno(Trabalhador t){
        for(var a : t.getAtribuicaoModulo().entrySet()){
            System.out.println("Modulo " + a.getKey().getNomeModulo() + " Nota " + a.getValue());
        }
        getMediaTrabalhador(t);
    }

}
