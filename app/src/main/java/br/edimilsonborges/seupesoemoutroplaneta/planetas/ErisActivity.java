package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class ErisActivity extends Fragment {

    TextView textViewREris;
    TextView textViewRFEris;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_eris,null);

        textViewREris = (TextView) view.findViewById(R.id.textViewREris);
        textViewRFEris = (TextView) view.findViewById(R.id.textViewRFEris);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.82);
        String resultadoForca = calculo.calculoForça();

        textViewREris.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFEris.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
