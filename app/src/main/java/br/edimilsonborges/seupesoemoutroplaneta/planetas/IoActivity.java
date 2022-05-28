package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class IoActivity extends Fragment {

    TextView textViewRIo;
    TextView textViewRFIo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_io,null);

        textViewRIo = (TextView)view.findViewById(R.id.textViewRIo);
        textViewRFIo = (TextView)view.findViewById(R.id.textViewRFIo);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.794);
        String resultadoForca = calculo.calculoForça();

        textViewRIo.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFIo.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
