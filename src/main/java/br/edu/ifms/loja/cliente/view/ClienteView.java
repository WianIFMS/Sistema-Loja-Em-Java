/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author gusta
 */
public class ClienteView extends GenericCRUDView{
    private JDialog janela;
    public ClienteView(JPanel formulario) {
        super(formulario);
        janela = new JDialog();
        janela.setModal(true);
        janela.add(this);
        janela.setSize(500, 400);
        janela.setTitle("Clientes");
    }

    @Override
    public String[] configurarCamposDeBusca() {
        return new String[0];
    }
    
    public void setVisible(boolean b){
        janela.setVisible(b);
    }
    
}
