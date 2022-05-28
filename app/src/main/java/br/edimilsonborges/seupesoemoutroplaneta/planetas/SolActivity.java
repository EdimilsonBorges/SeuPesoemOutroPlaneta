package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class SolActivity extends Fragment {

    TextView textViewRSol;
    TextView textViewRFSol;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sol,null);

        textViewRSol = (TextView) view.findViewById(R.id.textViewRSol);
        textViewRFSol = (TextView) view.findViewById(R.id.textViewRFSol);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(274.13);
        String resultadoForca = calculo.calculoForça();

        textViewRSol.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFSol.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
