package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class VenusActivity extends Fragment {

    TextView textViewRVenus;
    TextView textViewRFVenus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_venus,null);

        textViewRVenus = (TextView) view.findViewById(R.id.textViewRVenus);
        textViewRFVenus = (TextView) view.findViewById(R.id.textViewRFVenus);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(8.87);
        String resultadoForca = calculo.calculoForça();

        textViewRVenus.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFVenus.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
