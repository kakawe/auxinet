package com.vpfc18.vpfc18.Inicio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.vpfc18.vpfc18.Principal.Voluntario.Perfil.Voluntario_Perfil_Fragment_2;
import com.vpfc18.vpfc18.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registro_Fragment_1 extends Fragment {

    ImageButton ibtn_registro_ayudar,ibtn_registro_serAyudado;

    public Registro_Fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_registro_1, container, false);
        ibtn_registro_ayudar = (ImageButton)vista.findViewById(R.id.ibtn_registro_ayudar);
        ibtn_registro_serAyudado = (ImageButton)vista.findViewById(R.id.ibtn_registro_serAyudado);

        ibtn_registro_ayudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro2("ayudar");
            }
        });
        ibtn_registro_serAyudado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro2("serAyudado");
            }
        });
        return vista;
    }

    private void registro2(String tipo) {
        Fragment fragmentoSeleccionado = new Registro_Fragment_2();
        FragmentTransaction t = getFragmentManager().beginTransaction();
        t.replace(R.id.contenedor_Inicio, fragmentoSeleccionado);
        t.commit();
        Log.v("Datos",tipo);
    }

}
