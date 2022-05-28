package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class EuropaActivity extends Fragment {

    TextView textViewREuropa;
    TextView textViewRFEuropa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_europa,null);

        textViewREuropa = (TextView)view.findViewById(R.id.textViewREuropa);
        textViewRFEuropa = (TextView)view.findViewById(R.id.textViewRFEuropa);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.314);
        String resultadoForca = calculo.calculoForça();

        textViewREuropa.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFEuropa.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
