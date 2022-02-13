import enums.Status;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Modulo {
    private Trilha trilhaAssociada;
    private String nomeModulo;
    private String habilidadesTrabalhadas;
    private String tarefaValidacaoModulo;
    private Status statusModulo;
    private int prazoAvaliacao = 10;
    private int notaModulo;
    private String anotacoesModulo;
    private OffsetDateTime dataInicioModulo;
    private OffsetDateTime dataInicioAvaliacao;
    private OffsetDateTime dataFimAvalicao;

    public Modulo(String trilhaAssociada, String nomeModulo, String habilidadesTrabalhadas, String tarefaValidacaoModulo, Status statusModulo, int notaModulo, String anotacoesModulo, String dataInicioModulo, String dataInicioAvaliacao, String dataFimAvalicao) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(procuraTrilha(trilhaAssociada)!=null){
            this.trilhaAssociada = procuraTrilha(trilhaAssociada);
        }else{
            solicitarTrilhaValida();
        }
        this.nomeModulo = nomeModulo;
        this.habilidadesTrabalhadas = habilidadesTrabalhadas;
        this.tarefaValidacaoModulo = tarefaValidacaoModulo;
        checkStatusModulo();
        this.notaModulo = notaModulo;
        this.anotacoesModulo = anotacoesModulo;
        this.dataInicioModulo = OffsetDateTime.parse(dataInicioModulo,format);
        this.dataInicioAvaliacao = OffsetDateTime.parse(dataInicioAvaliacao,format);
        this.dataFimAvalicao = OffsetDateTime.parse(dataInicioAvaliacao,format).plusDays(10);
        this.prazoAvaliacao = (int) DAYS.between(this.dataFimAvalicao,this.dataInicioAvaliacao);
    }

    public void setDataFimAvaliacao(String dataFimAvaliacao){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFimAvalicao = OffsetDateTime.parse(dataFimAvaliacao,format);
    }

    public void checkStatusModulo(){
        if(OffsetDateTime.now().isBefore(dataInicioModulo)){
            this.statusModulo = Status.CursoNaoIniciado;
        }else if(OffsetDateTime.now().isAfter(dataInicioModulo) && OffsetDateTime.now().isBefore(dataInicioAvaliacao)){
            this.statusModulo = Status.EmAndamento;
        }else if(OffsetDateTime.now().isAfter(dataInicioAvaliacao) && OffsetDateTime.now().isBefore(dataFimAvalicao)){
            this.statusModulo = Status.EmAvaliacao;
        }else{
            this.statusModulo = Status.AvaliaaoFinalizada;
        }
    }

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
