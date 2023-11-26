
import java.util.ArrayList;

public class Comanda {
    private String id;
    final ArrayList<Produto> produtos = new ArrayList<>();
    private double valorF;

    public Comanda(String id){
        this.id = id;
    }
    
    public Comanda(){
        
    }
    
    
    public String getId() {
        return id;
    }

    /**
     * @return the produtos
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @return the valorF
     */
    public double getValorF() {
        return valorF;
    }
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
    
    
}
