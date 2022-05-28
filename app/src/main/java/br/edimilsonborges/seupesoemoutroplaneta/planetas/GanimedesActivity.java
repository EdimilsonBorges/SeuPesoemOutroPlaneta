package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class GanimedesActivity extends Fragment {

    TextView textViewRGanimedes;
    TextView textViewRFGanimedes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ganimedes,null);

        textViewRGanimedes = (TextView)view.findViewById(R.id.textViewRGanimedes);
        textViewRFGanimedes = (TextView)view.findViewById(R.id.textViewRFGanimedes);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.428);
        String resultadoForca = calculo.calculoForça();

        textViewRGanimedes.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFGanimedes.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
