package com.ufc.jordao.boaviagem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jordao on 15/09/17.
 */

public class Viagem {
    private String destino;
    private TipoViagem tipo;
    private Date dataChegada;
    private Date dataSaida;
    private String orcamento;
    private int qtdPessoas;
    private ArrayList<Gasto> listGastos;

    public ArrayList<Gasto> getListGastos() {
        return listGastos;
    }

    public void setListGastos(ArrayList<Gasto> listGastos) {
        this.listGastos = listGastos;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public TipoViagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoViagem tipo) {
        this.tipo = tipo;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
}
