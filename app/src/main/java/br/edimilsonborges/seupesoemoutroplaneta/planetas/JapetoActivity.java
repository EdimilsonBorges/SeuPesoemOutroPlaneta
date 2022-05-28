package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class JapetoActivity extends Fragment {

    TextView textViewRJapeto;
    TextView textViewRFJapeto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_japeto,null);

        textViewRJapeto = (TextView)view.findViewById(R.id.textViewRJapeto);
        textViewRFJapeto= (TextView)view.findViewById(R.id.textViewRFJapeto);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(2.186);
        String resultadoForca = calculo.calculoForça();

        textViewRJapeto.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFJapeto.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
