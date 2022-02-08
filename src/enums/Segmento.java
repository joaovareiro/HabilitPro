package enums;

public enum Segmento {

    AlimentosBebidas("Alimentos e Bebidas"),CelulosPapel("Celulos e Papel"),
    Construcao("Construção"), EquipamentosEletricos("Equipamentos elétricos"),
    FarmacosEquipamentosSaude("Fármacos e Equipamentos de Saúde"), Fumo("Fumo"),
    Automotiva("Indústria Autotiva"), Ceramica("Indústria Cerâmica"),
    Diversa("Indústria Diversa"), Extrativa("Indústria Extrativa"),
    Grafica("Indústria Gráfica"), MadeiraMoveis("Madeira e Móveis"),
    MaquinasEquipamentos("Máquinas e equipamentos"), MetalmecanicaMetaluriga("Metalmecânica e Metalurgia"),
    OleoGasEletricidade("Óleo,Gás e Eletricidade"), QuimicosPlasticos("Produtos Quḿicos e Plásticos"),
    SaneamentoBasico("Saneamento básico"), TIC("TIC"), TextilConfeccaoCouroCalcados("Textil, Confecção, Couro e Calçados");

    private String nomeSegmento;

    Segmento(String nomeSegmento){
        this.nomeSegmento = nomeSegmento;
    }
}
