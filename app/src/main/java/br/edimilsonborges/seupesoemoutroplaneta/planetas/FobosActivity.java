package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class FobosActivity extends Fragment {

    TextView textViewRFobos;
    TextView textViewRFFobos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fobos,null);

        textViewRFobos = (TextView)view.findViewById(R.id.textViewRFobos);
        textViewRFFobos = (TextView)view.findViewById(R.id.textViewRFFobos);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.0057);
        String resultadoForca = calculo.calculoForça();

        textViewRFobos.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFFobos.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
