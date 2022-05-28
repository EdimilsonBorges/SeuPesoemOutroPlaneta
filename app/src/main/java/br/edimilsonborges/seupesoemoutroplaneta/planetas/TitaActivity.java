package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class TitaActivity extends Fragment {

    TextView textViewRTita;
    TextView textViewRFTita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tita,null);

        textViewRTita = (TextView)view.findViewById(R.id.textViewRTita);
        textViewRFTita = (TextView)view.findViewById(R.id.textViewRFTita);
        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.352);
        String resultadoForca = calculo.calculoForça();

        textViewRTita.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFTita.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}

