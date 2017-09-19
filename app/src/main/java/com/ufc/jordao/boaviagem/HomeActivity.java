package com.ufc.jordao.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ufc.jordao.boaviagem.controller.ViagemController;
import com.ufc.jordao.boaviagem.model.Gasto;
import com.ufc.jordao.boaviagem.model.TipoGasto;
import com.ufc.jordao.boaviagem.model.TipoViagem;
import com.ufc.jordao.boaviagem.model.Viagem;

import java.util.Date;

/**
 * Created by jordao on 09/09/17.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* FOR TESTS */
        ViagemController viagemController = new ViagemController();
        Viagem viagem1 = new Viagem("Madalena", TipoViagem.LAZER, new Date(2017, 8, 10), new Date(2017, 8, 10), 1000.0, 5);
        Viagem viagem2 = new Viagem("Banabuiu", TipoViagem.NEGOCIOS, new Date(2017, 9, 11), new Date(2017, 9, 10), 1000.0, 3);
        Viagem viagem3 = new Viagem("Quixadá", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem4 = new Viagem("Quixadá", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem5 = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem6 = new Viagem("Canindé", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem7 = new Viagem("Horizonte", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem8 = new Viagem("Boa Viagem", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem9 = new Viagem("Quixeramobim", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem10 = new Viagem("Uruquê", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem11 = new Viagem("Capixaba", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);
        Viagem viagem12 = new Viagem("Ubaretama", TipoViagem.LAZER, new Date(2017, 7, 20), new Date(2017, 9, 18), 1200.0, 2);

        /* MAKE TESTS OF EXPENSES */

        Gasto gasto = new Gasto(TipoGasto.TRANSPORTE, 100.0, new Date(2017, 7, 20), "Teste1");
        Gasto gasto1 = new Gasto(TipoGasto.COMBUSTIVEL, 100.0, new Date(2017, 7, 20), "Teste2");
        Gasto gasto2 = new Gasto(TipoGasto.ALIMENTACAO, 100.0, new Date(2017, 7, 20), "Teste3");
        Gasto gasto3 = new Gasto(TipoGasto.OUTROS, 100.0, new Date(2017, 7, 20), "Teste4");
        Gasto gasto4 = new Gasto(TipoGasto.TRANSPORTE, 100.0, new Date(2017, 7, 20), "Teste5");
        Gasto gasto5 = new Gasto(TipoGasto.HOSPEDAGEM, 100.0, new Date(2017, 7, 20), "Teste6");

        viagemController.add(viagem1);
        viagemController.add(viagem2);
        viagemController.add(viagem3);
        viagemController.add(viagem4);
        viagemController.add(viagem5);
        viagemController.add(viagem6);
        viagemController.add(viagem7);
        viagemController.add(viagem8);
        viagemController.add(viagem9);
        viagemController.add(viagem10);
        viagemController.add(viagem11);
        viagemController.add(viagem12);

        viagemController.addGasto(gasto, viagem1);
        viagemController.addGasto(gasto1, viagem1);
        viagemController.addGasto(gasto2, viagem2);
        viagemController.addGasto(gasto3, viagem3);
        viagemController.addGasto(gasto4, viagem6);
        viagemController.addGasto(gasto5, viagem5);

    }

    public void selecionarOpcao(View v){
        switch (v.getId()){
            case R.id.item_novo_gasto:
                Intent newExpenseActivity = new Intent(HomeActivity.this, NewExpenseActivity.class);
                startActivity(newExpenseActivity);
                break;
            case R.id.item_nova_viagem:
                Intent newTripActivity = new Intent(HomeActivity.this, NewTripActivity.class);
                startActivity(newTripActivity);
                break;
            case R.id.item_minhas_viagens:
                Intent tripListActivity = new Intent(HomeActivity.this, TripListActivity.class);
                startActivity(tripListActivity);
                break;
            case R.id.item_configuracoes:
                break;
        }
    }
}
