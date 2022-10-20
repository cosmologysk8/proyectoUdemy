package com.example.proyectoudemy.dao;

import com.example.proyectoudemy.models.Cliente;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IClienteDao {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

}
