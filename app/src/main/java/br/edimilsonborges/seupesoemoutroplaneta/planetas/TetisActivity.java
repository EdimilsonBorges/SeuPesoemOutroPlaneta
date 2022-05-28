package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class TetisActivity extends Fragment {

    TextView textViewRTetis;
    TextView textViewRFTetis;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tetis,null);

        textViewRTetis = (TextView)view.findViewById(R.id.textViewRTetis);
        textViewRFTetis = (TextView)view.findViewById(R.id.textViewRFTetis);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.16);
        String resultadoForca = calculo.calculoForça();

        textViewRTetis.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFTetis.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
