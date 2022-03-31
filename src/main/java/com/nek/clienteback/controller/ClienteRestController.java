package com.nek.clienteback.controller;

import com.nek.clienteback.entity.Cliente;
import com.nek.clienteback.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})//aqui iria el link de angular
@RestController
@RequestMapping("/api")
public class ClienteRestController {


    //el bean va a buscar la primera implementacion que sea un componente, si tuviera mas de uno, hubiera que usar @Qualifer
    @Autowired
    IClienteService clienteService;
    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }


    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED) // por defecto es OK
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED) // por defecto es OK
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setEmail(cliente.getEmail());
        return clienteService.save(clienteActual);
    }
    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // por defecto es OK
    public void create( @PathVariable Long id){
         clienteService.delete(id);
    }
}
