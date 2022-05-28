package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class MarteActivity extends Fragment {

    TextView textViewRMarte;
    TextView textViewRFMarte;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_marte,null);

        textViewRMarte = (TextView) view.findViewById(R.id.textViewRMarte);
        textViewRFMarte = (TextView) view.findViewById(R.id.textViewRFMarte);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(3.711);
        String resultadoForca = calculo.calculoForça();

        textViewRMarte.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFMarte.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
