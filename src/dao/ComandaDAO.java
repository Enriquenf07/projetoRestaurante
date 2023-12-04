package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Comanda;
import model.Produto;
import services.ConnectorSql;

public class ComandaDAO{
    private Connection con;
    private Comanda comanda;
    
    public ComandaDAO(){
        con = ConnectorSql.getConnection();
    }
    public ComandaDAO(Comanda comanda){
        con = ConnectorSql.getConnection();
        this.comanda = comanda;
    }
    
    public Comanda getComandaById(String id){
        try {
            comanda =  new Comanda();
            comanda.setId(id);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM comandaProduto RIGHT JOIN produto ON produto.id = comandaProduto.produto_id WHERE comanda_id = ?");
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()){
                Produto produto = new Produto();
                produto.setId("" + resultado.getInt("produto_id"));
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setQntd(resultado.getInt("quantidade"));
                comanda.adicionarProduto(produto);
            }
            resultado.close();
            stmt.close();
            
        }catch (Exception e) {

            System.out.println(e);

        }
        return comanda;
    }
    
    public void adicionarProduto(String comanda_id, String input, Boolean isNumeric) {
        try {
            if (isNumeric){
                StringBuilder query = new StringBuilder();
                query.append("BEGIN; ");
                query.append("INSERT INTO comandaProduto(comanda_id, produto_id) VALUES( ? , ? ); ");
                query.append("UPDATE produto SET quantidade = quantidade - 1 WHERE id = ?; ");
                query.append("COMMIT; ");
                PreparedStatement stmt = con.prepareStatement(query.toString());
                stmt.setInt(1, Integer.parseInt(comanda_id));
                stmt.setInt(2, Integer.parseInt(input));
                stmt.setInt(3, Integer.parseInt(input));
                stmt.executeQuery();
                stmt.close();
            }else{
                PreparedStatement stmt = con.prepareStatement("SELECT p.id FROM produto p WHERE p.nome = ? ");
                stmt.setString(1, input);
                ResultSet resultado = stmt.executeQuery();
                int id = 0;
                if (resultado.next()){
                    id = resultado.getInt("id");
                }
                StringBuilder query = new StringBuilder();
                query.append("BEGIN; ");
                query.append("INSERT INTO comandaProduto(comanda_id, produto_id) VALUES( ? , ? ); ");
                query.append("UPDATE produto SET quantidade = quantidade - 1 WHERE id = ?; ");
                query.append("COMMIT; ");
                PreparedStatement stmt2 = con.prepareStatement(query.toString());
                stmt2.setInt(1, Integer.parseInt(comanda_id));
                stmt2.setInt(2, id);
                stmt2.setInt(3, id);
                stmt2.executeQuery();
                stmt.close();
                stmt2.close();
            }
            
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void limparComanda(String id){
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM comandaProduto c WHERE c.comanda_id = ?");
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeQuery();
            stmt.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
