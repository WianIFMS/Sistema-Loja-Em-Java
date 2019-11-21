/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.dao.CidadeDAO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.dao.ClienteDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author gusta
 */
public class ClienteBO extends GenericCRUDModel<Cliente>{

    private UfDAO ufDao;
    private CidadeDAO cidadeDao;
    private ClienteDAO dao;
    public ClienteBO(){
        dao = new ClienteDAO();
        ufDao = new UfDAO();
        cidadeDao = new CidadeDAO();
        preencherLista(dao.listarTodos());
    }
    
    public List<Uf> listarUfs(){
        return ufDao.listarTodos();
    }
    
    public List<Cidade> listarCidadesPorUf(Uf uf){
        return cidadeDao.listarCidadesPorUf(uf);
    }
    
    @Override
    public void salvarEmBaseDeDados(Cliente t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Cliente t) {
        dao.remover(t);
    }

    @Override
    public List<Cliente> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Cliente> buscar(String string, String string1) {
        return new ArrayList<Cliente>();
    }
    
}
