package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class UranoActivity extends Fragment {

    TextView textViewRUrano;
    TextView textViewRFUrano;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_urano,null);

        textViewRUrano = (TextView) view.findViewById(R.id.textViewRUrano);
        textViewRFUrano = (TextView) view.findViewById(R.id.textViewRFUrano);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(8.69);
        String resultadoForca = calculo.calculoForça();

        textViewRUrano.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFUrano.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
