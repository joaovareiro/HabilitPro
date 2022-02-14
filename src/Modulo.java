import enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
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

    public Modulo(String trilhaAssociada, String nomeModulo, String habilidadesTrabalhadas, String tarefaValidacaoModulo, String anotacoesModulo, String dataInicioModulo, String dataInicioAvaliacao, String dataFimAvalicao) {
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(procuraTrilha(trilhaAssociada)!=null){
            this.trilhaAssociada = procuraTrilha(trilhaAssociada);
        }else{
            solicitarTrilhaValida();
        }
        this.nomeModulo = nomeModulo;
        this.habilidadesTrabalhadas = habilidadesTrabalhadas;
        this.tarefaValidacaoModulo = tarefaValidacaoModulo;
        this.anotacoesModulo = anotacoesModulo;//
        this.dataInicioModulo = OffsetDateTime.from(LocalDate.parse(dataInicioModulo,format).atStartOfDay().atZone(fusoSP));
        this.dataInicioAvaliacao = OffsetDateTime.from(LocalDate.parse(dataInicioModulo,format).atStartOfDay().atZone(fusoSP));
        this.dataFimAvalicao = OffsetDateTime.from(LocalDate.parse(dataFimAvalicao,format).atStartOfDay().atZone(fusoSP)).plusDays(10);
        this.prazoAvaliacao = (int) DAYS.between(this.dataFimAvalicao,this.dataInicioAvaliacao);
        setStatusModulo();
    }

    public void setDataFimAvaliacao(String dataFimAvaliacao){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataFimAvalicao = OffsetDateTime.parse(dataFimAvaliacao,format);
    }
    public void setStatusModulo(){
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
        if (notaModulo >= 1 && notaModulo <=5) {
            this.notaModulo = notaModulo;
            notaInvalida = false;
        }else{
        while(notaInvalida){
            System.out.println("Digite uma nota de 1 a 5");
            int notaTeste = sc.nextInt();
            if (notaTeste >= 1 && notaTeste <=5) {
                this.notaModulo = notaTeste;
                notaInvalida = false;
            } else {
                notaInvalida = true;
                }
            }
        }
    }
}
