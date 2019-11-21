/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.cliente.view.ClienteForm;
import br.edu.ifms.loja.cliente.view.ClienteView;
import br.edu.ifms.loja.uf.datamodel.Uf;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author gusta
 */
public class ClienteController extends GenericCRUDController<Cliente> {

    private ClienteView view;
    private ClienteBO model;

    public ClienteController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        this.view = (ClienteView) view;
        this.model = (ClienteBO) model;
        carregarUFs();
        inicializarAcoesComboBox();
        
    }

    public void inicializarAcoesComboBox() {
        ClienteForm form = (ClienteForm) view.getFormulario();
        form.getComboUf().addActionListener((evt) -> {
            carregarCidades();
        });
    }

    public void carregarUFs() {
        ClienteForm form = (ClienteForm) view.getFormulario();
        form.getComboUf().removeAllItems();
        for (Uf uf : model.listarUfs()) {
            form.getComboUf().addItem(uf);
        }
    }

    public void carregarCidades() {
        ClienteForm form = (ClienteForm) view.getFormulario();
        Uf uf = (Uf) form.getComboUf().getSelectedItem();
        form.getComboCidade().removeAllItems();
        if (uf == null) {
            return;
        }
        for (Cidade cidade : model.listarCidadesPorUf(uf)) {
            form.getComboCidade().addItem(cidade);
        }
    }

    @Override
    public void dadosViewParaModel(Cliente t, JPanel pnl) {
        ClienteForm form = (ClienteForm) pnl;
        t.setNome(form.getCampoNome().getText());
        t.setCidade((Cidade) form.getComboCidade().getSelectedItem());
    }

    @Override
    public void dadosModelParaView(Cliente t, JPanel pnl) {
        ClienteForm form = (ClienteForm) pnl;
        form.getCampoNome().setText(t.getNome());
        if (t.getCidade() == null) {
            return;
        }
        form.getComboUf().setSelectedItem(t.getCidade().getUf());
        form.getComboCidade().setSelectedItem(t.getCidade());
    }

}
