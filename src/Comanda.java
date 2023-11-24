
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enrique
 */
public class Comanda {
    private String id;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private double valorF;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }  

    /**
     * @return the valorF
     */
    public double getValorF() {
        return valorF;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    

    public void setValorF(double valorF) {
        this.valorF = valorF;
    }
    
    
}
