package br.edimilsonborges.seupesoemoutroplaneta.planetas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edimilsonborges.seupesoemoutroplaneta.Calculo;
import br.edimilsonborges.seupesoemoutroplaneta.R;

public class LuaActivity extends Fragment {

    TextView textViewRLua;
    TextView textViewRFLua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lua,null);

        textViewRLua = (TextView) view.findViewById(R.id.textViewRLua);
        textViewRFLua = (TextView) view.findViewById(R.id.textViewRFLua);

        Calculo calculo = new Calculo();

        String resultadoPeso = calculo.calculoPeso(1.622);
        String resultadoForca = calculo.calculoForça();

        textViewRLua.setText(resultadoPeso +" "+ getString(R.string.kg));
        textViewRFLua.setText(resultadoForca +" "+ getString(R.string.newton));

        return (view);
    }
}
