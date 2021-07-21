package pizzaria.objetos;

import java.util.ArrayList;

public class TipoPizza {
    
    private String nome;
    private double precoCmQuadrado;
    ArrayList<SaborPizza> listaSabores;

    public TipoPizza(String nome) {
        this.nome = nome;
        listaSabores = new ArrayList();
        this.precoCmQuadrado = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCmQuadrado() {
        return precoCmQuadrado;
    }

    public void setPrecoCmQuadrado(double precoCmQuadrado) {
        this.precoCmQuadrado = precoCmQuadrado;
    }

    public ArrayList<SaborPizza> getListaSabores() {
        return listaSabores;
    }

    public void setListaSabores(ArrayList<SaborPizza> listaSabores) {
        this.listaSabores = listaSabores;
    }
    
    public void adicionarSabor(SaborPizza sabor) {
        sabor.setTipo(this);
        listaSabores.add(sabor);
    }
    
    public void removerSabor(String id) {
        listaSabores.removeIf(sabor -> sabor.getId().equals(id));
    }
    
}
