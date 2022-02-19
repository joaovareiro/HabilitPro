import enums.Status;

import java.time.LocalDate;
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
    private String anotacoesModulo;
    private OffsetDateTime dataInicioModulo;
    private OffsetDateTime dataInicioAvaliacao;
    private OffsetDateTime dataFimAvalicao;

    public Modulo(Trilha trilhaAssociada, String nomeModulo, String habilidadesTrabalhadas, String tarefaValidacaoModulo, String anotacoesModulo, String dataInicioModulo, String dataInicioAvaliacao, String dataFimAvalicao) {
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.trilhaAssociada = trilhaAssociada;
        this.nomeModulo = nomeModulo;
        this.habilidadesTrabalhadas = habilidadesTrabalhadas;
        this.tarefaValidacaoModulo = tarefaValidacaoModulo;
        this.anotacoesModulo = anotacoesModulo;
        this.dataInicioModulo = OffsetDateTime.from(LocalDate.parse(dataInicioModulo,format).atStartOfDay().atZone(fusoSP));
        this.dataInicioAvaliacao = OffsetDateTime.from(LocalDate.parse(dataInicioAvaliacao,format).atStartOfDay().atZone(fusoSP));
        this.dataFimAvalicao = OffsetDateTime.from(LocalDate.parse(dataFimAvalicao,format).atStartOfDay().atZone(fusoSP));
        this.prazoAvaliacao = (int) DAYS.between(this.dataInicioAvaliacao,this.dataFimAvalicao);
        setStatusModulo();
        Trilha.addModulo(trilhaAssociada,this);
    }

    public Status getStatusModulo() {
        return statusModulo;
    }

    public void setStatusModulo(){
        if(OffsetDateTime.now().isBefore(dataInicioModulo)){
            this.statusModulo = Status.CursoNaoIniciado;
        }else if(OffsetDateTime.now().isAfter(dataInicioModulo) && OffsetDateTime.now().isBefore(dataInicioAvaliacao)){
            this.statusModulo = Status.EmAndamento;
        }else if(OffsetDateTime.now().isAfter(dataInicioAvaliacao) && OffsetDateTime.now().isBefore(dataFimAvalicao)){
            this.statusModulo = Status.EmAvaliacao;
        }else{
            this.statusModulo = Status.AvaliacaoFinalizada;
        }
    }

    public static Trilha procuraTrilha(String apelido) {
        for (Trilha a : Trilha.listaTrilhasGeral) {
            if(a.getNomeTrilha().equals(apelido))
                return a;
        }
        return null;
    }

    public static Modulo procuraModulo(Trabalhador t, String nomeModulo) {
        for (Modulo a : t.getAtribuicaoModulo().keySet()) {
            if(a.getNomeModulo().equals(nomeModulo))
                return a;
        }
        return null;
    }

    public String getNomeModulo() {
        return nomeModulo;
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

    @Override
    public String toString() {
        return trilhaAssociada + " " + nomeModulo + " " + habilidadesTrabalhadas + " " +  tarefaValidacaoModulo + " " + statusModulo + " " + prazoAvaliacao + " " + anotacoesModulo + " " + dataInicioModulo + " " + dataInicioAvaliacao + " " + dataFimAvalicao;
    }
}
