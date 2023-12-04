package controller;


import dao.ProdutoDAO;
import model.Produto;
import javax.swing.JOptionPane;


public class ProdutoController {
    
    public void criarProduto(String nome, Integer qntd, Double preco){
        if (!nome.isEmpty() && qntd != null && preco != null){
            Produto produto = new Produto(nome, preco, qntd);
            ProdutoDAO dao = new ProdutoDAO(produto);
            dao.adicionarProduto();
            return;
        }
        JOptionPane.showMessageDialog(null, "parametros invalidos!");
    }
    public void atualizar(String id, String nome, Integer qntd, Double preco){
        if (!id.isEmpty() && !nome.isEmpty() && qntd != null && preco != null){
            Produto produto = new Produto(id, nome, preco, qntd);
            ProdutoDAO dao = new ProdutoDAO(produto);
            dao.atualizar();
            return;
        }
        JOptionPane.showMessageDialog(null, "parametros invalidos!");
    }
    
    public Produto getProdutoById(String id){
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.getProdutoById(id);
        return produto;
    }
}
