package com.ufc.jordao.boaviagem.controller;

import com.ufc.jordao.boaviagem.model.TipoViagem;
import com.ufc.jordao.boaviagem.model.Viagem;
import com.ufc.jordao.boaviagem.repository.ViagemRepository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jordao on 16/09/17.
 */

public class ViagemController {
    private ViagemRepository repository;

    public ViagemController(){
        repository = ViagemRepository.getInstance();
    }

    public void add(String destino, TipoViagem tipo, Date dataChegada, Date dataSaida, double orcamento, int qtdPessoas){
        Viagem viagem = new Viagem(destino, tipo, dataChegada, dataSaida, orcamento, qtdPessoas);
        repository.addViagem(viagem);
    }

    public ArrayList<Viagem> getAll(){
        return repository.getAll();
    }

    public ArrayList<String> getDestinos(){
        ArrayList<String> destinos = new ArrayList<String>();
        for (Viagem viagem : repository.getAll()) {
            destinos.add(viagem.getDestino());
        }
        return destinos;
    }
}
