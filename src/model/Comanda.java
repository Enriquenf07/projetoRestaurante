package model;


import java.util.ArrayList;

public class Comanda {
    private String id;
    public ArrayList<Produto> produtos;
    private double valorF;
    
    public Comanda(String id){
        this.id = id;
        produtos = new ArrayList<>();
    }
    
    public Comanda(){
        produtos = new ArrayList<>();
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

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param valorF the valorF to set
     */
    public void setValorF(double valorF) {
        this.valorF = valorF;
    }
    
    
}
