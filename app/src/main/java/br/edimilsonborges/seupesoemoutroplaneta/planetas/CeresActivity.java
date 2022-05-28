package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class CeresActivity extends Fragment {

    TextView textViewRCeres;
    TextView textViewRFCeres;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ceres,null);

        textViewRCeres = (TextView) view.findViewById(R.id.textViewRCeres);
        textViewRFCeres = (TextView) view.findViewById(R.id.textViewRFCeres);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.26);
        String resultadoForca = calculo.calculoForça();

        textViewRCeres.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFCeres.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
