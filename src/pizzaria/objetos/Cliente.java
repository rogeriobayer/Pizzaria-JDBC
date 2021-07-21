package pizzaria.objetos;

import java.util.ArrayList;

public class Cliente {
    
    private String nome;
    private String sobrenome;
    private String telefone;
    private Pedido pedidoCliente;
    
    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.pedidoCliente = pedidoCliente;
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
