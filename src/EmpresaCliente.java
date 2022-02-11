import enums.Regional;
import enums.Segmento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpresaCliente {
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private Matriz nomeMatriz;
    private Filial nomeFilial;
    private String nomeCidade;
    private String nomeEstado;
    private Regional regionalAssociada;
    private Segmento segmentoEmpresa;
    private final ArrayList<Trilha> listaTrilhasEmpresa = new ArrayList<Trilha>();

    public static String cnpjFormatado(String cnpjBruto){
        return cnpjBruto.substring(0, 2) + "." + cnpjBruto.substring(2, 5) + "." + cnpjBruto.substring(5, 8) + "."
                + cnpjBruto.substring(8, 12) + "-" + cnpjBruto.substring(12, 14);
    }

    public static boolean isMatriz(String cnpjTeste){
         boolean matriz = false;
        if(EmpresaCliente.cnpjBruto(cnpjTeste).substring(8, 12).equals("0001")){
            matriz = true;
        }
        return matriz;
    }

    //o processo de validação do CNPJ veio da fonte https://www.devmedia.com.br/validando-o-cnpj-em-uma-aplicacao-java/22374
    //estou usando como se fosse um método de uma biblioteca interna
    public static boolean validarCNPJ(String cnpjEntrada) {
        String cnpjValidar = cnpjBruto(cnpjEntrada);

        if (cnpjValidar.equals("00000000000000") || cnpjValidar.equals("11111111111111") ||
                cnpjValidar.equals("22222222222222") || cnpjValidar.equals("33333333333333") ||
                cnpjValidar.equals("44444444444444") || cnpjValidar.equals("55555555555555") ||
                cnpjValidar.equals("66666666666666") || cnpjValidar.equals("77777777777777") ||
                cnpjValidar.equals("88888888888888") || cnpjValidar.equals("99999999999999") ||
                (cnpjValidar.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 2;

            for (i=11; i>=0; i--) {

                num = (int)(cnpjValidar.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(cnpjValidar.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == cnpjValidar.charAt(12)) && (dig14 == cnpjValidar.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public void solicitarCNPJ() {
        Scanner sc = new Scanner(System.in);
        boolean cnpjIncorreto = true;
        while (cnpjIncorreto) {
            System.out.println("Por favor, digite um CNPJ valido");
            String cnpjTeste = sc.next();
            if (validarCNPJ(cnpjTeste) == true) {
                this.cnpjEmpresa = cnpjTeste;
                cnpjIncorreto = false;
            } else {
                cnpjIncorreto = true;
            }
        }
    }


    public static String cnpjBruto(String cnpjFormatado){
        return cnpjFormatado.replaceAll("[^0-9]", "");
    }


    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void addTrilha(Trilha t){
        listaTrilhasEmpresa.add(t);
    }
}
