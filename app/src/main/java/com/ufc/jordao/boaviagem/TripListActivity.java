package com.ufc.jordao.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ufc.jordao.boaviagem.controller.ViagemController;
import com.ufc.jordao.boaviagem.model.Viagem;
import com.ufc.jordao.boaviagem.repository.ViagemRepository;

import java.util.ArrayList;
import java.util.List;

public class TripListActivity extends Activity {

    ViagemController viagemController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);

        viagemController = new ViagemController();

        ArrayList<Viagem> listaViagens = viagemController.getAll();
        ListView lista = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Viagem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaViagens);

        lista.setAdapter(adapter);
    }

    public void onClickBreadcrumb(View v){
        switch (v.getId()){
            case R.id.toHomeBreadcrumb:
                Intent tripListActivity = new Intent(TripListActivity.this, HomeActivity.class);
                startActivity(tripListActivity);
                break;
        }
    }
}
