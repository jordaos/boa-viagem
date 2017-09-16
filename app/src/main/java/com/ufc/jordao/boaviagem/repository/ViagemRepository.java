package com.ufc.jordao.boaviagem.repository;

import com.ufc.jordao.boaviagem.model.Viagem;

import java.util.ArrayList;

/**
 * Created by jordao on 15/09/17.
 */

public class ViagemRepository {
    private ArrayList<Viagem> listViagens;
    private ArrayList<String> listDestinos;

    public ViagemRepository(){
        this.listViagens = new ArrayList<Viagem>();
        this.listDestinos = new ArrayList<String>();
    }

    public void addViagem(Viagem viagem){
        listViagens.add(viagem);
    }

    public void addDestino(Viagem viagem){
        String destino = viagem.getDestino();
        listDestinos.add(destino);
    }

    public ArrayList<Viagem> getAll(){
        return this.listViagens;
    }

    public ArrayList<String> getAllDestinos(){ return this.listDestinos; }
}
