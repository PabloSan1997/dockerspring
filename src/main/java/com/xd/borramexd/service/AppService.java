package com.xd.borramexd.service;

import com.xd.borramexd.models.Dato;
import com.xd.borramexd.models.DatoDto;

import java.util.List;
import java.util.UUID;

public interface AppService {
    List<Dato> findAll();
    Dato save(DatoDto datoDto);
    void delete(UUID id);
}
