package com.viacept.projeto.controller;

import com.viacept.projeto.dto.AddressDTO;
import com.viacept.projeto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressController {
    @Autowired
    private AddressService service;

    @PostMapping("/{cep}")
    public ResponseEntity<?> createByCep(@PathVariable("cep") String cep){
        return ResponseEntity.ok(service.createByCep(cep));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{cep}")
    public ResponseEntity<?> findByCep(@PathVariable("cep") String cep){
        return ResponseEntity.ok(service.findByCep(cep));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody AddressDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{cep}")
    public ResponseEntity<?> deleteByCep(@PathVariable("cep") String cep){
        service.deleteByCep(cep);
        return ResponseEntity.ok("CEP deleted");
    }
}