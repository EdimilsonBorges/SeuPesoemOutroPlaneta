package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class TerraActivity extends Fragment {

    TextView textViewRTerra;
    TextView textViewRFTerra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_terra,null);

        textViewRTerra = (TextView) view.findViewById(R.id.textViewRTerra);
        textViewRFTerra = (TextView) view.findViewById(R.id.textViewRFTerra);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(9.780);
        String resultadoForca = calculo.calculoForça();

        textViewRTerra.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFTerra.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
