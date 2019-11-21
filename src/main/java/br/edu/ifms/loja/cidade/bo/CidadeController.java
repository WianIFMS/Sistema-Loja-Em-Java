/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cidade.view.CidadeForm;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;
import maruyama.components.swing.ObjectTableModel;

/**
 *
 * @author gusta
 */
public class CidadeController extends GenericCRUDController<Cidade> {

    public CidadeController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        carregarComboBoxUF(view, (CidadeBO) model);
        inicializarAcoesDeBusca(view, (CidadeBO) model);
    }

    public void inicializarAcoesDeBusca(GenericCRUDView view, CidadeBO model) {
        view.getCampoBusca().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String campo = (String) view.getComboBoxAtributoDeBusca().getSelectedItem();
                String valor = view.getCampoBusca().getText();
                List<Cidade> lista = model.buscar(campo, valor);
                ObjectTableModel tableModel = new ObjectTableModel(Cidade.class, lista);
                view.getTabela().setModel(tableModel);
            }
        });
    }

    public void carregarComboBoxUF(GenericCRUDView view, CidadeBO model) {
        CidadeForm form = (CidadeForm) view.getFormulario();
        form.getComboUF().removeAllItems();

        for (Uf uf : model.listarUfs()) {
            form.getComboUF().addItem(uf);
        }
    }

    @Override
    public void dadosViewParaModel(Cidade t, JPanel pnl) {
        CidadeForm form = (CidadeForm) pnl;
        t.setNome(form.getCampoNome().getText());
        t.setUf((Uf) form.getComboUF().getSelectedItem());
    }

    @Override
    public void dadosModelParaView(Cidade t, JPanel pnl) {
        CidadeForm form = (CidadeForm) pnl;
        form.getCampoNome().setText(t.getNome());
        form.getComboUF().setSelectedItem(t.getUf());
    }

}
