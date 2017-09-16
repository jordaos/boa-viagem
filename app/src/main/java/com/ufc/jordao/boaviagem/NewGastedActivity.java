package com.ufc.jordao.boaviagem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.ufc.jordao.boaviagem.repository.ViagemRepository;

public class NewGastedActivity extends Activity implements View.OnClickListener {

    private Spinner categoria;
    private Spinner local;
    private Button dataGasto;

    static final int DATE_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gasted);

        ArrayAdapter<CharSequence> adapter = null;
        adapter = ArrayAdapter.createFromResource(this, R.array.categoria_gasto,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoria = (Spinner) findViewById(R.id.categoria);
        categoria.setAdapter(adapter);

       /*
        ViagemRepository viagemRepository = null;
        ArrayList<String> destinos = viagemRepository.getAllDestinos();
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, destinos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        local = (Spinner) findViewById(R.id.local);
        local.setAdapter(adapter2);*/

        dataGasto = (Button) findViewById(R.id.dataGasto);
        dataGasto.setOnClickListener(this);
    }

    public void onClickBreadcrumb(View v){
        switch (v.getId()){
            case R.id.toHomeBreadcrumb:
                Intent newGastedActivity = new Intent(NewGastedActivity.this, HomeActivity.class);
                startActivity(newGastedActivity);
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.dataGasto:
                return new DatePickerDialog(this, dataGastoListener, ano, mes, dia);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dataGastoListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Date date = new Date(year - 1900, monthOfYear, dayOfMonth);
            SimpleDateFormat sd1 = new SimpleDateFormat("dd/MMM/yyyy");
            dataGasto.setText(sd1.format(date));
        }
    };

    @Override
    public void onClick(View view) {
        if (view == dataGasto)
            showDialog(R.id.dataGasto);
    }
}