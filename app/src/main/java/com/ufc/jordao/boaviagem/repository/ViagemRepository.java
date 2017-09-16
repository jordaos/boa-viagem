package com.ufc.jordao.boaviagem.repository;

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

    public ArrayList<Viagem> getAll(){
        return this.listViagens;
    }
}
