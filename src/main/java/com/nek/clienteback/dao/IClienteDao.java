package com.nek.clienteback.dao;

import com.nek.clienteback.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends CrudRepository<Cliente, Long> {
}
