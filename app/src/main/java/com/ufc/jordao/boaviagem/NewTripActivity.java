package com.ufc.jordao.boaviagem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class NewTripActivity extends Activity implements Button.OnClickListener {

    private Button dataChegadaButton;
    private Button dataSaidaButton;

    static final int DATE_DIALOG_ID = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);
        dataChegadaButton = (Button) findViewById(R.id.dataChegada);
        dataSaidaButton = (Button) findViewById(R.id.dataSaida);
        dataChegadaButton.setOnClickListener(this);
        dataSaidaButton.setOnClickListener(this);
    }

    public void onClickBreadcrumb(View v){
        switch (v.getId()){
            case R.id.toHomeBreadcrumb:
                Intent newTripActivity = new Intent(NewTripActivity.this, HomeActivity.class);
                startActivity(newTripActivity);
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
            case R.id.dataChegada:
                return new DatePickerDialog(this, dataChegadaListener, ano, mes, dia);
            case R.id.dataSaida:
                return new DatePickerDialog(this, dataSaidaListener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dataSaidaListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Date date = new Date(year - 1900, monthOfYear, dayOfMonth);
            SimpleDateFormat sd1 = new SimpleDateFormat("dd/MMM/yyyy");
            dataSaidaButton.setText(sd1.format(date));
        }
    };

    private DatePickerDialog.OnDateSetListener dataChegadaListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Date date = new Date(year - 1900, monthOfYear, dayOfMonth);
            SimpleDateFormat sd1 = new SimpleDateFormat("dd/MMM/yyyy");
            dataChegadaButton.setText(sd1.format(date));
        }
    };

    @Override
    public void onClick(View v) {
        if (v == dataChegadaButton)
            showDialog(R.id.dataChegada);
        else if (v == dataSaidaButton)
            showDialog(R.id.dataSaida);
    }
}
