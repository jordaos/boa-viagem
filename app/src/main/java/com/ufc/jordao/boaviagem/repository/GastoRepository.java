package com.ufc.jordao.boaviagem.repository;

import com.ufc.jordao.boaviagem.model.Gasto;
import com.ufc.jordao.boaviagem.model.Viagem;

import java.util.ArrayList;

/**
 * Created by jordao on 15/09/17.
 */

public class GastoRepository {

    public void add(Viagem viagem, Gasto gasto){
        viagem.getListGastos().add(gasto);
    }

    public ArrayList<Gasto> getAll(){
        ViagemRepository viagemRepository = new ViagemRepository();
        ArrayList<Gasto> listGasto = new ArrayList<Gasto>();
        for (Viagem viagem : viagemRepository.getAll()) {
            listGasto.addAll(viagem.getListGastos());
        }
        return listGasto;
    }
}
