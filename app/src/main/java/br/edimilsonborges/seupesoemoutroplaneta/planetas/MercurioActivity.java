package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class MercurioActivity extends Fragment {

    TextView textViewRMercurio;
    TextView textViewRFMercurio;
    Calculo calculo = new Calculo();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mercurio,null);

        textViewRMercurio = (TextView) view.findViewById(R.id.textViewRMercurio);
        textViewRFMercurio = (TextView) view.findViewById(R.id.textViewRFMercurio);

        calcular();

        return (view);
    }

    private void calcular (){

        String resultadoPeso = calculo.calculoPeso(3.78);
        String resultadoForca = calculo.calculoForça();

        textViewRMercurio.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFMercurio.setText(resultadoForca +" "+ getString(R.string.newton));
    }
}

