package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class SaturnoActivity extends Fragment {

    TextView textViewRSaturno;
    TextView textViewRFSaturno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_saturno,null);

        textViewRSaturno = (TextView) view.findViewById(R.id.textViewRSaturno);
        textViewRFSaturno = (TextView) view.findViewById(R.id.textViewRFSaturno);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(10.44);
        String resultadoForca = calculo.calculoForça();

        textViewRSaturno.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFSaturno.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
