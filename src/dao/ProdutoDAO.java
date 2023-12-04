package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Comanda;
import model.Produto;
import services.ConnectorSql;


public class ProdutoDAO{
    private Connection con; 
    private Produto produto;
    
    public ProdutoDAO(Produto produto){
        con = ConnectorSql.getConnection();
        this.produto = produto;
    }

    
    public ProdutoDAO(){
        con = ConnectorSql.getConnection();
    }

    public void adicionarProduto(){
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO produto(nome, quantidade, preco) VALUES ( ? , ? , ? ); ");
            stmt.setString(1, produto.getNome());
            String nome = produto.getNome();
            int qntd = produto.getQntd();
            double preco = produto.getPreco();
            stmt.setInt(2, produto.getQntd());
            stmt.setDouble(3, produto.getPreco());
            stmt.executeQuery();
            stmt.close();
        }catch (Exception e) {
            System.out.println(e);
        }
     }

    public void atualizar() {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE produto SET nome = ?, quantidade = ?, preco = ? WHERE id = ?; ");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQntd());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, Integer.parseInt(produto.getId()));
            stmt.executeQuery();
            stmt.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public Produto getProdutoById(String id){
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM produto p WHERE p.id = ? ");
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()){
                produto = new Produto(id, resultado.getString("nome"),resultado.getDouble("preco"), resultado.getInt("quantidade"));
            }
            resultado.close();
            stmt.close();
            
        }catch (Exception e) {

            System.out.println(e);

        }
        return produto;
    }
    
}
