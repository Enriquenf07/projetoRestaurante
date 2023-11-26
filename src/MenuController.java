public class MenuController {
    public void abrirComanda(MenuView menu){
        new ComandaView().setVisible(true);
        menu.dispose();
    }
    
}
