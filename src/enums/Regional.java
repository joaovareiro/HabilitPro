package enums;

public enum Regional {

    AltoUruguaiCatarinense("Alto Uruguai Catarinense"),AltoValeItajai("Alto Vale do Itajaí"),
    CentroNorte("Centro-Norte"), CentroOeste("Centro-Oeste"),  ExtremoOeste("Extremo Oeste"),
    FozRioItajai("Foz do Rio Itajaí"), LitoralSul("Litoral Sul"), NorteNordeste("Norte-Nordeste"),
    Oeste("Oeste"), PlanaltoNorte("Planalto Norte"), SerraCatarinense("Serra Catarinense"),
    Sudeste("Sudeste"), Sul("Sul"), ValeItajai("Vale do Itajaí"),
    ValeItajaiMirim("Vale do Itajaí Mirim"), ValeItapocu("Vale do Itapocu");
    private String nomeRegional;

    Regional(String nomeRegional) {
        this.nomeRegional = nomeRegional;
    }
}
