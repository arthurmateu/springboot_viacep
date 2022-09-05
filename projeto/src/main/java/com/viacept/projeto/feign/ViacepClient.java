package com.viacept.projeto.feign;

import com.viacept.projeto.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViacepClient", url = "https://viacep.com.br/ws/")
public interface ViacepClient {

    @GetMapping("{cep}/json/")
    AddressDTO findAddressByCep(@PathVariable String cep);
}