package com.viacept.projeto;

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

}
