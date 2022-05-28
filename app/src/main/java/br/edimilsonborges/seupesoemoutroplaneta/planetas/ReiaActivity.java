package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class ReiaActivity extends Fragment {

    TextView textViewRReia;
    TextView textViewRFReia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reia,null);

        textViewRReia = (TextView)view.findViewById(R.id.textViewRReia);
        textViewRFReia = (TextView)view.findViewById(R.id.textViewRFReia);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(2.588);
        String resultadoForca = calculo.calculoForça();

        textViewRReia.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFReia.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
