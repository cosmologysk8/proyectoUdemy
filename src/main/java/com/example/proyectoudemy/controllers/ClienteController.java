package com.example.proyectoudemy.controllers;

import com.example.proyectoudemy.dao.IClienteDao;
import com.example.proyectoudemy.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Cliente");
        model.addAttribute("clientes", clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Model model){
        Cliente cliente = new Cliente();

        model.addAttribute("titulo", "Formulario de Cliente");
        model.addAttribute("cliente", cliente);

        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editarCliente(@PathVariable(value = "id") Long id, Model model){
        Cliente cliente = null;
        if (id >0){
            cliente = clienteDao.findOne(id);
        }else {
            return "redirect:/listar";
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Editar  Cliente");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:listar";
    }

}
