package com.ufc.jordao.boaviagem.repository;

import com.ufc.jordao.boaviagem.model.Gasto;
import com.ufc.jordao.boaviagem.model.Viagem;

import java.util.ArrayList;

/**
 * Created by jordao on 15/09/17.
 */

public class ViagemRepository {
    private ArrayList<Viagem> listViagens;
    private static volatile ViagemRepository INSTANCE;

    private ViagemRepository(){
        listViagens = new ArrayList<Viagem>();
    }

    public static ViagemRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (ViagemRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViagemRepository();
                }
            }
        }
        return INSTANCE;
    }

    public void addViagem(Viagem viagem){
        listViagens.add(viagem);
    }

    public void editViagem(Viagem velha, Viagem nova){
        listViagens.remove(velha);
        listViagens.add(nova);
    }

    public ArrayList<Viagem> getAll(){
        return this.listViagens;
    }

    public void addGasto(Gasto gasto, Viagem viagem){
        ArrayList<Gasto> gastos = viagem.getListGastos();
        gastos.add(gasto);
        viagem.setListGastos(gastos);
        Viagem aux = viagem;

        listViagens.remove(viagem);

        listViagens.add(aux);
    }

    public void removeViagem(Viagem viagem){
        listViagens.remove(viagem);
    }
}
