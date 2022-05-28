package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class NetunoActivity extends Fragment {

    TextView textViewRNetuno;
    TextView textViewRFNetuno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_netuno,null);

        textViewRNetuno = (TextView) view.findViewById(R.id.textViewRNetuno);
        textViewRFNetuno = (TextView) view.findViewById(R.id.textViewRFNetuno);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(11.15);
        String resultadoForca = calculo.calculoForça();

        textViewRNetuno.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFNetuno.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
