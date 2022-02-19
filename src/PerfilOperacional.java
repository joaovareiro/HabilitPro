import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PerfilOperacional extends Usuario{

    public PerfilOperacional(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }

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
        if(t.getAtribuicaoModulo().get(m) != null) {
            System.out.println("A nota do módulo procurado é: " + t.getAtribuicaoModulo().get(m));
        }else{
            System.out.println("Esse módulo não tem nota");
        }
    }

    public static void getTrilhasTrbalhador(Trabalhador t){
        if(t.getListaTrilhasTrabalhador().size()>0){
            for(Trilha a :t.getListaTrilhasTrabalhador()){
                System.out.println(a.getNomeTrilha());
            }
        }else{
            System.out.println("O trabalhador não tem trilhas atribuidas a ele");
        }
    }

    public static void getMediaTrabalhador(Trabalhador t){
        double soma = 0;
        double div = 0;

        HashMap<Modulo, Integer> mapaValoresMedia = new HashMap<>(t.getAtribuicaoModulo());
        mapaValoresMedia.values().removeAll(Collections.singleton(null));
        for (int a : mapaValoresMedia.values()) {
            soma += a;
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
