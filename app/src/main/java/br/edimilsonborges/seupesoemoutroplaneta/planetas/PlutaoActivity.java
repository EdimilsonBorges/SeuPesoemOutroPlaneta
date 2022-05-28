package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class PlutaoActivity extends Fragment {

    TextView textViewRPlutao;
    TextView textViewRFPlutao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plutao,null);

        textViewRPlutao = (TextView) view.findViewById(R.id.textViewRPlutao);
        textViewRFPlutao = (TextView) view.findViewById(R.id.textViewRFPlutao);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.658);
        String resultadoForca = calculo.calculoForça();

        textViewRPlutao.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFPlutao.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
