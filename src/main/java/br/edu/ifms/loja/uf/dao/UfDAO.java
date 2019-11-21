/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.List;

/**
 *
 * @author gusta
 */
public class UfDAO extends GenericDAO<Uf> {

    public UfDAO() {
        super(Uf.class);
    }

    public List<Uf> buscarPorSigla(String string1) {
        return getEm().createQuery("SELECT u FROM Uf u WHERE UPPER(u.sigla) LIKE :sigla")
                .setParameter("sigla", "%"+string1.toUpperCase()+"%").getResultList();
    }

}
