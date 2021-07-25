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

    public void setId(String id) {
        this.id = id;
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

    public String getTipoString() {
        switch (tipo) {
            case 0:
                return "Simples";
            case 1:
                return "Especial";

            case 2:
                return "Premium";

        }
        return null;
    }
}
