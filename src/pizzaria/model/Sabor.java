package pizzaria.model;

import java.util.UUID;

public class Sabor {

    private String id;
    private String nome;
    private Integer tipo;

    public Sabor(String nome, int tipo) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.tipo = tipo;
    }

    public Sabor(String id, String nome, int tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Sabor() {
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
