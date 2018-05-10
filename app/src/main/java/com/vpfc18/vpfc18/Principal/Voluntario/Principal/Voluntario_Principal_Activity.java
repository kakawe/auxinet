package com.vpfc18.vpfc18.Principal.Voluntario.Principal;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.vpfc18.vpfc18.Principal.Voluntario.Perfil.Voluntario_Perfil_Fragment;
import com.vpfc18.vpfc18.R;

public class Voluntario_Principal_Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar voluntario_principal_toolbar;
    int contador=0;
    int perfil = 0;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voluntario_activity_principal);

        voluntario_principal_toolbar =(android.support.v7.widget.Toolbar) findViewById(R.id.voluntario_principal_toolbar);
        setSupportActionBar(voluntario_principal_toolbar);
        voluntario_principal_toolbar.setNavigationIcon(R.drawable.ic_perfil);
        cargaMapa();
        voluntario_principal_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (perfil==0){
                    cargaPerfil();
                }else{
                    cargaMapa();
                }

            }
        });
    }

    //Para poder colocar el menu en la action bar, tenemos que añadir este método e inflar el recurso
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.barra_superior,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Para añadir el método cuando presione el menu derecho
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_derecho:
                if (contador==0){
                    Log.v("clic11",String.valueOf(item.getGroupId()));
                    contador=1;
                    item.setIcon(R.drawable.ic_map);
                    cargaLista();
                }else{
                    contador=0;
                    item.setIcon(R.drawable.ic_notificacion);
                    cargaMapa();

                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cargaMapa(){
        perfil=0;
        voluntario_principal_toolbar.setNavigationIcon(R.drawable.ic_perfil);
        getSupportActionBar().setTitle("Mapa eventos");
        Fragment fragmentoSeleccionado = new Voluntario_Mapa_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.voluntario_contenedor_principal, fragmentoSeleccionado);
        t.commit();
    }
    private void cargaLista(){
        perfil=0;
        voluntario_principal_toolbar.setNavigationIcon(R.drawable.ic_perfil);
        getSupportActionBar().setTitle("Listado eventos");
        Fragment fragmentoSeleccionado = new Voluntario_Listado_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.voluntario_contenedor_principal, fragmentoSeleccionado);
        t.commit();
    }
    private void cargaPerfil(){
        perfil=1;
        voluntario_principal_toolbar.setNavigationIcon(R.drawable.ic_vacio);
        getSupportActionBar().setTitle("Perfil Usuario");
        Fragment fragmentoSeleccionado = new Voluntario_Perfil_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        t.replace(R.id.voluntario_contenedor_principal, fragmentoSeleccionado);
        t.commit();
    }
}
