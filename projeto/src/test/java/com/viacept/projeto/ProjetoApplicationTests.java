package com.viacept.projeto;

import com.viacept.projeto.dto.AddressDTO;
import com.viacept.projeto.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoApplicationTests {

	@Autowired
	AddressService addressService;

	@Test
	void contextLoads() {
		addressService.createByCep("13090-660");
	}

	@Test
	void updateTest(){
		addressService.createByCep("13058-014");
		addressService.update(new AddressDTO("13058-014", "a", "a","a","a","a", "a", "a", "a", "a"));
		System.out.println(addressService.findByCep("13058-014"));
	}

	@Test
	void deleteTest(){
		addressService.deleteByCep("13090-660");
		addressService.deleteByCep("13058-014");
	}

}
