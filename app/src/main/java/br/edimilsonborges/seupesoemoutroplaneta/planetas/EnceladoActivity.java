package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class EnceladoActivity extends Fragment {

    TextView textViewREncelado;
    TextView textViewRFEncelado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_encelado,null);

        textViewREncelado = (TextView)view.findViewById(R.id.textViewREncelado);
        textViewRFEncelado = (TextView)view.findViewById(R.id.textViewRFEncelado);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(0.117);
        String resultadoForca = calculo.calculoForça();

        textViewREncelado.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFEncelado.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
