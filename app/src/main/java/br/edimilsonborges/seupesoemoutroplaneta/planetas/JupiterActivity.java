package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class JupiterActivity extends Fragment {

    TextView textViewRJupiter;
    TextView textViewRFJupiter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_jupiter,null);

        textViewRJupiter = (TextView) view.findViewById(R.id.textViewRJupiter);
        textViewRFJupiter = (TextView) view.findViewById(R.id.textViewRFJupiter);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(24.79);
        String resultadoForca = calculo.calculoForça();

        textViewRJupiter.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFJupiter.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
