package controller;


import dao.ComandaDAO;
import model.Comanda;
import model.Produto;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ComandaController {
    
    public void adicionarProduto(String id, String input){
        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");
        if(pattern.matcher(input).matches()){
            ComandaDAO dao = new ComandaDAO();
            dao.adicionarProduto(id, input, true);
        }else{
            ComandaDAO dao = new ComandaDAO();
            dao.adicionarProduto(id, input, false);
        }
        
    }
    
    public Comanda getComandaById(String id){
        ComandaDAO dao = new ComandaDAO();
        Comanda comanda = dao.getComandaById(id);
        double valor = 0;
        for (Produto p: comanda.produtos){
            valor += p.getPreco();
        }
        comanda.setValorF(valor);
        return comanda;
    }
}
