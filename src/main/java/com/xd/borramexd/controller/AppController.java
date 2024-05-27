package com.xd.borramexd.controller;

import com.xd.borramexd.models.DatoDto;
import com.xd.borramexd.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/datos")
public class AppController {
    @Autowired
    private AppService appService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(appService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody DatoDto datoDto){
        var res = appService.save(datoDto);
        return  ResponseEntity.status(HttpStatus.CREATED.value()).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        UUID iduuid = UUID.fromString(id);
        appService.delete(iduuid);
        return ResponseEntity.noContent().build();
    }
}
