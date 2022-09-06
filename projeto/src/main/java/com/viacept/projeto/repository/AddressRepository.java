package com.viacept.projeto.repository;

import com.viacept.projeto.dto.AddressDTO;
import com.viacept.projeto.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
//    @Query("select A from address A where A.cep = :cep")
//    Address findByCep(@Param("cep") String cep);
}