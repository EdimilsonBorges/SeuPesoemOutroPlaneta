package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class DioneActivity extends Fragment {

    TextView textViewRDione;
    TextView textViewRFDione;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dione,null);

        textViewRDione = (TextView)view.findViewById(R.id.textViewRDione);
        textViewRFDione = (TextView)view.findViewById(R.id.textViewRFDione);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.022);
        String resultadoForca = calculo.calculoForça();

        textViewRDione.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFDione.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
