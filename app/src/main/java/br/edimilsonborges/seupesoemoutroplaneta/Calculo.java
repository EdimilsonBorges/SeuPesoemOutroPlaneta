package br.edimilsonborges.seupesoemoutroplaneta;

import android.content.Intent;
import android.os.Bundle;

import java.text.DecimalFormat;

/*
 * Created by Edimilson Borges on 13/02/2017.
 */


public class Calculo {

    private double calculoPeso;
    private double aceleracao;
    private DecimalFormat resultado;
    private static double peso;
    private static double calculoForca;
    private static double setAceleracao;

    public Calculo(){
    }
    void setPeso(double peso,double setAceleracao){
        Calculo.setAceleracao = setAceleracao;
        Calculo.peso = peso;
    }

    public String calculoPeso(double aceleracao) {
        this.aceleracao = aceleracao;

        Calculo.calculoForca = Calculo.peso * aceleracao;
        calculoPeso = Calculo.calculoForca / Calculo.setAceleracao;

        resultado = new DecimalFormat("###,###,##0.00");
        return resultado.format(calculoPeso);
    }

    public String calculoForça() {
        double forca;
        forca = calculoPeso * aceleracao;
        resultado = new DecimalFormat("###,###,##0.00");
        return resultado.format(forca);
    }

}

