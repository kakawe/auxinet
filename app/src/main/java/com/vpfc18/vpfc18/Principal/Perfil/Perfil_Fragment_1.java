package com.vpfc18.vpfc18.Principal.Perfil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.vpfc18.vpfc18.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil_Fragment_1 extends Fragment {

    EditText et_perfil_email,et_perfil_contrasena,et_perfil_telefono,et_perfil_nombre,et_perfil_apellido;
    Button btn_perfil_guardar;

    String email,contrasena,nombre,apellido;
    int telefono;
    public Perfil_Fragment_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_perfil_1, container, false);
        et_perfil_email = (EditText)vista.findViewById(R.id.et_perfil_email);
        et_perfil_contrasena = (EditText)vista.findViewById(R.id.et_perfil_contrasena);
        et_perfil_telefono = (EditText)vista.findViewById(R.id.et_perfil_telefono);
        et_perfil_nombre = (EditText)vista.findViewById(R.id.et_perfil_nombre);
        et_perfil_apellido = (EditText)vista.findViewById(R.id.et_perfil_apellido);
        btn_perfil_guardar = (Button) vista.findViewById(R.id.btn_perfil_guardar);

        btn_perfil_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobarCampos()){
                    actualizarDatos();
                }
            }
        });
        return vista;
    }


    private void actualizarDatos(){

    }
    private boolean comprobarCampos(){
        email = et_perfil_email.getText().toString().trim();
        contrasena = et_perfil_contrasena.getText().toString();
        telefono = Integer.parseInt(et_perfil_telefono.getText().toString());
        nombre = et_perfil_nombre.getText().toString();
        apellido = et_perfil_apellido.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            String a= "No puedes dejar el campo correo vacio";
            Toast.makeText(getContext(), a, Toast.LENGTH_LONG).show();
            et_perfil_email.requestFocus();
            return false;
        }
        return true;
    }
}
