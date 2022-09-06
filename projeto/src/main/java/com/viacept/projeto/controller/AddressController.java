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

    @PostMapping("/create/{cep}")
    public ResponseEntity<?> createByCep(@Valid @PathVariable("cep") String cep){
        return ResponseEntity.ok(service.createByCep(cep));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find/{cep}")
    public ResponseEntity<?> findByCep(@Valid @PathVariable("cep") String cep){
        return ResponseEntity.ok(service.findByCep(cep));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateByCep(@RequestBody AddressDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/delete/{cep}")
    public ResponseEntity deleteByCep(@Valid @PathVariable("cep") String cep){
        service.deleteByCep(cep);
        return ResponseEntity.ok("CEP deleted");
    }
}