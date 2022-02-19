public class PerfilAdmin extends Usuario{
    public PerfilAdmin(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        super(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario);
    }

    public static void listaTrilhas(EmpresaCliente ec) {
        if(ec.getListaTrilhasAssociadas().size()>0){
            for (Trilha a : ec.getListaTrilhasAssociadas()) {
                System.out.println(a.getNomeTrilha());
            }
        }else{
            System.out.println("Essa empresa não possui trilhas associadas");
        }
    }

    public static void listaEmpresas(){
        for(EmpresaCliente a : EmpresaCliente.listaEmpresas){
            System.out.println(a.toString());
        }
    }

    public static void listaModulosTrilha(Trilha t){
        if(t.getListaModulos().size()>0){
            for(Modulo a : t.getListaModulos()){
                System.out.println(a.toString());
            }
        }else{
            System.out.println("Essa trilha não possui modulos asssociados a ela");
        }
    }

    public static void listaTrabalhadores(){
        for(Trabalhador a : Trabalhador.listaTrabalhadores){
            System.out.println(a.toString());
        }
    }

    public static void logTrabalhador(Trabalhador t) {
        for(String a: t.getLogTrabalhador()){
            System.out.println(a);
        }
    }





}
