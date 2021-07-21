package pizzaria.objetos;

import java.util.ArrayList;
import java.util.UUID;
import pizzaria.utils.EstadosEnum;

public class Pedido {
    
    private String id;
    private double preco;
    private Cliente cliente;
    private int estado;
    ArrayList<Pizza> listaPizzas;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        listaPizzas = new ArrayList();
        this.estado = EstadosEnum.ABERTO;
        this.cliente = cliente;
        this.preco = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Pizza> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(ArrayList<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }
    
    public void addPizza(Pizza pizza) {
        pizza.setPedido(this);
        listaPizzas.add(pizza);
    }
    
    public void removePizza(int index) {
        listaPizzas.remove(index);
    }
}
