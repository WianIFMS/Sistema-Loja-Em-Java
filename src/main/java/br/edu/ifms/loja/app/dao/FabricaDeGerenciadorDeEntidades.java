package br.edu.ifms.loja.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gusta
 */
public class FabricaDeGerenciadorDeEntidades {

    private EntityManagerFactory emf;
    private EntityManager em;
    private static FabricaDeGerenciadorDeEntidades fabrica;

    private FabricaDeGerenciadorDeEntidades() {
        emf = Persistence.createEntityManagerFactory("exemplo-pu");
        em = emf.createEntityManager();
    }

    private static FabricaDeGerenciadorDeEntidades getInstance() {
        if (fabrica == null) {
            fabrica = new FabricaDeGerenciadorDeEntidades();
        }
        return fabrica;
    }

    public static EntityManager getEntityManager() {
        return getInstance().getEm();
    }

    private EntityManager getEm() {
        return em;
    }
}
