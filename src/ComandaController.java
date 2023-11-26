
import java.util.ArrayList;

public class ComandaController {
    final ArrayList<Comanda> comandas = new ArrayList<>();
    
    public ComandaController(){
        comandas.add(new Comanda("1"));
        adicionarProduto(new Produto("1", "maça", 1, 1), comandas.get(0));
    }
    
    public void adicionarProduto(Produto produto, Comanda comanda){
        comanda.adicionarProduto(produto);
    }
    
    public Comanda getComandaById(String id){
        for (Comanda c: comandas){
            if (c.getId().equals(id)){
                return c;
            }
            
        }
        return new Comanda();
    }
}
