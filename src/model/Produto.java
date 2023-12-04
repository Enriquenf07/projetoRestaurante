package model;

import dao.ProdutoDAO;


public class Produto {
    private String id;
    private String nome;
    private double preco;
    private int qntd;
    
    public Produto(String id, String nome, double preco, int qnt){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qntd = qnt;
    }
    
    public Produto(String nome, double preco, int qnt){
        this.nome = nome;
        this.preco = preco;
        this.qntd = qnt;
    }
    
    public Produto(){
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    
}
