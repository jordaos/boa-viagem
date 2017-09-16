package com.ufc.jordao.boaviagem.repository;

import com.ufc.jordao.boaviagem.model.Viagem;

import java.util.ArrayList;

/**
 * Created by jordao on 15/09/17.
 */

public class ViagemRepository {
    private ArrayList<Viagem> listViagens;

    public ViagemRepository(){
        this.listViagens = new ArrayList<Viagem>();
    }

    public void addViagem(Viagem viagem){
        listViagens.add(viagem);
    }

    public ArrayList<Viagem> getAll(){
        return this.listViagens;
    }
}
