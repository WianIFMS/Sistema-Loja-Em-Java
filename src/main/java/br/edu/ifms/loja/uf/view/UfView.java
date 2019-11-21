/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.view;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author gusta
 */
public class UfView extends GenericCRUDView {

    private JDialog janela;

    public UfView(JPanel formulario) {
        super(formulario);
        janela = new JDialog();
        janela.setModal(true);
        janela.add(this);
        janela.setSize(600, 500);
        janela.setTitle("UF");
    }

    @Override
    public String[] configurarCamposDeBusca() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new String[]{"Sigla","Nome","Id"};
    }

    public void setVisible(boolean b) {
        janela.setVisible(b);
    }
}
