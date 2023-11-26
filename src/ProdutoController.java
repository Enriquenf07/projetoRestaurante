
import java.util.ArrayList;

public class ProdutoController {
    final ArrayList<Produto> produtos = new ArrayList<>();
    
    public ProdutoController(){
        produtos.add(new Produto("1", "maça", 2, 1));
    }
    
    public Produto pesquisarProduto(String id){
        for(Produto p: produtos){
            if (p.getId().equals(id)){
                return p;
            }
            
        }
        return new Produto();
    }
}
