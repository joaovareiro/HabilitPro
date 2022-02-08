import enums.Regional;
import enums.Segmento;

import java.util.ArrayList;

public class EmpresaCliente {
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private Matriz nomeMatriz;
    private Filial nomeFilial;
    private String nomeCidade;
    private String nomeEstado;
    private Regional regionalAssociada;
    private Segmento segmentoEmpresa;
    private ArrayList<Trilha> listaTrilhasEmpresa = new ArrayList<Trilha>();
}
