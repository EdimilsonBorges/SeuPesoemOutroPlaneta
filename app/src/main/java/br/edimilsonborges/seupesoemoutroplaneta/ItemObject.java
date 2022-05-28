package br.edimilsonborges.seupesoemoutroplaneta;

/*
 * Created by Edimilson Borges on 28/11/2017.
 */

public class ItemObject {

    private static String versaoCodigo;
    private static String versaoName;

    public ItemObject(String versaoCodigo, String versaoName) {
        this.versaoCodigo = versaoCodigo;
        this.versaoName = versaoName;
    }
    public String getVersaoCodigo() {
        return versaoCodigo;
    }
    public void setVersaoCodigo(String versaoCodigo) {
        this.versaoCodigo = versaoCodigo;
     }
    public String getVersaoName() {
        return versaoName;
    }
    public void setVersaoName(String versaoName) {
        this.versaoName = versaoName;
    }
}

