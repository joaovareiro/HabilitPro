import enums.Status;

import java.time.LocalDate;
import java.util.Scanner;

public class Modulo {
    private Trilha trilhaAssociada;
    private String nomeModulo;
    private String habilidadesTrabalhadas;
    private String tarefaValidacaoModulo;
    private Status statusModulo;
    private LocalDate prazoAvaliacao;
    private int notaModulo;
    private String anotacoesModulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public static Trilha procuraTrilha(String apelido) {
        for (Trilha a : Trilha.listaTrilhasGeral) {
            if(a.getApelido().equals(apelido))
                return a;
        }
        return null;
    }

    public void solicitarTrilhaValida() {
        Scanner sc = new Scanner(System.in);
        boolean trilhaInvalida = true;
        while (trilhaInvalida) {
            System.out.println("Por favor, digite um numero sequencial valido");
            String apelidoTeste = sc.next();
            if (procuraTrilha(apelidoTeste)!=null) {
                this.trilhaAssociada = procuraTrilha(apelidoTeste);
                trilhaInvalida = false;
            } else {
                trilhaInvalida = true;
            }
        }
    }

    public int getNotaModulo() {
        return notaModulo;
    }

    public void setNotaModulo(int notaModulo) {
        Scanner sc = new Scanner(System.in);
        boolean notaInvalida = true;
        while(notaInvalida){
            System.out.println("Digite uma nota de 1 a 5");
            int notaTeste = sc.nextInt();
            if (notaTeste >= 1 && notaTeste <=5) {
                this.notaModulo = notaModulo;
                notaInvalida = false;
            } else {
                notaInvalida = true;
            }
        }
    }

}
