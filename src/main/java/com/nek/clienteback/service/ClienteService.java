package com.nek.clienteback.service;

import com.nek.clienteback.dao.IClienteDao;
import com.nek.clienteback.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService implements  IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly=true) //los de CurudRepository ya viene con transactional, solo s epondria a los propios metodos
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDao.findAll(); //retorna un iterable, asi que se castea
    }

    @Override
    @Transactional()
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
}
