package pizzaria.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Cliente {

    private String id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private Array pedidoLista;

    private Pedido pedidoCliente;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String telefone) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.pedidoCliente = pedidoCliente;
    }

    public Cliente(String id, String nome, String sobrenome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.pedidoCliente = pedidoCliente;
    }

    public Array getArray() {
        return pedidoLista;
    }

    public void setArray(Array pedidoLista) {
        this.pedidoLista = pedidoLista;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pedido getPedido() {
        return pedidoCliente;
    }

    public void setPedido(Pedido pedido) {
        pedido.setCliente(this);
        this.pedidoCliente = pedido;
    }
}
