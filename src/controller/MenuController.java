package controller;

import view.MenuView;
import view.ComandaView;
import view.ProdutoView;

public class MenuController {
    public void abrirComanda(MenuView menu){
        new ComandaView().setVisible(true);
        menu.dispose();
    }
    public void abrirProduto(MenuView menu){
        new ProdutoView().setVisible(true);
        menu.dispose();
    }
    
    public void voltarParaMenu(javax.swing.JFrame view){
        new MenuView().setVisible(true);
        view.dispose();
    }
    
    
    
}
