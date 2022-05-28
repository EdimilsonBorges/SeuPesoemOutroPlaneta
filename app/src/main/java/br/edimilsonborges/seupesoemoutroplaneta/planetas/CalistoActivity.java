package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class CalistoActivity extends Fragment {

    TextView textViewRCalisto;
    TextView textViewRFCalisto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_calisto,null);

         textViewRCalisto = (TextView)view.findViewById(R.id.textViewRCalisto);
         textViewRFCalisto = (TextView)view.findViewById(R.id.textViewRFCalisto);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.235);
        String resultadoForca = calculo.calculoForça();

        textViewRCalisto.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFCalisto.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
