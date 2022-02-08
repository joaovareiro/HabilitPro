import enums.Status;

public class Modulo {
    private Trilha trilhaAssociada;
    private String nomeModulo;
    private String habilidadesTrabalhadas;
    private String tarefaValidacaoModulo;
    private Status statusModulo;
    //TODO adicionar prazo de validacao
    private int notaModulo;
    private String anotacoesModulo;

    public int getNotaModulo() {
        return notaModulo;
    }
}
