import java.util.Scanner;

public class PerfilOperacional extends Usuario{
    public PerfilOperacional(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }
    //avalia (set nota) e emite relatorios(get values do hashmap fazendo uma media geral e tambem lista o conjunto (nome modulo e nota))

    public void avaliaModulo(Modulo m, int notaModulo) {
        Scanner sc = new Scanner(System.in);
        boolean notaInvalida = true;
        if (notaModulo >= 1 && notaModulo <=5) {
            m.setNotaModulo(notaModulo);
        }else{
            while(notaInvalida){
                System.out.println("Digite uma nota de 1 a 5");
                int notaTeste = sc.nextInt();
                if (notaTeste >= 1 && notaTeste <=5) {
                    m.setNotaModulo(notaModulo);
                    notaInvalida = false;
                } else {
                    notaInvalida = true;
                }
            }
        }
    }

    public void getMediaTrabalhador(Trabalhador t){

    }


}
