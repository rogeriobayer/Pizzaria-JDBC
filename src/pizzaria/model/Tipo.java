package pizzaria.model;

public class Tipo {

    private String nome;
    private double precoCmQuadrado;
    private Integer id;

    public Tipo(Integer id, String nome, double precoCmQuadrado) {
        this.nome = nome;
        this.id = id;
        this.precoCmQuadrado = precoCmQuadrado;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCm() {
        return precoCmQuadrado;
    }

    public void setPrecoCmQuadrado(double precoCmQuadrado) {
        this.precoCmQuadrado = precoCmQuadrado;
    }

}
