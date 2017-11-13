package com.ufc.jordao.boaviagem;

import com.ufc.jordao.boaviagem.model.Gasto;
import com.ufc.jordao.boaviagem.model.TipoGasto;
import com.ufc.jordao.boaviagem.model.TipoViagem;
import com.ufc.jordao.boaviagem.model.Viagem;
import com.ufc.jordao.boaviagem.repository.ViagemRepository;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jordao on 13/11/17.
 */

public class RepositoryTests{
    ViagemRepository repository = ViagemRepository.getInstance();

    @Before
    public void resetRepository(){
        repository.clear();
    }

    @Test
    public void insertingViagem(){
        Viagem viagem = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        repository.addViagem(viagem);

        ArrayList<Viagem> lista = repository.getAll();
        System.out.println(lista.size());

        Assert.assertEquals(viagem, lista.get(0));
        return;
    }

    @Test
    public void addGastoTest(){
        Viagem viagem = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        repository.addViagem(viagem);

        Gasto gasto = new Gasto(TipoGasto.ALIMENTACAO, 20.00, new Date(), "Comida");

        repository.addGasto(gasto, viagem);

        ArrayList<Viagem> lista = repository.getAll();
        Viagem viagem1 = lista.get(0);

        Assert.assertEquals(gasto, viagem1.getListGastos().get(0));
        return;
    }

    @Test
    public void getViagensTest(){
        ArrayList<Viagem> lista = repository.getAll();
        Assert.assertEquals(lista.size(), 0);

        Viagem viagem1 = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        Viagem viagem2 = new Viagem("Quixadá", TipoViagem.NEGOCIOS, new Date(), new Date(), 400.00, 2);
        repository.addViagem(viagem1);
        repository.addViagem(viagem2);

        ArrayList<Viagem> lista1 = repository.getAll();
        Assert.assertEquals(lista.size(), 2);
        return;
    }

    @Test
    public void removeViagemTest(){
        Viagem viagem1 = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        Viagem viagem2 = new Viagem("Quixadá", TipoViagem.NEGOCIOS, new Date(), new Date(), 400.00, 2);
        repository.addViagem(viagem1);
        repository.addViagem(viagem2);

        ArrayList<Viagem> lista = repository.getAll();
        Assert.assertEquals(lista.size(), 2);

        repository.removeViagem(viagem1);

        ArrayList<Viagem> lista1 = repository.getAll();
        Assert.assertEquals(lista.size(), 1);
        return;
    }

    @Test
    public void editGastoTest(){
        Viagem viagem = new Viagem("Fortaleza", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        repository.addViagem(viagem);

        Viagem viagemUpdated = new Viagem("São paulo", TipoViagem.LAZER, new Date(), new Date(), 200.00, 1);
        repository.editViagem(viagem, viagemUpdated);

        ArrayList<Viagem> lista = repository.getAll();
        Viagem viagem1 = lista.get(0);

        Assert.assertNotEquals(lista.get(0), viagem);
        Assert.assertEquals(lista.get(0), viagemUpdated);

        return;
    }
}
