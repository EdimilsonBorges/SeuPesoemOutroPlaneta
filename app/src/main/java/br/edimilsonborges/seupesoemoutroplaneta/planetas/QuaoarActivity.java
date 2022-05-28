package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class QuaoarActivity extends Fragment {

    TextView textViewRQuaoar;
    TextView textViewRFQuaoar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_quaoar,null);

        textViewRQuaoar = (TextView) view.findViewById(R.id.textViewRQuaoar);
        textViewRFQuaoar = (TextView) view.findViewById(R.id.textViewRFQuaoar);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.17);
        String resultadoForca = calculo.calculoForça();

        textViewRQuaoar.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFQuaoar.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}