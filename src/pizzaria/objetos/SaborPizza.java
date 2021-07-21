package pizzaria.objetos;

import java.util.UUID;


public class SaborPizza {
    
    private String id;
    private String nome;
    private TipoPizza tipo;

    public SaborPizza(String nome, TipoPizza tipo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.tipo = tipo;
    }
    
        public SaborPizza(String id, String nome, TipoPizza tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public SaborPizza() {
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPizza getTipo() {
        return tipo;
    }

    public void setTipo(TipoPizza tipo) {
        this.tipo = tipo;
    }
}
