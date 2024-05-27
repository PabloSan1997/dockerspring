package com.xd.borramexd.service;

import com.xd.borramexd.models.Dato;
import com.xd.borramexd.models.DatoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class AppServiceImp implements AppService {
    private List<Dato> lista;

    public AppServiceImp() {
        this.lista = new ArrayList<>();
        this.lista.add(new Dato(UUID.randomUUID(), "Lap top", 25.25));
        this.lista.add(new Dato(UUID.randomUUID(), "Celular", 525.85));
        this.lista.add(new Dato(UUID.randomUUID(), "Awita", 89.1));
        this.lista.add(new Dato(UUID.randomUUID(), "One coin", 87645.2));
        this.lista.add(new Dato(UUID.randomUUID(), "Skibiri", 8546.52));
    }


    @Override
    public List<Dato> findAll() {
        return lista.stream().sorted((d1, d2) -> Double.compare(d2.getPrice(), d1.getPrice())).toList();
    }

    @Override
    public Dato save(DatoDto datoDto) {
        Dato dato = Dato.builder()
                .id(UUID.randomUUID())
                .price(datoDto.getPrice())
                .name(datoDto.getName()).build();
        lista.add(dato);
        return dato;
    }

    @Override
    public void delete(UUID id) {
        lista.stream().filter(p -> p.getId().equals(id)).findFirst()
                .ifPresent(l -> {
                    lista.remove(l);
                });
    }
}
