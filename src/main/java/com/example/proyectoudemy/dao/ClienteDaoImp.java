package com.example.proyectoudemy.dao;

import com.example.proyectoudemy.models.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDaoImp implements IClienteDao{
    // El entity Manager se encarga de manejar las clases de entidades, actualizando, eliminando. Realiza busqueda
    // a la BBDD a nivel de Objeto. Son consultas de JPA , que van a la clase entity no a la BBDD
    @PersistenceContext
    private EntityManager entityManager;

    //Es para leer solo ya que es una consulta
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("FROM Cliente").getResultList();
    }
}
