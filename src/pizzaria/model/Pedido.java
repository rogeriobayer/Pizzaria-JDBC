package pizzaria.model;

import java.util.ArrayList;
import java.util.UUID;
import pizzaria.utils.EstadosEnum;

public class Pedido {

    private String id;
    private double preco;
    private Cliente cliente; //FUTURE REMOVAL
    private String idCliente;

    private int estado;
    ArrayList<Pizza> listaPizzas; //FUTURE REMOVAL

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        listaPizzas = new ArrayList();
        this.estado = EstadosEnum.ABERTO;
        this.cliente = cliente;
        this.preco = 0;
    }

    public Pedido(String idCliente) { //NEW1
        this.id = UUID.randomUUID().toString();
//        listaPizzas = new ArrayList();
        this.estado = EstadosEnum.ABERTO;
        this.idCliente = idCliente;
        this.preco = 0;
    }

    public Pedido(String id, Double preco, String idCliente, Integer estado) { //NEW2
        this.id = id;
//        listaPizzas = new ArrayList();
        this.estado = estado;
        this.idCliente = idCliente;
        this.preco = preco;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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

    public Cliente getCliente() { ////FUTURE REMOVAL
        return cliente;
    }

    public void setCliente(Cliente cliente) { ////FUTURE REMOVAL
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
