public class PerfilAdmin extends Usuario{
    public PerfilAdmin(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }

    //realiza cadastros gerais e relatorios (lista trilhas, ocupacoes, empresas e funcionarios)

    public static void listaTrilhas(EmpresaCliente ec) {
        for (Trilha a : ec.getListaTrilhasAssociadas()) {
            System.out.println(a.getNomeTrilha());
        }
    }

    public static void listaOcupacoes() {
        for (Ocupacao a : Trilha.listaOcupacoes) {
            System.out.println(a.getNomeOcupacao());
        }
    }

    public static void listaEmpresas(){
        for(EmpresaCliente a : EmpresaCliente.listaEmpresas){
            System.out.println(a.toString());
        }
    }

    public static void listaModulosTrilha(Trilha t){
        for(Modulo a : t.getListaModulos()){
            System.out.println(a.toString());
        }
    }

    public static void listaTrabalhadores(){
        for(Trabalhador a : Trabalhador.listaTrabalhadores){
            System.out.println(a.toString());
        }
    }



}
