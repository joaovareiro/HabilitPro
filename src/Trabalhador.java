import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Trabalhador {
    private String nometrabalhador;
    private String cpfTrabalhador;
    private EmpresaCliente empresaAssociada;
    private String nomeSetor;
    private String nomeFuncao;
    private LocalDate ultimaFuncao;
    private ArrayList<Trilha> listaTrilhasTrabalhador = new ArrayList<Trilha>();
    private ArrayList<Modulo> listaTrilhas = new ArrayList<Modulo>(); //TODO extrair notas dos modulos dessa lista

    //validar com os metodos de usuario
    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (Usuario.validarCPF(cpfTeste) == true) {
                this.cpfTrabalhador = cpfTeste;
                cpfIncorreto = false;
            } else {
                cpfIncorreto = true;
            }
        }
    }
}
