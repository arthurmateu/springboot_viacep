package com.viacept.projeto.service;

import com.viacept.projeto.dto.AddressDTO;
import com.viacept.projeto.feign.ViacepClient;
import com.viacept.projeto.model.Address;
import com.viacept.projeto.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AddressRepository repository;

    @Autowired
    private ViacepClient client;

    public AddressDTO createByCep(String cep) {
        AddressDTO addressByCep = client.findAddressByCep(cep);
        var saved = repository.save(mapper.map(addressByCep, Address.class));
        return mapper.map(saved, AddressDTO.class);
    }

//    public AddressDTO create(AddressDTO addressDTO) {
//        var saved = repository.save(mapper.map(addressDTO, Address.class));
//        return mapper.map(saved, AddressDTO.class);
//    }

    public List<AddressDTO> findAll() {
        return repository.findAll().stream().map(address -> mapper.map(address, AddressDTO.class)).toList();
    }

    public AddressDTO findByCep(String cep) {
        return mapper.map(repository.findById(cep).orElseThrow(() -> new RuntimeException("Address not found")), AddressDTO.class);
    }


    public AddressDTO update(AddressDTO addressDTO) {
        repository.save(mapper.map(addressDTO, Address.class));
        return null;
    }

    public void delete(String cep) {
        repository.deleteById(cep);
    }
}