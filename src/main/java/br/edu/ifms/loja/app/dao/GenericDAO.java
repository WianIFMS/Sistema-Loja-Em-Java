/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.app.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author gusta
 */
public abstract class GenericDAO<T> {

    private EntityManager em;

    private Class clazz;

    public GenericDAO(Class clazz) {
        this.clazz = clazz;
        em = FabricaDeGerenciadorDeEntidades.getEntityManager();
    }

    public void persistir(T obj) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.persist(obj);
        em.getTransaction().commit();
    }

    public void remover(T obj) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.remove(obj);
        em.getTransaction().commit();
    }

    public void alterar(T obj) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.merge(obj);
        em.getTransaction().commit();
    }

    public T buscarPorId(Long id) {
        return (T) em.find(clazz, id);
    }

    public List<T> listarTodos() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT t ");
        query.append("FROM ");
        query.append(clazz.getSimpleName());
        query.append(" t");
        return em.createQuery(query.toString()).getResultList();
    }

    public EntityManager getEm() {
        return em;
    }
}
