package com.viacept.projeto.service;

import com.viacept.projeto.dto.AddressDTO;
import com.viacept.projeto.feign.ViacepClient;
import com.viacept.projeto.model.Address;
import com.viacept.projeto.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService{

    @Autowired
    private AddressRepository repository;

    @Autowired
    private ViacepClient client;

    public AddressDTO createByCep(String cep){
        ModelMapper mapper = new ModelMapper();
        AddressDTO addressByCep = client.findAddressByCep(cep);
        var saved = repository.save(mapper.map(addressByCep, Address.class));
        System.out.println(saved);
        return mapper.map(saved, AddressDTO.class);
    }

    // Create
    public AddressDTO create(AddressDTO addressDTO){

        return null;
    }

    // Get
        // All
        public List<AddressDTO> findAll(){

            return null;
        }
        // By Id
        public AddressDTO findByCep(String cep){

            return null;
        }


    // Update
    public AddressDTO update(String cep, AddressDTO addressDTO){

        return null;
    }

    // Delete
    public void delete(String cep){

    }
}